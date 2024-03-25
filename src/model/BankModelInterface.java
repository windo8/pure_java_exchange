package model;

import dto.BankDTO;

public interface BankModelInterface {

    int depositAmount(BankDTO dto);

    int withdrawAmount(BankDTO dto);

    double amountInterest(int balance);
}
