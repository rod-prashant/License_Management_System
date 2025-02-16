import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class user
{
    static ArrayList<user> UserDetail=new ArrayList<>();
String userID,citizenshipNumber,password,name,email;
int role;

    public user(String name, String userID, String citizenshipNumber, int role, String password, String email){
        this.name=name;
        this.userID=userID;
        this.citizenshipNumber=citizenshipNumber;
        this.role=role;
        this.password=password;
        this.email=email;
        UserDetail.add(this);

    }
    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.print("Enter Full name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty!");
            }
        } while (name.isEmpty());

        String email;
        do {
            System.out.print("Enter Email: ");
            email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Error: Invalid email format! Try again.");
            }
        } while (!isValidEmail(email));

        String citizenshipID;
        do {
            System.out.print("Enter Citizenship ID: ");
            citizenshipID = scanner.nextLine().trim();
            if (citizenshipID.isEmpty()) {
                System.out.println("Error: Citizenship ID cannot be empty!");
            }
        } while (citizenshipID.isEmpty());

        String password;
        do {
            System.out.print("Enter Password (min 4 chars): ");
            password = scanner.nextLine();
            if (password.length() < 4) {
                System.out.println("Error: Password must be at least 4 characters long!");
            }
        } while (password.length() < 4);

        int roleChoice;
        do {
            System.out.println("Choose a Role\n1 for Admin\n2 for Normal User");
            while (!scanner.hasNextInt())
            {
                System.out.println("Error: Please enter a valid number (1 or 2)!");
                scanner.next();
            }
            roleChoice = scanner.nextInt();
            scanner.nextLine();
            if (roleChoice != 1 && roleChoice != 2) {
                System.out.println("Error: Invalid choice! Choose 1 for Admin or 2 for Normal User.");
            }
        } while (roleChoice != 1 && roleChoice != 2);

        String userID = "U" + (UserDetail.size() + 1);
        System.out.println("Your UserID is: " + userID);
        System.out.println("User Registered Successfully!!!");

        UserDetail.add(new user(name, userID, citizenshipID, roleChoice, password, email));
    }

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    public static void login()
    {
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your UserID: ");
        String userID=sc.next();
        System.out.print("Enter Password: ");
        String password=sc.next();
        for(user i:user.UserDetail)
        {
            if ((i.userID.equalsIgnoreCase(userID) ) && (Objects.equals(i.password,password)))
            {
                isLogin=true;
                System.out.println("Welcome "+i.name+" !!!");
                if(i.role==2)
                {
                    NormalUser.userMenu(userID,i.name);
                }
                else
                {
                    Admin.AdminMenu();

                }
                return;

                }



        }
        if(!isLogin)
                {
                    System.out.println("Incorrect UserName and Password!!!");
                }
    }
}
