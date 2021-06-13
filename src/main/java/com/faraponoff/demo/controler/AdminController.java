package com.faraponoff.demo.controler;

import com.faraponoff.demo.model.User;
import com.faraponoff.demo.service.RoleService;
import com.faraponoff.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Главная страница");
        return "index";
    }

    private UserService userService;
    private RoleService roleService;



    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/")
    public String showUserById(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "showUser";

    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "selectRoles[]") String[] roleNames) {
        userService.saveUser(user, roleNames);
        return "redirect:/admin";
    }

    @PostMapping("/edit")
    public String editForm(Model model, @RequestParam("id") long id) {

        model.addAttribute("user", userService.getUserById(id));

        return "editUser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "selectRoles[]") String[] roleNames) {

        userService.updateUser(user, roleNames);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
