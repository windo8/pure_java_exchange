package service;

import dto.UserDTO;
import model.UserRepository;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{

    private final UserRepository memoryTradeRepository;

    public UserServiceImpl(UserRepository memoryTradeRepository) {
        this.memoryTradeRepository = memoryTradeRepository;
    }

    @Override //회원가입
    public void createUser(UserDTO userDTO) {
        memoryTradeRepository.join(userDTO);
    }

    @Override //로그인
    public boolean login(List<UserDTO> userList, Map<String, String> userInput) {
        // 입력된 사용자 이름과 비밀번호가 저장된 사용자 이름과 비밀번호와 일치하는지 확인
        for (UserDTO userDTO : userList) {
            if (userDTO.getUserName().equals(userInput.get("name")) && userDTO.getUserPassword().equals(userInput.get("ps"))) {
                return true; //로그인 성공
            }
        }
        return false; // 로그인 실패
    }

    @Override //id로 유저 조회
    public UserDTO findUser(Long userId) {
        return memoryTradeRepository.findById(userId);
    }

    @Override //전체 유저 조회
    public List<UserDTO> findAllUser() {
        return memoryTradeRepository.findAll();
    }
}
