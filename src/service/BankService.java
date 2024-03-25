package service;

import dto.BankDTO;
import model.BankModelInterface;

import java.util.Scanner;

public class BankService implements BankSeviceInteface{
    Scanner sc = new Scanner(System.in);

    private final BankModelInterface bankModelInterface;

    public BankService(BankModelInterface bankModelInterface) {
        this.bankModelInterface = bankModelInterface;
    }

    @Override
    public BankDTO deposit(BankDTO dto) {
        BankDTO dto1 = new BankDTO();

        dto1.setAmount(sc.nextInt());
        dto1.setBalance(bankModelInterface.depositAmount(dto1));

        return dto1;
    }

    @Override
    public BankDTO withdraw(BankDTO dto) {
        BankDTO dto1 = new BankDTO();

        dto1.setBalance(dto.getBalance());
        dto1.setAmount(sc.nextInt());

        if (dto.getBalance() >= dto1.getAmount()) {
            dto1.setBalance(bankModelInterface.withdrawAmount(dto1));
        } else {
            System.out.println("금액을 초과했습니다.");
        }

        return dto1;
    }

    @Override
    public double interest(int balance) {
       double interest = bankModelInterface.amountInterest(balance);
        return interest;
    }
}
