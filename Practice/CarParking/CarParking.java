import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import common.Type;
import models.Admin;
import models.Car;
import models.ParkingLot;
import models.Ticket;

public class CarParking {
    Map<String, Car> cars = new HashMap<>();
    Map<String, Ticket> ticket = new HashMap<>();
    ParkingLot parkingLot;
    Admin admin;

    public CarParking() {
        cars = new HashMap<>();
        ticket = new HashMap<>();
        parkingLot = new ParkingLot(10, 5);
        admin = new Admin("admin");
    }

    public boolean parkCar(Car car) {
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select the operation");
            System.out.println("1.Park Car");
            System.out.println("2.Exit Car");
            System.out.println("3.View All Parked Cars");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter car number");
                    String numer = scanner.nextLine();
                    System.out.println("Enter car type");
                    String type = scanner.nextLine();
                    Car car = null;
                    if (type.equalsIgnoreCase("SUV")) {
                        car = new Car(numer, Type.SUV);
                    } else if (type.equalsIgnoreCase("hatchback")) {
                        car = new Car(numer, Type.HATCHBACK);
                    } else {
                        System.out.println("Please enter the valid number and car type");
                    }

                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    return;
            }
        }

    }
}