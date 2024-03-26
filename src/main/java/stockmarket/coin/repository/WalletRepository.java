package stockmarket.coin.repository;

import stockmarket.coin.asset.Symbol;
import stockmarket.coin.dto.WalletDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface WalletRepository {
    void createWallet(WalletDTO walletDTO);

    WalletDTO getWallet(Long userId, Symbol currency);

    List<WalletDTO> getAllWallets(Long userId);

    void updateWallet(WalletDTO walletDTO);

    void deposit(Long userId, Symbol currency, double amount, LocalDateTime updatedAt);

    void withdraw(Long userId, Symbol currency, double amount, LocalDateTime updatedAt);
}
