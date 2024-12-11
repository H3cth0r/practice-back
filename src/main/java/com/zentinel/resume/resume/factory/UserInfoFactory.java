package com.zentinel.resume.resume.factory;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.zentinel.resume.resume.model.UserInfo;
import com.zentinel.resume.resume.dto.CreateUserInfoDto;
import com.zentinel.resume.resume.repository.UserInfoRepository;

@Component
public class UserInfoFactory {
    @Autowired 
    UserInfoRepository userInfoRepository;

    public UserInfo createUserInfoFromCreateUserInfoDto(CreateUserInfoDto createUserInfoDto) {
        UserInfo userInfo = new UserInfo();

        userInfo.setName(createUserInfoDto.getName());
        userInfo.setActive(createUserInfoDto.getActive());
        userInfo.setEmail(createUserInfoDto.getEmail());
        userInfo.setSecondEmail(createUserInfoDto.getSecondEmail());

        return userInfo;
    }
}
