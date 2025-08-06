package com.eokz.iso20022.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "conversion_logs")
public class ConversionLog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private LocalDateTime timestamp;

    @Column(columnDefinition = "TEXT")
    private String logMessage;

    public ConversionLog() {}

    public ConversionLog(String fileName, String logMessage) {
        this.fileName = fileName;
        this.logMessage = logMessage;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}
