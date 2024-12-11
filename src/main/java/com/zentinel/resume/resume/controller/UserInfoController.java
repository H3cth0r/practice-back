package com.zentinel.resume.resume.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

import com.zentinel.resume.resume.model.UserInfo;
import com.zentinel.resume.resume.service.UserInfoService;
import com.zentinel.resume.resume.dto.CreateUserInfoDto;

@RestController
@RequestMapping(path="/v1/user-info")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping(path="/user-info-by-id")
    public ResponseEntity<?> getUserInfoById(@RequestParam Long id, Principal principal) {
        UserInfo userInfo;
        try {
            userInfo = userInfoService.findByIdAndActive(id);
        } catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @GetMapping(path="/user-info-by-email")
    public ResponseEntity<?> getUserInfoByEmail(@RequestParam String email, Principal principal) {
        UserInfo userInfo;
        try {
            userInfo = userInfoService.findByEmailAndActive(email);
        } catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PostMapping(path="/create")
    public ResponseEntity<?> createUserInfo(@RequestBody CreateUserInfoDto createUserInfoDto, Principal principal) {
        Boolean created;
        try {
            created = userInfoService.createUserInfo(createUserInfoDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.OK);
    }
}
