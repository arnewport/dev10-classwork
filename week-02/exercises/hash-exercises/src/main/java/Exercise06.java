import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;
import java.util.Map;

public class Exercise06 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Loop over each vehicle in `vehicleMap` and print vehicles with a Dodge make.
        // 2. Loop three times with three different techniques: .values(), .entrySet(), and .keySet().

        System.out.println(".values() technique");
        for (Vehicle v : vehicleMap.values()) {
            if (v.getMake().equals("Dodge")) {
                System.out.println(v);
            }
        }

        System.out.println(".entrySet() technique");
        for (Map.Entry<String, Vehicle> entry : vehicleMap.entrySet()) {
            if (entry.getValue().getMake().equals("Dodge")) {
                System.out.println(entry);
            }
        }

        // declaring Vehicle v is not required but makes the code more readable
        System.out.println(".keySet() technique");
        for (String key : vehicleMap.keySet()) {
            Vehicle v = vehicleMap.get(key);
            if (v.getMake().equals("Dodge")) {
                System.out.println(v);
            }
        }
    }
}
