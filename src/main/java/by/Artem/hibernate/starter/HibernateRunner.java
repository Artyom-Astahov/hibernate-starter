package by.Artem.hibernate.starter;


import by.Artem.hibernate.starter.conventer.example.BirthDayConventer;
import by.Artem.hibernate.starter.entity.Ticket;
import by.Artem.hibernate.starter.entity.example.Birthday;
import by.Artem.hibernate.starter.entity.example.Role;
import by.Artem.hibernate.starter.entity.example.User;
import by.Artem.hibernate.starter.persister.TicketEntityPersister;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Month;

public class HibernateRunner {


    public static void main(String[] args) {
        TicketEntityPersister ticketEntityPersister = TicketEntityPersister.getINSTANCE();
        Ticket ticket = Ticket.builder()
                .id(66L)
                .passportNo("AB123456")
                .passengerName("John DDD")
                .flightId(1L)
                .seatNo("A23")
                .cost(100.0f)
                .build();


//            ticketEntityPersister.save(ticket);
//            ticketEntityPersister.update(ticket);
//            ticketEntityPersister.delete(ticket);





    }
}
