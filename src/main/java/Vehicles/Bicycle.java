package Vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Bicycle extends Vehicles {
    private String type;

    public Bicycle(String producer, int maxVelocity, String type) {
        super(producer, maxVelocity);
        this.type = type;
    }

    @Override
    public String getType() {
        return "bicycle";
    }

    @Override
    public String toString() {
        return getProducer() + " " + type + ", maksymalna predkosc: " + getMaxVelocity();
    }
}
