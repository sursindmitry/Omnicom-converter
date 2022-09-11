package com.grodastr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.getIcons().add(new Image("icon/icon.png"));

        Label response = new Label("Hello");

        TextField textField = new TextField("Введите время в секундах");
        Button convertOmnicom = new javafx.scene.control.Button("Из Unix-времени,\nв Omnicom-время");
        Button convertUnix = new Button("Из Omnicom-времени,\nв Unix-время");

        convertUnix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Converter converter = new Converter();
                try {
                    if (converter.searchUnix(Long.parseLong(textField.getText()))<0) response.setText("Время не может уйти в минус");
                    else {
                        response.setText(Long.toString(converter.searchUnix(Long.parseLong(textField.getText()))));
                    }
                }catch (Exception e){
                    response.setText("Ты еблан?");
                }
            }
        });

        convertOmnicom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Converter converter = new Converter();
                try {
                    if (converter.searchOmnicom(Long.parseLong(textField.getText()))<0){
                        response.setText("Время до 2009 года");
                    }
                    else {
                        response.setText(Long.toString(converter.searchOmnicom(Long.parseLong(textField.getText()))));
                    }
                }catch (Exception e){
                    response.setText("Ты еблан?");
                }
            }
        });

        BorderPane.setAlignment(convertOmnicom, Pos.CENTER);
        BorderPane.setAlignment(convertUnix, Pos.CENTER);
        BorderPane.setAlignment(response, Pos.BASELINE_CENTER);
        BorderPane.setAlignment(textField,Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setLeft(convertOmnicom);
        root.setRight(convertUnix);
        root.setBottom(response);
        root.setCenter(textField);

        Scene myScene = new Scene(root,600,400);
        primaryStage.setScene(myScene);

        primaryStage.setTitle("Converter");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch();
    }
}
