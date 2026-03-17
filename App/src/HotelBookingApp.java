
import java.util.*;

class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
    }

    public void increaseAvailability(String roomType) {
        inventory.put(roomType, inventory.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return inventory.get(roomType);
    }
}

class CancellationService {

    private Set<String> confirmedBookings;
    private Stack<String> rollbackStack;

    public CancellationService() {
        confirmedBookings = new HashSet<>();
        rollbackStack = new Stack<>();
    }

    public void addBooking(String reservationId) {
        confirmedBookings.add(reservationId);
    }

    public void cancelBooking(String reservationId, String roomType, RoomInventory inventory) {

        System.out.println("Booking Cancellation");

        if (!confirmedBookings.contains(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found");
            return;
        }

        rollbackStack.push(reservationId);

        inventory.increaseAvailability(roomType);

        confirmedBookings.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

        System.out.println("\nRollback History (Most Recent First):");
        System.out.println("Released Reservation ID: " + rollbackStack.peek());

        System.out.println("\nUpdated " + roomType + " Room Availability: " + inventory.getAvailability(roomType));
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        service.addBooking("Single-1");

        service.cancelBooking("Single-1", "Single", inventory);
    }
}