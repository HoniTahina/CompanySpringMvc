package com.groupeisi.companyspringmvc.controller;

import com.groupeisi.companyspringmvc.dto.AccountUserDto;
import com.groupeisi.companyspringmvc.service.AccountUserService;
import com.groupeisi.companyspringmvc.service.IAccountUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final IAccountUserService accountUserService = new AccountUserService();

    @GetMapping(name = "login", value = "/")
    public String index() {
        return "login";
    }
    @GetMapping(name = "logout", value = "/logout")
    public String logout() {
        return "index";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            HttpSession session) {

        try {
            Optional<AccountUserDto> accountUserDto = accountUserService.login(userName, password);

            if (accountUserDto.isPresent()) {
                session.setAttribute("username", userName);
                return "redirect:/welcome";
            } else {

                return "redirect:/";
            }
        } catch (Exception e) {
            logger.error("Erreur lors de la connexion : {}", e.getMessage());

            return "redirect:/";
        }
    }

}
