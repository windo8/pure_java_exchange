package stockmarket.coin.service;

import stockmarket.coin.asset.Symbol;
import stockmarket.coin.dto.WalletDTO;
import stockmarket.coin.repository.WalletRepository;

import java.time.LocalDateTime;
import java.util.List;

public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void createWallet(WalletDTO walletDTO) {
        walletRepository.createWallet(walletDTO);
    }

    @Override
    public WalletDTO getWallet(Long walletId, Symbol currency) {
        return walletRepository.getWallet(walletId, currency);
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        return null;
    }

    @Override
    public List<WalletDTO> getUserWallets(Long userId) {
        return walletRepository.getAllWallets(userId);
    }

    @Override
    public void updateWallet(WalletDTO walletDTO) {
        walletRepository.updateWallet(walletDTO);
    }

    @Override
    public void deleteWallet(Long walletId) {

    }

    @Override
    public void deposit(WalletDTO walletDTO, double amount) {
        // 현재 잔고에 입금 금액 추가
        double newBalance = walletDTO.getBalance() + amount;
        walletDTO.setBalance(newBalance);
        // 업데이트된 지갑 정보 저장
        walletRepository.updateWallet(walletDTO);
    }

    @Override
    public void withdraw(WalletDTO walletDTO, double amount) {
        // 출금 금액이 현재 잔고보다 작은지 확인
        if (amount <= walletDTO.getBalance()) {
            // 출금 금액을 현재 잔고에서 차감
            double newBalance = walletDTO.getBalance() - amount;
            walletDTO.setBalance(newBalance);
            // 업데이트된 지갑 정보 저장
            walletRepository.updateWallet(walletDTO);
        } else {
            throw new IllegalArgumentException("출금 금액이 잔고보다 큽니다.");
        }
    }
}
