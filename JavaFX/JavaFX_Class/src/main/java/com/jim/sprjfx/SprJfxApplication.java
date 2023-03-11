package com.jim.sprjfx;

import com.jim.sprjfx.view.*;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SprJfxApplication extends AbstractJavaFxApplicationSupport {



    public static void main(String[] args) {
        launch(SprJfxApplication.class, SLoginView.class,new SplashScreen(){
            public boolean visible() { return false; }
        },args);

    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setResizable(false); /* 设置窗口不可改变 */
        stage.getIcons().add(new Image("img/icon.png"));
//      窗口置顶
//      stage.setAlwaysOnTop(true);
//      stage.initStyle(StageStyle.TRANSPARENT); /* 透明标题栏 */

    }

}
