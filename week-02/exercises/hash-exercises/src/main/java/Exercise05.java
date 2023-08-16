import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise05 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Instantiate a new HashMap<String, Vehicle>.
        // 2. Add two vehicles to the new map.
        // 3. Add items from the new map to `vehicleMap` using the `putAll` method.
        // 4. Confirm the vehicles were added by retrieving on with its VIN and printing it to the console.
        Vehicle exerciseVehicle1 = new Vehicle("test1", "make", "model", 0, "color");
        Vehicle exerciseVehicle2 = new Vehicle("test2", "make", "model", 0, "color");
        HashMap<String, Vehicle> exerciseMap = new HashMap<>();
        exerciseMap.put("test1", exerciseVehicle1);
        exerciseMap.put("test2", exerciseVehicle2);
        System.out.println(exerciseMap.get("test1"));
        System.out.println(exerciseMap.get("test2"));
    }
}
