package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 600);

        Button button = new Button("Exit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Platform.exit();
            }
        });
        Label label = new Label("Player's fortune to be displayed here");

        VBox vbox = new VBox(30, label, button);

        // set Alignment
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefHeight(600);
        root.getChildren().add(vbox);
        primaryStage.setTitle("Task3");
        primaryStage.setScene(scene);

        Runnable task =new MyThread();
        Thread myThread1 = new Thread(task);

        //File file=new File("gjenstander.txt");
        //TreasureChest t = new TreasureChest();
       // try{
            Terrain terrain=new Terrain();
            Terminal terminal=new Terminal();
            Robot robot=new Robot();
            Player player2=new Player(terrain.getStart(),robot);

            while(player2.place.next!=null){
                player2.newMove();
            }
            label.setText("player\'s fortune is "+ Double.toString(player2.fortune));

       // }catch(Exception e){
         //   System.out.print("file not found");
        //}


        myThread1.start();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
