package com.jim.sprjfx.handle;

import com.jim.sprjfx.SprJfxApplication;
import com.jim.sprjfx.view.Demo;
import com.jim.sprjfx.view.LoginView;
import com.jim.sprjfx.view.RegistView;
import de.felixroske.jfxsupport.GUIState;

public class Goto{

    // 跳转到登录界面，用于两个位置：退出登录、注册完毕后跳转到登录页面
    public static void Login(){
        GUIState.getStage().setWidth(510);
        GUIState.getStage().setHeight(380);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(LoginView.class);
    }

    // 登录成功后，跳转到工作空间页面
    public static void Book(){
        GUIState.getStage().setWidth(830);
        GUIState.getStage().setHeight(550);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(Demo.class);
    }

    // 在登录页面点击注册，然后会进行注册
    public static void Regist(){
        GUIState.getStage().setWidth(440);
        GUIState.getStage().setHeight(430);
        GUIState.getStage().centerOnScreen();
        SprJfxApplication.showView(RegistView.class);
    }


}
