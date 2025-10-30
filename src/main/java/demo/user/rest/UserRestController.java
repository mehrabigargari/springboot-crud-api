package demo.user.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.user.entity.User;
import demo.user.error.UserException;
import demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserRestController(UserService userService, ObjectMapper objectMapper1) {
        this.userService = userService;
        this.objectMapper = objectMapper1;
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

    @PatchMapping("/user/{userId}")
    public User partiallyUpdate(@PathVariable int userId, @RequestBody Map<String, Object> patchPayload) {
        if(userId>userService.findAll().size() || userId<0){
            throw new UserException("There is not any user with this id.");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("The id field is now allowed.");
        }
        User tempUser = userService.findById(userId);
        return userService.save(apply(tempUser, patchPayload));
    }

    private User apply(User tempUser, Map<String, Object> patchPayload) {
        ObjectNode userNode = objectMapper.convertValue(tempUser,ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);
        userNode.setAll(patchNode);
        return objectMapper.convertValue(userNode,User.class);
    }
}
