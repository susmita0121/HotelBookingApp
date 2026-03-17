public class HotelBookingApp {


    public abstract class Room {

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

        public abstract void displayDetails();
    }

    class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 250, 1500);
        }

        public void displayDetails() {
            System.out.println("Single Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
        }
    }

    class DoubleRoom extends Room {

        public DoubleRoom() {
            super("Double Room", 2, 400, 2500);
        }

        public void displayDetails() {
            System.out.println("Double Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
        }
    }

    class SuiteRoom extends Room {

        public SuiteRoom() {
            super("Suite Room", 3, 750, 5000);
        }

        public void displayDetails() {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + getBeds());
            System.out.println("Size: " + getSize() + " sqft");
            System.out.println("Price per night: " + getPrice());
        }
    }

    public class HotelBookingApp {

        public static void main(String[] args) {

            System.out.println("Hotel Room Initialization\n");

            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            int singleAvailable = 5;
            int doubleAvailable = 3;
            int suiteAvailable = 2;

            single.displayDetails();
            System.out.println("Available: " + singleAvailable + "\n");

            doubleRoom.displayDetails();
            System.out.println("Available: " + doubleAvailable + "\n");

            suite.displayDetails();
            System.out.println("Available: " + suiteAvailable);
        }
    }
}