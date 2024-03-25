package config;

import controller.BankController;
import model.BankModelInterface;
import model.MemoryBankModel;
import service.BankService;
import service.BankSeviceInteface;

public class AppConfig {

    public BankSeviceInteface bankSeviceInteface() {
        return new BankService(bankInterface());
    }

    public BankModelInterface bankInterface() {
        return new MemoryBankModel();
    }
}
