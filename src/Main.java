import controller.BankController;

public class Main {
    public static void main(String[] args) {
        BankController controller = new BankController();

        System.out.println("1.Bank | 2.bbb | 3.ccc");
        int userChoise = 1;
        System.out.println("choose menu : " + userChoise);
        switch (userChoise){
            case 1:
                controller.bankingStart();
                break;

            case 2:
                break;

            case 3:
                break;
        }
    }
}

