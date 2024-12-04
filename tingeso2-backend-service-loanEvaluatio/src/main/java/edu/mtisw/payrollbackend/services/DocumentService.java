package edu.mtisw.payrollbackend.services;

import edu.mtisw.payrollbackend.entities.DocumentEntity;
import edu.mtisw.payrollbackend.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public DocumentEntity getDocumentByLoanRequestId(Long loanRequestId, String type) throws FileNotFoundException {
        DocumentEntity documentEntity = documentRepository.findByLoanRequestIdAndType(loanRequestId, type);
        if (documentEntity != null) {
            return documentEntity;
        }
        throw new FileNotFoundException("Document not found for the provided loanRequestId and type.");
    }

}
