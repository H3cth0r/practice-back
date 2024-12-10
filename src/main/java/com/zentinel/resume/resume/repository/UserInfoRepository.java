package com.zentinel.resume.resume.repository;

import com.zentinel.resume.resume.model.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{

    public UserInfo findByIdAndActive(Long id, Boolean active);

}
