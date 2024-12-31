package com.songpro.spring_junit_mokito_back.repository.user;

import com.songpro.spring_junit_mokito_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>, UserCustom {
    User findByUserIdAndUserPwd(String userId, String userPwd);
}
