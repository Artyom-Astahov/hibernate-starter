package by.Artem.hibernate.starter.persister;


import by.Artem.hibernate.starter.entity.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cfg.Configuration;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TicketEntityPersister {
    @Getter
    private static final TicketEntityPersister INSTANCE = new TicketEntityPersister();


    public void save(Ticket ticket) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
        }

    }

    public void update(Ticket ticket) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
        }
    }

    public void delete(Ticket ticket) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(ticket);
            session.getTransaction().commit();
        }
    }

}
