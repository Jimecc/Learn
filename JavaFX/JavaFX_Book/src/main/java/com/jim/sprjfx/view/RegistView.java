package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.User;
import com.jim.sprjfx.handle.Dynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.UserService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description 注册
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/RegistView.fxml")
public class RegistView extends AbstractFxmlView {

    // Service层，用于读取数据库中的数据
    @Autowired
    private UserService userService;

    // 按钮
    public Button ButtonSubmit;
    public Button ButtonGotoLogin;
    // 输入框
    public TextField Text_name;
    public TextField Text_username;
    public TextField Text_password1;
    public TextField Text_password2;
    // 提示
    public Label redLabel;
    public Label genLabel;
    public Label ErrorPassword;

    // 点击注册按钮，开始注册
    public void ClickedSubmit(){
        String name      = Text_name.getText();
        String username  = Text_username.getText();
        String password1 =Text_password1.getText();
        String password2 = Text_password2.getText();

        // 如果用户名、两次密码、姓名 没有填写完整，则登录失败
        if("".equals(name) || "".equals(username) || "".equals(password1) || "".equals(password2)){
            redLabel.setText("请填写所有字段后重试！");
            return;
        }

        // 如果两次尼玛不一致，则登录失败
        if(!password1.equals(password2)){
            ErrorPassword.setText("两次密码不一致！");
            return;
        }

        //  创建一个用户对象
        User user = new User(0,name,username,password1,0,0);
        // 向数据库中插入数据，将事务交给Service层来操作
        int result = userService.Regist(user);

        // 如果返回值为0，那么就注册失败
        if(result == 0){
            initLabel();
            redLabel.setText("注册失败，请重试");
        }
        // 返回值为 1，注册成功
        if(result == 1){
            initLabel();
            genLabel.setText("注册成功！");
            return;
        }
        // 返回值为2，注册失败，用户名已经被注册了
        if(result == 2){
            initLabel();
            redLabel.setText("用户已存在，请更改用户名后重试");
            return;
        }

    }

    public void MovedSubmit(){
        Dynamic.movedon(ButtonSubmit, Color.blue);
    }

    public void initLabel(){
        redLabel.setText(null);
        genLabel.setText(null);
        ErrorPassword.setText(null);
    }
    public void ClickName(){
        initLabel();
    }
    public void ClickUsername(){
        initLabel();
    }
    public void ClickPassword1(){
        initLabel();
    }
    public void ClickPassword2(){
        initLabel();
    }


    public void MovedGotoLogin(){
        Dynamic.movedon(ButtonGotoLogin,Color.green);
    }

    public void ClickedGotoLogin(){
        Goto.Login();
    }
}
