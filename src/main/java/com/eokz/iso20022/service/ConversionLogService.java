package com.eokz.iso20022.service;

import com.eokz.iso20022.model.ConversionLog;
import com.eokz.iso20022.repository.ConversionLogRepository;

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
