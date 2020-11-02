package all.web.controller;


import all.hiber.cervise.UserServiceImp;
import all.web.model.User;
import all.web.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    @GetMapping("/users")
    public String allUser (Model model){
        model.addAttribute("users", userServiceImp.allUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") long id, Model model){
        model.addAttribute("user", userServiceImp.getById(id));
        return  "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userServiceImp.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userServiceImp.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String udgate(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImp.edit(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImp.delete(user);
        return "redirect:/users";
    }



}
