package bg.softuni.linkedout.services;

import bg.softuni.linkedout.models.Company;
import bg.softuni.linkedout.models.dtos.CompanyAddDto;
import bg.softuni.linkedout.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}