package com.moneyware.application.service;

import com.moneyware.application.model.MWFileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MWFileStorageService {
    public MWFileDB store(MultipartFile file, String documentType, int customerId) throws IOException;
}
