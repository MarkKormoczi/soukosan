package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_Crate extends Graphic_Movable{
    private Crate graphic;
    private Image img;
    private int z_index=2;

    public Graphic_Crate(Crate gr){
        graphic=gr;
        try {
            img = new Image(new FileInputStream(new File("img/crate.png").getAbsolutePath()));
        }
        catch (IOException e) {
        }
    }

    @Override
    public void Draw(Stage stage) {
        Group root = new Group();
        ObservableList list = root.getChildren();

        int x= graphic.getPlace().GetPosition().GetX();
        int y= graphic.getPlace().GetPosition().GetY();

        ImageView imageView = new ImageView(img);
        imageView.setX(x);
        imageView.setY(y);
        list.add(imageView);
        stage.show();

    }

    public void Destroy(){
        graphic.Destroy();

    }
}
