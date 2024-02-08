package com.example.mpr2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignupController {
    @FXML
    TextField emailTextField;
    @FXML
    TextField passTextField;
    @FXML
    TextField repeatPassTextField;

    @FXML
    Parent root;
    @FXML
    Stage stage;
    @FXML
    Scene scene;
    @FXML
    RadioButton r1,r2;
    public void signup (ActionEvent e) throws SQLException {
        String choice;
        if (r2.isSelected()) {
            choice = "Non-Veg";
        }
        else {
            choice = "Veg";
        }

        if (emailTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Username Not Entered.");
            alert.setContentText("Please Enter a Username");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        if (passTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Password Not Entered.");
            alert.setContentText("Please Enter a Password");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        if (repeatPassTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Password Not Confirmed.");
            alert.setContentText("Please Confirm Password");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        if (!repeatPassTextField.getText().equals(passTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Passwords Don't Match");
            alert.setContentText("Please Enter Matching Passwords");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mprdata";
        String user = "root";
        String password = "Khalid1198";
        Connection con = DriverManager.getConnection(url, user, password);

        String query = "INSERT INTO User_info VALUES (?, ?, ?)";
        PreparedStatement st1 = con.prepareStatement(query);
        st1.setString(1, emailTextField.getText());
        st1.setString(2, passTextField.getText());
        st1.setString(3, choice);

        try {
            int rowsAffected = st1.executeUpdate(); // Use executeUpdate for INSERT

            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Successfully Registered");
                alert.setContentText("Enjoy Using Click N Cook :)");
                alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
                alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                root = loader.load();
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("No rows were inserted.");
            }
        } catch (SQLException | IOException exc) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Registration Went Wrong");
            alert.setContentText("Please Try Again");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("alertStyles.css").toExternalForm());
            alert.showAndWait();
            exc.printStackTrace();
        } finally {
            st1.close(); // Close the PreparedStatement
            con.close();
        }

    }
}
