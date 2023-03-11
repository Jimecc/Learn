package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.Student;
import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.StudentService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/SRegisterView.fxml")
public class SRegisterView extends AbstractFxmlView {

    public TextField tfname;
    public TextField tfusername;
    public TextField tfclass;
    public TextField tfpassword1;
    public TextField tfpassword2;
    public Button ButtonSubmit;
    public Label warning;
    public Label success;

    @Autowired
    StudentService studentService;

    public void ClickSubmit(){
        init();
        String name = tfname.getText();
        String username = tfusername.getText();
        String clas = tfclass.getText();
        String password1 = tfpassword1.getText();
        String password2 = tfpassword2.getText();

        Student student = new Student(0,name,username,password1,clas);

        if("".equals(name) || "".equals(username) || "".equals(clas) || "".equals(password1) || "".equals(password2) ){
            warning.setText("字段填写不完整！");
            return;
        }
        if(!password1.equals(password2)){
            warning.setText("两次密码不一致！");
            return;
        }
        if(studentService.getStudentByUsername(username) != null){
            warning.setText("该用户已存在，请直接登录！");
            return;
        }
        if(studentService.register(student) == 1){
            warning.setText(null);
            success.setText("注册成功！");
            return;
        }else{
            warning.setText("注册失败！");
            success.setText("null");
        }

    }

    public void MovedSubmit(){
        ButtonDynamic.movedon(ButtonSubmit, Color.blue);
    }

    public void init(){
        success.setText(null);
        warning.setText(null);
    }

    public void tfclick() {
        init();
    }

    public void ClickGotoLogin() {
        Goto.stulogin();
    }
}
