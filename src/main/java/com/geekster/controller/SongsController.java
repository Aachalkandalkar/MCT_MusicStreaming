package com.geekster.controller;

import com.geekster.dto.SongDto;
import com.geekster.service.SongService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/song")
public class SongsController {

    @Autowired
    private SongService songService;

    @PostMapping("/addSong")
    public ResponseEntity<String> addSong(@Valid @RequestBody SongDto songDto,
                                          @NotBlank @RequestParam("userName") String userName,
                                          @NotBlank @RequestParam("password") String password){
        JSONObject songStatus = songService.addSong(songDto, userName, password);
        if(songStatus.has("errormessage")){
             return new ResponseEntity<>(songStatus.toString(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(songStatus.toString(), HttpStatus.CREATED);
    }

    @PutMapping("/updateSong")
    public ResponseEntity<String> updateSing(@Valid @RequestBody SongDto songDto,
                                          @NotBlank @RequestParam("songId") Integer songId,
                                          @NotBlank @RequestParam("userName") String userName,
                                          @NotBlank @RequestParam("password") String password){
        JSONObject songStatus = songService.updateSong(songDto, userName, password, songId);
        if(songStatus.has("errormessage")){
            return new ResponseEntity<>(songStatus.toString(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(songStatus.toString(), HttpStatus.CREATED);
    }

    @PutMapping("/deleteSong")
    public ResponseEntity<String> deleteSong(@Valid @RequestBody SongDto songDto,
                                             @NotBlank @RequestParam("songId") Integer songId,
                                             @NotBlank @RequestParam("userName") String userName,
                                             @NotBlank @RequestParam("password") String password){
        JSONObject songStatus = songService.deleteSong(userName, password, songId);
        if(songStatus.has("errormessage")){
            return new ResponseEntity<>(songStatus.toString(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(songStatus.toString(), HttpStatus.CREATED);
    }


}
