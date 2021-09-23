/*Student: Amandine Velamala
Final Project
Course number: CSC 240 C00 Java Programming
File name: Main.java
Last modified: 08/05/2020

Description: This is the main class for the Menu project.
It creates a new menu and launches the MenuGUI class.
*/
package menu;


import javafx.application.Application;


public class Main {
   public static void main(String[] args) {
       
       Menu todaysMenu = new Menu();
       todaysMenu.setMenu("menuItems.txt");
      
       todaysMenu.getMenu().get(0).getName();
       
       Application.launch(MenuGUI.class, args);
   } 
}
