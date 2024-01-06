package pl.javorek.tdd.traveltomars.application.command.persistence;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
public class TravelToMars {
    @Id
    private UUID id;

    public TravelToMars() {
        this.id = UUID.randomUUID();
    }
}
