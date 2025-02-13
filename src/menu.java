import java.util.Scanner;
public class menu
{
    public static Scanner scanner = new Scanner(System.in);
    public static void mainMenu()
    {

        int userChoice;
        System.out.println("=====================================");
        System.out.println("LICENSE MANAGEMENT SYSTEM -- NEPAL ꔪ");
        System.out.println("=====================================");
        while(true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.println("Please enter a number according to your need: ");
            userChoice = scanner.nextInt();
            switch (userChoice)
            {
                case 1:
                    user.registerUser();
                    break;
                case 2:
                    user.login();
                    break;
                case 3:
                    System.out.println("Thank You For Using The System!!!\nGoodBye!!!\nHave a Good Day!!!");
                    return;
                default:
                    System.out.println("Invalid Input!!!\nkindly Requested to Enter a Valid Input!!!");
                    menu.mainMenu();
            }

        }
    }


}
