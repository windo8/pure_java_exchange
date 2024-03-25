import asset.Symbol;
import config.TradConfig;
import dto.UserDTO;
import dto.WalletDTO;
import service.UserService;
import service.WalletService;

import java.time.LocalDateTime;
import java.util.*;

public class TradApp {
    public static void main(String[] args) {
        // 사용자 서비스와 지갑 서비스 생성
        TradConfig tradConfig = new TradConfig();
        UserService userService = tradConfig.userService();
        WalletService walletService = tradConfig.walletService();

        // 사용자 생성
        UserDTO user = new UserDTO(1L, "JohnDoe", "john@example.com", "1234", new ArrayList<>());
        userService.createUser(user);

        // 사용자 리스트
        List<UserDTO> userList = userService.findAllUser();


        // 사용자 로그인
        Map<String, String> userInput = new HashMap<>();
        userInput.put("name", "JohnDoe");
        userInput.put("ps", "1234");

        // 로그인 검증
        boolean success = userService.login(userList, userInput);
        if (success) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        // 코인 지갑 생성 및 사용자에게 추가
        WalletDTO btcWallet = new WalletDTO(user.getUserId(), Symbol.BTC, 0, LocalDateTime.now(), null);
        WalletDTO ethWallet = new WalletDTO(user.getUserId(), Symbol.ETH, 0, LocalDateTime.now(), null);
        WalletDTO xrpWallet = new WalletDTO(user.getUserId(), Symbol.XRP, 0, LocalDateTime.now(), null);
        walletService.createWallet(btcWallet);
        walletService.createWallet(ethWallet);
        walletService.createWallet(xrpWallet);

        // 사용자의 지갑 목록 조회
        List<WalletDTO> userWallets = walletService.getUserWallets(user.getUserId());
        System.out.println("User Wallets:");
        for (WalletDTO wallet : userWallets) {
            System.out.println(wallet.getCurrency().name() + ": " + wallet.getBalance());
        }

        // BTC를 지갑에 입금
        double depositAmount = 1.5; // 입금할 BTC 양
        walletService.deposit(btcWallet, depositAmount);
        System.out.println("Deposit completed. BTC balance: " + btcWallet.getBalance());

        // BTC를 지갑에서 출금
        double withdrawalAmount = 0.5; // 출금할 ETH 양
        walletService.withdraw(btcWallet, withdrawalAmount);
        System.out.println("Withdrawal completed. BTC balance: " + btcWallet.getBalance());
    }
}
