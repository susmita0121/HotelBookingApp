

import java.util.*;

class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return history;
    }
}

class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("Booking History Report\n");

        for (Reservation r : reservations) {
            System.out.println("Reservation ID: " + r.getReservationId());
            System.out.println("Guest: " + r.getGuestName());
            System.out.println("Room Type: " + r.getRoomType());
            System.out.println("--------------------------");
        }

        System.out.println("Total Bookings: " + reservations.size());
    }
}

public class HotelBookingApp{

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("SI1", "Arun", "Single Room"));
        history.addReservation(new Reservation("SI2", "Priya", "Single Room"));
        history.addReservation(new Reservation("DO3", "Rahul", "Double Room"));

        BookingReportService reportService = new BookingReportService();

        reportService.generateReport(history.getAllReservations());
    }
}