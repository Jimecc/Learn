package com.jim.sprjfx.service.Impl;

import com.jim.sprjfx.entity.LesStu;
import com.jim.sprjfx.entity.Lesson;
import com.jim.sprjfx.mapper.LesStuMapper;
import com.jim.sprjfx.service.LesStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月08日
 */

@Service
public class LesStuServiceImpl implements LesStuService {
    @Autowired
    LesStuMapper lesStuMapper;

    @Override
    public int insert(LesStu lesStu) {
        return lesStuMapper.insert(lesStu);
    }

    @Override
    public LesStu getByLesAndStu(LesStu lesStu) {
        return lesStuMapper.getByLesAndStu(lesStu);
    }

    @Override
    public int deleteLes(LesStu lesStu) {
        return lesStuMapper.deleteLes(lesStu);
    }

    @Override
    public List<LesStu> selectByStuID(int id) {
        return lesStuMapper.selectByStuID(id);
    }

    @Override
    public int deleteByLesid(int lesid) {
        return lesStuMapper.deleteByLesid(lesid);
    }
}
