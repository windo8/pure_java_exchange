package stockmarket.coin.repository;

import stockmarket.coin.dto.UserDTO;
import stockmarket.coin.dto.WalletDTO;

import java.util.List;

public interface UserRepository {
    void join(UserDTO userDTO);

    UserDTO findById(Long userId);

    List<UserDTO> findAll();

    void addWalletToUser(Long userId, WalletDTO walletDTO);

    List<WalletDTO> getUserWallets(Long userId);
}
