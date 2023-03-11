package com.jim.sprjfx.view;

import com.jim.sprjfx.handle.Dynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.UserService;
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
@FXMLView(value = "/view/LoginView.fxml")
public class LoginView extends AbstractFxmlView {


    // 一些输入框以及按钮
    public TextField textField_username;
    public PasswordField textField_password;
    public Label labelError;
    public Button ButtonALogin;
    public Button ButtonLogin;
    public Button ButtonRegist;
    // 自动注入Service层
    @Autowired
    private UserService userService;

    // 点击登录按钮
    public void onMouseClicked_buttonLogin(){

        // 获取输入框内容
        String username = textField_username.getText();
        String password = textField_password.getText();

        // 如果用户名或者密码是空的，那么就登录失败了
        if("".equals(username) || "".equals(password)){
            System.out.println("用户名或密码为空");
            labelError.setText("错误！请填写所有字段后重试");
            return;
        }

        // 如果Service层的login方法返回值为1，那么就登录成功，并且跳转到工作页面【将登录工作交给service层】
        if(userService.Login(username, password)==1){
            // 页面跳转
            Goto.Book();
            return;
        }else{
            // 登录失败，用户名与密码错误
            labelError.setText("错误！用户名或密码错误");
            return;
        }
    }


    // 点击注册按钮，进入注册页面
    public void onMouseClicked_buttonrRegist(){
        Goto.Regist();
    }


    // 点击用户名输入框，清空 密码 与 提示
    public void Clicked_textFieldLogin(){
        labelError.setText(null);
        textField_username.setText(null);
    }
    // 点击密码输入框，清空 密码 与 提示
    public void Clicked_textFieldPassword(){
        labelError.setText(null);
        textField_password.setText(null);
    }

    // 在密码框点击回车键登录
    public void onActionPassword(){
        onMouseClicked_buttonLogin();
    }

    // 在用户名输入框点击回车键登录
    public void onActionUsername(){
        onMouseClicked_buttonLogin();
    }
    // 鼠标移动到登录按钮上，登录按钮变成深蓝色
    public void onMouseMoved_buttonLogin(){
        Dynamic.movedon(ButtonLogin,Color.blue);
    }
    // 鼠标移动到注册按钮上，按钮变成灰色
    public void onMouseMoved_buttonRegist(){
        Dynamic.movedon(ButtonRegist,Color.gray);
    }
    // 鼠标移动到按钮上变色
    public void Moved_ALogin(){
        Dynamic.movedon(ButtonALogin, Color.gray);
    }

}
