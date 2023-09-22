import java.util.*;
import java.io.*;


public class ApSystem {
    
    private static final String FILE_PATH = "users.txt";
    
    static void Main() 
    {
        Scanner s = new Scanner(System.in);
        Boolean enable = true;
        ApSystem basic = new ApSystem();
        new booking();
       
        while(enable){
            System.out.println("Welcome to our appointment system:)");
            System.out.println("---------------------------");
            System.out.println("|      1. Register        |");
            System.out.println("|      2. Login           |");
            System.out.println("|      3. Exit            |");
            System.out.println("---------------------------");
            System.out.println("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine(); // Consume the newline character after reading the integer input
            
            switch (choice) {
                case 1:
                System.out.println("Enter your name: ");
                String registerName = s.nextLine();
                System.out.println("Enter your phone number: ");
                String registerPhonenumber = s.nextLine();
                System.out.println("Create password: ");
                String registerPassword = s.nextLine();
                
                basic.register(registerName, registerPhonenumber, registerPassword);
                break;
                case 2:
                System.out.println("Enter your name: ");
                String loginName = s.nextLine();
                System.out.println("Enter your password: ");
                String loginPassword = s.nextLine();
                if(basic.checkAdmin(loginName, loginPassword))
                {
                    new admin();
                }
                else
                {
                    boolean loginSuccessful = basic.login(loginName, loginPassword);
                    if (loginSuccessful) {
                        System.out.println("Login Successful");
                        new userPart(loginName);
                    } else {
                        System.out.println("Login Failed");
                    }
                }
                
                break;
                case 3:
                System.out.println("Exiting the program...");
                enable = false;
                break;
                default:
                System.out.println("Invalid option");
                break;
            }
        }
        s.close();
        System.exit(0); // Exit the program with a status code 0 (successful exit)
    }
    
    public void register(String name,  String phonenumber, String password) {
        String userData = name + ":" + phonenumber + ":" + password;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(userData);
            writer.newLine();
            System.out.println("Registration successful for username: " + name);
        } catch (IOException e) {
            System.out.println("Error occurred during registration: " + e.getMessage());
        }
    }
    public boolean checkAdmin(String name, String password)
    {
        File file = new File("Admin.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(":");
                if (userData[0].equals(name) && userData[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found: " + e.getMessage());
        }
        return false;
    }
    public boolean login(String name, String password) {
        File file = new File(FILE_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(":");
                if (userData[0].equals(name) && userData[2].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found: " + e.getMessage());
        }
        return false;
    }

    public void main(Class<String[]> class1) {
    }
    
    
}
