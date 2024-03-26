package stockmarket.coin.service;

import stockmarket.coin.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    //회원가입
    void createUser(UserDTO userDTO);

    //로그인
    boolean login(List<UserDTO> userList, Map<String, String> userInput);

    //id로 유저 조회
    UserDTO findUser(Long userId);

    //전체 유저 조회
    List<UserDTO> findAllUser();
}
