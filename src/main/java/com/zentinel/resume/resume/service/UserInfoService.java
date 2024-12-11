package com.zentinel.resume.resume.service;

import com.zentinel.resume.resume.repository.UserInfoRepository;
import com.zentinel.resume.resume.model.UserInfo;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    /*
     *  This method retrives a UserInfo object by itst id from the database
     * */
    public UserInfo findByIdAndActive(Integer id) throws Exception {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByIdAndActive(id);
        if (optionalUserInfo.isPresent()) return optionalUserInfo.get();
        else throw new Exception("Driving test with id " + id + " doesn't exists");
    }
}
