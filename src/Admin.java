public class Admin
{
    public static void AdminMenu()
    {
        System.out.println("1. View Pending Application");
        System.out.println("2. Generate Report Of License");
        System.out.println("3. Logout");
        int userChoice = menu.scanner.nextInt();
        if (userChoice == 1) {
            Admin.approval();
            AdminMenu();
        }
        else if (userChoice==2)
        {
            userReportForAdmin();
            AdminMenu();
        }
        else
        {
            menu.mainMenu();
        }
    }
    public static void approval()
    {
            boolean foundPending = false;
        for(Application a:NormalUser.applicationDetails)
        {
            if (a.status.equals("Pending"))
            {
                foundPending=true;
                System.out.println("Application ID: "+a.ApplicationID+"    Selected Category: "+a.category+"    Issue Date: "+a.issueDate);
            System.out.println("1. Approve");
            System.out.println("2. Reject");
            int AdminChoice=menu.scanner.nextInt();
            if(AdminChoice==1)
            {
                a.status="Approved";
                System.out.println("License for Application ID "+a.ApplicationID+" Has been  Approved");
            }
            else
            {
                a.status="Rejected";
                System.out.println("License for Application ID "+a.ApplicationID+" Has been Rejected");
            }
            }
        }
        if(!foundPending)
        {
            System.out.println("No pending applications!");
        }
    }
    public static void userReportForAdmin()
    {
        System.out.println("Report Of License");
        System.out.println("Total No of Users: "+NormalUser.applicationDetails.size());
        for(user usr:user.UserDetail)
        {
            for(Application app:NormalUser.applicationDetails)
            {
                if(usr.role==2)
                {
                if(usr.userID.equals(app.UserID))
                {

                    System.out.println("---------------------------");
                    System.out.println("Name: "+usr.name);
                    System.out.println("User ID: "+usr.userID);
                    System.out.println("Citizenship Number: "+usr.citizenshipNumber);
                    System.out.println("Email: "+usr.email);
                    System.out.println("Category: "+app.category);
                    System.out.println("License Status: "+app.status);
                    System.out.println("Issue Date: "+app.issueDate);
                    if (app.status.equalsIgnoreCase("Approved"))
                    {
                        System.out.println("Expiry Date: "+app.expiryDate);
                    }

                }
                }
            }
        }
    }

}