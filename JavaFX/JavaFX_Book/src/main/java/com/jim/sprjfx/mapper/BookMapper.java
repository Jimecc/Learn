package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookMapper {

// 配合 /resources/mybatis/BookMapper.xml 对数据库中的书籍进行增删改查

    // 插入书记，一般用于添加图书
    public int insertBook(Book book);
    // 使用ID查找书籍，一般用于更新的时候判断书本内容
    public Book getBookByID(int id);
    // 使用名称查找数据，一般用于判断数据库中是否已经有这本书了
    public Book getBookByName(String name);
    // 使用用户名进行删除，用于删除图书
    public int DeleteByName(String name);
    // 更新数据，用于图书的更新
    public int updateBook(Book book);

    int insert(Book book);

    List<Book> getBookLikeName(String name);




}
