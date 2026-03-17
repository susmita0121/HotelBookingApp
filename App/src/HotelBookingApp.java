import java.io.*;
import java.util.*;

class RoomInventory implements Serializable {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void displayInventory() {
        for (String type : inventory.keySet()) {
            System.out.println(type + " Rooms: " + inventory.get(type));
        }
    }
}

class BookingHistory implements Serializable {

    private List<String> bookings;

    public BookingHistory() {
        bookings = new ArrayList<>();
    }

    public void addBooking(String booking) {
        bookings.add(booking);
    }

    public List<String> getBookings() {
        return bookings;
    }

    public void displayBookings() {
        for (String b : bookings) {
            System.out.println(b);
        }
    }
}

class PersistenceService {

    private static final String FILE_NAME = "system_state.ser";

    public void save(RoomInventory inventory, BookingHistory history) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(inventory);
            out.writeObject(history);
            out.close();
            System.out.println("System state saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving system state.");
        }
    }

    public Object[] load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            RoomInventory inventory = (RoomInventory) in.readObject();
            BookingHistory history = (BookingHistory) in.readObject();
            in.close();
            System.out.println("System state restored successfully.");
            return new Object[]{inventory, history};
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return null;
        }
    }
}

public class HotelBookingApp{

    public static void main(String[] args) {

        System.out.println("Data Persistence & Recovery");

        PersistenceService service = new PersistenceService();

        Object[] data = service.load();

        RoomInventory inventory;
        BookingHistory history;

        if (data != null) {
            inventory = (RoomInventory) data[0];
            history = (BookingHistory) data[1];
        } else {
            inventory = new RoomInventory();
            history = new BookingHistory();
        }

        history.addBooking("Single-1");
        history.addBooking("Double-1");

        System.out.println("\nCurrent Inventory:");
        inventory.displayInventory();

        System.out.println("\nBooking History:");
        history.displayBookings();

        service.save(inventory, history);
    }
}