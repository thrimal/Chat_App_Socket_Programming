package client.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UIController {
    public static String userName;
    public static ArrayList<User> users=new ArrayList<>();
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane root;


    public void btnLoginOnAction(ActionEvent actionEvent) {
        if((txtUserName.getText().isEmpty()||txtPassword.getText().isEmpty())){
            new Alert(Alert.AlertType.WARNING,"Fields Empty...").show();
        }else {
            if (!txtUserName.getText().isEmpty()) {
                users.add(new User(txtUserName.getText(), txtPassword.getText()));
                for (User u:users) {
                    userName=txtUserName.getText();
                    setUI(u.getUserName(),"/client/UI.fxml");
                }

            }
        }
    }

    public void setUI(String users,String location)  {

        try {
            if(users.isEmpty()){
                new Alert(Alert.AlertType.WARNING,"Fields Empty...").show();
            }else {
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setTitle(users);
//                stage.setResizable(true);
//                stage.setMaximized(true);
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource(location))));
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
}
