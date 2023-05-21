package com.geekster.controller;

import com.geekster.dto.UserDto;
import com.geekster.service.UsersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private UsersService usersService;


    @PostMapping("/addAdmin")
    public ResponseEntity<String> addAdmin(@Valid @RequestBody UserDto userDto){
        JSONObject response = usersService.addUser(userDto,"admin");
        if(response.has("errorMessage")){
            return new ResponseEntity<>(response.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);
    }



}
