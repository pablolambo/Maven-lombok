package vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plane extends Vehicles{
    private String name;

    public Plane(String producer, int maxVelocity, String name) {
        super(producer, maxVelocity);
        this.name = name;
    }

    @Override
    public String getType() {
        return "plane";
    }

    @Override
    public String toString() {
        return name + " " + getProducer() + ", maksymalna predkosc: " + getMaxVelocity();
    }
}
