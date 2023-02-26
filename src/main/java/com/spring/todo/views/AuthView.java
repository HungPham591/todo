package com.spring.todo.views;

import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"", "/view/auth"})
public class AuthView extends BaseView {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, ModelMap modelMap) throws Exception {
        if (error != null) {
            modelMap.put("msg", "Login - Failed !!! ");
        }
        if (logout != null) {
            modelMap.put("msg", "Logout Successful");
        }
        modelMap.put("user", new AccountEntity());
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(ModelMap modelMap, @RequestParam(value = "error", required = false) String error) throws Exception {
        if (error != null) {
            modelMap.put("msg", "Username đã tồn tại !");
        }
        modelMap.put("user", new AccountEntity());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") AccountInput account) throws Exception {
        AccountEntity accountEntity = this.accountService.findByEmail(account.getEmail());
        if (accountEntity != null) {
            if (accountEntity.getEmail().equals(account.getEmail())) {
                return "redirect:/auth/register?error";
            }
        }
        accountService.createNewAccount(account);
        return "redirect:/admin/employees";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() throws Exception {
        return "auth/accessDenied";
    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, ModelMap modelMap, @RequestParam(value = "error", required = false) String error) throws Exception {
        if (error != null) {
            modelMap.put("msg", "Nhập thiếu thông tin hoặc Username đã tồn tại !");
        }
        AccountEntity user = accountService.findByEmail(authentication.getName());
        modelMap.put("user", user);
        return "auth/profile";
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String saveProfile(Authentication authentication, @ModelAttribute("user") AccountInput account) throws Exception {
        AccountEntity user = accountService.findByEmail(authentication.getName());
        try {
            accountService.createNewAccount(account);
        } catch (Exception e) {
            return "redirect:/auth/profile?errol";
        }
        return "redirect:/orders/index";
    }
}
