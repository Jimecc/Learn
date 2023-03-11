package com.jim.sprjfx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 * @Description
 * @createTime 2022年12月11日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lend {

    private int id;
    private String uname; // 借阅人名称
    private String bname; // 书本名称

    public Lend(String uname, String bname) {
        this.uname = uname;
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }

}
