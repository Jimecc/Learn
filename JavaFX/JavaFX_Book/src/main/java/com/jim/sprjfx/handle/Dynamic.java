package com.jim.sprjfx.handle;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class Dynamic {

    // 当鼠标移动到上面的时候，给 button 的颜色变成 color
    public static void movedon(Button button, String color) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf(color), new CornerRadii(5), new Insets(1))));
    }
    public static void label(Label label, String color, String info){
        label.setTextFill(Paint.valueOf(color));
        label.setText(info);
    }
}
