package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.LesStu;
import com.jim.sprjfx.entity.Lesson;
import com.jim.sprjfx.entity.Teacher;
import com.jim.sprjfx.handle.ButtonDynamic;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Goto;
import com.jim.sprjfx.handle.MYID;
import com.jim.sprjfx.service.LesStuService;
import com.jim.sprjfx.service.LessonService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Jim
 * @Description 学生选课视图
 * @createTime 2022年12月07日
 */
@FXMLView(value = "/view/StuView.fxml")
public class StuView extends AbstractFxmlView {
    @Autowired
    LessonService lessonService;
    @Autowired
    LesStuService lesStuService;

    public TextArea kongzhitai;
    public Button ButtonLayout;
    public TextField TFSearchID;
    public TextField FXSearchName;
    public TextField ChoseClassID;
    public Label warrnig;
    public Label success;

    public void ClickLayout() {
        Goto.stulogin();
    }

    public void MovedLayout() {
        ButtonDynamic.movedon(ButtonLayout, Color.purple);
    }


    public void ClickShowAll() {
        List<Lesson> list = lessonService.getAllLessons();
        String info = "";
        for (Lesson lesson : list) {
            info += lesson.toString()+"\n";
        }
        kongzhitai.setText(info);
    }

    public void ClickSearchByName() {
        System.out.println("模糊搜索");
        String name = FXSearchName.getText();
        List<Lesson> list = lessonService.getLessonsByName(name);
        String info = "";
        for (Lesson lesson : list) {
            info += lesson.toString()+"\n";
        }
        kongzhitai.setText(info);
    }

    public void ClickSearchByID() {
        int id = Integer.valueOf(TFSearchID.getText());
        System.out.println(id);
        kongzhitai.setText(lessonService.getLessonsByID(id).toString());

    }

    public void EnterIDSearch() {
        ClickSearchByID();
    }

    public void ClickChoseLesson() {
        int lesID = 0;
        try{
            lesID = Integer.parseInt(ChoseClassID.getText());
        }catch (Exception e){
            warrnig.setText("ID有误，请重试！");
            return ;
        }
        LesStu lesStu = new LesStu();
        lesStu.setStuid(MYID.StudentID);
        lesStu.setLesid(lesID);
        if(CheckChoseLesson(lesStu)){
            init();
            warrnig.setText("您已经选过此课程了，请勿重复选择");
            return;
        }
        if(lesStuService.insert(lesStu) == 1){
            UpdateLessonRem(lesID,1); // 从课程的库里面 减少 一个剩余数量
            warrnig.setText(null);
            success.setText("添加成功");
        }
    }


    // 有就返回true，没有就返回false
    public boolean CheckChoseLesson(LesStu lesStu){
        LesStu result = lesStuService.getByLesAndStu(lesStu);
        if(!(null == result)){
            return true;
        }
        return false;
    }

    public void init(){
        warrnig.setText(null);
        success.setText(null);
    }

    public void ClickedDelLesson() {
        init();
        int lesID = 0;
        try{
            lesID = Integer.parseInt(ChoseClassID.getText());
        }catch (Exception e){
            warrnig.setText("ID有误，请重试！");
            return ;
        }

        LesStu lesStu = new LesStu();
        lesStu.setLesid(lesID);
        lesStu.setStuid(MYID.StudentID);
        if(lesStuService.deleteLes(lesStu) == 1){
            UpdateLessonRem(lesID,2); // 从课程的库里面 增加 一个剩余数量
            success.setText("删除成功！");
        }else{
            warrnig.setText("删除失败！您可能未选此课程");
        }
    }

    // 查找已选课程 将选择的课程依次放入字符段中
    public void ClickHaveChosenLesson() {
        // 操作 LesStu 表
        List<LesStu> list = lesStuService.selectByStuID(MYID.StudentID);
        String result = "";
        for (LesStu lesStu : list) {
            System.out.println(lesStu.toString());
            // 操作 Lesson 表
            result += lessonService.getLessonByID(lesStu.getLesid()).toString()+"\n";
        }

        kongzhitai.setText(result);
    }

    // 选课后课程-1 删除选课后课程+1
    public void UpdateLessonRem(int id,int a) {
        Lesson lesson = lessonService.getLessonByID(id);
        if(a == 1) {
            lesson.setRem(lesson.getRem() - 1);
        }else{
            lesson.setRem(lesson.getRem() + 1);
        }
        lessonService.updateLesson(lesson);
    }
}
