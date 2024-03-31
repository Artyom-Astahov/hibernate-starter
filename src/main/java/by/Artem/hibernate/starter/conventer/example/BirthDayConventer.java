package by.Artem.hibernate.starter.conventer.example;

import by.Artem.hibernate.starter.entity.example.Birthday;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.util.Optional;

public class BirthDayConventer implements AttributeConverter<Birthday, Date> {
    @Override
    public Date convertToDatabaseColumn(Birthday birthday) {
        return Optional.ofNullable(birthday)
                .map(Birthday::birthDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public Birthday convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(Date::toLocalDate)
                .map(Birthday::new)
                .orElse(null);
    }
}
