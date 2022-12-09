package com.mimoudix.usermanagement.web;

import com.mimoudix.usermanagement.entities.User;
import com.mimoudix.usermanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;

    @GetMapping(path = "/index")
    public String users(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<User> pageUsers = userRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listUsers", pageUsers.getContent());
        model.addAttribute("pages", new int[pageUsers.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "users";

    }

    @GetMapping(path = "/delete")
    public String delete(Long id, String keyword, int page) {
        userRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping(path = "/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping(path = "/users")
    @ResponseBody
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
