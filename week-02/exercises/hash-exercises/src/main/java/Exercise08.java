import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise08 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Instantiate a new HashMap<String, Vehicle> named `twoThousandSix`.
        // 2. Loop through `vehicleMap` and all 2006 vehicles to `twoThousandSix`;
        // 3. Loop through `twoThousandSix` and display all vehicles.
        // (You may want to use your print all method from Exercise03.)
        // 4. How many 2006 vehicles are there? (Expected: 50)

        HashMap<String, Vehicle> twoThousandSix = new HashMap<>();
        int count = 0;

        for (Vehicle v : vehicleMap.values()) {
            if (v.getYear() == 2006) {
                twoThousandSix.put(v.getVin(), v);
            }
        }

        for (Vehicle v : twoThousandSix.values()) {
            count++;
            System.out.printf("%s %s %d %s%n", v.getMake(), v.getModel(), v.getYear(), v.getColor());
        }

        System.out.println(count);

    }
}
