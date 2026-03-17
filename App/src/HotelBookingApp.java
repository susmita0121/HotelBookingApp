import java.util.LinkedList;
import java.util.Queue;

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

    class BookingQueue {

        private Queue<Reservation> queue;

        public BookingQueue() {
            queue = new LinkedList<>();
        }

        public void addRequest(Reservation reservation) {
            queue.add(reservation);
            System.out.println("Request Added: " + reservation.getGuestName() + " -> " + reservation.getRoomType());
        }

        public void displayQueue() {
            System.out.println("\nCurrent Booking Queue:\n");

            for (Reservation r : queue) {
                System.out.println("Guest: " + r.getGuestName() + ", Room: " + r.getRoomType());
            }
        }
    }

    public class UseCase5BookingRequestQueue {

        public static void main(String[] args) {

            System.out.println("Booking Request Queue (FIFO)\n");

            BookingQueue bookingQueue = new BookingQueue();

            bookingQueue.addRequest(new Reservation("Arun", "Single Room"));
            bookingQueue.addRequest(new Reservation("Priya", "Double Room"));
            bookingQueue.addRequest(new Reservation("Rahul", "Suite Room"));

            bookingQueue.displayQueue();
        }
    }
}