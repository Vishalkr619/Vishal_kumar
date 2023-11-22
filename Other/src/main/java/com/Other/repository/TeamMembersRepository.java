package com.Other.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Other.model.TeamMembers;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {

}
