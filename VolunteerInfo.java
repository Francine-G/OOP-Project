import java.util.Scanner;

class LoginUser {
    private String volunteerName;
    private String volunteerPassword;
    private String volunteerContact;
    private String volunteerAddress;

    public void setLogin(String volunteerName, String volunteerPassword, String volunteerContact, String volunteerAddress) {
        this.volunteerName = volunteerName;
        this.volunteerPassword = volunteerPassword;
        this.volunteerContact = volunteerContact;
        this.volunteerAddress = volunteerAddress;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public String getVolunteerPassword() {
        return volunteerPassword;
    }

    public String getVolunteerContact() {
        return volunteerContact;
    }

    public String getVolunteerAddress() {
        return volunteerAddress;
    }

    public void displayLogin() {
        System.out.println(" ");
        System.out.println("=====================================================================================");
        System.out.println("Username (Full Name): " + volunteerName);
        System.out.println("User Password (6-digits): " + "******");
        System.out.println("Contact Number: " + volunteerContact);
        System.out.println("Address: " + volunteerAddress);
        System.out.println("=====================================================================================\n");
    }
}

class SignUp extends LoginUser {
    public SignUp(String volunteerName, String volunteerPassword, String volunteerContact, String volunteerAddress) {
        super.setLogin(volunteerName, volunteerPassword, volunteerContact, volunteerAddress);
    }
}

class Volunteer {
    private String volunteerType;

    public void setVolunteerType(String volunteerType) {
        this.volunteerType = volunteerType;
    }

    public String getVolunteerType() {
        return volunteerType;
    }

    public void displayVolunteerType() {
        System.out.println("");
        System.out.println("=====================================================================================");
        System.out.println("In which areas would you like to volunteer?");
        System.out.println("1. Technical rescue");
        System.out.println("2. Fire response");
        System.out.println("3. Medical response");
        System.out.println("4. Debris cleaning");
        System.out.println("5. Logistical support");
        System.out.println("6. Transportation");
        System.out.println("7. Distributing clean water and nonperishable food");
        System.out.println("8. Helping demolish homes and businesses");
        System.out.println("=====================================================================================\n");
        System.out.println("");
    }

    public void selectVolunteerType(Scanner userInput) {
        displayVolunteerType();
        System.out.print("Enter the number of your choice: ");
        int choice = userInput.nextInt();
        userInput.nextLine(); // Consume the newline character after nextInt()

        switch (choice) {
            case 1: volunteerType = "Technical rescue"; break;
            case 2: volunteerType = "Fire response"; break;
            case 3: volunteerType = "Medical response"; break;
            case 4: volunteerType = "Debris cleaning"; break;
            case 5: volunteerType = "Logistical support"; break;
            case 6: volunteerType = "Transportation"; break;
            case 7: volunteerType = "Distributing clean water and nonperishable food"; break;
            case 8: volunteerType = "Helping demolish homes and businesses"; break;
            default: System.out.println("Invalid choice."); break;
        }
    }

    public void displayVolunteerSummary(String name, String newContact, String address) {
        System.out.println("=====================================================================================");
        System.out.println("                          VOLUNTEER SUMMARY                                 ");
        System.out.println("=====================================================================================\n");
        System.out.println("Volunteer Name: " + name);
        System.out.println("Contact Number: " + newContact);
        System.out.println("Address: " + address);
        System.out.println("Volunteer Type: " + volunteerType);
        System.out.println("=====================================================================================");
        System.out.println("Thank you for your time and willingness to help! We appreciate your support.");
        System.out.println("=====================================================================================\n");
    }

    public void displayAgreement() {
        System.out.println("=====================================================================================");
        System.out.println("                         VOLUNTEER AGREEMENT                                  ");
        System.out.println("=====================================================================================\n");
        System.out.println("By volunteering, you agree to assist with disaster relief efforts. As a volunteer,");
        System.out.println("you may be exposed to challenging and hazardous conditions. You acknowledge that");
        System.out.println("you are participating of your own free will and take full responsibility for your actions.");
        System.out.println("Your personal safety is of utmost importance, and you agree to follow all safety protocols.");
        System.out.println("=====================================================================================\n");
    }

    public boolean getAgreementResponse(Scanner userInput) {
        String response = userInput.nextLine().trim().toUpperCase();
        return response.equals("YES");
    }

    public static boolean validatePassword(String password) {
        return password.matches("\\d{6}");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{11}");
    }

    public static String getValidInput(Scanner userInput, String prompt, String regex) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = userInput.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("Invalid input. Please follow the required format.");
            }
        }
    }
}

class DisasterDisplayInfo {
    private String[] location;
    private String[] disasterType;
    private int[] popSize;

    public DisasterDisplayInfo(String[] location, String[] disasterType, int[] popSize) {
        this.location = location;
        this.disasterType = disasterType;
        this.popSize = popSize;
    }

    public String[] getLocation() {
        return location;
    }

    public String[] getDisasterType() {
        return disasterType;
    }

    public int[] getPopSize() {
        return popSize;
    }

    public void displayDisasterDetails() {
        System.out.println("=====================================================================================");
        System.out.println("|         Location        |          Disaster            |       Population Size    | ");
        System.out.println("=====================================================================================");

        for (int i = 0; i < location.length && i < disasterType.length && i < popSize.length; i++) {
            System.out.printf("| %-25s | %-28s | %-23d |%n", location[i], disasterType[i], popSize[i]);
        }

        System.out.println("=====================================================================================");
        System.out.println("");
    }

    public void displayLocationMenu() {
        System.out.println("Available locations:");
        for (int i = 0; i < location.length; i++) {
            System.out.println(i + 1 + ". " + location[i]);
        }
        System.out.println(" ");
    }

    public void displayLocationDetails(int locationIndex) {
        if (locationIndex >= 0 && locationIndex < location.length) {
            System.out.println("=====================================================================================");
            System.out.println("Preferred Location: " + location[locationIndex]);
            System.out.println("Disaster Type: " + disasterType[locationIndex]);
            System.out.println("Population Size: " + popSize[locationIndex]);
            System.out.println("=====================================================================================");
        } else {
            System.out.println("Invalid selection.");
        }
    }
}

public class VolunteerInfo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String name = "";
        String address = ""; 
        String newContact = ""; 

        System.out.println("=====================================================================================");
        System.out.println("                              VOLUNTEERING PROCESS                            ");
        System.out.println("    |===== 1. Log-In =====|                   |===== 2. Sign Up =====|");
        System.out.println("=====================================================================================\n");
        System.out.print("Enter your choice: ");
        int option = userInput.nextInt();
        userInput.nextLine(); // Consume newline character

        switch (option) {
            case 1: // Login
                System.out.println("");
                System.out.println("=====================================================================================\n");
                System.out.print("Enter Username (Full Name): ");
                name = userInput.nextLine();

                String pass;
                while (true) {
                    System.out.print("Enter Password (6-digits): ");
                    pass = userInput.nextLine();
                    if (Volunteer.validatePassword(pass)) { 
                        System.out.println("Valid Password.\n");

                        while (true) {
                            newContact = Volunteer.getValidInput(userInput, "Enter Contact Number (11-Digits): ", "\\d{11}");
                            System.out.print("Enter your Address: ");
                            address = userInput.nextLine();
                            break;
                        }
                        break;
                    } else {
                        System.out.println("Invalid password. Password should be 6 digits.");
                    }
                }

                SignUp volunteerSignUp = new SignUp(name, pass, newContact, address);
                volunteerSignUp.displayLogin();

                break;
            case 2: // Sign Up
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
