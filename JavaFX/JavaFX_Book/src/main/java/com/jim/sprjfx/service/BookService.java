package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.Book;

import java.util.List;

/**
 * SprJfx-master  com.jim.sprjfx.service
 * Anan
 *
 * @author an
 * description : 不可描述
 * @date 2022/11/19 15:57
 */


public interface BookService {

    public Book getBook(int id);

    public int insertBook(Book book);

    public Book getBookByName(String name);

    public int DeleteByName(String name);

    public int UpdateBook(Book book);

    List<Book> getBooksLikeName(String name);

    int insert(String name, String author, String press, String type, String price, String max, String info);

    // 0 插入失败 1 成功
    // 2.未填写必选项 3.数字填写错误 4.已存在相同书名的数
    int update(String id, String name, String author, String press, String type, String price, String max, String num, String info);

}
