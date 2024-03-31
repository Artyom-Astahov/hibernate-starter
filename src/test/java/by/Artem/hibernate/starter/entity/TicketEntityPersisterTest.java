package by.Artem.hibernate.starter.entity;

import by.Artem.hibernate.starter.persister.TicketEntityPersister;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketEntityPersisterTest {

    private final TicketEntityPersister ticketEntityPersister = TicketEntityPersister.getINSTANCE();


    @Test
    public void save() {
        Ticket ticket = Ticket.builder()
                .id(90L)
                .passportNo("AB123456")
                .passengerName("John DDD")
                .flightId(1L)
                .seatNo("A23")
                .cost(100.0f)
                .build();
        ticketEntityPersister.save(ticket);
        Configuration configuration = new Configuration();
        configuration.configure();
        Ticket ticketResult;
        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.openSession();
            session.beginTransaction();
            ticketResult = session.get(Ticket.class, 90L);
            session.getTransaction().commit();
            session.close();

            Assertions.assertEquals(ticket.getId(), ticketResult.getId());
            var session2 = sessionFactory.openSession();
            session2.beginTransaction();
            session2.delete(ticket);
            session2.getTransaction().commit();
            session2.close();
        }


    }

    @Test
    public void update() {

        Ticket ticket = Ticket.builder()
                .id(92L)
                .passportNo("AB123456")
                .passengerName("John Doe")
                .flightId(1L)
                .seatNo("A23")
                .cost(100.0f)
                .build();

        Configuration configuration = new Configuration();
        configuration.configure();
        Ticket ticketResult;
        try (var sessionFactory = configuration.buildSessionFactory();
        ) {
            var session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
            session.close();

            ticket.setPassengerName("John DDD");
            ticketEntityPersister.update(ticket);

            var session2 = sessionFactory.openSession();
            session2.beginTransaction();
            ticketResult = session2.get(Ticket.class, 92L);
            session2.getTransaction().commit();
            session2.close();

            Assertions.assertEquals(ticket.getPassengerName(), ticketResult.getPassengerName());

            var session3 = sessionFactory.openSession();
            session3.beginTransaction();
            session3.delete(ticket);
            session3.getTransaction().commit();
            session3.close();

        }


    }


    @Test
    public void delete() {
        Ticket ticketResult;
        Ticket ticketExample = Ticket.builder()
                .id(91L)
                .passportNo("AB123456")
                .passengerName("John DDD")
                .flightId(1L)
                .seatNo("A23")
                .cost(100.0f)
                .build();

        Configuration configuration = new Configuration();
        configuration.configure();
        try (var sessionFactory = configuration.buildSessionFactory()
        ) {
            var session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(ticketExample);
            session.getTransaction().commit();
            session.close();

            ticketEntityPersister.delete(ticketExample);

            var session2 = sessionFactory.openSession();
            session2.beginTransaction();
            ticketResult = session2.get(Ticket.class, 91L);
            session2.getTransaction().commit();
            session2.close();

        }
        Assertions.assertNull(ticketResult);
    }
}
