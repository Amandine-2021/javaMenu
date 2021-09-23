/*Student: Amandine Velamala
Final Project
Course number: CSC 240 C00 Java Programming
File name: Order.java
Last modified: 08/05/2020
Description: This Order class's constructor takes a list of MenuItems and a list 
of quantities ordered.
Its printReceipt() method returns a receipt for the order which can be displayed.
*/
package menu;

import static java.lang.String.format;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Order {
    
    final static double taxRate = 0.08;
    ArrayList<MenuItem> itemsOrdered; 
    ArrayList<Integer> quantitiesOrdered;
    private double total;
    
    //Constructors
    Order()
    {
        itemsOrdered = new ArrayList<>();
        quantitiesOrdered = new ArrayList<>();
        total = calculateTotal();
    }
    Order(ArrayList<MenuItem> items, ArrayList<Integer> quantities)
    {
        itemsOrdered = new ArrayList<>(items);
        quantitiesOrdered = new ArrayList<>(quantities);
        total = calculateTotal();
    }
    //Getter methods
    public double getTotal() 
    {
        return total;
    }  
    //this method returns the sales tax on the order
    public double getSalesTax() 
    {
        return getTotal() * taxRate;
    }
    //this method returns the total price of the order(total + tax)
    public double getTotalPrice() 
    {
        return getTotal() + getSalesTax();
    }
    public double getTaxRate()
    {
        return taxRate;
    }
    //this method calculates the total of the order (before tax)
    private double calculateTotal()
    {
        total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++)
        {
            double price = itemsOrdered.get(i).getPrice();
            total += (price * quantitiesOrdered.get(i));
        }
        return total;
    }
    //this method returns a receipt for the order (as a string)
    public String printReceipt()
    {
        String receipt = "";
        java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String currentDateString = dateFormatter.format(currentDate);
        String order = "";
        for (int i = 0; i < itemsOrdered.size(); i++)
        {
            order += quantitiesOrdered.get(i) + "  " 
                    + itemsOrdered.get(i).getName() 
                    + "\n\t\t@\t$"
                    + format("%4.2f", itemsOrdered.get(i).getPrice()) + " each:"
                    + format("\t$%9.2f", (quantitiesOrdered.get(i) * itemsOrdered.get(i).getPrice()))
                    + "\n";
        }
        receipt = "Your receipt\n\n"
                    + "Todays' date: " + currentDateString + "\n\n"
                    + order + "_____________________________________" 
                    + "\n\nSubtotal:\t\t\t\t\t$" +  format("%9.2f", this.getTotal())
                   
                    + "\nTotal Tax (" + (this.getTaxRate() * 100) + "%):\t\t\t$"
                    + format("%9.2f", (this.getTaxRate() * this.getTotal()) * 100.0 / 100)
                   
                    + "\n\nTotal:\t\t\t\t\t$" + format("%9.2f",this.getTotalPrice());
        return receipt;
    }
     
}
    

