package com.moneyware.application;

import com.moneyware.application.model.MWFileDB;

import java.util.Date;

public class Utility {

    public static MWFileDB dummyFileDB() {
        return new MWFileDB("hello.txt", 10000, new Date().toString(), 1001, "KYC", "C", "".getBytes());
    }
}
