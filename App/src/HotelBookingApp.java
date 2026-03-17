import java.util.*;
public class HotelBookingApp {

    class Reservation {

        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    class RoomInventory {

        private HashMap<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single Room", 2);
            inventory.put("Double Room", 1);
            inventory.put("Suite Room", 1);
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        public void reduceAvailability(String roomType) {
            if (inventory.get(roomType) > 0) {
                inventory.put(roomType, inventory.get(roomType) - 1);
            }
        }
    }

    class BookingService {

        private Queue<Reservation> queue;
        private HashMap<String, Set<String>> allocatedRooms;
        private int roomCounter = 1;

        public BookingService(Queue<Reservation> queue) {
            this.queue = queue;
            allocatedRooms = new HashMap<>();
        }

        public void processBookings(RoomInventory inventory) {

            System.out.println("Processing Bookings...\n");

            while (!queue.isEmpty()) {

                Reservation r = queue.poll();
                String type = r.getRoomType();

                if (inventory.getAvailability(type) > 0) {

                    String roomId = generateRoomId(type);

                    allocatedRooms.putIfAbsent(type, new HashSet<>());
                    allocatedRooms.get(type).add(roomId);

                    inventory.reduceAvailability(type);

                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + r.getGuestName());
                    System.out.println("Room Type: " + type);
                    System.out.println("Room ID: " + roomId + "\n");

                } else {
                    System.out.println("Booking Failed (No Availability): " + r.getGuestName() + " -> " + type + "\n");
                }
            }
        }

        private String generateRoomId(String type) {
            return type.substring(0, 2).toUpperCase() + roomCounter++;
        }
    }

    public class HotelBookingApp {

        public static void main(String[] args) {

            Queue<Reservation> queue = new LinkedList<>();

            queue.add(new Reservation("Arun", "Single Room"));
            queue.add(new Reservation("Priya", "Single Room"));
            queue.add(new Reservation("Rahul", "Single Room")); // will fail
            queue.add(new Reservation("Neha", "Double Room"));

            RoomInventory inventory = new RoomInventory();

            BookingService bookingService = new BookingService(queue);

            bookingService.processBookings(inventory);
        }
    }
}