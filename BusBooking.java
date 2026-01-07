import java.util.*;

class BusBooking {

    static Scanner sc = new Scanner(System.in);
    static int ticketNumber = 7654567;

    public static void main(String[] args) {

        System.out.println("===========================================================================");
        System.out.println("       *********** WELCOME ALL INDIA BUS BOOKING ***********");
        System.out.println("===========================================================================");

        System.out.println("****** AVAILABLE TRIPS ******");
        System.out.println("1. BENGALURU - CHENNAI");
        System.out.println("2. MUMBAI - BENGALURU");
        System.out.println("3. BENGALURU - HYDERABAD");
        System.out.println("4. BENGALURU - MYSORE");
        System.out.println("5. COCHI - BENGALURU");

        System.out.println("\n****** JOURNEY TYPE ******");
        System.out.println("1. AC SLEEPER");
        System.out.println("2. SEMI SLEEPER");
        System.out.println("3. SEATER");

        System.out.println("===========================================================================");
        System.out.print("SELECT YOUR TRIP SEQUENCE : ");
        int tripChoice = sc.nextInt();

        System.out.print("ENTER JOURNEY DATE (DD/MM/YYYY) : ");
        String date = sc.next();

        System.out.print("SELECT BUS TYPE (1/2/3) : ");
        int busType = sc.nextInt();

        int farePerSeat = getFare(busType);

        showAvailableBuses(farePerSeat);

        System.out.print("SELECT BUS NAME : ");
        String busName = sc.next();

        System.out.print("NUMBER OF SEATS : ");
        int seats = sc.nextInt();

        String[] names = new String[seats];
        String[] genders = new String[seats];
        long[] contacts = new long[seats];

        for (int i = 0; i < seats; i++) {
            System.out.print("PASSENGER " + (i + 1) + " NAME : ");
            names[i] = sc.next();
            System.out.print("GENDER : ");
            genders[i] = sc.next();
            System.out.print("CONTACT NUMBER : ");
            contacts[i] = sc.nextLong();
        }

        int basicFare = seats * farePerSeat;
        double tax = basicFare * 0.05;
        double totalFare = basicFare + tax;

        printTicket(tripChoice, date, busType, busName, seats, names, genders, contacts, basicFare, tax, totalFare);
    }

    static int getFare(int busType) {
        if (busType == 1) return 1500;
        if (busType == 2) return 1000;
        return 500;
    }

    static void showAvailableBuses(int fare) {
        System.out.println("===========================================================================");
        System.out.println("*** AVAILABLE BUSES ***");
        System.out.println("VOLVO       9 AM - 1 PM     FARE = " + fare);
        System.out.println("RAJADHANI   10 AM - 2 PM    FARE = " + fare);
        System.out.println("AMBARI      11 AM - 3 PM    FARE = " + fare);
        System.out.println("JABBAR      4 PM - 9 PM     FARE = " + fare);
        System.out.println("AIRAVATHA   9 PM - 1 AM     FARE = " + fare);
        System.out.println("===========================================================================");
    }

    static void printTicket(int tripChoice, String date, int busType, String busName,
                            int seats, String[] names, String[] genders,
                            long[] contacts, int basicFare, double tax, double totalFare) {

        System.out.println("\n===========================================================================");
        System.out.println("               *********** BUS TICKET ***********");
        System.out.println("===========================================================================");
        System.out.println("BUS NAME        : " + busName);
        System.out.println("BUS TYPE        : " + busType);
        System.out.println("TICKET NUMBER   : " + ticketNumber);
        System.out.println("JOURNEY DATE    : " + date);
        System.out.println("TOTAL SEATS     : " + seats);
        System.out.println("===========================================================================");

        for (int i = 0; i < seats; i++) {
            System.out.println("PASSENGER " + (i + 1));
            System.out.println("NAME    : " + names[i]);
            System.out.println("GENDER  : " + genders[i]);
            System.out.println("CONTACT : " + contacts[i]);
            System.out.println("-----------------------------------------------------------------------");
        }

        System.out.println("BASIC FARE      : " + basicFare);
        System.out.println("TRANSPORT TAX   : " + tax);
        System.out.println("TOTAL AMOUNT    : " + totalFare);
        System.out.println("===========================================================================");
        System.out.println("                 *********** THANK YOU ***********");
        System.out.println("===========================================================================");
    }
}
