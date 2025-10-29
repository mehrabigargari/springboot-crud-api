package demo.user.rest;
import demo.user.entity.User;
import demo.user.error.UserException;
import demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable int userId){
        if(userId>=userService.findAll().size() || userId<0){
            throw new UserException("There is not any user with this id.");
        }
        return userService.findById(userId);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User newUser){
        newUser.setId(0);
        return userService.save(newUser);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User theUser){
        return userService.save(theUser);
    }
}
