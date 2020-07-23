package training.demo.controller;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import training.demo.domain.Role;
import training.demo.domain.User;
import training.demo.repository.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo UserRepo;

    @GetMapping("/registration")
    public String registration (){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
    User userFromDb = UserRepo.FindByUsername(user.getUsername());
    if (userFromDb !=null){
        model.put("message", "User already Exist");
        return "registrarion";
    }
    else {
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    UserRepo.save(user);

    }
        return"redirect/login";
    }
}
