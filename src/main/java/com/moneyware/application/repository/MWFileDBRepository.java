package com.moneyware.application.repository;

import com.moneyware.application.model.MWFileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWFileDBRepository extends JpaRepository<MWFileDB, String> {

}
