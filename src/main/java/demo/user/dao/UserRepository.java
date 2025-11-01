package demo.user.dao;
import demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface UserRepository extends JpaRepository<User, Integer> {

}
