package sample;

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

public class Figure {
    public void drawOval(GraphicsContext gc, double x, double y){
        gc.fillOval(x,y,100,40);
    }

    public void drawRect(GraphicsContext gc, double x, double y){
        gc.fillRect(x,y,100,40);
    }

    public void drawLine(GraphicsContext gc, double x, double y){
        gc.setLineWidth(5);
        gc.strokeLine(x,y,x+100,y);


    }

    public void remove(GraphicsContext gc, double x, double y){
        gc.clearRect(x,y,100,40);
    }

    // Ne fonctionne pas
    public void clone(GraphicsContext gc, double x, double y, String forme){
        // String forme = la forme de la figure sélectionné
        // String color = la couleur de la figure sélectionné
        // gc.setFill(color); // Applique la couleur
        // gc.setStroke(color); // Applique la couleur
        if (forme == "rectangle")
            this.drawRect(gc, x, y);
        else if (forme == "ligne")
            this.drawLine(gc, x, y);
        else if (forme == "ellipse")
            this.drawOval(gc, x, y);
    }

    /*public void shapeSelected(MouseEvent e, GraphicsContext gc){
        double x = e.getX();
        double y = e.getY();
        gc.translate(x,y);

    }


    public void move(double x, double y){
        this.setTranslateX(x);
    }
    public void delete(){

    }*/
}
