package com.skorupa.simplerestapi.repository;

import com.skorupa.simplerestapi.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken,Long> {
    List<VerificationToken> findByUnverifiedUserEmail(String email);
    List<VerificationToken> findByToken(String token);
}
