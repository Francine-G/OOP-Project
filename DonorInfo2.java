import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class ProgressBarExample extends JFrame {
    JProgressBar jb;
    int i = 0;

    ProgressBarExample() {
        jb = new JProgressBar(0, 100);
        jb.setBounds(50, 50, 400, 40);
        jb.setValue(0);
        jb.setStringPainted(true);

        jb.setForeground(Color.GREEN);

        add(jb);

        setSize(500, 150); // Adjusted size for better visibility
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void iterate() {
        while (i <= 100) {
            jb.setValue(i);
            i += 5; // Adjust progress speed
            try {
                Thread.sleep(150); // Adjust timing for progress update
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Donor {
    private int transactionChoice;
    private String donorName;
    private String donorAddress;
    private String donorContact;
    private String donorEmail;
    private String donationType;
    private String accountName;
    private int accountNumber;
    private int cashDonationAmount;
    private String[] inKindSupportItems = new String[5];
    private int[] inKindSupportQuantities = new int[5];

    public void setUserDetails(int transactionChoice, String donorName, String donationType, String accountName, int accountNumber, int cashDonationAmount) {
        this.transactionChoice = transactionChoice;
        this.donorName = donorName;
        this.donationType = donationType;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.cashDonationAmount = cashDonationAmount;
    }

    public void setDonorDetails(String donorName, String donorAddress, String donorContact, String donorEmail) {
        this.donorName = donorName;
        this.donorAddress = donorAddress;
        this.donorContact = donorContact;
        this.donorEmail = donorEmail;
    }

    public void addInKindSupportItem(int index, String itemType, int quantity) {
        inKindSupportItems[index] = itemType;
        inKindSupportQuantities[index] = quantity;
    }

    public void donationProcess() {
        SwingUtilities.invokeLater(() -> {
            ProgressBarExample progressBar = new ProgressBarExample();
            progressBar.setVisible(true);

            // Use a separate thread to handle the progress bar
            new Thread(() -> {
                progressBar.iterate();
                SwingUtilities.invokeLater(progressBar::dispose);

                // Print the donation details after progress completes
                printDonationDetails();
            }).start();
        });
    }

    private void printDonationDetails() {
        System.out.println("\n==============================================================================");
        System.out.println("               . . .  WE ARE CURRENTLY PROCESSING YOUR DONATION . . .           ");
        System.out.println("");
        System.out.println("Name: " + donorName);
        System.out.println("Address: " + donorAddress);
        System.out.println("Contact Number: " + donorContact);
        System.out.println("Email: " + donorEmail);
        System.out.println("Transaction Choice: " + (transactionChoice == 1 ? "Donate" : "Cancel"));
        System.out.println("Donation Type: " + donationType);

        if (donationType.equals("In-Kind Support")) {
            System.out.println("In-Kind Support Breakdown:");
            int totalQuantity = 0;
            for (int i = 0; i < inKindSupportItems.length; i++) {
                if (inKindSupportItems[i] != null) {
                    System.out.println(inKindSupportItems[i] + ": " + inKindSupportQuantities[i]);
                    totalQuantity += inKindSupportQuantities[i];
                }
            }
            System.out.println("Total Items Donated: " + totalQuantity);
        } else if (donationType.equals("Cash")) {
            System.out.println("Cash Donation Breakdown:");
            System.out.println("Amount Donated: P" + cashDonationAmount);
            System.out.println("Account Name: " + accountName);
            System.out.println("Account Number: " + accountNumber);
        }
        System.out.println("");
        System.out.println("                   AGAIN, THANK YOU FOR YOUR GENEROSITY!                        ");
        System.out.println("        A copy of your receipt will be sent to your email very shortly.         ");
        System.out.println("==============================================================================\n");
    }
}

public class DonorInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Donor donor = new Donor();

        while (true) {
            System.out.println("==============================================================================");
            System.out.println("                            TRANSACTION CHOICE                        ");
            System.out.println("    |===== 1. Donate =====|                   |===== 2. Cancel =====|");
            System.out.println("==============================================================================");
            System.out.print("Enter your choice: ");

            int transactionChoice;
            try {
                transactionChoice = Integer.parseInt(scanner.nextLine());
                if (transactionChoice < 1 || transactionChoice > 2) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                continue;
            }

            if (transactionChoice == 2) {
                System.out.println("Thank you for considering us! Would you like to do another transaction? (yes/no)");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("no")) {
                    System.out.println(". . . You are now exiting the program. Thank you! . . . ");
                    break;
                } else {
                    continue;
                }
            }

            System.out.print("Enter Full Name: ");
            String donorName = scanner.nextLine();

            System.out.print("Enter Address: ");
            String donorAddress = scanner.nextLine();

            System.out.print("Enter Contact Number: ");
            String donorContact = scanner.nextLine();

            System.out.print("Enter Personal Email: ");
            String donorEmail = scanner.nextLine();

            System.out.println("==============================================================================");
            System.out.println("                            TYPE OF DONATION                        ");
            System.out.println("    |===== 1. Cash =====|                   |===== 2. In-Kind Support =====|");
            System.out.println("==============================================================================");
            System.out.print("Enter Type of Donation: ");

            String donationType = "";
            int donationTypeChoice;
            try {
                donationTypeChoice = Integer.parseInt(scanner.nextLine());
                switch (donationTypeChoice) {
                    case 1:
                        donationType = "Cash";
                        break;
                    case 2:
                        donationType = "In-Kind Support";
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 1 or 2.");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                continue;
            }

            if (donationType.equals("In-Kind Support")) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("Enter In-Kind Support Type (or type 'done' to finish): ");
                    String itemType = scanner.nextLine();
                    if (itemType.equalsIgnoreCase("done")) break;

                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    donor.addInKindSupportItem(i, itemType, quantity);
                }

                donor.setDonorDetails(donorName, donorAddress, donorContact, donorEmail);
                donor.setUserDetails(transactionChoice, donorName, donationType, "N/A", 0, 0);
                donor.donationProcess();
                break;
            }

            System.out.print("Enter Account Name: ");
            String accountName = scanner.nextLine();

            System.out.print("Enter Account Number: ");
            int accountNumber = Integer.parseInt(scanner.nextLine());

            System.out.println("\nCash Denomination Options:");
            System.out.println("=====================================");
            System.out.println("| 1. P50                            |");
            System.out.println("| 2. P100                           |");
            System.out.println("| 3. P350                           |");
            System.out.println("| 4. P500                           |");
            System.out.println("| 5. P1000                          |");
            System.out.println("| 6. P2000                          |");
            System.out.println("| 7. P5000                          |");
            System.out.println("| 8. Enter other denomination       |");
            System.out.println("=====================================");
            System.out.print("Please choose an amount: ");

            int cashDonationAmount;
            try {
                int amountChoice = Integer.parseInt(scanner.nextLine());
                switch (amountChoice) {
                    case 1: cashDonationAmount = 50; break;
                    case 2: cashDonationAmount = 100; break;
                    case 3: cashDonationAmount = 350; break;
                    case 4: cashDonationAmount = 500; break;
                    case 5: cashDonationAmount = 1000; break;
                    case 6: cashDonationAmount = 2000; break;
                    case 7: cashDonationAmount = 5000; break;
                    case 8:
                        System.out.print("Enter your preferred denomination: P");
                        cashDonationAmount = Integer.parseInt(scanner.nextLine());
                        break;
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Restarting process...");
                continue;
            }

            donor.setDonorDetails(donorName, donorAddress, donorContact, donorEmail);
            donor.setUserDetails(transactionChoice, donorName, donationType, accountName, accountNumber, cashDonationAmount);
            donor.donationProcess();
            break;
        }

        scanner.close();
    }
}