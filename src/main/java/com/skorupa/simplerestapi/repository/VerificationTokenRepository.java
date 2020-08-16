package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}
