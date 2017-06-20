package views;

import Core.*;
import dataStructures.IndexedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mongoDB.MongoDB;

import java.io.IOException;

public class LoginDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //MongoDB.setMongoConnection();
        loadUserAccounts();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        primaryStage.setTitle("Application Login");
        primaryStage.setScene(new Scene(root, 726, 300));
        primaryStage.show();
    }

    public void loadUserAccounts() {
        try {
            // Validate for existing account
            System.out.print((IndexedList<User>)AcctDataTracker.readAccounts());
            AccountIndexedList.setUsers((IndexedList<User>) AcctDataTracker.readAccounts());
            //AccountLinkedList.setUsers((LinkedOrderedList<User>) AcctDataTracker.readAccounts()); //AccountLinkedList
            //AccountList.setUsers((ArrayList<User>) AcctDataTracker.readAccounts()); //original ArrayList setter
        } catch (IOException e) {
            System.err.print("Cannot open Accounts file.");
        } catch (ClassNotFoundException e) {
            System.err.print("Error: error in class file for reading Accounts.");
        }
    }

}
