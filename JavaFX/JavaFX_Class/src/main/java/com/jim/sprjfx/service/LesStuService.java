package com.jim.sprjfx.service;

import com.jim.sprjfx.entity.LesStu;
import com.jim.sprjfx.entity.Lesson;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月08日
 */

public interface LesStuService {
    public int insert(LesStu lesStu);
    public LesStu getByLesAndStu(LesStu lesStu);
    public int deleteLes(LesStu lesStu);
    public List<LesStu> selectByStuID(int id);
    public int deleteByLesid(int lesid);
}
