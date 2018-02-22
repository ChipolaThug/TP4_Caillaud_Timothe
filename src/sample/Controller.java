package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Controller{

    private Color color;
    private String forme;
    private Figure shape;
    private String mode;


    @FXML
    private RadioButton selectButton;

    @FXML
    private RadioButton ellipseButton;

    @FXML
    private RadioButton rectangleButton;

    @FXML
    private RadioButton lineButton;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button deleteButton;

    @FXML
    private Button cloneButton;

    @FXML
    private Canvas canvas;



    public Controller() {
        super();
        shape = new Figure();
    }

    @FXML
    public void initialize() {
        //Quand selectButton sélectionné, décoche les autres radioButton et active les bouttons Clone et Delete
        selectButton.setOnMouseClicked(event -> {
            ellipseButton.setSelected(false);
            rectangleButton.setSelected(false);
            lineButton.setSelected(false);
            deleteButton.setDisable(false);
            cloneButton.setDisable(false);
            forme = "select";
        });

        //Quand ellipseButton sélectionné, décoche les autres radioButton et désactive les bouttons Clone et Delete
        ellipseButton.setOnMouseClicked(event -> {
            selectButton.setSelected(false);
            rectangleButton.setSelected(false);
            lineButton.setSelected(false);
            deleteButton.setDisable(true);
            cloneButton.setDisable(true);
            forme = "ellipse";
            mode = "";
        });

        //Quand rectangleButton sélectionné, décoche les autres radioButton et désactive les bouttons Clone et Delete
        rectangleButton.setOnMouseClicked(event -> {
            ellipseButton.setSelected(false);
            selectButton.setSelected(false);
            lineButton.setSelected(false);
            deleteButton.setDisable(true);
            cloneButton.setDisable(true);
            forme = "rectangle";
            mode = "";
        });

        //Quand lineButton sélectionné, décoche les autres radioButton et désactive les bouttons Clone et Delete
        lineButton.setOnMouseClicked(event -> {
            ellipseButton.setSelected(false);
            rectangleButton.setSelected(false);
            selectButton.setSelected(false);
            deleteButton.setDisable(true);
            cloneButton.setDisable(true);
            forme = "ligne";
            mode = "";
        });



/*
        colorPick = new EventHandler() {
            @Override
            public void handle(Event event) {
                color = colorPicker.getValue();
            }
        };
        /*colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                Color c = colorPicker.getValue();
                System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
            }
        });
*/

        // Dessine la figure sélectionnée à l'endroit ou l'on clique
        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            color = colorPicker.getValue();  // Récupère la couleur choisis dans le color Picker
            gc.setFill(color); // Applique la couleur
            gc.setStroke(color); // Applique la couleur

            if (forme == "rectangle") {
                shape.drawRect(gc,x,y);
            } else if (forme == "ligne") {
                shape.drawLine(gc,x,y);
            } else if (forme == "ellipse") {
                shape.drawOval(gc,x,y);
            } else if (forme == "select") {
                if (mode == "delete"){
                    shape.remove(gc,x,y);
                } else if (mode == "clone"){
                    shape.clone(gc,x,y,forme);
                }
            }

        });
        deleteButton.setOnMouseClicked(event -> {
            mode = "delete";
        });

        cloneButton.setOnMouseClicked(event -> {
            mode = "clone";
        });
    }


}
