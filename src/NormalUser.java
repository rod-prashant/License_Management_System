import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;

public class NormalUser
{
    public static ArrayList<Application> applicationDetails=new ArrayList<>();
   static  Scanner sc=new Scanner(System.in);
    public static void userMenu(String userID,String name)
    {
        System.out.println("User Name: "+name);
        System.out.println("1. Apply For License");
        System.out.println("2. View License Details");
        System.out.println("3. Logout");
        int userChoice=sc.nextInt();
        if (userChoice==1)
        {
            NormalUser.applyForCategory(userID);
            NormalUser.userMenu(userID,name);

        }
        else if (userChoice==2)
        {
            NormalUser.report(userID);
            NormalUser.userMenu(userID,name);

        }
        else
        {
            menu.mainMenu();
        }
    }
    public static void applyForCategory(String UserID)
    {
        System.out.println("Select Category");
        System.out.println("A: For Bike");
        System.out.println("B: For Car");
        System.out.println("K: For Scooter");
        String selectedCategory=sc.next();
        for (Application app : applicationDetails) {
            if (UserID.equals(app.UserID) && app.category.equalsIgnoreCase(selectedCategory)) {
                if (app.status.equalsIgnoreCase("Approved"))
                {
                    System.out.println("You already have a license for this category.");
                } else {
                    System.out.println("You already have a pending application for this category.");
                }
                return;
            }
        }
        System.out.println("Enter Issue Date(YYYY-MM-DD): ");
        String issueDate=sc.next();
        LocalDate date = LocalDate.parse(issueDate);
        LocalDate expiryDate = date.plusYears(5);
        String applicationID="A"+(applicationDetails.size()+1);
        System.out.println("Your Application ID is: "+applicationID);
        System.out.println("Successfully Registered License for User ID: "+UserID);
        new Application(applicationID,selectedCategory,issueDate,UserID,expiryDate);

    }
    public static void report(String userID)
    {
        for (Application a : applicationDetails)
        {
            if (Objects.equals(userID, a.UserID))
            {
                for (user b : user.UserDetail) {
                    if (Objects.equals(userID, b.userID))
                    {
                        System.out.println("--------------------------------------");
                        System.out.println("Name: " + b.name);
                        System.out.println("User ID: " + b.userID);
                        System.out.println("Application ID: " + a.ApplicationID);
                        System.out.println("Citizenship Number: " + b.citizenshipNumber);
                        System.out.println("License Category: "+a.category);
                        System.out.println("Issue Date: " + a.issueDate);
                        System.out.println("Status: " + a.status);
                        if (a.status.equalsIgnoreCase("Approved"))
                        {
                            System.out.println("Expiry Date: " +a.expiryDate );
                        }
                        System.out.println("--------------------------------------");
                    }

                }

            }

        }
    }
}
