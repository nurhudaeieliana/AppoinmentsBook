// import java.io.FileWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisterAdmin 
{
    private static final String FILE_NAME = "Admin.txt";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        
        RegisterAdmin back = new RegisterAdmin();
        
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line = br.readLine();
            if(line != null)
            {
                System.out.println("");
                 ApSystem.Main();
            }
            else
            {
                back.registerAdmins();
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading the file: " + e.getMessage());
            back.registerAdmins();
            //ApSystem.main();
        }

      
    }

        public void registerAdmins()
        {
            try(Scanner input = new Scanner(System.in);
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME)))
                {   
                    System.out.println("Fill this form");
                    System.out.println("Name: ");
                    String registerAdminsNames = input.nextLine();
                    System.out.println("Create password: ");
                    String registerAdminsPasswords = input.nextLine();
                    String adminsData = registerAdminsNames + ":" + registerAdminsPasswords ;
                    writer.write(adminsData);
                    writer.newLine();
                    System.out.println("Successful register");
                    //2ApSystem.Main();
                
                }
                catch (IOException e)
                {
                    System.err.println("Error! " + e.getMessage());
                }
            
        }

        
    
        
         



    

    
    
    
}
