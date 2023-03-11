package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.LesStu;
import com.jim.sprjfx.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月08日
 */
@Mapper
public interface LesStuMapper {
    int insert(LesStu lesStuu);
    LesStu getByLesAndStu(LesStu lesStu);
    int deleteLes(LesStu lesStu);
    List<LesStu> selectByStuID(int id);
    int deleteByLesid(int lesid);
}
