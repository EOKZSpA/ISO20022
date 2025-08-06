package com.eokz.iso20022.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import java.util.Optional;

@Service
public class MtToMxService {
    @Value("${converter.input-folder}")
    private String inputFolder;

    @Value("${converter.output-folder}")
    private String outputFolder;

    public Optional<String> convert(String fileName) {
        File file = new File(inputFolder, fileName);
        if (!file.exists()) {
            return Optional.empty();
        }
        try {
            String mtContent = Files.readString(file.toPath());

            String xml = """
                    <Document xmlns="urn:iso:std:iso:20022:tech:xsd:pacs.008.001.09">
                        <FIToFICstmrCdtTrf> 
                            <GrpHdr>
                                <MsgId>SIMULTAED-%s</MsgId>
                            </GrpHrd>
                            <CdtTrfTxInf>
                                <PmtId>
                                    <InstrId>MT2MX</InstrId>
                                </PmtId>
                                <Amt>
                                    <InstAmt Ccy="USD">1000</InstAmt>
                                </Amt>
                            </CdtTrfTxInf>
                        </FIToFICstmrCdtTrf>
                    </Document>
                    """.formatted(fileName.replaceAll("\\..+$", ""));

            File output = new File(outputFolder, fileName.replaceAll("\\..+$", "") + ".xml");
            Files.writeString(output.toPath(), xml);

            return Optional.of(xml);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public boolean isInputFolderEmpty() {
        File folder = new File(inputFolder);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt") || name.startsWith("MT"));

        return files == null || files.length == 0;
    }
}
