import java.util.*;
    class Service {

        private String name;
        private double price;

        public Service(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    class AddOnServiceManager {

        private Map<String, List<Service>> servicesByReservation;

        public AddOnServiceManager() {
            servicesByReservation = new HashMap<>();
        }

        public void addService(String reservationId, Service service) {

            servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
            servicesByReservation.get(reservationId).add(service);
        }

        public double calculateTotalServiceCost(String reservationId) {

            double total = 0;

            List<Service> services = servicesByReservation.get(reservationId);

            if (services != null) {
                for (Service s : services) {
                    total += s.getPrice();
                }
            }

            return total;
        }
    }

    public class HotelBookingApp {

        public static void main(String[] args) {

            AddOnServiceManager manager = new AddOnServiceManager();

            String reservationId = "Single-1";

            manager.addService(reservationId, new Service("Breakfast", 500));
            manager.addService(reservationId, new Service("Pickup", 1000));

            double totalCost = manager.calculateTotalServiceCost(reservationId);

            System.out.println("Add-On Service Selection");
            System.out.println("Reservation ID: " + reservationId);
            System.out.println("Total Add-On Cost: " + totalCost);
        }
    }
}