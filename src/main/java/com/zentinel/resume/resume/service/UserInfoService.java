package com.zentinel.resume.resume.service;

import com.zentinel.resume.resume.repository.UserInfoRepository;
import com.zentinel.resume.resume.model.UserInfo;
import com.zentinel.resume.resume.dto.CreateUserInfoDto;
import com.zentinel.resume.resume.factory.UserInfoFactory;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserInfoFactory userInfoFactory;


    /*
     *  This method retrives a UserInfo object by itst id from the database
     * */
    public UserInfo findByIdAndActive(Long id) throws Exception {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByIdAndActive(id, true);
        if (optionalUserInfo.isPresent()) return optionalUserInfo.get();
        else throw new Exception("Driving test with id " + id + " doesn't exists");
    }

    public UserInfo findByEmailAndActive(String email) throws Exception {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByEmailAndActive(email, true);
        if (optionalUserInfo.isPresent()) return optionalUserInfo.get();
        else throw new Exception("Driving test with email " + email + " doesn't exists");
    }

    public Boolean createUserInfo(CreateUserInfoDto createUserInfoDto) throws Exception {
        UserInfo userInfo = userInfoFactory.createUserInfoFromCreateUserInfoDto(createUserInfoDto);
        userInfoRepository.save(userInfo);
        return true;
    }
}
