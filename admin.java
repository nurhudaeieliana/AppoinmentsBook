import java.util.Scanner;

public class admin {
    public static final String txt = null;
    booking api = new booking();
    tools help = new tools();
    Scanner huda;
    public admin()
    {
        huda = new Scanner(System.in);
        int choice = 0;
        while(true)
        {
            help.clearScreen();
            System.out.println("0. Exit");
            System.out.println("1. View Booking");
            System.out.println("2. Accepting/Rejecting Booking");
            System.out.println("3. View Aaccepted Booking");
            System.out.println("4. View Rejected Booking");
            System.out.println("\nPlease enter your choice: ");
            choice = huda.nextInt();
            huda.nextLine();
            switch(choice)
            {
                case 0:
                    return ;
                case 1:
                    viewBooking();
                    break;
                case 2:
                    acceptBooking();
                    break;
                case 3:
                    viewAcceptedBooking();
                    break;
                case 4:
                    viewRejectedBooking();
                    break;
            } 
        }
    }
    public void viewBooking()
    {
        api.checkBookingStatus("");
        huda.nextLine();
    }
    public void acceptBooking()
    {
        int account, chooosing;
        api.viewRecipient(3);
        System.out.print("\nAccepting[1] | Rejecting[2] | Cancel[3] ... Please choose: ");
        account = huda.nextInt();
        if(account == 3) return ;
        System.out.printf("Please choose the number that you want to %s: ", (account==1 ? "Accept" : "Reject"));
        chooosing = huda.nextInt();
        api.AcceptRejectBooking(chooosing, account);
    }
    public void viewAcceptedBooking()
    {
        api.viewRecipient(1);
        huda.nextLine();
    }
    public void viewRejectedBooking()
    {
        api.viewRecipient(2);
        huda.nextLine();
    }
    public static Object txt() {
        return null;
    }
}
