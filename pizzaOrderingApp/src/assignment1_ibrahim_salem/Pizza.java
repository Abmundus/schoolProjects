package assignment1_ibrahim_salem;
/**
 *
 * @author Ibrahim
 */
public class Pizza {
    String pizzaSize;
    String pizzaCrust;
    String pizzaToppings;
    double pizzaPrice;
    // a String for adding the dollar sign to the prices
    String stringDollarSign = "$";
    /* I tired to use the 'java.text.numberFormat' and the 'java.util.Locale' methods but
       since 'numberFormat' converts my double price variable into a String; I elected to eliminate them*/
    
    // A Constuctoer for storing the PIZZA's SIZE, CRUST, TOPPINGS, and overall PRICE
    public Pizza(String pizzaSize, String pizzaCrust, String pizzaToppings, double pizzaPrice){
        this.pizzaSize = pizzaSize ;
        this.pizzaCrust = pizzaCrust;
        this.pizzaToppings = pizzaToppings;
        this.pizzaPrice = pizzaPrice;
    }
    // get Method to get the SIZE the customer selects
    public String getPizzaSize(){
        return pizzaSize;
    }
    // get Method to get the CRUST TYPE the customer selects
    public String getPizzaCrust(){
        return pizzaCrust;
    }
    // get Method to get the TOPPING(S) the customer selects
    public String getPizzaToppings(){
        return pizzaToppings;
    }
    // get Method to get the overall PRICE the customer will be charged with paying
    public double getPizzaPrice(){
        return pizzaPrice;
    }
    @Override
    public String toString(){
        return String.format("%s%n%s%18s%.2f%n%s%n%s", 
                             "******************************************", 
                             pizzaSize, stringDollarSign, pizzaPrice, pizzaCrust, pizzaToppings);
    }
}
