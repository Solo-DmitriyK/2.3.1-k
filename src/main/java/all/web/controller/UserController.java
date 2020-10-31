package all.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import all.web.model.User;
import all.web.servise.UserServise;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping
    public String allUser (Model model){
        model.addAttribute("users", userServise.list());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userServise.show(id));
        return  "users/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userServise.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userServise.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String udgate(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userServise.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userServise.delete(id);
        return "redirect:/users";
    }



}
