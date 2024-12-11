package com.zentinel.resume.resume.repository;

import com.zentinel.resume.resume.model.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{

    public Optional<UserInfo> findByIdAndActive(Long id, Boolean active);
    public Optional<UserInfo> findByEmailAndActive(String email, Boolean active);

}
