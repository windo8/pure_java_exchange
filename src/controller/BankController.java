package controller;

import config.AppConfig;
import dto.BankDTO;
import model.MemoryBankModel;
import service.BankService;
import service.BankSeviceInteface;
import view.BankView;

import java.util.Scanner;

public class BankController {

    public void bankingStart() {
        Scanner sc = new Scanner(System.in);

        AppConfig appConfig = new AppConfig();
        BankSeviceInteface service = appConfig.bankSeviceInteface();
        BankView view = new BankView();

        BankDTO bankBook = new BankDTO();

        while (true) {
            view.printStart(); //시작 문구
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    view.printDeposit();

                    BankDTO dto1 = service.deposit(bankBook);
                    bankBook.setBalance(bankBook.getBalance() + dto1.getBalance());

                    view.printAmount(bankBook.getBalance());
                    break;

                case 2:
                    view.printWithdraw();

                    BankDTO dto2 = service.withdraw(bankBook);
                    bankBook.setBalance(dto2.getBalance());

                    view.printAmount(bankBook.getBalance());
                    break;

                case 3:
                    view.printAmount(bankBook.getBalance());
                    break;

                case 4:
                    double interest = service.interest(bankBook.getBalance());
                    view.prinInterest(interest);
                    break;

                case 5:
                    view.printEnd();
                    return;

                default:
                    view.printError();
            }
        }
    }
}
