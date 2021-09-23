/*Student: Amandine Velamala
Final Project
Course number: CSC 240 C00 Java Programming
File name: MenuGUI.java
Last modified: 08/05/2020

Description: This is the GUI class for the Menu project.
It shows the MenuItems to the user and allows the user to enter quantities for
each MenuItems.
After clicking the submit button, it displays a receipt for the order.
*/

package menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javax.swing.JScrollBar;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler; 
import static java.lang.String.format;
import java.util.ArrayList;

public class MenuGUI extends Application{

    @Override
    public void start (Stage stage)
    {
        Menu menu = new Menu();
        menu.setMenu("menuItems.txt");
        stage.setTitle("Menu Order");
        
        FlowPane menuPane = new FlowPane();
        menuPane.setStyle("-fx-background-color: maroon");
        menuPane.setPadding(new Insets(30, 30, 30, 30));
        menuPane.setHgap(18);
        menuPane.setVgap(18);
        
        ArrayList <TextField> quantityInputs = new ArrayList <TextField>();
       
        for (int i = 0; i < menu.getMenu().size(); i++)
        {
            GridPane pane = new GridPane();
            pane.setStyle("-fx-background-color: white");
            pane.setPadding(new Insets(10, 10, 10, 10));
            pane.setHgap(30);
            Text title = new Text(menu.getMenu().get(i).getName());
            title.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            Text info = new Text(menu.getMenu().get(i).getInfo());
            info.setFont(Font.font("Verdana", 16));
            info.setWrappingWidth(500);
            String imageFileName = "file:images/" + menu.getMenu().get(i).getImageLink() ;
            Image image = new Image(imageFileName);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            Text price = new Text("$" + format("%.2f", menu.getMenu().get(i).getPrice()));
            price.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            TextField inputBox = new TextField();
            inputBox.setText("0");
            inputBox.setMaxSize(45, 15);
            quantityInputs.add(inputBox);
            //this handler resets the inputBox to 0 if any non-digit key is pressed 
            //and released.
            inputBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent ev) {
                    String input = inputBox.getText();
                    try {
                        Integer.parseInt(input);
                    } catch (NumberFormatException ex){
                    inputBox.setText("0");
                    }
                }
            });

            pane.add(title, 1, 0);
            pane.add(info, 1, 1);
            pane.add(price, 2, 1);
            pane.add(new Label("Quantity"), 3, 0);
            pane.add(inputBox, 3, 1);
            pane.add(imageView, 0, 0, 1, 2);
            menuPane.getChildren().add(pane);
        }
        Button submitOrder = new Button("Submit Order");
        submitOrder.setStyle("-fx-background-color: black; -fx-text-fill: white; "
                + "-fx-font-weight: bold; -fx-font-size: 20px");
        
        ScrollPane scroll = new ScrollPane(menuPane);  
        JScrollBar scrollBar =new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
        
        TextField msg = new TextField(); 
        msg.setEditable(false);
        msg.setStyle("-fx-background-color: maroon");
        menuPane.getChildren().add(submitOrder);
        menuPane.getChildren().add(msg);
        

        ArrayList<MenuItem> itemsOrdered = new ArrayList<>();
        ArrayList<Integer> quantitiesOrdered = new ArrayList<>();
        
        Scene scene = new Scene(scroll, 900, 800  );
        
        stage.setScene(scene);
        stage.show();
        
        //this lambda function handles the clicking of the submit button
        //The handler creates an Order instance and displays the receipt associated 
        //with the order to the user.
        submitOrder.setOnMouseClicked(e ->{
            for (int i = 0; i < menu.getMenu().size(); i++){
                int quantity = Integer.parseInt(quantityInputs.get(i).getText());
                if (quantity > 0)
                {
                    quantitiesOrdered.add(quantity);
                    itemsOrdered.add(menu.getMenu().get(i));
                }
            }
            if (itemsOrdered.size() > 0)
            {
                Order newOrder = new Order(itemsOrdered, quantitiesOrdered );
                
                FlowPane receiptPane = new FlowPane();
                receiptPane.setStyle("-fx-background-color: maroon");
                receiptPane.setPadding(new Insets(30, 30, 30, 30));
                receiptPane.setAlignment(Pos.BASELINE_CENTER);
                
                FlowPane pane = new FlowPane();
                pane.setStyle("-fx-background-color: white");
                pane.setPadding(new Insets(20, 20, 20, 20));

                Text receiptText = new Text(newOrder.printReceipt());
                receiptText.setFont(Font.font("Verdana", 16));
                pane.getChildren().add(receiptText);

                receiptPane.getChildren().add(pane);
                
                Scene sceneReceipt = new Scene(receiptPane, 900, 800);
                stage.setScene(sceneReceipt);
            }
            else
            {
               msg.setText("Your order is empty"); 
               msg.setStyle("-fx-background-color: white");  
            }
        });   
    }
}
    
    
        
 
  


