package com.abc_telecom_Ltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc_telecom_Ltd.entity.Engineer;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {

}
