package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.Lend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zzy
 * @Description
 * @createTime 2022年12月11日
 */
@Mapper
public interface LendMapper {

    List<Lend> getLendLikeName(String name);
    int insert(Lend lend);
    Lend getBuUNameAndBname(Lend lend);
    int delete(Lend lend);
}
