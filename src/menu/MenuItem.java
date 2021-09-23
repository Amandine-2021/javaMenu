/*Student: Amandine Velamala
Final Project
Course number: CSC 240 C00 Java Programming
File name: MenuItem.java
Last modified: 08/05/2020

Description: This class implements a MenuItem.
The MenuItem class encapsulates an item in a menu.
Its getter methods are getName(), getDescription(), getAllergens(), getPrice(), 
getType(), getImageLink() and getInfo().
*/
package menu;

public class MenuItem {

    private String name;
    private String description;
    private String allergens;
    private double price;
    private String type;
    private String imageLink;
    
    //Constructors
    MenuItem() {
    }
    MenuItem(String itemName, String itemDescription, String itemAllergens, double itemPrice, String itemType, String itemImageLink)
    {
        name = itemName;
        description = itemDescription;
        allergens = itemAllergens;
        price = itemPrice;
        type = itemType;
        imageLink = itemImageLink;
    }  
    
    //Setter methods
    public void setName(String itemName)
    {
        this.name = itemName;
    }
    public void setDescription(String itemDescription)
    {
        this.description = itemDescription;
    }
    public void setAllergens(String itemAllergens)
    {
        this.allergens = itemAllergens;
    }
    public void setPrice(double itemPrice)
    {
        this.price = itemPrice;
    }
    public void setType(String itemType)
    {
        this.type = itemType;
    }
    public void setImageLink(String itemImageLink)
    {
        this.imageLink = itemImageLink;
    }
    
    //Getter methods
    public String getName()
    {
        return this.name;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getAllergens()
    {
        return this.allergens;
    }
    public double getPrice()
    {
        return this.price;
    }
    public String getType()
    {
        return this.type;
    }
    public String getImageLink()
    {
        return this.imageLink;
    }
    //This method reurns the description and the allergens in one String
    public String getInfo()
    {
        String info =  this.getDescription() + "\nAllergens: " + this.getAllergens();
        return info;
    }
}
