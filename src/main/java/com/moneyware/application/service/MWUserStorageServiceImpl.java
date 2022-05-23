package com.moneyware.application.service;

import com.moneyware.application.model.User;
import com.moneyware.application.repository.MWUserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MWUserStorageServiceImpl implements MWUserStorageService {

    @Autowired
    MWUserDBRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }
}
