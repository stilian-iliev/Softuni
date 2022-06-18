package bg.softuni.battleships.config;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.enums.ShipType;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Configuration
public class ApplicationConfig {
    @Bean
    @Primary

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "ship")
    public ModelMapper modelDateMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new Converter<ShipType, Category>() {
            @Override
            public Category convert(MappingContext<ShipType, Category> mappingContext) {
                return new Category(mappingContext.getSource());
            }
        });
        return mapper;
    }
}
