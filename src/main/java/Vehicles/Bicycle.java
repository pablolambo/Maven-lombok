package Vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Bicycle extends Vehicles {
    private String type;

    public Bicycle(String type) {
        this.type = type;
    }

    public Bicycle(String producer, int maxVelocity, String type) {
        super(producer, maxVelocity);
        this.type = type;
    }
}
