package com.Proposals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proposals.model.Proposals;

@Repository
public interface ProposalsRepository extends JpaRepository<Proposals, Integer> {

}
