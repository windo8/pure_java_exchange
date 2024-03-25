package config;

import model.MemoryWalletRepositoryImpl;
import model.UserRepository;
import model.MemoryUserRepositoryImpl;
import model.WalletRepository;
import service.UserService;
import service.UserServiceImpl;
import service.WalletService;
import service.WalletServiceImpl;

public class TradConfig {

    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    public UserRepository userRepository() {
        return new MemoryUserRepositoryImpl();
    }

    public WalletService walletService() {
        return new WalletServiceImpl(walletRepository());
    }

    public WalletRepository walletRepository() {
        return new MemoryWalletRepositoryImpl();
    }

}
