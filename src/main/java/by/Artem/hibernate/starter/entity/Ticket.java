package by.Artem.hibernate.starter.entity;


import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private Long id;
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "seat_no")
    private String seatNo;
    private Float cost;
}
