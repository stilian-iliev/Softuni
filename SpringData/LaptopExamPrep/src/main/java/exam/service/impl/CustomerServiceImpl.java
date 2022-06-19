package exam.service.impl;

import com.google.gson.Gson;
import exam.model.customer.Customer;
import exam.model.customer.CustomerImportDto;
import exam.model.town.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Path CUSTOMERS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "customers.json");

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        gson = new Gson();

        mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(CUSTOMERS_JSON_PATH);
    }

    @Override
    public String importCustomers() throws IOException {
        CustomerImportDto[] customerImportDtos = gson.fromJson(new FileReader(CUSTOMERS_JSON_PATH.toString()), CustomerImportDto[].class);
        List<String> output = new ArrayList<>();

        for (CustomerImportDto customerDto : customerImportDtos) {
            if (customerDto.validate() && customerRepository.findByEmail(customerDto.getEmail()) == null) {
                Customer customer = mapper.map(customerDto, Customer.class);
                Town town = townRepository.findByName(customer.getTown().getName());
                customer.setTown(town);
                customerRepository.save(customer);
                output.add(String.format("Successfully imported Customer %s %s - %s", customer.getFirstName(), customer.getLastName(), customer.getEmail()));
            } else {
                output.add("Invalid Customer");
            }
        }
        return String.join("\n", output);
    }
}
