package assignment1_ibrahim_salem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/**
 *
 * @author Ibrahim
 */
public class FXMLDocumentController implements Initializable {
    // Create new Toggle Group for the PIZZA SIZE radio buttons
    ToggleGroup pizzaSizeToggle= new ToggleGroup();
    // Create new Toggle Group for the PIZZA CRUST TYPE radio buttons
    ToggleGroup pizzaCrustToggle= new ToggleGroup();
    //Add an instance of our Pizza Object/Class to an ArrayList
    ArrayList<Pizza> myPizzas = new ArrayList<Pizza>();
    /* Declare and initialize a double variable 'orderTotal' in order to store,
      then FORMAT, and then print -separate from the toString- the total price
      for all of the ITEMS the user purchased */
    double orderTotal=0;
    //Store the percentage of TAX the user will have to pay
    double orderTotalTax=0.13;
    //Calculate the amount of tax the CUSTOMER will have to pay
    double calculateOrderTotalTax =0;
    //Calculate the FINAL PRICE the CUSTOMER will have to pay -i.e. TAX included-
    double calculateOrderTotalWithTax = 0;
    // This String will be used to add the dollar sign next to the amount(s) the CUSTOMER will have to pay for
    String stringDollarSign = "$";
    
    @FXML
    private RadioButton rbPizzaLarge; //RadioButton for the LARGE PIZZA selection option
    
    @FXML
    private RadioButton rbPizzaMedium; //RadioButton for the MEDIUM PIZZA selection option
    
    @FXML
    private RadioButton rbPizzaSmall; //RadioButton for the SMALL PIZZA selection option
   
    @FXML
    private RadioButton rbPizzaCrustThick; //RadioButton for the THICK PIZZA CRUST selection option
    
    @FXML
    private RadioButton rbPizzaCrustStuffed; //RadioButton for the STUFFED PIZZA CRUST selection option
    
    @FXML
    private RadioButton rbPizzaCrustNormal; //RadioButton for the NORMAL PIZZA CRUST selection option
    
    @FXML
    private CheckBox cbToppingsGreenOlives; //CheckBox for the Green Olives Topping Option
    
    @FXML
    private CheckBox cbToppingsMushrooms; //CheckBox for the Mushrooms Topping Option
    
    @FXML
    private CheckBox cbToppingsRoastedGarlic; //CheckBox for the Roasted Garlic Topping Option
    
    @FXML
    private CheckBox cbToppingsRedOnions; //CheckBox for the Red Onions Topping Option
    
    @FXML
    private CheckBox cbToppingsSpinach; //CheckBox for the Spinach Topping Option
    
    @FXML
    private CheckBox cbToppingsGreenPeppers; //CheckBox for the Green Peppers Topping Option
    
    @FXML
    private CheckBox cbToppingsBroccoli; //CheckBox for the Broccoli Topping Option
    
    @FXML
    private CheckBox cbToppingsTomatoes; //CheckBox for Tomatoes Topping Option
    
    @FXML
    private CheckBox cbToppingsGrilledZucchini; //CheckBox for the Grilled Zucchini Topping Option
    
    @FXML
    private CheckBox cbToppingsPineapple; //CheckBox for the Pineapple Topping Option
    
    @FXML
    private void handleAddButton(ActionEvent event){ // Handle what occurs when the PIZZA ADD button is clicked
        String size = "";
        String crust = "";
        String topping = "";
        // Use this variable to add the prices for each and every item the USER selects
        double price = 0;
        
        // If-else statements for matching the user's selection for the PIZZA SIZE
        if(rbPizzaLarge.isSelected()){
            size="---LARGE PIZZA---";
            price+=13.45;
        }else if(rbPizzaMedium.isSelected()){
            size="---MEDIUM PIZZA--";
            price+=11.35;
        }else if(rbPizzaSmall.isSelected()){
            size="---SMALL PIZZA---";
            price+=9.25;
        }
        
        // If-else statements for matching the user's selection for the PIZZA CRUST TYPE
        if(rbPizzaCrustThick.isSelected()){
            crust=" **THICK CRUST";
            price+=2;
        }else if(rbPizzaCrustStuffed.isSelected()){
            crust=" **STUFFED CRUST";
            price+=2.50;
        }else if(rbPizzaCrustNormal.isSelected()){
            crust=" **NORMAL CRUST";
            /* No EXTRA CHARGE for NORMAL CRUST! */
        }
        
        // If statements for matching the user's selection for the PIZZA TOPPINGS
                                /*IMPORTANT NOTE */
        /* I referred to JavaFxTutorials.com while writing this Code. Specifically this page:
            http://www.javafxtutorials.com/tutorials/checkboxes-in-javafx-and-fxml/ */
        int count = 0;
        String toppingsSelected = "";
        if(cbToppingsGreenOlives.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsGreenOlives.getText() + "|";
            price+=0.75;
        }
        if(cbToppingsMushrooms.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsMushrooms.getText() + "|";
            price+=0.65;
        }
        if(cbToppingsRoastedGarlic.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsRoastedGarlic.getText() + "|";
            price+=0.95;
        }
        if(cbToppingsRedOnions.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsRedOnions.getText() + "|";
            price+=1.00;
        }
        if(cbToppingsSpinach.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsSpinach.getText() + "|";
            price+=1.15;
        }
        if(cbToppingsGreenPeppers.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsGreenPeppers.getText() + "|";
            price+=2.05;
        }
        if(cbToppingsBroccoli.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsBroccoli.getText() + "|";
            price+=0.75;
        }
        if(cbToppingsTomatoes.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsTomatoes.getText() + "|";
            price+=1.35;
        }
        if(cbToppingsGrilledZucchini.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsGrilledZucchini.getText() + "|";
            price+=0.75;
        }
        if(cbToppingsPineapple.isSelected()){
            count++;
            toppingsSelected+= "  >" + cbToppingsPineapple.getText() + "|";
            price+=2.75;
        }
        topping = toppingsSelected;
        // Assgn all the prices selected by the user [i.e. TOTAL AMOUNT] to the variable 'orderTotal'
        orderTotal += price;
        /* Create a new Pizza Object [Instance of Pizza.java Class] in order to store
           the COSTUMER'S/USER'S selections/choices */
        Pizza pizza = new Pizza(size, crust, topping, price);
        myPizzas.add(pizza);
        /* unselect the 3 RADIO BUTTONS [post-user-selection] to give the user
           the impression that his data has been stored */
        rbPizzaLarge.setSelected(false); //unselect both radio buttons
        rbPizzaMedium.setSelected(false);
        rbPizzaSmall.setSelected(false);
        /* unselect the 3 RADIO BUTTONS [post-user-selection] to give the USER
           the impression that their data has been stored */
        rbPizzaCrustThick.setSelected(false); 
        rbPizzaCrustStuffed.setSelected(false);
        rbPizzaCrustNormal.setSelected(false);
        /* unselect the 10 CHECK BOXES [post-user-selection] to give the USER
           the impression that their data has been stored */
        cbToppingsGreenOlives.setSelected(false);
        cbToppingsMushrooms.setSelected(false);
        cbToppingsRoastedGarlic.setSelected(false);
        cbToppingsRedOnions.setSelected(false);
        cbToppingsSpinach.setSelected(false);
        cbToppingsGreenPeppers.setSelected(false);
        cbToppingsBroccoli.setSelected(false);
        cbToppingsTomatoes.setSelected(false);
        cbToppingsGrilledZucchini.setSelected(false);
        cbToppingsPineapple.setSelected(false);
    }
    
    @FXML
    private void handleOrderButton(ActionEvent event){ // Handle what occurs when the FINISH ORDERING button is clicked
        for(int i=0; i<myPizzas.size(); i++){
            System.out.println(myPizzas.get(i).toString());
        }
        // Print the Receipt immediately after the user clicks on the FINISH ORDERING button
        printPizzaReceipt(myPizzas);
    }
    
    // This method creates the receipt and writes into 'pizzaReceipt.txt'
    public  void printPizzaReceipt(ArrayList pizzas){
        try{
            //Create a new file for writing the receipt
            File pizzaReceipt = new File("pizzaReceipt.txt");
            // Good practice - check if the file exists
            if(!pizzaReceipt.exists()) {
                // If the file above does not exist, then create the file
                pizzaReceipt.createNewFile();
            }
            // Open the file for writing + Write [Add data] to the file
            FileWriter fw = new FileWriter(pizzaReceipt.getAbsoluteFile(),false); // Add Boolean value false in order to delete the previous receipt whenever we have a new one to write
            BufferedWriter bw = new BufferedWriter(fw);
            /* Write/print the Header of the receipt (i.e. Logo + address)
               Outside of the toString method in order to prevent the Header
               of being repeated (i.e. prevent having it print more than once
               on each individual receipt) */
            String printPizzaReceiptHeader = String.format("%29s%n%n %27s%n %30s%n %28s%n %25s%n",
                                                            "365-701-0590",
                                                            "MUNDUSPIZZA",
                                                            "1430 Trafalgar Rd", 
                                                            "Oakville, ON", 
                                                            "L6H 2L1");
            bw.write(printPizzaReceiptHeader);
            // For Loop to access each array inside the ArrayList separately
            for(int i=0;i<pizzas.size();i++){
              Pizza myPizza=(Pizza)pizzas.get(i);
              /* Use the "|" delimiter to split Each line -which we have previously chosen using the toString-
                 into separate(new) line(s) */ 
              /*[NOTE - Ultimately, I did not use this delimiter. I found a way to separate the lines
                 using the String.format method{please refer to Pizza.java toString}] */
              String [] receiptParts = myPizza.toString().split("\\|");
              /* for(int i=0;i<receiptParts.length;i++)
                 String p = receiptParts[i];
                  --> These 2 lines of code represent a 'longer alternative'
                      to the 'for each loop' below */
              for(String p: receiptParts){ //Split the specific strings form the receipt [selected using the toString method] into separat lines
                  bw.write(p);
                  bw.newLine();
              }
            }
            //Print the Total order of the user into the Receipt
            String printOrderTotal = String.format("Subtotal %26s %.2f", stringDollarSign, orderTotal);
            bw.write("******************************************");
            bw.newLine();
            bw.write(printOrderTotal);
            bw.newLine();
            // Print the amount of TAX the Customer has to pay
            calculateOrderTotalTax = orderTotal * orderTotalTax;
            String printOrderTotalTax = String.format("Taxes (13%%) %23s %.2f",  stringDollarSign, calculateOrderTotalTax);
            bw.write(printOrderTotalTax);
            bw.newLine();
            //Print the Final TOTAL for pay INCLUDING TAX
            calculateOrderTotalWithTax = orderTotal + calculateOrderTotalTax;
            String printOrderTotalWithTax = String.format("Total %29s %.2f" , stringDollarSign, calculateOrderTotalWithTax);
            bw.write(printOrderTotalWithTax);
            bw.newLine();
            // Close the file after appending data to it
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ToggleGroup for the PIZZA SIZE radio buttons
        rbPizzaLarge.setToggleGroup(pizzaSizeToggle);
        rbPizzaMedium.setToggleGroup(pizzaSizeToggle);
        rbPizzaSmall.setToggleGroup(pizzaSizeToggle);
        // ToggleGroup for the PIZZA CRUST TYPE radio buttons
        rbPizzaCrustThick.setToggleGroup(pizzaCrustToggle);
        rbPizzaCrustStuffed.setToggleGroup(pizzaCrustToggle);
        rbPizzaCrustNormal.setToggleGroup(pizzaCrustToggle);
    }
}
