package com.example.mpr2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class LoginController {
    @FXML
    TextField emailTextField;
    @FXML
    TextField passwordTextField;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void login(ActionEvent e) throws SQLException {

        if (emailTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Username Not Entered.");
            alert.setContentText("Please Enter a Username");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        if (passwordTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Password Not Entered.");
            alert.setContentText("Please Enter a Password");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mprdata";
        String user = "root";
        String password = "Khalid1198";
        Connection con = DriverManager.getConnection(url,user,password);
        String query = "Select * from User_info where email = '"+ emailTextField.getText() +"'";

        PreparedStatement st1 = con.prepareStatement(query);

        try {
            ResultSet results = st1.executeQuery();
            results.next();

            if (results.getString(2).equals(passwordTextField.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Successfully Logged in");
                alert.setContentText("Enjoy Using Click N Cook :)");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
                alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("selector.fxml"));
                root = loader.load();
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                stage.setTitle("Cuisine Selector");
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect Password");
                alert.setContentText("Please Enter the Correct Password");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
                alert.showAndWait();
            }
        }
        catch (SQLException | IOException sqe) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Username Not Found");
            alert.setContentText("Please Enter a Valid Username");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
        }
        finally {
            con.close();
        }
    }

    public void signup(ActionEvent e) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Register");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}