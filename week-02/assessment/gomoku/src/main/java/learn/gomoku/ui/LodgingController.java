package learn.gomoku.ui;

import learn.gomoku.utilities.ConsoleHelper;

//public class LodgingController {
//    private final ConsoleHelper io = new ConsoleHelper();
//    private Lodging lodging;
//
//    public void run() {
//        io.printHeader("Welcome to the Lodging Manager!");
//        // Ask how many rooms we want for the capsule hotel
//        int roomCount = io.readInt("How many rooms would you like in your lodging?");
//        // TODO: Make this dynamic, e.g., new Inn(), new Resort(), new Motel()
//        lodging = new CapsuleHotel(roomCount);
//
//        // Display the Hotel Manager menu
//        runMenu();
//    }
//
//    private void handleCheckIn() {
//        io.printHeader("Check In Guest");
//
//        if (lodging.isFull()) {
//            System.out.println("[Error]: Lodging is at capacity. No rooms available.");
//            return;
//        }
//
//        boolean checkedIn = false;
//        int roomNumber;
//
//        Guest guest = new Guest();
//        guest.setName(io.readRequiredString("What is the guest name?"));
//        guest.setEmail(io.readRequiredString("What is the guest email?"));
//        guest.setPhoneNumber(io.readString("What is the guest phone number?"));
//
//
//        do {
//            roomNumber = io.readInt("Enter Room Number: ");
//            checkedIn = lodging.checkIn(guest, roomNumber);
//            if (!checkedIn) {
//                io.print("[Error]: Please provide a valid room, unoccupied number!");
//            }
//
//        } while (!checkedIn);
//
//        io.print(String.format("Success! %s is booked into room %s", guest.getName(), roomNumber));
//    }
//
//    private void handleViewGuests() {
//        io.printHeader("View Guests By Room");
//        // Get the user input (which capsule they want to view)
//        int roomNumber = io.readInt("Which room would you like to view?");
//        String guestList = lodging.getGuestList(roomNumber);
//        io.print(guestList);
//
//    }
//
//    private void handleCheckOut() {
//        io.printHeader("Check Out Guest");
//        int roomNumber = io.readInt("Which room number would you like to check out?");
//        boolean checkedOut = lodging.checkOut(roomNumber);
//        if (checkedOut) {
//            io.print("Successfully checked out from room " + roomNumber);
//        } else {
//            io.print("[Error]: Please provide a valid, occupied room number.");
//        }
//    }
//
//    private void runMenu() {
//        boolean exit = false;
//
//        do {
//            String menuOption = getMenuOption();
//            switch (menuOption) {
//                case "1" -> handleCheckIn();
//                case "2" -> handleCheckOut();
//                case "3" -> handleViewGuests();
//                case "4" -> {
//                    // TODO: Exit confirm
//                    io.print("Exiting program...");
//                    exit = true;
//                }
//                default -> io.print("Unknown option.");
//            }
//        } while (!exit);
//    }
//
//    private String getMenuOption() {
//        io.printHeader("Menu Options");
//        io.print("1. Check In");
//        io.print("2. Check Out");
//        io.print("3. View Guests");
//        io.print("4. Exit");
//
//        return io.readRequiredString("Choose an option [1-4]: ");
//    }
//}
