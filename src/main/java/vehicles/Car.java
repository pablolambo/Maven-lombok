package vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicles{
    private int year;

    public Car(String producer, int maxVelocity, int year) {
        super(producer, maxVelocity);
        this.year = year;
    }

    @Override
    public String getType() {
        return "car";
    }

    @Override
    public String toString() {
        return getProducer() + " " + year + ", maksymalna predkosc: " + getMaxVelocity();
    }
}
