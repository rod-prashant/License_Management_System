import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class user {
    static int userCounter = 1;
    static ArrayList<user> UserDetail = new ArrayList<>();
    String userID, citizenshipNumber, password, name, email, dateOfBirth;
    int role;

    public user(String name, String userID, String citizenshipNumber, int role, String password, String email, String dateOfBirth) {
        this.name = name;
        this.userID = userID;
        this.citizenshipNumber = citizenshipNumber;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
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
        String dateOfBirth;
        do {
            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            dateOfBirth = scanner.nextLine().trim();
            if (!isValidDate(dateOfBirth)) {
                System.out.println("Error: Invalid date format! Use yyyy-MM-dd.");
            }
        } while (!isValidDate(dateOfBirth));


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
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid number (1 or 2)!");
                scanner.next();
            }
            roleChoice = scanner.nextInt();
            scanner.nextLine();
            if (roleChoice != 1 && roleChoice != 2) {
                System.out.println("Error: Invalid choice! Choose 1 for Admin or 2 for Normal User.");
            }
        } while (roleChoice != 1 && roleChoice != 2);

        String userID = "U" + (userCounter);
        userCounter++;
        System.out.println("Your UserID is: " + userID);
        new user(name, userID, citizenshipID, roleChoice, password, email, dateOfBirth);
        System.out.println("User Registered Successfully!!!");
    }

    public static boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    public static void login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your UserID: ");
        String userID = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();
        for (user i : user.UserDetail) {
            if ((i.userID.equalsIgnoreCase(userID)) && (Objects.equals(i.password, password))) {
                isLogin = true;
                System.out.println("Welcome " + i.name + " !!!");
                if (i.role == 2) {
                    NormalUser.userMenu(userID, i.name,i.dateOfBirth);
                } else {
                    Admin.AdminMenu();
                }
                return;

            }
        }
        if (!isLogin) {
            System.out.println("Incorrect UserName and Password!!!");
        }
    }
}
class AgeCalculator {

    public static int calculateAge(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        return age.getYears();
    }
}