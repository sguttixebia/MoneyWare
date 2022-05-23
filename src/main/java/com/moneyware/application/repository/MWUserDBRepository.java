package com.moneyware.application.repository;

import com.moneyware.application.model.MWFileDB;
import com.moneyware.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWUserDBRepository extends JpaRepository<User, Integer> {

}
