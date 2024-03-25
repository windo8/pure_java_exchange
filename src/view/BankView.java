package view;

public class BankView {
    public void printStart() {
        System.out.println("1.deposit | 2.withdraw | 3.overview | 4.interest | 5.END");
        System.out.print("choise menu : ");
    }

    public void printDeposit() {
        System.out.print("입금할 금액을 입력하세요 : ");
    }

    public void printWithdraw() {
        System.out.print("출금할 금액을 입력하세요 : ");
    }

    public void printAmount(int balance) {
        System.out.println("현재 잔고 : " + balance + "원 입니다.");
    }

    public void prinInterest(double interest) {
        System.out.println("연 이자율 : " + interest + "원 입니다.");
    }

    public void printError() {
        System.out.println("*잘못된 접근입니다*");
    }

    public void printEnd() {
        System.out.println("= END =");
    }
}
