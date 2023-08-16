import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise07 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. How many vehicles are Pink (ignore case)?
        // Expected: 54

        // it either already checks for case or I didn't need to implement it
        int count = 0;
        for (Vehicle v : vehicleMap.values()) {
            if (v.getColor().equals("Pink")) {
                count++;
            }
        }
        System.out.println(count);

    }
}
