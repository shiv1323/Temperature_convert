package com.Shiv1323;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
// responsible fro connect main class and fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userInterface.fxml"));
        VBox root = loader.load();

//        calling menuBar
        MenuBar menuBar = createMenuBAr();
        root.getChildren().add(0,menuBar);



        primaryStage.setTitle("Temperature Converter Toll");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    //        creating menuBar
private MenuBar createMenuBAr(){
//        file menu
    Menu menu = new Menu("File");

    MenuItem newMenuItem   = new MenuItem("New");
    newMenuItem.setOnAction(event -> System.out.println("New clicked"));
    SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
    MenuItem quitMenuItem   = new MenuItem("Quit");
    quitMenuItem.setOnAction(event -> {
        Platform.exit();
        System.exit(0);
    });

    menu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

    //        Help menu
    Menu helpMenu = new Menu("Help");
    MenuItem aboutApp   = new MenuItem("About");
    aboutApp.setOnAction(event -> aboutApp());
    helpMenu.getItems().addAll(aboutApp);


//    Menubar
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(menu,helpMenu);
    return menuBar;

}

//alert dialog box for about developer
    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("JavaFx");
        alertDialog.setContentText("Shivansh Verma\n"+ "\uD83D\uDC9A");
        alertDialog.show();
    }

    //optional
    public static void main(String[] args) {
        launch(args);
    }
}
