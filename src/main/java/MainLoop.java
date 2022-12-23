import Vehicles.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ToString
public class MainLoop {

    private static final Logger logger = LogManager.getLogger(MainLoop.class);
    private Scanner scanner = new Scanner(System.in);

    void optionsLoop() {
        ArrayList<Vehicles> twoVehicles = new ArrayList();
        twoVehicles.add(new Car("Ford", 220, 1990));
        twoVehicles.add(new Car("Fiat", 10, 2010));
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
            switch (option) {
                case CAR:
                case PLANE:
                case BICYCLE:
                case SHIP:
                    showTheFastestVehicle(twoVehicles);
                    break;
                case ALL:
                    for (Vehicles vehicle : twoVehicles) {
                        logger.info(vehicle.toString());
                    }
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    logger.debug("Podaj prawidłową opcję!");
            }
        } while (option != Option.EXIT);
    }

    private void showTheFastestVehicle(ArrayList<Vehicles> vehiclesList) {
        Vehicles fastest = vehiclesList.get(0);
        int maxSpeed = 0;
        for (int i = 0; i < vehiclesList.size(); i++) {
            if (ifTheSameClass(fastest,vehiclesList,i)) { // sortowanie babelkowe? kazdy z kazdym musi sprawdzac

            }
        }
    }
        //logger.info("Pojazd {} producenta {} jest najszybszy (maksymalna predkosc = {} )", 3 zmienne);



    private boolean ifTheSameClass(Vehicles fastest,ArrayList<Vehicles> vehiclesList, int index){
        return fastest.getClass().equals(vehiclesList.get(index + 1).getClass());
    }
    private void exit() {
        logger.info("Uzytkownik sie wylogowal.");
    }

    private Option getOption() {
        logger.info("Wybierz opcje:");
        boolean flag = true;
        Option option = null;

        while (flag) {
            try {
                option = Option.valueOf(scanner.nextLine().toUpperCase());
                flag = false;
            } catch (NoSuchElementException | IllegalArgumentException e) {
                logger.warn("Sprobuj ponownie");
            }
        }
        return option;
    }

    private void showOptions() {
        logger.info("Lista opcji:");
        for (Option option : Option.values()) {
            logger.info(option.toString());
        }
    }

    private enum Option {
        CAR, SHIP, PLANE, BICYCLE, ALL, EXIT
    }
}
