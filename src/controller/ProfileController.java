package controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import static controller.LoginController.profile;

public class ProfileController {

    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField gender;
    @FXML
    TextField dob;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    ImageView profilePic;
    @FXML
    TextField notice;

    @FXML
    private void initialize() {
    	firstName.setText(profile.getFname());
        lastName.setText(profile.getlName());
        gender.setText(profile.getGend());
        dob.setText(profile.getDob());
        email.setText(profile.geteMail());
        phone.setText(profile.getPhoneNum());
        File file = new File(profile.getPic());
        Image image = new Image(file.toURI().toString());
        profilePic.setImage(image);

        if (firstName.getText().equals("")){
        	notice.setText("Error loading user data.");
        }
             
    }

    public void logOff(){
        System.exit(0);
    }

}
