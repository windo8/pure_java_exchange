package service;

import dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {

    void createUser(UserDTO userDTO);

    boolean login(List<UserDTO> userList, Map<String, String> userInput);

    UserDTO findUser(Long userId);

    List<UserDTO> findAllUser();
}
