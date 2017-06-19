package controller;

import Core.*;
import dataStructures.IndexedList;
import exceptions.Duplicate;
import exceptions.ElementNotExist;
import exceptions.IndexOutOfBounds;
import mongoDB.MongoDB;
import views.ProfileDriver;
import views.RegisterDriver;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {
    public static ProfileInfo profile;

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label failAuthentication;

    public void openRegister() throws IOException {
        System.out.println("Opening Registration...");
        new RegisterDriver();
    }

    /** Check login credentials from local MongoDB */
    public void mongoAuthenticate() throws IOException{
        if (MongoDB.doesUsernameExist(userName.getText())) {
            User user = MongoDB.getUser(userName.getText());
            System.out.println("MongoDB Authentication Check:");
            System.out.println(user.toString());
            if (password.getText().equals(user.getEmail())) { /** For some odd reason user.getPassword return the
                                                                phone number and user.getEmail returns the password*/
                System.out.println("Account information accepted.");
                profile = new ProfileInfo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getGender(), user.getDob(), user.getPhoto());
                new ProfileDriver();
                System.out.println("welcome" + " " + userName.getText() );

            } else {
                failAuthentication.setVisible(true);
            }
        }
    }

    /** Authentication attempt with AccountIndexedList */
    public void authenticate() throws Exception {
        int userIndex = AccountIndexedList.getUsers().indexOf(userName.getText());
        User userCheck = (User) AccountIndexedList.getUsers().get(userIndex);

        if (userName.getText().equals(userCheck.getUserName()) && password.getText().equals(userCheck.getPassword())){
            System.out.println("Account information accepted.");
            System.out.println("welcome" + " " + userName.getText() );
        }
        else
            failAuthentication.setVisible(true);
    }

    /** Authentication attempt with AccountLinkedList
     *
    //Check login credentials from local .dat file from Linked Ordered List
    public void authenticate() throws IOException, IndexOutOfBounds {
        //replacing AccountList.getUsers() with AccountIndexed

      for (int i = 0; i < AccountLinkedList.getUsers().size(); i++) {
           //Compare userName and password from user input to each username and password from AccountLinkedList

            if (userName.getText().equals((AccountLinkedList.getUsers().get(userName.getText())))
                   && password.getText().equals(AccountLinkedList.getUsers().get(password.getText()))) {
               System.out.println("Account information accepted.");
               //profile = new ProfileInfo(AccountList.getUsers().get(i).getFirstName(), AccountList.getUsers().get(i).getLastName(), AccountList.getUsers().get(i).getEmail(), AccountList.getUsers().get(i).getPhone(), AccountList.getUsers().get(i).getGender(), AccountList.getUsers().get(i).getDob(), AccountList.getUsers().get(i).getPhoto());
                new ProfileDriver();
               System.out.println("welcome" + " " + userName.getText() );
              break;
            } else {
              failAuthentication.setVisible(true);
          }
      }
    }
     */

    /**Original Authentication with AccountList (Array)
     *
    //Check login credentials from local .dat file from ArrayList
    public void authenticate() throws IOException {
  	//Loop through AccountList to validate if it exists
       //replacing AccountList.getUsers() with AccountIndexed
        for (int i = 0; i < AccountList.getUsers().size(); i++) {
       	//Compare userName and password from user input to each username and password from AccountList

           if (userName.getText().equals(AccountList.getUsers().get(i).getUserName())
                    && password.getText().equals(AccountList.getUsers().get(i).getPassword())) {
                System.out.println("Account information accepted.");
                profile = new ProfileInfo(AccountList.getUsers().get(i).getFirstName(), AccountList.getUsers().get(i).getLastName(), AccountList.getUsers().get(i).getEmail(), AccountList.getUsers().get(i).getPhone(), AccountList.getUsers().get(i).getGender(), AccountList.getUsers().get(i).getDob(), AccountList.getUsers().get(i).getPhoto());
                new ProfileDriver();
               System.out.println("welcome" + " " + userName.getText() );
                break;
            } else {
                failAuthentication.setVisible(true);
           }
       }
    }
     */

}