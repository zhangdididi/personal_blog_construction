package dison.controller;

import dison.Service.UserService;
import dison.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名和密码来进行校验并且做一个跳转逻辑
     * @return 跳转
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        //用户名密码校验，省略，只做是否为空的一个判断
        //校验通过的话就跳转到首页，为空就跳转到登陆页面
        if (username == null || password == null) {
            return "login";
        }
        User user = userService.login(username, password);
        if (user == null) {
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "/";
        }
    }
}
