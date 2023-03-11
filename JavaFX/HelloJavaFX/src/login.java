import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


/**
 * 内容： 文本框 x2
 * 编码： hsk
 * -------------
 * */
        // 双文本框
        TextField text_username = new TextField();
        TextField text_password = new TextField();
        // 文本内容
        text_username.setText("用户名");
        text_password.setText("密码");
        // 高度 & 宽度
        text_username.setPrefWidth(200);  // username 80x40
        text_username.setPrefHeight(40);
        text_password.setPrefWidth(200);  // password 80x40
        text_password.setPrefHeight(40);

        int textLayoutX =  500;
        int textLayoutY =  160;
        int textDistanceY = 50;
        text_username.setLayoutX(textLayoutX);
        text_password.setLayoutX(textLayoutX);
        text_username.setLayoutY(textLayoutY);
        text_password.setLayoutY(textLayoutY+textDistanceY);
        Tooltip tip_username = new Tooltip("请输入用户名");
        Tooltip tip_password = new Tooltip("请输入密码");

        int fontSize = 15;
        tip_username.setFont(Font.font(fontSize));
        tip_password.setFont(Font.font(fontSize));
        text_username.setTooltip(tip_username);
        text_password.setTooltip(tip_password);


/**
 * 内容： Button
 * 编码： hsk
 * -------------
 * */
        Button buttonLogin = newButton("      登  录      ","#00BFFF","#FFFFFF",200,60);
        Button buttonRegister = newButton("注册","#FFFFFF","#808080",90,60);
        Button buttonForgot = newButton("忘记密码","#FFFFFF","#808080",90,60);


        buttonLogin.addEventHandler(MouseEvent.MOUSE_MOVED,new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(event.getTarget()!=buttonLogin){
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#4169E1"), new CornerRadii(7),new Insets(10)));
                    buttonLogin.setBackground(bg);
                }else{
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#00BFFF"), new CornerRadii(7),new Insets(10)));
                    buttonLogin.setBackground(bg);
                }
            }
        });

        buttonRegister.addEventHandler(MouseEvent.MOUSE_MOVED,new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(event.getTarget()!=buttonRegister){
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#F5F5F5"), new CornerRadii(7),new Insets(10)));
                    buttonRegister.setBackground(bg);
                }else{
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#FFFFFF"), new CornerRadii(7),new Insets(10)));
                    buttonRegister.setBackground(bg);
                }
            }
        });

        buttonForgot.addEventHandler(MouseEvent.MOUSE_MOVED,new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println(event);
                if(event.getTarget()!=buttonForgot){
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#F5F5F5"), new CornerRadii(7),new Insets(10)));
                    buttonForgot.setBackground(bg);
                }else{
                    Background bg = new Background(new BackgroundFill(Paint.valueOf("#FFFFFF"), new CornerRadii(7),new Insets(10)));
                    buttonForgot.setBackground(bg);
                }
            }
        });

        int buttonLayoutX = textLayoutX;
        int buttonLayoutY = textLayoutY;
        buttonLogin.setLayoutX(buttonLayoutX);
        buttonLogin.setLayoutY(buttonLayoutY+100);
        buttonRegister.setLayoutX(buttonLayoutX);
        buttonRegister.setLayoutY(buttonLayoutY+160);
        buttonForgot.setLayoutX(buttonLayoutX+100);
        buttonForgot.setLayoutY(buttonLayoutY+160);

/**
 * 内容： show
 * 编码： hsk
 * -------------
 * */
        // Group && Scene && PrimaryStage
        Group group = new Group();
        group.getChildren().addAll(text_username,text_password,buttonLogin,buttonRegister,buttonForgot);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("上海世沃新承");
        primaryStage.getIcons().add(new Image("/resources/img/icon.png"));
        primaryStage.setResizable(false);

        primaryStage.setFullScreen(false);
        primaryStage.setHeight(500);
        primaryStage.setWidth(840);
        primaryStage.show();
    }

//  int setprefHeight,int prefWidth,
    public Button newButton(String name,String bgColor,String fontColor,int Width,int Height){
        Button button = new Button(name);
        button.setPrefHeight(Height);
        button.setPrefWidth(Width);

        // Background
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf(bgColor), new CornerRadii(7),new Insets(10));
        Background bg = new Background(bgf);
        button.setBackground(bg);

        button.setTextFill(Paint.valueOf(fontColor));

        // 边框
//        BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"),
//                BorderStrokeStyle.DOTTED,new CornerRadii(10),
//                new BorderWidths((2)));
//        Border bo = new Border(bos);
//        button.setBorder(bo);

        //
        return button;
    }

}
