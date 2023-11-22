package com.Proposals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proposals.model.Templates;

@Repository
public interface TemplatesRepository extends JpaRepository<Templates, Integer> {

}
