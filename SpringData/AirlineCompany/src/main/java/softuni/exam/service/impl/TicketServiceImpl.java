package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Passenger;
import softuni.exam.models.Plane;
import softuni.exam.models.Ticket;
import softuni.exam.models.Town;
import softuni.exam.models.dto.ticket.TicketImportDto;
import softuni.exam.models.dto.ticket.TicketListImportDto;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private final Path TICKET_JSON_PATH = Path.of("src", "main", "resources", "files", "xml", "tickets.xml");

    private final ValidationUtil validator;
    private final TicketRepository ticketRepository;
    private final PlaneRepository planeRepository;
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ModelMapper mapper;

    public TicketServiceImpl(ValidationUtil validator, TicketRepository ticketRepository, PlaneRepository planeRepository, PassengerRepository passengerRepository, TownRepository townRepository, XmlParser xmlParser,@Qualifier("dateTimeMapper") ModelMapper mapper) {
        this.validator = validator;
        this.ticketRepository = ticketRepository;
        this.planeRepository = planeRepository;
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(TICKET_JSON_PATH);
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(TicketListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TicketListImportDto ticketListImportDto = (TicketListImportDto) unmarshaller.unmarshal(new FileReader(TICKET_JSON_PATH.toString()));

        List<String> output = new ArrayList<>();
        for (TicketImportDto ticketDto : ticketListImportDto.getTickets()) {
            Optional<Town> fromTown = townRepository.findByName(ticketDto.getFromTown().getName());
            Optional<Town> toTown = townRepository.findByName(ticketDto.getToTown().getName());
            Optional<Passenger> passenger = passengerRepository.findByEmail(ticketDto.getPassenger().getEmail());
            Optional<Plane> plane = planeRepository.findByRegisterNumber(ticketDto.getPlane().getRegisterNumber());

            boolean exists = ticketRepository.findBySerialNumber(ticketDto.getSerialNumber()).isPresent();
            if (!exists && validator.isValid(ticketDto) && fromTown.isPresent() && toTown.isPresent() && passenger.isPresent() && plane.isPresent()) {
                Ticket ticket = mapper.map(ticketDto, Ticket.class);
                ticket.setFromTown(fromTown.get());
                ticket.setToTown(toTown.get());
                ticket.setPassenger(passenger.get());
                ticket.setPlane(plane.get());
                ticketRepository.save(ticket);

                output.add(String.format("Successfully imported Ticket %s - %s", ticket.getFromTown().getName(), ticket.getToTown().getName()));
            } else {
                output.add("Invalid Ticket");
            }
        }

        return String.join("\n", output);
    }
}
