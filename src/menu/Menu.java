/*Student: Amandine Velamala
Final Project
Course number: CSC 240 C00 Java Programming
File name: Menu.java
Last modified: 08/05/2020

Description: This class implements a Menu.
The Menu contains a list of MenuItems.
Its getter method is getMenu();
*/

package menu;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
  
    public class Menu 
    {
        ArrayList<MenuItem> menu; 
        
        //Constructor
        public Menu()
        {
            menu = new ArrayList<>();
        }
        //This method creates a Menu from a file 
        public void setMenu(String menuFileName)
        {
            try 
            {
                InputStream inputStream = new FileInputStream(menuFileName);

                Scanner input = new Scanner(inputStream);
                while (input.hasNextLine())
                {
                    MenuItem item = new MenuItem();
                    menu.add(item);
                    String line = input.nextLine();
                    while(!line.equals("*****"))
                    {
                        String key = "", value = "";
                        if (line.contains(":"))
                        { 
                            String[] lineArray = line.split(":");
                            key = lineArray[0];
                            if (lineArray.length > 1)
                                 value = lineArray[1];
                        }
                        else {
                            System.out.println("formatting error");
                        }

                        switch(key)
                        {
                            case "name":
                                item.setName(value);
                                break;
                            case "description":
                                item.setDescription(value);
                                break;
                            case "allergens":
                                item.setAllergens(value);
                                break;
                            case "price":
                                item.setPrice(Double.parseDouble(value));
                                break;
                            case "type":
                                item.setType(value);
                                break;
                            case "img":
                                item.setImageLink(value);
                                break;
                        }
                        line = input.nextLine();     
                    }
                }
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("The file was not found.");
            }
        }  
        //Accessor
        public ArrayList<MenuItem> getMenu() 
        {
            return menu;
        }
    } 



