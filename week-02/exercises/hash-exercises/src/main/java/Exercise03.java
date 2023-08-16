import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise03 {

    // 1. Create a method to print all Vehicles in a HashMap<String, Vehicle>.
    // Consider making it `public` so you can use it in other exercises.
     public static void printAllVehicles(HashMap<String, Vehicle> hash) {
         for (Vehicle v : hash.values()) {
             System.out.printf("%s %s %d %s%n", v.getMake(), v.getModel(), v.getYear(), v.getColor());
         }
     }

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 2. Print `vehicleMap` using your "print all" method.
        printAllVehicles(vehicleMap);
    }
}

