import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /**
         * {
         * 	“request_head”:”sunward_websocket”
         * 	“request”:”websocket”,
         * "type": 3,
         * "data": {
         * 	“send_data”:”输入框内容”
         * 	“send_num”:发送给当前websocket连接上的数量
         * 	“datatype”:”输入框内数据类型”	（纯字符，纯数字，纯字串，混合字串）
         * }
         * “date”:”2022-01-20 11:08:57”
         * }
         * */
        // 输入框1 请求头    “request_head”:”sunward_websocket”
        // 输入框2     “request”:”websocket”,
        // 输入框3     "type": 3,
        // 输入框4     "data": {   “send_data”:”输入框内容”
        // 输入框5     "data": {   “send_num”:发送给当前websocket连接上的数量
        // 输入框6     "data": {   “datatype”:”输入框内数据类型”	（纯字符，纯数字，纯字串，混合字串）
        // 输入框7     “date”:”2022-01-20 11:08:57”

        // 控制按钮 开启/关闭   socket
        // 控制按钮 开启/关闭   web

        int width = 240;
        int height= 40;
        int x = 144;
        TextField textRequesthead1 = newTextField("request_head","请输入请求头",width,height,x,50);
        TextField textRequesthead2 = newTextField("request","请输入请求头",width,height,x,100);
        TextField textRequesthead3 = newTextField("1/2/3","请输入请求头",width,height,x,150);
        TextField textRequesthead4 = newTextField("输入框内容","请输入请求头",width,height,x,200);
        TextField textRequesthead5 = newTextField("发送给当前websocket连接上的数量","请输入请求头",width,height,x,250);
        TextField textRequesthead6 = newTextField("输入框内数据类型","请输入请求头",width,height,x,300);
        TextField textRequesthead7 = newTextField("时间","请输入请求头",width,height,x,350);
        Button but1 = newPureButton("request_head",40,50);
        Button but2 = newPureButton("request",40,100);
        Button but3 = newPureButton("type",40,150);
        Button but4 = newPureButton("data:send_data",40,200);
        Button but5 = newPureButton("data:send_num",40,250);
        Button but6 = newPureButton("data:data_type",40,300);
        Button but7 = newPureButton("date",40,350);

        // 双按钮
        Button butswitchsocket = newButton("开关socket","#00BFFF","#FFFFFF",460,40);
        Button butswitchweb = newButton("开关web","#00BFFF","#FFFFFF",620,40);


        butswitchweb.addEventHandler(MouseEvent.MOUSE_MOVED,new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(event.getTarget()!=butswitchweb){
                    System.out.println("Yes");
                    BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#00ADFF"), new CornerRadii(7),new Insets(10));
                    Background bg = new Background(bgf);
                    butswitchweb.setBackground(bg);
                }else{
                    System.out.println("No");
                    BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#00BFFF"), new CornerRadii(7),new Insets(10));
                    Background bg = new Background(bgf);
                    butswitchweb.setBackground(bg);
                }
            }
        });


        butswitchsocket.addEventHandler(MouseEvent.MOUSE_MOVED,new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(event.getTarget()!=butswitchsocket){
                    System.out.println("Yes");
                    BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#00ADFF"), new CornerRadii(7),new Insets(10));
                    Background bg = new Background(bgf);
                    butswitchsocket.setBackground(bg);
                }else{
                    System.out.println("No");
                    BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#00BFFF"), new CornerRadii(7),new Insets(10));
                    Background bg = new Background(bgf);
                    butswitchsocket.setBackground(bg);
                }
            }
        });

        Group group = new Group();
        group.getChildren().addAll(but1,but2,but3,but4,but5,but6,but7,textRequesthead1,textRequesthead2,textRequesthead3,textRequesthead4,textRequesthead5,textRequesthead6,textRequesthead7,butswitchsocket,butswitchweb);
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

    // 输入框内文字、宽度、高度、布局X/Y、
    private TextField newTextField(String words,String tip,int width,int height,int textLayoutX,int textLayoutY) {
        TextField text = new TextField();
        // 文本内容 words
        text.setText(words);
        // 高度 & 宽度
        text.setPrefWidth(width);  // username 80x40
        text.setPrefHeight(height);

        text.setLayoutX(textLayoutX);
        text.setLayoutY(textLayoutY);
        Tooltip tip_username = new Tooltip(tip);
        int fontSize = 15;
        tip_username.setFont(Font.font(fontSize));
        text.setTooltip(tip_username);
        return text;
    }

    private Button newPureButton(String Name,int x,int y){
        Button button = new Button(Name);
        button.setPrefHeight(40);
        button.setPrefWidth(120);
        button.setLayoutX(x);
        button.setLayoutY(y);

        // Background
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#FFFFFF"), new CornerRadii(7),new Insets(10));
        Background bg = new Background(bgf);
        button.setBackground(bg);

        button.setTextFill(Paint.valueOf("#000000"));

        // 边框
//        BorderStroke bos = new BorderStroke(Paint.valueOf("#8A2BE2"),
//                BorderStrokeStyle.DOTTED,new CornerRadii(10),
//                new BorderWidths((2)));
//        Border bo = new Border(bos);
//        button.setBorder(bo);

        //


        return button;

    }

    private Button newButton(String Name,String butColor,String fontColor,int x,int y){
        Button button = new Button(Name);
        button.setPrefHeight(60);
        button.setPrefWidth(130);
        button.setLayoutX(x);
        button.setLayoutY(y);

        // Background
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf(butColor), new CornerRadii(7),new Insets(10));
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
