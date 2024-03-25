package model;

import asset.Symbol;
import dto.WalletDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryWalletRepositoryImpl implements WalletRepository{

    private static final Map<String, WalletDTO> wallets = new HashMap<>();
    /*
    * key: userid + Symbol.name() => 회원 각자의 고유 지갑
    * value: walletDTO
    */


    @Override
    public void createWallet(WalletDTO walletDTO) {
        wallets.put(walletDTO.getCurrency().name(), walletDTO);
    }

    @Override
    public WalletDTO getWallet(Long userId, Symbol currency) {
        return wallets.get(userId + currency.name()); //사용자의 고유 지갑 식별하기위한 로
    }

    @Override
    public List<WalletDTO> getAllWallets(Long userId) {
        List<WalletDTO> userWallet = new ArrayList<>();

        for (WalletDTO wallet : wallets.values()) {
            if (wallet.getUserId().equals(userId)) { //현재 user의 모든 지갑을 가져옴
                userWallet.add(wallet);
            }
        }
        return userWallet;
    }

    @Override
    public void updateWallet(WalletDTO walletDTO) {
        wallets.put(walletDTO.getUserId() + walletDTO.getCurrency().name(), walletDTO); //업데이트에 새로운 시선
    }

    @Override
    public void deposit(Long userId, Symbol currency, double amount, LocalDateTime updatedAt) {
        WalletDTO wallet = wallets.get(userId + currency.name()); //user 본인의 지갑

        if (wallet != null) { //존재하면
            double newBalance = wallet.getBalance() + amount;
            wallet.setBalance(newBalance);
            wallet.setUpdatedAt(updatedAt);
            updateWallet(wallet);
        }
    }

    @Override
    public void withdraw(Long userId, Symbol currency, double amount, LocalDateTime updatedAt) {
        WalletDTO wallet = wallets.get(userId + currency.name()); //user 본인의 지갑

        if (wallet != null) { //존재하면
            double newBalance = wallet.getBalance() - amount;
            wallet.setBalance(newBalance);
            wallet.setUpdatedAt(updatedAt);
            updateWallet(wallet);
        }
    }
}
