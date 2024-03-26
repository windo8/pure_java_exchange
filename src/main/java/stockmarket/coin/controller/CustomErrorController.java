package stockmarket.coin.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // 오류 처리 로직을 여기에 구현합니다.
        // 예를 들어, 오류 페이지로 리다이렉트하거나 특정 오류에 대한 메시지를 표시할 수 있습니다.
        return "error-page"; // 오류 페이지로 이동하는 뷰 이름을 반환합니다.
    }

//    @Override
//    public String getErrorPath() {
//        return "/error"; // ErrorController 인터페이스의 메서드를 구현합니다.
//    }
}
