import java.util.*;

public class userPart {
    public userPart(String name) {
        booking api = new booking();
        Scanner book = new Scanner(System.in);
        tools help = new tools();
        help.clearScreen();

        boolean looping = true;
        while (looping) {
            help.clearScreen();
            System.out.println("Make an appointment here.");
            System.out.println("1. Set a date");
            System.out.println("2. View booking");
            System.out.println("3. Cancel booking");
            System.out.println("4. Exit");

            System.out.println("Enter your choice here: ");
            int choices = book.nextInt();
            book.nextLine();
            help.clearScreen();
            switch (choices) {
                case 1:
                    System.out.println("Enter date (DD-MM-YYYY): ");
                    String date = book.nextLine();
                    System.out.println("Reason for appointment: ");
                    String reason = book.nextLine();
                    api.storeBookingDate(name, date, reason);
                    break;
                case 2:
                    api.checkBookingStatus(name);
                    book.nextLine();
                    break;

                case 3:
                    api.checkBookingStatus(name);
                    System.out.println("\nPlease choose number: ");
                    int index = book.nextInt();
                    book.nextLine();
                    api.removeBooking(name, index);
                    break;
                case 4:
                    looping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        System.exit(0);
        book.close();
    }
}