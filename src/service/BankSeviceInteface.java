package service;

import dto.BankDTO;

public interface BankSeviceInteface {

    BankDTO deposit(BankDTO dto);

    BankDTO withdraw(BankDTO dto);

    double interest(int balance);
}
