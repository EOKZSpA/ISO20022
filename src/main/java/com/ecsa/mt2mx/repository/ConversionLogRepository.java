package com.ecsa.mt2mx.repository;

import com.ecsa.mt2mx.model.ConversionLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionLogRepository extends JpaRepository<ConversionLog, Long> {

}
