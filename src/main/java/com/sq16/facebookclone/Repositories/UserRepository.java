package com.sq16.facebookclone.Repositories;

import com.sq16.facebookclone.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail (String email);
}
