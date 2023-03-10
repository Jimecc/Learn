package com.jim.sprjfx.controller;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.SocketIOServer;
import com.jim.sprjfx.SprJfxApplication;
import com.jim.sprjfx.service.*;
import com.jim.sprjfx.view.MainView;
import com.jim.sprjfx.view.RegistView;
import de.felixroske.jfxsupport.FXMLController;
import de.felixroske.jfxsupport.GUIState;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;


@Slf4j
@Controller
@FXMLController
@RequestMapping(value="/shsw2")
public class DemoController {
    @Autowired
    private MsgController msgController;

    @Autowired
    private SocketIOServer socketIOServer;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private JsonService jsonService;

    @Autowired
    private DemoService demoService;

    @Autowired
    private SocketThread socketThread;

    @Autowired
    private JsonController jsonController;

    @Autowired
    private MsgSendService msgSendService;




    private boolean flag = true;
    public boolean webStatus = false;
    public boolean socketStatus = true;

    public Button button_socket;
    public Button button_web;
    public Button button_submit;
    public Button button_logout;
    public Button button_newnumber;
    public Button button_submit_jsonAddress;
    public Label label_nums;
    public Label label_address_update_success;
    public Label label_address_update_fail;
    public TextField textField_JsonAddress;
    public TextField TextField_SendData;
    public Circle circle;
    public Label label_WebSocketType;
    public Button button_startRedis;
    public Button button_startSocket;
    public Button buttonTurnUpload;
    public Button buttonTurnDownload;
    public Button buttonClearWebsocket;
    public Button button_switchGetPost;
    public Button button_transmit;
    public boolean switchGet = true;
    public boolean switchTransmit  = true;
    public boolean switchRedis = true;



    RestOperations restTemplate = new RestTemplate();

    //    http://localhost:8081/shsw/json
    @RequestMapping(value = "/json")
    @ResponseBody
    public String JSONGet(@RequestBody JSONObject jsonObject) {
        if(!this.switchGet) {
            return "???????????????";
        }
        if(switchTransmit){
            try {
                log.info("Post.JSON.Info--------------" + jsonService.JsonData(jsonObject, textField_JsonAddress.getText()));
                return "Success";
            }catch(Exception e){
                log.error(e.toString());
                return "????????????";
            }
        }else{
            return "?????????????????????";
        }
    }

    public void onMouseClicked_button_transmit(){
        this.switchTransmit = !this.switchTransmit;
    }

    public void onMouseMoved_button_transmit(){
        String color="";
        if(switchTransmit) {
            button_transmit.setText("????????????");
            color = "#FFDCD4"; // ??????
        }else{
            button_transmit.setText("????????????");
            color = "#ABDC65"; // ??????
        }
        demoService.onMouseMoved_bg(button_transmit,color);
    }

    public void onMouseClicked_button_switchGetPost(){
        this.switchGet = ! this.switchGet;
    }

    public void onMouseMoved_button_switchGetPost(){
            String color="";
            if(switchGet) { // ?????????????????? ???????????????????????????
                button_switchGetPost.setText("?????? Get / Post??????");
                color = "#FFDCD4"; // ??????
            }else{                              // ?????????????????? ????????????
                button_switchGetPost.setText("?????? Get / Post??????");
                color = "#ABDC65"; // ??????
            }
            demoService.onMouseMoved_bg(button_switchGetPost,color);
    }



    public void onMouseClicked_socket() {
        socketStatus = !socketStatus;
        if (socketStatus == false) {
            System.out.println("--??????-------------------------------------------------------------");
            socketIOServer.addDisconnectListener(client -> {
                client.disconnect();
            });
        } else {
            socketIOServer.addDisconnectListener(client -> {
                client.disconnect();
            });
            System.out.println("--??????-------------------------------------------------------------");

        }
    }

    public void onMouseClicked_web() {
        webStatus = !webStatus;
    }


    public void onMouseMoved_buttonClearWebsocket(){
        msgSendService.cleanMap();
        demoService.onMouseMoved_bg(buttonClearWebsocket,"#FFDCD4");

    }

    public void onMouseMoved_button_socket() {
        if (socketStatus == true) {
            demoService.onMouseMoved_bg(button_socket,"#6495ED");
        } else {
            demoService.onMouseMoved_bg(button_socket,"#6495ED");
        }
    }

    public void onMouseClicked_button_submit_jsonAddress() {
        String url = textField_JsonAddress.getText();
        if (!"".equals(url)) {
            try {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
                linkedHashMap.put("testLink", "Success");
                //
                JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(linkedHashMap));
                log.info("newLinkTest--------- " + restTemplate.postForEntity(url, json, String.class).getBody());
                label_address_update_success.setTextFill(Paint.valueOf("#15c930"));
                label_address_update_success.setText("??????????????????");
                label_address_update_fail.setText(null);
            } catch (Exception e) {
                label_address_update_success.setTextFill(Paint.valueOf("#ff3838"));
                label_address_update_success.setText("?????????????????????????????????");
                label_address_update_fail.setText(e.toString());
            }
        } else {
            label_address_update_success.setTextFill(Paint.valueOf("#ffc61c"));
            label_address_update_success.setText("??????????????????");
            label_address_update_fail.setText(null);

        }
    }

    /**
     * ?????????hsk
     * ?????????onMouseMoved
     * ?????????*3
     * ?????????????????????????????????????????????
     */

    public void onMouseMoved_turnUpload(){
        String color="";
        if(jsonController.upload == true) { // ?????????????????? ???????????????????????????
            buttonTurnUpload.setText("??????????????????");
            color = "#ABDC65"; // ??????
        }else{                              // ?????????????????? ????????????
            buttonTurnUpload.setText("??????????????????");
            color = "#FFDCD4"; // ??????
        }
        demoService.onMouseMoved_bg(buttonTurnUpload,color);

    }

    public void onMouseMoved_turnDownload(){
        String color = "";
        if(jsonController.download == true){
            buttonTurnDownload.setText("??????????????????");
            color = "#ABDC65";
        }else{
            buttonTurnDownload.setText("??????????????????");
            color = "#FFDCD4";
        }
        demoService.onMouseMoved_bg(buttonTurnDownload,color);
    }

    // Socket ??????
    public void onMouseMoved_startSocket(){
        String color = "";
        if (msgSendService.switchWebsocket) {
            button_startSocket.setText("???      ???");
            color = "#FFDCD4"; // ??????
        } else {
            button_startSocket.setText("???      ???");
            color = "#ABDC65";
        }
        demoService.onMouseMoved_bg(button_startSocket,color);
    }

    // Redis ?????????????????????
    public void onMouseMoved_startRedis(){
        demoService.onMouseMoved_bg(button_startRedis,"#69B319");
    }

    // JSONAddress ??????url??????
    public void onMouseMoved_button_submit_jsonAddress() {
        demoService.onMouseMoved_bg(button_submit_jsonAddress,"#6495ED");
    }

    // websocket ??????data??????
    public void onMouseMoved_button_submit() {
        demoService.onMouseMoved_bg(button_submit,"#6495ED");
    }

    // layout ????????????
    public void onMouseMoved_button_logout() {
        demoService.onMouseMoved_bg(button_logout,"#FFDCD4");
    }

    // newUser ??????????????????
    public void onMouseMoved_button_newnumber() {
        demoService.onMouseMoved_bg(button_newnumber,"#B3E5FF");
    }

    // onAction ??????Enter == ??????
    public void onEnter_send_data(ActionEvent ae) {
        onMouseClicked_submit();
    }
    public void onAction_JsonAddress() {
        onMouseClicked_button_submit_jsonAddress();
    }

    public void onMouseClicked_submit() {
        String text = TextField_SendData.getText();
        String type = typeService.returnType(text);
        showView(type);
        label_WebSocketType.setText("???????????????:  " + type);
        label_nums.setText(msgController.send(text));
    }

    public void onMouseClicked_startSocket() throws IOException, InterruptedException {
        msgSendService.switchWebSocket();
    }
    public void onMouseClicked_startRedis() throws InterruptedException {
        if(switchRedis) {
            threadService.switchRedis();
        }else{
            threadService.switchRedis();
            threadService.ScanRedis("hskcool");
        }
        this.switchRedis = ! this.switchRedis;

    }

    public void onMouseClickedTurnUpload() throws IOException, URISyntaxException{
        jsonController.toffUpload();
        if(jsonController.upload == true) { // ?????????????????? ???????????????????????????
            buttonTurnUpload.setText("??????????????????");
        }else{                              // ?????????????????? ????????????
            buttonTurnUpload.setText("??????????????????");
        }
        log.info("?????????????????????"+jsonController.upload);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }



    public void onMouseClickedTurnDownload(){
        jsonController.toffDownload();
        if(jsonController.download == true) { // ?????????????????? ???????????????????????????
            buttonTurnDownload.setText("??????????????????");
        }else{                              // ?????????????????? ????????????
            buttonTurnDownload.setText("??????????????????");
        }
        log.info("?????????????????????"+jsonController.download);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void onMouseClicked_test() throws IOException, URISyntaxException {
        msgSendService.cleanMap();
        msgSendService.switchWebSocket();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void onMouseClicked_openWebsocketWeb() throws IOException, URISyntaxException{
        String url="http://localhost:8080";
        Desktop desktop = Desktop.getDesktop();
        URI uri = new URI(url);
        desktop.browse(uri);
    }

    public void onMouseClicked_turnOff() throws IOException {
        socketThread.test();
    }
    public void onMouseClicked_JsonAddress() {
        label_address_update_success.setText(null);
        label_address_update_fail.setText(null);
    }

    public void onMouseClicked_sendWebsocketMessage() {
        label_WebSocketType.setText(null);
        label_nums.setText(null);
    }


    public void onMouseClicked_layout() {
        demoService.jumpWindows(520,380,MainView.class);
    }

    public void onMouseClicked_button_newnumber() {
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(RegistView.class);
    }


    public void showView(String type){
        if("pureChinese".equals(type)){
            demoService.moveCircle(160, 0, -30, 40, 20,circle);
        }else if("pureNumber".equals(type)){
            demoService.moveCircle(160, 0, 0, 0, 20,circle);
        }else if("pureString".equals(type)){
            demoService.moveCircle(0, 160, 0, 0, 20,circle);
        }else if("pureChar".equals(type)){
            demoService.moveCircle(160, 0, 30, -40, 20,circle);
        }else if("NULL".equals(type)){
            demoService.toBig(circle);
        }else if("notPure".equals(type)){
            demoService.moveCircle(0, 160, 30, -40, 20,circle);
        }

    }
    // ?????????
    public void moveCircleL2R() {
        demoService.moveCircle(0, 160, 0, 0, 20,circle);
    }



}
