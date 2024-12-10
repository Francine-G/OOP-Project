import java.util.*;

class Facilitator{
    private String facilitatorName = "Jologs";
    private int pin;
    private String[] location;
    private String[] disasterType;
    private int[] popSize;
    private double donatedCash;


    public Facilitator(String facilitatorName, int pin, String[] location, String[] disasterType, int[] popSize, double donatedCash){
        this.facilitatorName = facilitatorName;
        this.pin = pin;
        this.location = location;
        this.disasterType = disasterType;
        this.popSize = popSize;
        this.donatedCash = donatedCash;

    }

public void transactions() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("================================================================================================================");
    System.out.println("                                                  ENTER TRANSACTION                                             ");
    System.out.println("    |===== 1. See Donors & Volunteers =====|    |===== 2. View Donations =====|    |===== 3. Cancel =====|");
    System.out.println("================================================================================================================");

    System.out.print("Enter your choice (1, 2, or 3): ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (choice) {
        case 1: // See Donors & Volunteers
            System.out.println("\n|===== 1. View List of Donors =====|    |===== 2. View List of Volunteers =====|");
            System.out.print("Enter your choice (1 or 2): ");
            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (subChoice) {
                case 1: // View List of Donors
                    System.out.println("\n|===== 1. In-Kind =====|    |===== 2. Cash =====|");
                    System.out.print("Enter your choice (1 or 2): ");
                    int donorChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (donorChoice == 1) {
                        System.out.println("\nList of In-Kind Donors:");
                        System.out.printf("%-5s | %-30s\n", "No.", "Donor Name");
                        System.out.println("-------------------------------------");
                        for (int i = 0; i < inKindDonors.length; i++) {
                            System.out.printf("%-5d | %-30s\n", (i + 1), inKindDonors[i]);
                        }
                    } else if (donorChoice == 2) {
                        System.out.println("\nList of Cash Donors:");
                        System.out.printf("%-5s | %-30s\n", "No.", "Donor Name");
                        System.out.println("-------------------------------------");
                        for (int i = 0; i < cashDonors.length; i++) {
                            System.out.printf("%-5d | %-30s\n", (i + 1), cashDonors[i]);
                        }
                    } else {
                        System.out.println("\nInvalid choice. Returning to main menu...");
                    }
                    break;

                case 2: // View List of Volunteers
                    System.out.println("\nList of Volunteers:");
                    System.out.printf("%-5s | %-20s | %-20s | %-20s\n", "No.", "Name", "Contact Info", "Preferred Location");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (int i = 0; i < volunteers.length; i++) {
                        System.out.printf("%-5d | %-20s | %-20s | %-20s\n", 
                                          (i + 1), 
                                          volunteers[i].name, 
                                          volunteers[i].contactInfo, 
                                          volunteers[i].preferredLocation);
                    }
                    break;

                default:
                    System.out.println("\nInvalid choice. Returning to main menu...");
                    break;
            }
            break;

        case 2: // View Donations
            System.out.println("\n|===== 1. Check Cash Balance =====|    |===== 2. Check Supplies Balance =====|");
            System.out.print("Enter your choice (1 or 2): ");
            int donationChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (donationChoice == 1) {
                System.out.printf("\nTotal Cash Balance: %.2f\n", cashBalance);
            } else if (donationChoice == 2) {
                System.out.println("\nSupplies Balance:");
                System.out.printf("%-20s | %-10s\n", "Item", "Quantity");
                System.out.println("-----------------------------------");
                for (int i = 0; i < supplies.length; i++) {
                    System.out.printf("%-20s | %-10d\n", supplies[i].itemName, supplies[i].quantity);
                }
            } else {
                System.out.println("\nInvalid choice. Returning to main menu...");
            }
            break;

        case 3: // Cancel
            System.out.println("\nTransaction canceled. Returning to main menu...");
            break;

        default:
            System.out.println("\nInvalid choice. Please try again.");
            break;
    }
}

    public String getFacilitatorName() {
        return facilitatorName;
    }

    public int getPin() {
        return pin;
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
    public double getDonatedCash() {
        return donatedCash;
    }

    public void displayDisasterDetails(){
        
        System.out.println("\n======================================================================");
        System.out.println("         Location              Disaster             Population Size     ");
        System.out.println("======================================================================");

        for(int i = 0; i < location.length && i < disasterType.length && i < popSize.length; i++){
            System.out.println("         " +location[i] + "              " + disasterType[i] + "             " + popSize[i] + "     " );
        }
        
    }

    public void displayInventories(int food, int water, int medicalSupplies, int clothing){
        System.out.println(" ");
        System.out.println("\n=======================================================================================================================================================");
        System.out.println("                                                       RELIEF GOODS SUPPLIES                                ");
        System.out.println("=======================================================================================================================================================");
        System.out.println("Range of Size            Citizens Affected             Foods             Water             Medical Supplies             Clothing             Status");
        System.out.println("=======================================================================================================================================================");
        System.out.println(" ");

        for(int i = 0; i < popSize.length; i++){
            if  (10 < popSize[i] && popSize[i] < 20){
                System.out.println("10-20" + "             "+ popSize[i] + "             " + food + "             " + water + "             " + medicalSupplies + "             " + clothing + "             " + "Sufficient");
            } else {
                System.out.println("10-20" + "             "+ popSize[i] + "             " + food + "             " + water + "             " + medicalSupplies + "             " + clothing + "             " + "Insufficient");
            }

        }
    }

    public void processTransactions(){

        
    }

    public void displayVolunteers(){
       
    }

    public void displayDonors(){    
        
    }

    public void displayFaciSummary(){

    }
}

public class FacilitatorInfo{
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        

      
    }

    
}
