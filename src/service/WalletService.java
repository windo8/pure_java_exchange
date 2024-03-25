package service;

import asset.Symbol;
import dto.WalletDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface WalletService {

    void createWallet(WalletDTO walletDTO);

    WalletDTO getWallet(Long walletId, Symbol currency);

    List<WalletDTO> getAllWallets();

    List<WalletDTO> getUserWallets(Long userId);

    void updateWallet(WalletDTO walletDTO);

    void deleteWallet(Long walletId);

    // 코인을 입금하여 사용자의 코인 지갑 잔고 업데이트
    void deposit(WalletDTO walletDTO, double amount);

    // 코인을 출금하여 사용자의 코인 지갑 잔고 업데이트
    void withdraw(WalletDTO walletDTO, double amount);
}
