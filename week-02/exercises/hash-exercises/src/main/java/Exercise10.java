import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise10 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Replace the vehicle with VIN 2G4WD582061270646 with a new Orange 1994 Chrysler School Bus.
        // 2. Retrieve the new vehicle from `vehicleMap` and print it to confirm it was updated.
        vehicleMap.remove("2G4WD582061270646");
        vehicleMap.put("2G4WD582061270646", new Vehicle("2G4WD582061270646", "School Bus", "Chrysler", 1994, "Orange"));
        System.out.println(vehicleMap.get("2G4WD582061270646"));

    }
}
