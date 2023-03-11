package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * SprJfx-master  com.jim.sprjfx.entity
 * Anan
 *
 * @author an
 * description : 不可描述
 * @date 2022/11/19 15:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String name;
    private String type;
    private String press;
    private int price;
    private int max; // 最大数量
    private int num;
    private String author;
    private String info;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", press='" + press + '\'' +
                ", price=" + price +
                ", max=" + max +
                ", num=" + num +
                ", author='" + author + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
