package softuni.exam.config;

import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.util.impl.ValidationUtilImpl;
import softuni.exam.util.impl.XmlParserImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean(name = "default")
    @Primary
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "date")
    public ModelMapper modelDateMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
        return mapper;
    }

    @Bean(name = "dateTime")
    public ModelMapper modelDateTimeMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });
        return mapper;
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

}
