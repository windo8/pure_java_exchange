package stockmarket.coin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stockmarket.coin.dto.UserDTO;
import stockmarket.coin.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-new-user")
    public String registerUser(@ModelAttribute UserDTO userDTO) {
        userService.createUser(userDTO);
        return "redirect:/login"; // 회원가입 후 로그인 페이지로 이동
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        Map<String, String> userInput = new HashMap<>();
        userInput.put("email", email);
        userInput.put("password", password);

        // 로그인 로직을 userService에서 처리
        boolean success = userService.login(userService.findAllUser(), userInput);
        if (success) {
            return "redirect:/home-dashboard"; // 로그인 성공 시 대시보드 페이지로 이동
        } else {
            return "redirect:/login?error"; // 로그인 실패 시 로그인 페이지로 다시 이동
        }
    }

    // 기타 사용자 관련 컨트롤러 메서드 추가 가능
}
