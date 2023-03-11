package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.LesStu;
import com.jim.sprjfx.entity.Lesson;
import com.jim.sprjfx.entity.Teacher;
import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.service.LesStuService;
import com.jim.sprjfx.service.LessonService;
import com.jim.sprjfx.service.TeacherService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Jim
 * @Description 教师课程管理视图
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/TecView.fxml")
public class TecView extends AbstractFxmlView {

    @Autowired
    TeacherService teacherService;
    @Autowired
    LessonService lessonService;
    @Autowired
    LesStuService lesStuService;


    public TextArea TAInfo;
    public TextField tfid;
    public TextField tfname;
    public TextField tfsum;
    public Label LabelWarning;
    public Label LabelSuccess;

    public Button ButtonLayout;
    public static String my = "";

    public void Click_layout() {
        Goto.teclogin();
    }

    public void MovedLayout() {
        ButtonDynamic.movedon(ButtonLayout, Color.purple);
    }

    public void ClickViewMyLessons() {
        Teacher me = teacherService.getTeacherByUsername(my);
        int myID = me.getId();
        List<Lesson> list = lessonService.getLessonsByTecID(myID);
        String info = "";
        for (Lesson lesson : list) {
            info += lesson.toString()+"\n";
        }
        TAInfo.setText(info);
    }


    public void ClickSubmit() {
        init();
        Lesson lesson = GiveLesson();
        if(lesson.getName()==null || lesson.getNum() == 0){
            init();
            LabelWarning.setText("您输入的字段有误！请输入所有字段后重试！");
            return;
        }
        // 使用我的ID与课程名字做检测
        if(lessonService.getLessonByNameAndTecID(lesson) != null){
            LabelWarning.setText("系统检测到您已经开设过此课程，请勿重复开设！");
            return;
        }

        if(lessonService.insertLesson(lesson) == 1){
            LabelSuccess.setText("添加成功！");
            return;
        }
    }





    // 更新
    public void ClickUpdate() {
        init();
        Lesson lesson = GiveLesson();
        Lesson checkLesson = lessonService.getLessonByNameAndTecID(lesson);
        if (lessonService.getLessonByID(lesson.getId()) == null) {
            LabelWarning.setText("您没有开设此课程，请修改ID后重试！");
            return;
        }
        if(checkLesson != null && checkLesson.getId()!=GiveLesson().getId()){
            LabelWarning.setText("课程名称重复！");
            return;
        }

        if(lessonService.updateLesson(lesson) == 1){
            LabelSuccess.setText("更新成功");
            return;
        }
        LabelWarning.setText("更新失败，请修改ID后重试");
    }

    public Lesson GiveLesson(){
        String name = tfname.getText();
        int id = 0;
        int num = 0;
        int rem = 0;

        if("".equals(tfid.getText())){
            System.out.println("空白ID");
        }else{
            try{
                id = Integer.valueOf(tfid.getText());
            }catch (Exception e){
                System.out.println(e);
            }
        }

        try{
            num = Integer.valueOf( tfsum.getText());
            rem = num;
        }catch (Exception e){
            System.out.println("报错了");
        }
        Teacher me = teacherService.getTeacherByUsername(my);
        int myID = me.getId();
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setName(name);
        lesson.setNum(num);
        lesson.setRem(rem);
        lesson.setTecid(myID);
        return lesson;
    }

    public void ClickDelLesson() {
        // 字符串转换为整型
        int id = 0;
        try{
            id = Integer.parseInt(tfid.getText());
        }catch (Exception e){
            LabelWarning.setText("您的ID有误，请重新输入！");
        }

        if(lessonService.deleteByID(id) == 1){
            init();
            lesStuService.deleteByLesid(id);
            LabelSuccess.setText("删除成功！");
        }else {
            init();
            LabelWarning.setText("删除失败，您可能没有此课程！");
        }
    }



    public void init(){
        LabelWarning.setText(null);
        LabelSuccess.setText(null);
    }
}
