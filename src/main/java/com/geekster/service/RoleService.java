package com.geekster.service;

import com.geekster.interfaces.IRoleServiceInterface;
import com.geekster.model.Role;
import com.geekster.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleServiceInterface {
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public Role addROle(Role role) {
        return iRoleRepository.save(role);
    }
}
