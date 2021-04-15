package com.paymybuddy.p6.config;

import java.sql.Connection;

public class DataBasePreparing {
    DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();

    public void clearDataBaseEntries() {
        Connection connection = null;
        try {
            connection = dataBaseTestConfig.connect();
            connection.prepareStatement("Set foreign_key_checks =0;").execute();
            connection.prepareStatement("truncate table test.user;").execute();
            connection.prepareStatement("truncate table test.account;").execute();
            connection.prepareStatement("truncate table test.friend;").execute();
            connection.prepareStatement("truncate table test.transaction;").execute();
            connection.prepareStatement("set foreign_key_checks = 1;").execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
