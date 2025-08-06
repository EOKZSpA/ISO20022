package com.eokz.iso20022.controller;

import com.eokz.iso20022.model.ConversionLog;
import com.eokz.iso20022.repository.ConversionLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ConversionLogController {
    @Autowired
    private ConversionLogRepository repository;

    @GetMapping
    public List<ConversionLog> getAllLogs() {
        return repository.findAll();
    }
}
