package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.Book;
import com.jim.sprjfx.entity.Lend;
import com.jim.sprjfx.mapper.BookMapper;
import com.jim.sprjfx.mapper.LendMapper;
import com.jim.sprjfx.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzy
 * @Description
 * @createTime 2022年12月11日
 */
@Service
public class LendServiceImpl implements LendService {

    @Autowired
    LendMapper lendMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Lend> getLendsLikeName(String name) {
        return lendMapper.getLendLikeName(name);
    }

    @Override
    // 0 失败 1 成功
    // 2.没有这本书 3. 书本的数量小于 4. 已经借过，未归还
    public int insert(Lend lend){
        if(lendMapper.getBuUNameAndBname(lend) != null){
            return 4;
        }
        Book check = bookMapper.getBookByName(lend.getBname());
        if(check == null){
            return 2;
        }
        if(check.getNum() < 1){
            return 3;
        }
        System.out.println("-------");
        System.out.println(check.getNum());
        check.setNum(check.getNum()-1);
        System.out.println(check.getNum());
        System.out.println("-------");
        int resultUpdate = bookMapper.updateBook(check);
        System.out.println(resultUpdate);
        if(resultUpdate != 1){
            return 0;
        }
        return lendMapper.insert(lend);
    }

    // 0 失败 1成功
    // 2 字段不完整 3.没结果这本书 4.书库中没有这本书
    @Override
    public int delete(String uname, String bname){
        if("".equals(uname) || "".equals(bname)){
            return 2;
        }
        Lend lend = new Lend(uname,bname);
        if(lendMapper.getBuUNameAndBname(lend) == null){
            return 3;
        }
        Book book = bookMapper.getBookByName(bname);
        if(book == null){
            return 4;
        }
        System.out.println(book.toString());
        book.setNum(book.getNum()+1);
        if(bookMapper.updateBook(book) != 1){
            return 0;
        }
        return lendMapper.delete(lend);
    }
}
