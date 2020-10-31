package all.hiber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import all.web.model.User;

public interface UserDao extends JpaRepository <User, Long> {

}
