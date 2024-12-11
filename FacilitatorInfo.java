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

    public void transactions(){}
        
    
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

    public void processTransactions(int food, int water, int medicalSupplies, int clothing, int others){
        Scanner scanner = Facilitator.processTransactions();
        while (true) {
         System.out.println("Enter the Supply you would like to withdraw: ");
         int supplyType = scanner.nextInt();
 
         System.out.println("Enter the quantity needed for the supply: ");
         int supplyQuantity = scanner.nextInt();
 
         switch (supplyType){
             case 1: //foods
                 if (supplyQuantity <= food){
                     food -= supplyQuantity; 
                     System.out.println("You have withdrawn" + supplyQuantity + "remaining supplies: " + food );
                 }else{
                         System.out.println("Insufficient Supplies");
                     } 
                 }
                 
              }
             case 2: //water
                 if (supplyQuantity <= water){
                     water -= supplyQuantity;
                     System.out.println("You have withdrawn" + supplyQuantity + "remaining supplies: " + water);
                 }else{
                         System.out.println("Insufficient Supplies");
                     }
 
             case 3: //medical supplies
                 if (supplyQuantity <= medicalSupplies){
                     medicalSupplies -= supplyQuantity; 
                     System.out.println("You have withdrawn" + supplyQuantity + "remaining supplies: " + medicalSupplies);
                 }else{
                     System.out.println("Insufficient Supplies");
                     }
 
             case 4: //clothing
                     if (supplyQuantity <= clothing){
                     clothing -= supplyQuantity; 
                     System.out.println("You have withdrawn" + supplyQuantity + "remaining supplies: " + clothing);
                 }else{
                     System.out.println("Insufficient Supplies");
                     }
 
             case 5: //others
                 if (supplyQuantity <= others){
                     others -= supplyQuantity; 
                     System.out.println("You have withdrawn" + supplyQuantity + "remaining supplies: " + others);
                  }else{
                     System.out.println("Insufficient Supplies");
                      }   
     }
        

    public void displayVolunteers(){
       
    }

    public void displayDonors(){
        
    }

    public void displayFaciSummary(){

    }

public class FacilitatorInfo{
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        

      
    }

    
}
