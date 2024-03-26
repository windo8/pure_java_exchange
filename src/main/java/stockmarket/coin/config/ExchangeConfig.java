package stockmarket.coin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stockmarket.coin.controller.UserController;
import stockmarket.coin.repository.UserRepository;
import stockmarket.coin.repository.UserRepositoryImpl;
import stockmarket.coin.repository.WalletRepository;
import stockmarket.coin.repository.WalletRepositoryImpl;
import stockmarket.coin.service.UserService;
import stockmarket.coin.service.UserServiceImpl;
import stockmarket.coin.service.WalletService;
import stockmarket.coin.service.WalletServiceImpl;

@Configuration
public class ExchangeConfig {

    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public WalletService walletService() {
        return new WalletServiceImpl(walletRepository());
    }

    @Bean
    public WalletRepository walletRepository() {
        return new WalletRepositoryImpl();
    }
}
