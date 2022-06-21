package bg.softuni.linkedout.services;

import bg.softuni.linkedout.models.Company;
import bg.softuni.linkedout.models.dtos.CompanyAddDto;
import bg.softuni.linkedout.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;

    public CompanyService(CompanyRepository companyRepository, ModelMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }


    public void add(CompanyAddDto companyAddDto) {
        Company company = mapper.map(companyAddDto, Company.class);
        companyRepository.save(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(UUID companyId) {
        return companyRepository.getReferenceById(companyId);
    }

    public void delete(UUID companyId) {
        Optional<Company> byId = companyRepository.findById(companyId);
        byId.ifPresent(companyRepository::delete);
    }
}
