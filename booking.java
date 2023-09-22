import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class bookDetail
{
    String name, date, status, reason;
    
    public bookDetail(){name = date = status = reason = "";}
    public bookDetail(String name, String date, String status, String reason)
    {
        this.name = name;
        this.date = date;
        this.status = status;
        this.reason = reason;
    }
}
public class booking {
    private ArrayList<bookDetail> allData = new ArrayList<>();
    
    public booking()
    {
        try {
            if(allData.size() != 0) return;
            File file = new File("data.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String data[] = line.split(";");
                allData.add(new bookDetail(data[0], data[1], data[2], data[3]));
            }
            scan.close();  
        } catch (Exception e) {
        }
    }
    
    public int checkDateOverlap(String date)
    {
        for(int i = 0 ; i < allData.size() ; i++)
        if(allData.get(i).date.equals(date)) return 0;
        return 1;
    }
    
    public void storeBookingDate(String name, String date, String reason)
    {
        allData.add(new bookDetail(name, date, "Waiting Responses", reason));
        saveData();
    }
    
    public void checkBookingStatus(String name)
    {
        int count = 1;
        for(int i = 0 ; i < allData.size() ; i++)
        if(allData.get(i).name.equals(name) || name.equalsIgnoreCase(""))
        printBox(count++, allData.get(i).name, allData.get(i).date, allData.get(i).status, allData.get(i).reason);
    }
    
    private void printBox(int count, String name, String date, String status, String reason)
    {
        System.out.println("===============================================");
        System.out.printf("|             %-32d|\n", count);
        System.out.println("===============================================");
        System.out.printf("|Name   : %-36s|\n", name);
        System.out.printf("|Date   : %-36s|\n", date);
        System.out.printf("|Status : %-36s|\n", status);
        System.out.printf("|Reason : %-36s|\n", reason);
        System.out.println("===============================================");
    }
    
    public void removeBooking(String name, int index)
    {
        int count = 0;
        for(int i = 0 ; i < allData.size() ; i++)
        {   
            bookDetail a = allData.get(i);
            if(a.name.equalsIgnoreCase(name) || name.equalsIgnoreCase(""))
            {
                count++;
                if(count == index)
                {
                    allData.remove(index-1);
                    saveData();
                    return ;
                }
            }
        }
    }
    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (bookDetail book : allData) {
                String line = book.name + ";" + book.date + ";" + book.status + ";" + book.reason+";";
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data: " + e.getMessage());
        }
    }    
    // ADMIN SECTIONS
    public void AcceptRejectBooking(int index, int status)
    {
        for(int i = 0 ; i < allData.size() ; i++)
        if(index-1 == i)
        {
            allData.get(i).status = (status == 1 ? "Accepted" : "Rejected");
            saveData();
            return ;
        }
    }
    
    public void viewRecipient(int status)
    {
        int count = 1;
        if(status == 1)
        {
            for(int i = 0 ; i < allData.size();  i++)
            {
                if(allData.get(i).status.equalsIgnoreCase("Accepted"))
                    printBox(count++, allData.get(i).name, allData.get(i).date, allData.get(i).status, allData.get(i).reason);
            }
        }
        else if(status == 2)
        {
           for(int i = 0 ; i < allData.size();  i++)
            {
                if(allData.get(i).status.equalsIgnoreCase("Rejected"))
                    printBox(count++, allData.get(i).name, allData.get(i).date, allData.get(i).status, allData.get(i).reason);
            } 
        }
        else
        {
            for(int i = 0 ; i < allData.size();  i++)
            {
                if(allData.get(i).status.equalsIgnoreCase("Waiting Responses"))
                    printBox(count++, allData.get(i).name, allData.get(i).date, allData.get(i).status, allData.get(i).reason);
            } 
        }
    }
}