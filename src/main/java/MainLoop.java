import Vehicles.*;
import lombok.ToString;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ToString
public class MainLoop {

    void optionsLoop(){
        ArrayList<Vehicles> twoVehicles = new ArrayList();
        twoVehicles.add(new Car("Ford",220,1990));
        twoVehicles.add(new Car("Fiat",10,2010));
        twoVehicles.add(new Bicycle("Ghost", 50, "Górski"));
        twoVehicles.add(new Bicycle("Ghost", 25, "Miejski"));
        twoVehicles.add(new Ship("GhostMarine", 100, "Tiger"));
        twoVehicles.add(new Ship("GhostMarine", 80, "Titanic"));
        twoVehicles.add(new Plane("ArabicAirlines", 500, "Boeing-750"));
        twoVehicles.add(new Plane("ArabicAirlines", 480, "Boeing-630"));

        Option option;
        do {
            showOptions();
            option = getOption();
            switch (option){
                case CAR:
                case PLANE:
                case BICYCLE:
                case SHIP:
                    showTheFastestVehicle(twoVehicles);
                    break;
                case ALL:
                    showAllVehicles(twoVehicles);
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Podaj prawidłową opcję”");          // LOGIEM ZROB
            }
        } while(option != Option.EXIT);
    }

    private void showTheFastestVehicle(Vehicles vehicles) {
        for(Vehicles vehicle : vehicles){

        }
    }

    private void exit(){

    }

    private Option getOption() {
        // zapytaj loggiem jaka chce opcje

    }

    private void showOptions(){
        System.out.println("\nWybierz opcję: ");
        for(Option option : Option.values()){
            System.out.println(option.toString());                        // LOGIEM ZROB
        }
    }

    private enum Option {
        CAR, SHIP, PLANE, BICYCLE, ALL, EXIT
    }

}
