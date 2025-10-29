package demo.user.dao;
import demo.user.entity.User;
import java.util.List;

public interface UserDAO {
    public User findById(int id);
    public List<User> findAll();
    public User save(User user);
    public void deleteById(int id);
    public void deleteAll();
}
