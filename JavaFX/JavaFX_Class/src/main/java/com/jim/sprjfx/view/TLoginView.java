package com.jim.sprjfx.view;

import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.TeacherService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description 登录功能
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/TLoginView.fxml")
public class TLoginView extends AbstractFxmlView {

    // FXML
    public TextField textField_username;
    public PasswordField textField_password;
    public Button ButtonALogin;
    public Button ButtonLogin;
    public Button ButtonRegist;
    public Label labelErrorUsername;

    @Autowired
    private TeacherService teacherService;

    public void Clicked_buttonLogin(){

        String username = textField_username.getText();
        String password = textField_password.getText();


        if("".equals(username) || "".equals(password)){
            labelErrorUsername.setText("请填写所有字段后重试。");
            return;
        }

        // 访问Service层
        if(teacherService.login(username, password)==1){
            labelErrorUsername.setText(null);
            TecView.my = username;
            Goto.teacher();
            return;
        }else{
            labelErrorUsername.setText("用户名或密码错误");
        }
    }

    public void Moved_ALogin(){
        ButtonDynamic.movedon(ButtonALogin, Color.gray);
    }

    public void Click_ALogin(){
        Goto.stulogin();
    }


    public void Moved_buttonLogin(){
        ButtonDynamic.movedon(ButtonLogin,Color.blue);
    }

    public void onMouseClicked_textFieldPassword() {
        labelErrorUsername.setText(null);
    }


    public void onActionPassword() {
        Clicked_buttonLogin();
    }

    public void onActionUsername() {
        Clicked_buttonLogin();
    }

    public void onMouseClicked_textFieldLogin() {
        labelErrorUsername.setText(null);
    }

    public void onMouseClicked_buttonrRegist() {
        Goto.tregister();
    }

    public void onMouseMoved_buttonRegist() {
        ButtonDynamic.movedon(ButtonRegist,Color.gray);
    }
}
