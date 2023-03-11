package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.Lend;

import java.util.List;

/**
 * @author zzy
 * @Description
 * @createTime 2022年12月11日
 */
public interface LendService {

    List<Lend> getLendsLikeName(String name);

    int insert(Lend lend);

    // 0 失败 1成功
    // 2 字段不完整 3.没结果这本书
    int delete(String uname, String bname);
}
