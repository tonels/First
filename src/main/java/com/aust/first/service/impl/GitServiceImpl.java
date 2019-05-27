package com.aust.first.service.impl;

import com.aust.first.service.GitService;

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
    public String g3() {
        return "GIT";
    }
}
