package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.ApkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<ApkUser, Long> {

    ApkUser findUserByUsername(String username);
    ApkUser findUserByEmail(String email);
    ApkUser findApkUserById(Long id);

}
