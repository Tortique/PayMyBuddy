package com.paymybuddy.p6.config;

import java.sql.Connection;

public class DataBasePreparing {
    DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();

    public void clearDataBaseEntries() {
        Connection connection = null;
        try {
            connection = dataBaseTestConfig.connect();
            connection.prepareStatement("truncate table users").execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataBaseTestConfig.disconnect();
        }
    }

}
