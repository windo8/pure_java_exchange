package model;

import asset.Symbol;
import dto.WalletDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface WalletRepository {

    // 사용자의 코인 지갑 생성
    void createWallet(WalletDTO walletDTO);

    // 사용자의 코인 지갑 조회
    WalletDTO getWallet(Long userId, Symbol currency);

    // 사용자의 모든 코인 지갑 조회
    List<WalletDTO> getAllWallets(Long userId);

    // 사용자의 코인 지갑 정보 업데이트
    void updateWallet(WalletDTO wallet);

    // 코인을 입금하여 사용자의 코인 지갑 잔고 업데이트
    void deposit(Long userId, Symbol currency, double amount, LocalDateTime updatedAt);

    // 코인을 출금하여 사용자의 코인 지갑 잔고 업데이트
    void withdraw(Long userId, Symbol currency, double amount, LocalDateTime updatedAt);
}
