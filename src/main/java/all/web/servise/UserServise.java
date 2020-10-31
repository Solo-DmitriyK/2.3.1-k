package all.web.servise;

import org.springframework.stereotype.Component;
import all.web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServise {
    private  static int COUNT;
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(++COUNT, "Den"));
        userList.add(new User(++COUNT, "Ben"));
        userList.add(new User(++COUNT, "Tom"));
        userList.add(new User(++COUNT, "Tim"));

    }

    public List<User> list(){
        return userList;
    }

    public User show(int id){
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++COUNT);
        userList.add(user);
    }

    public void update(int id, User updateUser){
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
    }

    public void delete(int id){
        userList.removeIf(user -> user.getId()==id);
    }

}
