package com.moneyware.application.service;

import com.moneyware.application.model.MWFileDB;
import com.moneyware.application.repository.MWFileDBRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.moneyware.application.util.MWConstants.COMPLETED_STATUS;

@Service
public class MWFileStorageServiceImpl implements MWFileStorageService{
  @Autowired
  private MWFileDBRepository fileDBRepository;

   public MWFileDB store(@NonNull MultipartFile file, String documentType, int customerId) throws IOException {
     String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    MWFileDB fileDB = new MWFileDB(fileName, file.getSize(), new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
            customerId, documentType, COMPLETED_STATUS, file.getBytes());


    return fileDBRepository.save(fileDB);
  }
}
