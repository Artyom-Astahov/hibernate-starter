package by.Artem.hibernate.starter.entity.example;


import by.Artem.hibernate.starter.conventer.example.BirthDayConventer;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    @Convert(converter = BirthDayConventer.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;
}
