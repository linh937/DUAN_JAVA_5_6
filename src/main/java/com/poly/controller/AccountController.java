package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.service.*;
import com.poly.bean.UserRole;
import com.poly.bean.Users;
import com.poly.service_bean.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    UsersService userService;
    
    @Autowired
    UserRoleService userRoleService;
    
    @Autowired
    RoleService roleService;

    @Autowired
    CookieService cookieService;
    
    @Autowired
    HttpSession session;

    @Autowired
    SessionService ss;

    @Autowired
    ParamService param;

    @RequestMapping("/account/login/form")
    public String getLogin(Model m) {
        return "account/login";
    }

    @RequestMapping("/account/login/success")
    public String success(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpSession session = request.getSession();
        List<String> authList = new ArrayList<>();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<String> roleNames = userService.getRolesByUsername(username);

            for (String roleName : roleNames) {
                authList.add("ROLE_" + roleName);
            }

            cookieService.create("auth", username, 1); // Create a cookie with authentication details for 1 day
        }

        if (authList.contains("ROLE_ADMIN")) {
            return "redirect:/admin/index";
        } else {
            return "redirect:/home/index";
        }
    }


    @RequestMapping("/account/login/error")
    public String loginError(Model model) {
        return "account/login";
    }

    @RequestMapping("/account/logoff/success")
    public String logoffSuccess(Model model) {
        model.addAttribute("message", "Bạn đã đăng xuất!");
        return "account/login";
    }

    @RequestMapping("/account/register/form")
    public String getRegister(Model m) {
        return "account/register";
    }

    @RequestMapping("/account/forget")
    public String getForgetPassword(Model m) {
        return "account/forgetPassword";
    }

    @RequestMapping("/account/change")
    public String getChange(Model m) {
        return "account/changePassword";
    }

    @RequestMapping("/account/OTP")
    public String getOTP(Model m) {
        return "account/otp";
    }

    @PostMapping("/account/registers")
    public String Register(Model m, Users u, @Param("username") String username) {
        Users ufind = userService.findById(username);
        if (ufind != null) {
            m.addAttribute("errorUsername", "true");
        } else {
            userService.create(u);
            UserRole uRole = new UserRole();
            uRole.setUsername(u);
            uRole.setRoleid(roleService.findbyId("USER"));
            userRoleService.create(uRole);
            m.addAttribute("successRegister", "true");
        }
        return "account/register";
    }

    @PostMapping("/account/changeprofile")
    public String ChangeProfile(Model m, Users u, @Param("username") String username) {
        userService.update(u);
        Users user = (Users) ss.getAttribute("users");
        m.addAttribute("profile", userService.findById(user.getUsername()));
        return "home/profile";
    }

    @PostMapping("/account/changePassProfile")
    public String ChangePassProfile(Model m, @Param("passwords") String passwords) {
        Users user = (Users) ss.getAttribute("users");
        
        String passwordsNew = param.getString("passwordsNew", "");
        String passwordsNew2 = param.getString("passwordsNew2", "");

        if (!passwords.equals(user.getPasswords())) {
            m.addAttribute("errorPass", "Kiểm tra lại mật khẩu");
        } else if (!passwordsNew.equals(passwordsNew2)) {
            m.addAttribute("errorPass", "Kiểm tra lại mật khẩu mới");
        } else {
            user.setPasswords(passwordsNew);
            userService.update(user);
            m.addAttribute("profile", userService.findById(user.getUsername()));
            m.addAttribute("successPass", true);
        }
        return "home/profile";
    }

    @CrossOrigin("*")
    @ResponseBody
    @RequestMapping("/rest/security/authentication")
    public Object getAuthentication(HttpSession session) {
        return session.getAttribute("authentication");
    }
}
