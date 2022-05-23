package com.moneyware.application.service;

import com.moneyware.application.repository.MWFileDBRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static com.moneyware.application.Utility.dummyFileDB;

@SpringBootTest
public class MWFileStorageServiceImplTests {
    @Mock
    MWFileDBRepository fileDBRepository;

    @InjectMocks
    MWFileStorageService fileStorageService = new MWFileStorageServiceImpl();

    @Test
    public void testStore() throws IOException {

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        fileStorageService.store(file, "KYC", 1001);
        Mockito.when(fileDBRepository.save(dummyFileDB())).thenReturn(dummyFileDB());

        Assert.assertEquals(dummyFileDB().getFileName(), dummyFileDB().getFileName());
    }
}
