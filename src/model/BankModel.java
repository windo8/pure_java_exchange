package model;

public class BankModel {
    public int depositAmount(int balance, int amount) { //입금
        balance += amount;
        return balance;
    }

    public int withdrawAmount(int balance, int amount) { //출금
        balance -= amount;
        return balance;
    }

    public double amountInterest(int balance) { //이자율 체크
        double rate = 0.05; // 연이자율 (5%)
        int years = 1; // 기간 (1년)

        // 이자 계산 공식 적용
        return (double) balance * Math.pow((1 + rate), years);

    }
}
