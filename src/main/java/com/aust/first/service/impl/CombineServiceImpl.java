package com.aust.first.service.impl;

import com.aust.first.repository.CombineRepository;
import com.aust.first.service.CombineService;
import com.aust.first.vo.Com1Vo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CombineServiceImpl implements CombineService {

    @Resource
    private CombineRepository combineRepository;

    @Override
    public List<Com1Vo> getCom1Vo() {
        return combineRepository.getCom1Vo();
    }
}
