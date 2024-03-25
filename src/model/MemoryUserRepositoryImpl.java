package model;

import dto.UserDTO;
import dto.WalletDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepositoryImpl implements UserRepository {

    private static final Map<Long, UserDTO> users = new HashMap<>();

    @Override
    public void join(UserDTO userDTO) {
        users.put(userDTO.getUserId(), userDTO);
    }

    @Override
    public UserDTO findById(Long userId) {
        return users.get(userId);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (Long key : users.keySet()) {
            userDTOS.add(users.get(key));
        }
        return userDTOS;
//        return new ArrayList<>(userInfo.values());
    }

    @Override
    public void addWalletToUser(Long userId, WalletDTO walletDTO) {
        walletDTO.setUserId(userId);
    }

    @Override
    public List<WalletDTO> getUserWallets(Long userId) {
        return null;
    }
}
