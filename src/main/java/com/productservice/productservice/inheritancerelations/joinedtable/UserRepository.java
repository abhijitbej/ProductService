package com.productservice.productservice.inheritancerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("j_userrepo")
public interface UserRepository extends JpaRepository<User, UUID> {
}