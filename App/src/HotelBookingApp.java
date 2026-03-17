
import java.util.HashMap;
public class HotelBookingApp {

    abstract class Room {

        private String type;
        private int beds;
        private int size;
        private double price;

        public Room(String type, int beds, int size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public int getBeds() {
            return beds;
        }

        public int getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        public abstract void displayDetails(int available);
    }

    class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 250, 1500);
        }

        public void displayDetails(int available) {
            System.out.println("Single Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
            System.out.println("Available: " + available + "\n");
        }
    }

    class DoubleRoom extends Room {

        public DoubleRoom() {
            super("Double Room", 2, 400, 2500);
        }

        public void displayDetails(int available) {
            System.out.println("Double Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
            System.out.println("Available: " + available + "\n");
        }
    }

    class SuiteRoom extends Room {

        public SuiteRoom() {
            super("Suite Room", 3, 750, 5000);
        }

        public void displayDetails(int available) {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
            System.out.println("Available: " + available);
        }
    }

    class RoomInventory {

        private HashMap<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 0); // intentionally 0 to test filtering
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }
    }

    class RoomSearchService {

        public void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {

            System.out.println("Hotel Room Initialization\n");

            for (Room room : rooms) {

                int available = inventory.getAvailability(room.getType());

                if (available > 0) { // filter unavailable rooms
                    room.displayDetails(available);
                }
            }
        }
    }

    public class HotelBookingApp {

        public static void main(String[] args) {

            RoomInventory inventory = new RoomInventory();

            Room[] rooms = {
                    new SingleRoom(),
                    new DoubleRoom(),
                    new SuiteRoom()
            };

            RoomSearchService searchService = new RoomSearchService();

            searchService.searchAvailableRooms(inventory, rooms);
        }
    }
}