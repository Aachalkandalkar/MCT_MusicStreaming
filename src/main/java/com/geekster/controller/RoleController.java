package com.geekster.controller;

import com.geekster.model.Role;
import com.geekster.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/addRole")
    public Role addRole(@Valid  @RequestBody Role role){
        return roleService.addROle(role);
    }
}
