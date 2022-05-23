package com.moneyware.application.service;

import com.moneyware.application.model.User;
import com.moneyware.application.repository.MWUserDBRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class MWUserStorageServiceTests {

    @Mock
    MWUserDBRepository userDBRepository;

    @InjectMocks
    MWUserStorageService userStorageService = new MWUserStorageServiceImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("test");
        user.setPassword("testPass");

        Mockito.when(userDBRepository.save(any(User.class))).thenReturn(user);
        User responseUser = userStorageService.saveUser(user);
        Assert.assertEquals( responseUser.getName(), user.getName());
    }
}
