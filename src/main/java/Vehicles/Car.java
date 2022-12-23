package Vehicles;

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
}
