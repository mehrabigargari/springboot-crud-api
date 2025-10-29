package demo.user.dao;
import demo.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User save(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(this.findById(id));
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM User").executeUpdate();
    }
}
