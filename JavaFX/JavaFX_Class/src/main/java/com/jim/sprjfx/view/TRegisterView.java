package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.Teacher;
import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.TeacherService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description 注册页面
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/TRegisterView.fxml")
public class TRegisterView extends AbstractFxmlView{

    @Autowired
    TeacherService teacherService;

    public Button ButtonSubmit;
    public TextField tname;
    public TextField tusername;
    public TextField tpassword1;
    public TextField tpassword2;
    public Label warning;
    public Label success;



    public void MovedSubmit() {
        ButtonDynamic.movedon(ButtonSubmit, Color.blue);
    }

    public void ClickGotoLogin() {
        Goto.teclogin();
    }

    public void ClickSubmit() {
        warning.setText(null);
        success.setText(null);
        String name = tname.getText();
        String username = tusername.getText();
        String password1 = tpassword1.getText();
        String password2 = tpassword2.getText();



        if("".equals(name) || "".equals(username) || "".equals(password1) || "".equals(password2) ){
            warning.setText("请填写完整字段后重试！");
            return;
        }
        if(password1 != password2 ){
            warning.setText("两次密码不一致！请修改后重试！");
            return;
        }
        if(teacherService.getTeacherByUsername(username) != null){
            warning.setText("该用户名已经被注册，请重新输入！");
            return;
        }

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setUsername(username);
        teacher.setPassword(password1);
        if(teacherService.register(teacher) == 1){
            success.setText("注册成功！");
        }

    }

    public void init(){
        warning.setText(null);
        success.setText(null);
    }
    public void ClickTF() {
        init();
    }
}
