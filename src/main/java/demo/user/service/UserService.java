package demo.user.service;
import demo.user.entity.User;
import java.util.List;

public interface UserService {
    public User findById(int id);
    public List<User> findAll();
    public User save(User user);
    public void deleteById(int id);
    public void deleteAll();
}
