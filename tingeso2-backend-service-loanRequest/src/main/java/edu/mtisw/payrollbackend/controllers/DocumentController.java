package edu.mtisw.payrollbackend.controllers;

import edu.mtisw.payrollbackend.entities.DocumentEntity;
import edu.mtisw.payrollbackend.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/documents")
//@CrossOrigin("*")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<DocumentEntity> saveDocument(@RequestParam("file") MultipartFile file,
                                                       @RequestParam("loanRequestId") Long loanRequestId,
                                                       @RequestParam("type") String type) throws IOException {
        DocumentEntity documentNew = documentService.saveDocument(file, loanRequestId, type);
        return ResponseEntity.status(HttpStatus.OK).body(documentNew);
    }

}
