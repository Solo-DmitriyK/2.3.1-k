package all.hiber.cervise;

import all.web.model.User;

import java.util.List;

public interface UserServise {

    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(long id);

}
