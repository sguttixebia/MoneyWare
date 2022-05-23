package com.moneyware.application.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static com.moneyware.application.util.MWConstants.JWT_SECRET;
import static com.moneyware.application.util.MWConstants.JWT_USER;

@SpringBootTest
public class MWJwtUserDetailsServiceTests {


    @Test
    public void testLoadUserByUsername() {
        UserDetailsService userDetailsService = new MWJwtUserDetailsService();
        UserDetails userDetails =  userDetailsService.loadUserByUsername(JWT_USER);

        Assert.assertEquals(userDetails.getPassword() , JWT_SECRET);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByInvalidUsername() {
        UserDetailsService userDetailsService = new MWJwtUserDetailsService();
        userDetailsService.loadUserByUsername("Invalid UserName");
    }
}
