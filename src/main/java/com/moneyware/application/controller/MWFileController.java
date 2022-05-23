package com.moneyware.application.controller;

import com.moneyware.application.message.MWResponseMessage;
import com.moneyware.application.model.MWFileDB;
import com.moneyware.application.service.MWFileStorageService;
import com.moneyware.application.upload.MWUploadMessagingGateway;
import com.moneyware.application.util.MWFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static com.moneyware.application.util.MWConstants.FILE_UPLOAD_ERROR_MESSAGE;
import static com.moneyware.application.util.MWConstants.FILE_UPLOAD_SUCCESS_MESSAGE;

@RestController
@RequestMapping("/file")
@CrossOrigin()
public class MWFileController {
    @Autowired
    private MWFileStorageService fileStorageService;
    @Autowired
    private MWUploadMessagingGateway gateway;

    @PostMapping(value = "/upload")
    public ResponseEntity<MWResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("type") String documentType,
                                                      @RequestParam("customerId") int customerId) {
        String message = "";
        try {
            MWFileDB fileDB = fileStorageService.store(file, documentType, customerId);

            message = FILE_UPLOAD_SUCCESS_MESSAGE + file.getOriginalFilename();
            File uploadFile = MWFileUtils.generateIndexFile(fileDB);
            gateway.uploadFile(uploadFile);

            return ResponseEntity.status(HttpStatus.OK).body(new MWResponseMessage(message));
        } catch (Exception e) {
            message = FILE_UPLOAD_ERROR_MESSAGE + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MWResponseMessage(message));
        }
    }
}
