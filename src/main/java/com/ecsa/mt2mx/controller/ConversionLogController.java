package com.ecsa.mt2mx.controller;

import com.ecsa.mt2mx.model.ConversionLog;
import com.ecsa.mt2mx.repository.ConversionLogRepository;

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
