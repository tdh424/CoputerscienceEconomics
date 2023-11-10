package com.reservation;

import java.util.*;

import com.reservation.Client.MembershipType;

public class ReservationApp {
    private static Map<String, Car> cars = new HashMap<>();
    private static Map<String, Vacation> vacations = new HashMap<>();
    private static Map<String, Booking> bookings = new HashMap<>();
    private static Map<String, Client> clients = new HashMap<>();
    private static Map<String, Bike> bikes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // Create a new item (Car/Vacation/Bike)
                    createNewItem(scanner);
                    break;
                case "2":
                    // Create a new client
                    createNewClient(scanner);
                    break;
                case "3":
                    // List items (Cars, Vacations, and Bikes)
                    listItems();
                    break;
                case "4":
                    // Book a new item
                    bookNewItem(scanner);
                    break;
                case "5":
                    // Cancel a booking
                    cancelBooking(scanner);
                    break;
                case "6":
                    // List all bookings
                    listBookings();
                    break;
                case "7":
                    // List bookings by user
                    listBookingsByUser(scanner);
                    break;
                case "8":
                    // Show revenue of the business
                    showRevenue();
                    break;
                case "exit":
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Create a new item (Car/Vacation/Bike)");
        System.out.println("2. Create a new client");
        System.out.println("3. List items (Cars, Vacations, and Bikes)");
        System.out.println("4. Book a new item");
        System.out.println("5. Cancel a booking");
        System.out.println("6. List all bookings");
        System.out.println("7. List bookings by user");
        System.out.println("8. Show revenue of the business");
        System.out.println("Type 'exit' to quit");
    }


    private static void createNewItem(Scanner scanner) {
        System.out.println("Choose item type to create (Car/Vacation/Bike):");
        String type = scanner.nextLine().toLowerCase();

        switch (type) {
            case "car":
                System.out.println("Enter car license plate:");
                String carLicensePlate = scanner.nextLine();
                System.out.println("Enter year:");
                int carYear = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter make:");
                String carMake = scanner.nextLine();
                System.out.println("Enter number of doors:");
                int numberOfDoors = Integer.parseInt(scanner.nextLine());

                Car car = new Car(carLicensePlate, carYear, carMake, numberOfDoors);
                cars.put(carLicensePlate, car); 
                System.out.println("Car added successfully!");
                break;

            case "vacation":
                System.out.println("Enter country:");
                String country = scanner.nextLine();
                System.out.println("Enter city:");
                String city = scanner.nextLine();
                System.out.println("Enter season:");
                String season = scanner.nextLine();

                Vacation vacation = new Vacation(country, city, season);
                vacations.put(city, vacation); 
                System.out.println("Vacation added successfully!");
                break;
                    
            case "bike":
                System.out.println("Enter bike license plate:");
                String bikeLicensePlate = scanner.nextLine();
                System.out.println("Enter make:");
                String bikeMake = scanner.nextLine();
                System.out.println("Enter year:");
                int bikeYear = Integer.parseInt(scanner.nextLine());

                Bike bike = new Bike(bikeLicensePlate, bikeMake, bikeYear);
                bikes.put(bikeLicensePlate, bike);
                System.out.println("Bike added successfully!");
                break;
                    
            default:
                System.out.println("Invalid type. Please try again.");
        }
    }

    private static void listItems() {
        System.out.println("Cars:");
        for (Car car : cars.values()) {
            System.out.println(car);
        }

        System.out.println("\nVacations:");
        for (Vacation vacation : vacations.values()) {
            System.out.println(vacation);
        }

        System.out.println("\nBikes:");
        for (Bike bike : bikes.values()) {
            System.out.println(bike);
        }
    }
    
    private static void bookNewItem(Scanner scanner) {
        System.out.println("Enter Client ID:");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null) {
            System.out.println("Client not found!");
            return;
        }

        System.out.println("Choose item type to book (Car/Vacation/Bike):");
        String type = scanner.nextLine().toLowerCase();
        Object itemToBook = null;

        switch (type) {
            case "car":
                System.out.println("Enter license plate of the car:");
                String carlicensePlate = scanner.nextLine();
                itemToBook = cars.get(carlicensePlate);
                if (itemToBook == null) {
                    System.out.println("Car not found!");
                    return;
                }
                break;

            case "vacation":
                System.out.println("Enter city of the vacation:");
                String city = scanner.nextLine();
                itemToBook = vacations.get(city);
                if (itemToBook == null) {
                    System.out.println("Vacation not found!");
                    return;
                }
                break;
                
            case "bike":
                System.out.println("Enter Bike License Plate:");
                String bikelicensePlate = scanner.nextLine();
                Bike selectedBike = bikes.get(bikelicensePlate);
                if (selectedBike != null) {
                    itemToBook = selectedBike;
                } else {
                    System.out.println("Bike not found!");
                    return;
                }
                break;
                
            default:
                System.out.println("Invalid type. Please try again.");
                return;
        }

        System.out.println("Enter start date (YYYY-MM-DD):");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date (YYYY-MM-DD):");
        String endDate = scanner.nextLine();

        String bookingID = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingID, startDate, endDate, client, itemToBook);
        bookings.put(bookingID, booking);

        System.out.println("Booking Complete! Booking ID: " + bookingID);
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.println("Enter Booking ID to cancel:");
        String bookingID = scanner.nextLine();

        if (bookings.containsKey(bookingID)) {
            bookings.remove(bookingID);
            System.out.println("Booking cancelled!");
        } else {
            System.out.println("Booking not found!");
        }
    }
    
    private static void listBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("All Bookings:");
        for (Booking booking : bookings.values()) {
            System.out.println(booking);
        }
    }

    private static void listBookingsByUser(Scanner scanner) {
        System.out.println("Enter Client ID:");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null) {
            System.out.println("Client ID not found!");
            return;
        }

        boolean hasBookings = false;
        System.out.println("Bookings for " + client.getName() + ":");
        for (Booking booking : bookings.values()) {
            if (booking.getClient().getClientID().equals(clientID)) {
                System.out.println(booking);
                hasBookings = true;
            }
        }

        if (!hasBookings) {
            System.out.println("No bookings found for this client.");
        }
    }
    
    private static void createNewClient(Scanner scanner) {
        System.out.println("Enter Client Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Birth Date (YYYY-MM-DD):");
        String birthDate = scanner.nextLine();

        System.out.println("Enter Contact Information:");
        String contactInfo = scanner.nextLine();

        System.out.println("Choose Membership (Regular, Silver, Gold):");
        String membershipType = scanner.nextLine().toUpperCase();
        MembershipType membership;
        switch (membershipType) {
            case "SILVER":
                membership = MembershipType.SILVER;
                break;
            case "GOLD":
                membership = MembershipType.GOLD;
                break;
            case "REGULAR":
            default:
                membership = MembershipType.REGULAR;
                break;
        }

        String clientID = UUID.randomUUID().toString(); 
        Client client = new Client(clientID, name, birthDate, contactInfo, membership);
        clients.put(clientID, client);

        System.out.println("Client created! Client ID: " + clientID);
    }

    private static void showRevenue() {
        final double CAR_BOOKING_REVENUE = 100.0;
        final double VACATION_BOOKING_REVENUE = 200.0; 
        final double BIKE_BOOKING_REVENUE = 50.0;

        double totalRevenue = 0.0;

        for (Booking booking : bookings.values()) {
            Client client = booking.getClient();
            if (booking.getItem() instanceof Car) {
                totalRevenue += CAR_BOOKING_REVENUE * (1 - (client.getMembership().getDiscount() / 100.0));
            } else if (booking.getItem() instanceof Vacation) {
                totalRevenue += VACATION_BOOKING_REVENUE * (1 - (client.getMembership().getDiscount() / 100.0));
            } else if (booking.getItem() instanceof Bike) {
                totalRevenue += BIKE_BOOKING_REVENUE * (1 - (client.getMembership().getDiscount() / 100.0));
            }
        }

        System.out.println("Total Revenue: $" + totalRevenue);
    }
}
