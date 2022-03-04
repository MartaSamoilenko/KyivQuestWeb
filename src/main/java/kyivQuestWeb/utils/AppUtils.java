package kyivQuestWeb.utils;

import kyivQuestWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppUtils {
    @Autowired
    static UserService userService;

    public static final String C_LOGIN ="cLogin";

    public static Cookie getLoginCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(C_LOGIN)) {
                    return cookie;
                }
            }
        }
        return null;
    }


    public static void addLoginCookie(HttpServletResponse response, String value) {
        addLoginCookie(response, value, 60*60*12);
    }

    public static void deleteLoginCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getLoginCookie(request);
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setMaxAge(0);
            cookie.setValue("");
            response.addCookie(cookie);
        }
    }

    private static void addLoginCookie(HttpServletResponse response, String value, int maxAge) {
        Cookie cookie = new Cookie(C_LOGIN, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        System.out.println(cookie.getValue());
    }

    public static void checkLogin(HttpServletRequest request, HttpServletResponse response, String login) {
        if (!login.equals(getLoginCookie(request))) {
            addLoginCookie(response, login);
        }
    }
}
