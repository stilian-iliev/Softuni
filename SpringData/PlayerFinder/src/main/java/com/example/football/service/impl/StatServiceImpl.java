package com.example.football.service.impl;

import com.example.football.models.dto.stat.StatImportDto;
import com.example.football.models.dto.stat.StatsListImportDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {
    private final Path STATS_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "stats.xml");

    private final StatRepository statRepository;

    private final ModelMapper mapper;

    @Autowired
    public StatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
        mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(STATS_XML_PATH);
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(StatsListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StatsListImportDto statsListDto = (StatsListImportDto)unmarshaller.unmarshal(new FileReader(STATS_XML_PATH.toString()));
        List<String> output = new ArrayList<>();
        for (StatImportDto statDto : statsListDto.getStats()) {
            if (statRepository.findByPassingAndShootingAndEndurance(statDto.getPassing(), statDto.getShooting(), statDto.getEndurance()) == null && statDto.isValid()){
                Stat stat = mapper.map(statDto, Stat.class);
                statRepository.save(stat);
                output.add(String.format("Successfully imported Stat %.2f - %.2f - %.2f", stat.getShooting(), stat.getPassing(), stat.getEndurance()));
            } else {
                output.add("Invalid Stat");
            }
        }
        return String.join("\n", output);
    }
}
