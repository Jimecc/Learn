package com.jim.sprjfx.view;

import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.handle.MYID;
import com.jim.sprjfx.service.StudentService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description 登录功能
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/SLoginView.fxml")
public class SLoginView extends AbstractFxmlView {

    // FXML
    public TextField textField_username;
    public PasswordField textField_password;
    public Label labelError;
    public Button ButtonALogin;
    public Button ButtonLogin;
    public Button ButtonRegist;

    private String gray = "#DCDCDC";

    @Autowired
    private StudentService studentService;

    //
    public void onMouseClicked_buttonLogin(){

        String username = textField_username.getText();
        String password = textField_password.getText();

        if("".equals(username) || "".equals(password)){
            labelError.setText("错误！请填写所有字段后重试");
            return;
        }

        if(studentService.login(username, password)==1){
            MYID.StudentID = studentService.getStudentByUsername(username).getId();
            Goto.student();
            return;
        }else{
            labelError.setText("错误！用户名或密码错误");
            return;
        }
    }




    public void Clicked_textFieldLogin(){
        labelError.setText(null);
        textField_username.setText(null);
    }
    public void Clicked_textFieldPassword(){
        labelError.setText(null);
        textField_password.setText(null);
    }

    // 触碰改变颜色
    public void Moved_ALogin(){
        ButtonDynamic.movedon(ButtonALogin, Color.gray);
    }

    // 点击 进入教师登录界面
    public void Click_ALogin(){
        Goto.teclogin();
    }

    // 回车登录
    public void onActionPassword(){
        onMouseClicked_buttonLogin();
    }

    public void onActionUsername(){
        onMouseClicked_buttonLogin();
    }
    public void onMouseMoved_buttonLogin(){
        ButtonDynamic.movedon(ButtonLogin,Color.blue);
    }

    // 进入注册页面
    public void onMouseClicked_buttonrRegist() {
        Goto.sregister();
    }

    public void onMouseMoved_buttonRegist() {
        ButtonDynamic.movedon(ButtonRegist,Color.gray);
    }
}
