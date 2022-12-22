import Vehicles.Vehicles;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public class MainLoop {

    void optionsLoop(){
        ArrayList<Vehicles> twoVehicles = new ArrayList();
        twoVehicles.add()
        while(option != Options.EXIT) {
            showOptions();
            option = getOption();
            switch (option){
                case:
            }
        }
    }

    private void showOptions(){
        System.out.println("\nWybierz opcję: ");
        for(Option option : Option.values()){
            System.out.println(option.toString());
        }
    }

    private enum Option {
        CAR, SHIP, PLANE, BICYCLE, ALL, EXIT
    }

}
