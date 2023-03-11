package com.jim.sprjfx.view;

import com.jim.sprjfx.entity.Book;
import com.jim.sprjfx.entity.Lend;
import com.jim.sprjfx.handle.Color;
import com.jim.sprjfx.handle.Dynamic;
import com.jim.sprjfx.service.BookService;
import com.jim.sprjfx.service.LendService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;


/**
 * @author zzy
 * @Description
 * @createTime 2022年12月11日
 */

@FXMLView(value = "/view/Demo.fxml")
public class Demo extends AbstractFxmlView {

    @Autowired
    BookService bookService;

    @Autowired
    LendService lendService;

    public Label Label1;
    public Label Label2;
    public Label Label3;
    public Label Label4;

    // 控制台
    public ListView kongzhitai;


    // 插入图书
    public TextField TfInsertbookName;
    public TextField TfInsertbookAuthor;
    public TextField TfInsertbookPress;
    public TextField TfInsertbookType;
    public TextField TfInsertbookPrice;
    public TextField TfInsertbookMax;
    public TextField TfInsertbookInfo;
    public Button ButtonInsert;

    // 更新图书
    public TextField TfUpdateBookID;
    public TextField TfUpdateBookName;
    public TextField TfUpdateBookAuthor;
    public TextField TfUpdateBookPress;
    public TextField TfUpdateBookType;
    public TextField TfUpdateBookPrice;
    public TextField TfUpdateBookMax;
    public TextField TfUpdateBookNum;
    public TextField TfUpdateBookInfo;

    // 查找/删除
    public TextField TfSearchAndDeleteByName;
    // 借阅功能
    public TextField LoutUname;
    public TextField LoutBname;
    public TextField LinUname;
    public TextField LinBname;
    // 借阅查询
    public TextField TfLendSearch;

    // 0 插入失败 1 成功
    // 2.未填写必选项 3.数字填写错误 4.已存在相同书名的数
    public void ClickInsertBook() {
        int result = bookService.insert(TfInsertbookName.getText(), TfInsertbookAuthor.getText(), TfInsertbookPress.getText(), TfInsertbookType.getText(), TfInsertbookPrice.getText(), TfInsertbookMax.getText(), TfInsertbookInfo.getText());
        if (result == 0){
            Dynamic.label(Label1, Color.error,"插入失败");
        }
        if (result == 1){
            Dynamic.label(Label1, Color.success,"插入成功！");
        }
        if (result == 2){
            Dynamic.label(Label1, Color.error,"插入失败，请填写书名后重试！");
        }
        if (result == 3){
            Dynamic.label(Label1, Color.error,"插入失败，请在\"价格、数量\"的位置填写数字");
        }
        if (result == 4){
            Dynamic.label(Label1, Color.error,"插入失败，数据库中已存在同名书籍");
        }
    }

    // 0 更新失败 1 成功
    // 2.未填写必选项 3.数字填写错误 4.已存在同名书籍 5.空白内容，不用更新 6.数据库中没有这本书 7.num过大
    public void ClickButtonUpdate() {
        int result = bookService.update(TfUpdateBookID.getText(), TfUpdateBookName.getText(), TfUpdateBookAuthor.getText(), TfUpdateBookPress.getText(), TfUpdateBookType.getText(), TfUpdateBookPrice.getText(), TfUpdateBookMax.getText(), TfUpdateBookNum.getText(), TfUpdateBookInfo.getText());
        if (result == 0){
            Dynamic.label(Label2,Color.error,"更新失败！");
        }
        if (result == 1){
            Dynamic.label(Label2,Color.success,"更新成功！");
        }
        if (result == 2){
            Dynamic.label(Label2,Color.error,"ID未填写，请修改后重试");
        }
        if (result == 3){
            Dynamic.label(Label2,Color.error,"字段填写错误，您是不是在填写数字的地方写了字符串？");
        }
        if (result == 4){
            Dynamic.label(Label2,Color.error,"更新失败，已存在其他同名书籍");
        }
        if (result == 5){
            Dynamic.label(Label2,Color.error,"您未填写任何内容");
        }
        if (result == 6){
            Dynamic.label(Label2,Color.error,"没有找到这本书，请检查您的ID输入是否正确");
        }
        if (result == 7){
            Dynamic.label(Label2,Color.error,"剩余书籍数量填写过大");
        }
    }


    public void ClickSearchByName() {
        Label4.setText(null);
        kongzhitai.getItems().clear();
        URL cssurl = this.getClass().getClassLoader().getResource("css/kongzhitai.css");
        kongzhitai.getStylesheets().add(cssurl.toExternalForm());
        ObservableList<Pane> paneList = FXCollections.observableArrayList();

        List<Book> books = bookService.getBooksLikeName(TfSearchAndDeleteByName.getText());
        for (Book book : books) {
            Pane pan = new Pane();
            Label LabelName = new Label(book.getName());
            Label LabelNum = new Label("ID:"+book.getId()+" 数量:"+book.getMax() + " - " + book.getNum());
            Label LabelInfo = new Label("简介："+book.getInfo());


            ImageView imageView = new ImageView(new Image("file:src/main/resources/img/book.png"));;
            if(book.getNum()<1){
                imageView = new ImageView(new Image("file:src/main/resources/img/bookn.png"));
            }
            imageView.setLayoutX(3);
            imageView.setLayoutY(5);
            imageView.setFitHeight(38);
            imageView.setFitWidth(38);


            LabelName.setLayoutX(55);
            LabelName.setLayoutY(3);
            LabelName.setFont(Font.font(16));

            LabelNum.setLayoutX(55);
            LabelNum.setLayoutY(23);
            LabelNum.setFont(Font.font(11));
            LabelNum.setTextFill(Paint.valueOf(String.valueOf(javafx.scene.paint.Color.GRAY)));

            LabelInfo.setLayoutX(55);
            LabelInfo.setLayoutY(34);
            LabelInfo.setFont(Font.font(14));
            LabelInfo.setTextFill(Paint.valueOf(String.valueOf(javafx.scene.paint.Color.LIGHTSLATEGREY)));

            pan.getChildren().addAll(LabelNum,LabelName,LabelInfo,imageView);
            paneList.add(pan);

        }
        kongzhitai.getItems().addAll(paneList);
    }

    public void ClickDeleteByName() {
        int result = bookService.DeleteByName(TfSearchAndDeleteByName.getText());
        if(result == 1){
            Dynamic.label(Label4,Color.success,"删除成功");
        }
        if(result == 0){
            Dynamic.label(Label4,Color.error,"删除失败，请检查书名是否填写正确");
        }
    }

    // 0 失败 1 成功
    // 2.没有这本书 3. 书本的数量小于 4. 已经借过，未归还
    public void ClickButtonLendOut() {
        if("".equals(LoutUname.getText() ) || "".equals(LoutBname.getText())){
            Dynamic.label(Label3,Color.error,"未填写必填项");
            return;
        }


        Lend lend = new Lend(LoutUname.getText(),LoutBname.getText());
        int result = lendService.insert(lend);
        if(result == 0){
            Dynamic.label(Label3,Color.error,"借出失败");
        }
        if(result == 1){
            Dynamic.label(Label3,Color.success,"借出成功");
        }
        if(result == 2){
            Dynamic.label(Label3,Color.error,"没有这本书");
        }
        if(result == 3){
            Dynamic.label(Label3,Color.error,"库存不足，请添加书籍后重试！");
        }
        if(result == 4){
            Dynamic.label(Label3,Color.error,"您已经借过这本书了，在归还之前不可以再借这本书了");
        }

    }

    // 0 失败 1成功
    // 2 字段不完整 3.没结果这本书  4.书库中没有这本书
    public void ClickButtonLendin() {
        int result = lendService.delete(LinUname.getText(),LinBname.getText());
        if (result==0){
            Dynamic.label(Label3,Color.error,"归还失败");
            return;
        }
        if (result == 1){
            Dynamic.label(Label3,Color.success,"归还成功！");
            return;
        }
        if (result==2){
            Dynamic.label(Label3,Color.error,"您没有填写所有字段");
            return;
        }
        if (result==3){
            Dynamic.label(Label3,Color.error,"归还失败，此人没有借过这本书");
            return;
        }
        if(result == 4){
            Dynamic.label(Label3,Color.error,"归还失败，书库中没有这本书");
            return;
        }
    }

    public void ClickButtonLendSearch() {
        Label4.setText(null);
        kongzhitai.getItems().clear();
        URL cssurl = this.getClass().getClassLoader().getResource("css/kongzhitai.css");
        kongzhitai.getStylesheets().add(cssurl.toExternalForm());
        ObservableList<Pane> paneList = FXCollections.observableArrayList();

        List<Lend> lends = lendService.getLendsLikeName(TfLendSearch.getText());

        for (Lend lend : lends) {
            Pane pan = new Pane();
            Label LabelUname = new Label(lend.getUname());
            Label LabelBname = new Label("租借人：" + lend.getBname());

            LabelUname.setLayoutX(55);
            LabelUname.setLayoutY(3);
            LabelUname.setFont(Font.font(16));

            ImageView imageView = new ImageView(new Image("file:src/main/resources/img/book.png"));;
            imageView.setLayoutX(3);
            imageView.setLayoutY(5);
            imageView.setFitHeight(38);
            imageView.setFitWidth(38);

            LabelBname.setLayoutX(55);
            LabelBname.setLayoutY(34);
            LabelBname.setFont(Font.font(14));
            LabelBname.setTextFill(Paint.valueOf(String.valueOf(javafx.scene.paint.Color.LIGHTSLATEGREY)));

            pan.getChildren().addAll(LabelUname, LabelBname,imageView);
            paneList.add(pan);

        }
        kongzhitai.getItems().addAll(paneList);
    }
}
