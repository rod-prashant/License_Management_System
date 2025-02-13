import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
    public static void registerUser()
    {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter Full name: ");
        String name= scanner.nextLine();
        System.out.print("Enter Email: ");
        String email=scanner.nextLine();
        System.out.print("Enter Citizenship ID: ");
        String citizenshipID=scanner.nextLine();
        System.out.print("Enter Password: ");
        String password=scanner.nextLine();
        System.out.println("Choose a Role\n1 for Admin\n2 for Normal User");
        int roleChoice=scanner.nextInt();
        scanner.nextLine();
        String UserID="U"+(UserDetail.size() + 1);
        System.out.println("Your UserID is: "+UserID);
        System.out.println("User Registered Successfully!!!");
        new user(name,UserID,citizenshipID,roleChoice,password,email);
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
            if ((Objects.equals(i.userID, userID)) && (Objects.equals(i.password,password)))
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
