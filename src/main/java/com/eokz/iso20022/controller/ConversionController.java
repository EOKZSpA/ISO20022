package com.eokz.iso20022.controller;

import com.eokz.iso20022.service.ConversionLogService;
import com.eokz.iso20022.service.MtToMxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/convert")
public class ConversionController {
    @Autowired
    private MtToMxService mtToMxService;

    @Autowired
    private ConversionLogService logService;

    @PostMapping("/mt2mx")
    public ResponseEntity<?> convertMtToMx(@RequestBody Map<String, String> payload) {
        String fileName = payload.get("filename");
        if (fileName == null || fileName.isBlank()) {
            return ResponseEntity.badRequest().body("El nombre del archivo es requerido");
        }
        if (mtToMxService.isInputFolderEmpty()) {
            return ResponseEntity.ok("Carpeta MT = > MX vacia");
        }
        var xmlOptional = mtToMxService.convert(fileName);
        if (xmlOptional.isEmpty()) {
            logService.saveLog(fileName, "Error: Archivo no encontrado o falla de conversion.");
            return ResponseEntity.status(404).body("Archivo no encontrado o error en la conversion.");
        }

        String xml = xmlOptional.get();

        logService.saveLog(fileName, "Conversion exitosa a MX");

        Map<String, Object> response = new HashMap<>();
        response.put("status", "sucess");
        response.put("convertedXml", xml);
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}
