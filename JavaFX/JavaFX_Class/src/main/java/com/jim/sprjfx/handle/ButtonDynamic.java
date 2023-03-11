package com.jim.sprjfx.handle;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class ButtonDynamic {

    public static void movedon(Button button, String color) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf(color), new CornerRadii(5), new Insets(1))));
    }
}
