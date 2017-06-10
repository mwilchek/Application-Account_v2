package views;

import Core.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mongoDB.MongoDB;

import java.io.IOException;
import java.util.ArrayList;

public class LoginDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MongoDB.setMongoConnection();
        loadUserAccounts();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        primaryStage.setTitle("Application Login");
        primaryStage.setScene(new Scene(root, 726, 300));
        primaryStage.show();
    }

    public void loadUserAccounts() {
        try {
            // Validate for existing account
            AccountList.setUsers((ArrayList<User>) AcctDataTracker.readAccounts());
        } catch (IOException e) {
            System.err.print("Cannot open Accounts file.");
        } catch (ClassNotFoundException e) {
            System.err.print("Error: error in class file for reading Accounts.");
        }
    }

}
