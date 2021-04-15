package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Bill;

public interface IBillingDAO {
    void saveBilling(Bill bill);

    Bill getBill(int billId);
}
