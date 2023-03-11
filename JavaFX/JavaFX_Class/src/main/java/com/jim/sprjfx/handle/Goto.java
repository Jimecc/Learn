package com.jim.sprjfx.handle;

import com.jim.sprjfx.SprJfxApplication;
import com.jim.sprjfx.view.*;
import de.felixroske.jfxsupport.GUIState;

public class Goto{

    //教师页面
    public static void teacher(){
        GUIState.getStage().setWidth(1024);
        GUIState.getStage().setHeight(600);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(TecView.class);
    }

    // 学生页面
    public static void student(){
        GUIState.getStage().setWidth(893);
        GUIState.getStage().setHeight(580);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(StuView.class);
    }

    // 教师登录
    public static void teclogin(){
        GUIState.getStage().setWidth(510);
        GUIState.getStage().setHeight(380);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(TLoginView.class);
    }

    // 学生登录
    public static void stulogin(){
        GUIState.getStage().setWidth(510);
        GUIState.getStage().setHeight(380);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(SLoginView.class);
    }

    // 教师注册
    public static void tregister(){
        GUIState.getStage().setWidth(550);
        GUIState.getStage().setHeight(420);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(TRegisterView.class);
    }

    // 学生注册
    public static void sregister(){
        GUIState.getStage().setWidth(600);
        GUIState.getStage().setHeight(420);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(SRegisterView.class);
    }


}
