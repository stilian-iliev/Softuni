package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.agent.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    private final Path AGENTS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "agents.json");

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validation;

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson, ModelMapper mapper, ValidationUtil validation) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validation = validation;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(AGENTS_JSON_PATH);
    }

    @Override
    public String importAgents() throws IOException {
        AgentImportDto[] agentImportDtos = gson.fromJson(new FileReader(AGENTS_JSON_PATH.toString()), AgentImportDto[].class);

        List<String > output = new ArrayList<>();
        for (AgentImportDto agentDto : agentImportDtos) {
            Optional<Town> town = townRepository.findByTownName(agentDto.getTown());
            boolean unique = agentRepository.findByFirstName(agentDto.getFirstName()).isEmpty()
                    && agentRepository.findByEmail(agentDto.getEmail()).isEmpty();
            if (validation.isValid(agentDto) && unique && town.isPresent()) {
                Agent agent = mapper.map(agentDto, Agent.class);
                agent.setTown(town.get());
                agentRepository.save(agent);
                output.add(String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName()));
            } else {
                output.add("Invalid agent");
            }

        }
        return String.join("\n", output);
    }
}
