package com.productservice.productservice.inheritancerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("j_mentorrepo")
public interface MentorRepository extends JpaRepository<Mentor, UUID> {
}