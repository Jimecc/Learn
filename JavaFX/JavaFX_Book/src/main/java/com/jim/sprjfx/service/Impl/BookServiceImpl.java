package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.Book;
import com.jim.sprjfx.handle.Read;
import com.jim.sprjfx.mapper.BookMapper;
import com.jim.sprjfx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SprJfx-master  com.jim.sprjfx.service.Impl
 * Anan
 *
 * @author an
 * description : 不可描述
 * @date 2022/11/19 15:57
 */

@Service
public class BookServiceImpl implements BookService {


    // 自动注入Mapper层（Mapper层是与数据库做交互的层）
    @Autowired
    BookMapper bookMapper;


    // 根据id查找图书
    @Override
    public Book getBook(int id) {
        return bookMapper.getBookByID(id);
    }

    // 插入图书
    @Override
    public int insertBook(Book book) {
        bookMapper.insertBook(book);
        return 0;
    }

    // 用书名查找一本书
    @Override
    public Book getBookByName(String name) {
        return bookMapper.getBookByName(name);
    }

    // 根据书名删除一本书
    @Override
    public int DeleteByName(String name) {
        return bookMapper.DeleteByName(name);
    }

    // 根据id更新一本书（传入值为一个book对象）
    @Override
    public int UpdateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public List<Book> getBooksLikeName(String name){
        return bookMapper.getBookLikeName(name);
    }

    @Override
    // 0 插入失败 1 成功
    // 2.未填写必选项 3.数字填写错误 4.已存在相同书名的数
    public int insert(String name, String author, String press, String type, String price, String max, String info) {
        if("".equals(name)){
            return 2;
        }

        int bprice = Read.Int(price);
        int bmax   = Read.Int(max);
        Book book = new Book();
        if(bprice == -2 || bmax == -2){
            return 3;
        }
        if(bookMapper.getBookByName(name) != null){
            return 4;
        }
        if( bprice > -1){
            book.setPrice(bprice);
        }
        if( bmax > -1){
            book.setMax( bmax );
            book.setNum( bmax );
        }
        book.setName(name);
        book.setAuthor(author);
        book.setType(type);
        book.setPress(press);
        book.setInfo(info);

        return bookMapper.insert(book);

    }

    @Override
    // 0 更新失败 1 成功
    // 2.未填写必选项 3.数字填写错误 4.已存在同名书籍 5.空白内容，不用更新 6.数据库中没有这本书 7.num过大
    public int update(String id, String name, String author, String press, String type, String price, String max, String num, String info){
        if("".equals(id)){
            return 2;
        }
        if("".equals(name) && "".equals(author) && "".equals(press) && "".equals(type) && "".equals(price) && "".equals(max) && "".equals(num) && "".equals(info) ){
            return 5;
        }

        // 判断是否填写了正确的ID
        int bid   = Read.Int(id);
        if(bid == -2){
            return 3;
        }
        // 判断是不是有这本书
        Book checkbookByID = bookMapper.getBookByID(bid);
        if(checkbookByID == null){
            return 6;
        }

        int bprice = 0;
        int bmax = 0;
        int bnum = 0;


        if(!price.equals("")){
            bprice = Read.Int(price);
        }
        if(!num.equals("")){
            bnum = Read.Int(num);
        }
        if(!max.equals("")){
            bmax = Read.Int(max);
            if (bmax < bnum){
                return 7;
            }
        }

        if (checkbookByID.getMax() < bnum && "".equals(max)){
            return 7;
        }


        Book book = new Book();
        if(bprice == -2 || bmax == -2 || bnum == -2){
            return 3;
        }

        if( bprice > -1){
            book.setPrice(bprice);
        }
        if( bmax > -1){
            book.setMax( bmax );
        }
        if( bnum > -1){
            book.setNum( bnum );
        }


        // 判断是否存在t同名数据
        if(!"".equals(name)) {
            Book checkBookByName = bookMapper.getBookByName(name);
            if(checkBookByName!=null){
                if(checkBookByName.getId() != bid){
                    return 4;
                }
            }
        }

        System.out.println("xx1");
        book.setId(bid);
        // 正常赋值
        if(!"".equals(name)){
            book.setName(name);
        }
        if(!"".equals(author)){
            book.setAuthor(author);
        }
        if(!"".equals(press)){
            book.setPress(press);
        }
        if(!"".equals(type)){
            book.setType(type);
        }
        if(!"".equals(info)){
            book.setInfo(info);
        }


        System.out.println(book.toString());
        return bookMapper.updateBook(book);
    }



}
