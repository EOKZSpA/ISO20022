package com.eokz.iso20022.repository;

import com.eokz.iso20022.model.ConversionLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionLogRepository extends JpaRepository<ConversionLog, Long> {

}
