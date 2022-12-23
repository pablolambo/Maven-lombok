package Vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ship extends Vehicles{
    private String name;
    public Ship(String producer, int maxVelocity, String name) {
        super(producer, maxVelocity);
        this.name = name;
    }
}
