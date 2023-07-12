package com.sample.app1.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private RoleRepo repo;

    public Role createNewRole(Role role) {
        return repo.save(role);
    }
}
