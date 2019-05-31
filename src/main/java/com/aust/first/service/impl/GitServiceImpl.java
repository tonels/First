package com.aust.first.service.impl;

import com.aust.first.service.GitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GitServiceImpl implements GitService {
    @Override
    public String g1() {
        return "GIT hello";
    }

    @Override
    public String g2() {
        return "git 2";
    }

    @Override
    public String g33() {
        return null;
    }

    @Override
    public String g3() {
        return "GIT";
    }
}
