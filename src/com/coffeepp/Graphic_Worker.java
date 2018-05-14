package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Graphic_Worker extends Graphic_Movable{
    private Worker graphic;



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
}
