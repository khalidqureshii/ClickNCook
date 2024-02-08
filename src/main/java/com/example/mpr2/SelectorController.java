package com.example.mpr2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectorController {
    @FXML
    Parent root;
    Stage stage;
    Scene scene;

    public void indianPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/indianRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void chinesePressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/chineseRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void italianPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/italianRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void japanesePressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/japaneseRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void mexicanPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/mexicanRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void frenchPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/frenchRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void greekPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/greekRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void thaiPressed (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeSelectors/thaiRecipeSelector.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
