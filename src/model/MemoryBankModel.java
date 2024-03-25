package model;

import dto.BankDTO;

public class MemoryBankModel implements BankModelInterface {

    @Override
    public int depositAmount(BankDTO dto) {
        return dto.getBalance() + dto.getAmount();

    }

    @Override
    public int withdrawAmount(BankDTO dto) {
        return dto.getBalance() - dto.getAmount();
    }

    @Override
    public double amountInterest(int balance) {
        double rate = 0.05; // 연이자율 (5%)
        int years = 1; // 기간 (1년)

        // 이자 계산 공식 적용
        return (double) balance * Math.pow((1 + rate), years);
    }
}
