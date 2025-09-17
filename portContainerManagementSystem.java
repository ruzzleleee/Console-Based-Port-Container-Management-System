import java.util.*;

public class portContainerManagementSystem {

    private static Scanner scan = new Scanner(System.in);
    private static ArrayDeque<container> containerStack = new ArrayDeque<>();
    private static ArrayDeque<ship> shipsQueue = new ArrayDeque<>();
    public static void main(String[] args) {
        int choice;
        do {
            menu();
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> storeContainer();
                case 2 -> viewContainer();
                case 3 -> registerShip();
                case 4 -> viewShips();
                case 5 -> loadNextShip();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

    }
    
    public static void menu() {
        System.out.println("""
=== Port Container Management System ===
[1] Store container (push)
[2] View port containers
[3] Register arriving ship (enqueue)
[4] View waiting ships
[5] Load next ship (pop container + poll ship)
[0] Exit
        """);
    }

    public static void storeContainer(){
        System.out.print("Enter ID: ");
        String id = scan.next();
        System.out.print("Enter Description: ");
        String description = scan.next();
        System.out.print("Enter Weight: ");
        int weight = scan.nextInt();

        container cont = new container(id, description, weight);
        containerStack.push(cont);
        System.out.println("Stored: " + cont);

    }

    public static void viewContainer() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers at the port.");
            return;
        }
        System.out.println("\nTOP >");
        for (container theCotainers : containerStack) {
            System.out.println(theCotainers);
        }
        System.out.println("< BOTTOM");

    }

    public static void registerShip() {
        System.out.print("Enter Ship Name: ");
        String shipName = scan.next();
        System.out.print("Enter Captain Name: ");
        String captainName = scan.next();

        ship ships = new ship(shipName, captainName);
        shipsQueue.offer(ships);
        System.out.println("Registered: MV " + ships);
    }

    public static void viewShips() {
        if (shipsQueue.isEmpty()) {
            System.out.println("No ships waiting on the port as of the moment.");
            return;
        }
        System.out.println("\nTOP >");
        for (ship theShips : shipsQueue) {
            System.out.println(theShips);
        }
        System.out.println("< BOTTOM");
    }
    public static void loadNextShip() {
         if (containerStack.isEmpty() || shipsQueue.isEmpty()) {
            System.out.println("Cannot load: Either no containers or no ships available.");
            return;
        }

        container cont = containerStack.pop();
        ship ship = shipsQueue.poll();
        System.out.println("Loaded: " + cont + " → " + ship);
        System.out.println("Remaining containers: " + containerStack.size());
        System.out.println("Remaining ships waiting: " + shipsQueue.size());
    }
}