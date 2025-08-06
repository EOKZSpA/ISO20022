package com.ecsa.mt2mx.service;

import com.ecsa.mt2mx.model.ConversionLog;
import com.ecsa.mt2mx.repository.ConversionLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionLogService {
    private final ConversionLogRepository logRepository;

    @Autowired
    public ConversionLogService(ConversionLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(String fileName, String message) {
        ConversionLog log = new ConversionLog(fileName, message);
        logRepository.save(log);
    }
}
