package Vehicles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class Vehicles {
    private String producer;
    private int maxVelocity; // int czy Integer ???? zadecyduj potem

    public Vehicles(String producer, int maxVelocity) {
        this.producer = producer;
        this.maxVelocity = maxVelocity;
    }
}
