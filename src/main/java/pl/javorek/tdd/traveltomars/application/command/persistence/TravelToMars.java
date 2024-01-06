package pl.javorek.tdd.traveltomars.application.command.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TravelToMars {
    @Id
    private Integer version;

    public static TravelToMars planTravel() {
        return new TravelToMars(1);
    }

    public TravelToMars(int version) {
        this.version = version;
    }
}
