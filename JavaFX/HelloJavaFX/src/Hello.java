import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.event.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 快捷键在Sence中进行设置 第11集
/**
 *
* */
import java.awt.event.MouseEvent;

public class Hello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int i = 0;
        Button b1 = greenButton("B1");
        Button b2 = greenButton("B2");
        b2.setLayoutX(400);
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("按键2单击事件");
            }
        });

        TextField text = new TextField();
        text.setText("这是文本");
        text.setLayoutX(100);
        text.setLayoutY(300);
        text.setPrefHeight(20);
        text.setPrefWidth(400);
        text.setFont(Font.font(16));
        Tooltip tip = new Tooltip("这是提示");
        tip.setFont(Font.font(15));
        text.setTooltip(tip);
        /*
        b1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event){

                if(event.getClickCount() == 2){
                    System.out.println("按键1双击事件");
                }
            }
        });
        */
        b1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按下 "+event.getCode().getName());
            }
        });
        b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("松开 "+event.getCode().getName());
            }
        });





        Group group = new Group();
        group.getChildren().addAll(b1,b2,text);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);


        primaryStage.setFullScreen(false);
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.show();

    }

    public Button greenButton(String name){
        Button button = new Button(name);
        button.setPrefHeight(200);
        button.setPrefWidth(400);

        // Background
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"),
                new CornerRadii(20),new Insets(10));
        Background bg = new Background(bgf);
        button.setBackground(bg);

        button.setTextFill(Paint.valueOf("#CD0000"));
        // 边框
        BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"),
                BorderStrokeStyle.DOTTED,new CornerRadii(10),
                new BorderWidths((2)));
        Border bo = new Border(bos);
        button.setBorder(bo);

        //


        return button;
    }
}
