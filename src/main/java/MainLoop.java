import vehicles.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ToString
class MainLoop {

    private static final Logger logger = LogManager.getLogger(MainLoop.class);
    private Scanner scanner = new Scanner(System.in);

    void optionsLoop() {
        ArrayList<Vehicles> twoVehicles = new ArrayList();
        addVehiclesToList(twoVehicles);

        Option option;
        do {
            showOptions();
            option = getOption();
            switch (option) {
                case CAR:
                case PLANE:
                case BICYCLE:
                case SHIP:
                    showTheFastestVehicle(twoVehicles,option.toString());
                    break;
                case ALL:
                    showAllVehicles(twoVehicles);
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    logger.debug("Podaj prawidłową opcję!");
            }
        } while (option != Option.EXIT);
    }

    private void showTheFastestVehicle(ArrayList<Vehicles> vehiclesList, String usersChoice) {
        Vehicles fastest = vehiclesList.get(0);
        int maxSpeed = fastest.getMaxVelocity();

        for (int i = 0; i < vehiclesList.size() - 1; i++) {
            fastest = vehiclesList.get(i);

            if (ifTheSameClass(fastest, vehiclesList, i)) {
                if (vehiclesList.get(i+1).getMaxVelocity() < vehiclesList.get(i).getMaxVelocity()) {
                    maxSpeed = vehiclesList.get(i).getMaxVelocity();
                    fastest = vehiclesList.get(i);
                    PrintInformationAboutFastestAmongGivenClass(usersChoice, fastest);
                }
                else {
                    maxSpeed = vehiclesList.get(i+1).getMaxVelocity();
                    fastest = vehiclesList.get(i+1);
                    PrintInformationAboutFastestAmongGivenClass(usersChoice, fastest);
                }
            }
        }
    }

    private void PrintInformationAboutFastestAmongGivenClass(String usersChoice, Vehicles fastest) {
        if(usersChoice.equalsIgnoreCase(fastest.getType())) {
            logger.info("Pojazd {} producenta {} jest najszybszy (maksymalna predkosc = {} )", fastest.getType(), fastest.getProducer(), fastest.getMaxVelocity());
        }
    }

    private boolean ifTheSameClass(Vehicles fastest,ArrayList<Vehicles> vehiclesList, int index){
        return fastest.getClass().equals(vehiclesList.get(index+1).getClass());
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

    private void showAllVehicles(ArrayList<Vehicles> twoVehicles) {
        for (Vehicles vehicle : twoVehicles) {
            logger.info(vehicle.toString());
        }
    }

    private void addVehiclesToList(ArrayList<Vehicles> twoVehicles) {
        twoVehicles.add(new Car("Ford", 220, 1990));
        twoVehicles.add(new Car("Fiat", 10, 2010));
        twoVehicles.add(new Bicycle("Ghost", 50, "Górski"));
        twoVehicles.add(new Bicycle("Ghost", 25, "Miejski"));
        twoVehicles.add(new Ship("GhostMarine", 100, "Tiger"));
        twoVehicles.add(new Ship("GhostMarine", 80, "Titanic"));
        twoVehicles.add(new Plane("ArabicAirlines", 500, "Boeing-750"));
        twoVehicles.add(new Plane("ArabicAirlines", 480, "Boeing-630"));
    }
}
