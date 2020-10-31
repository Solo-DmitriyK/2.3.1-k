package all.hiber.cervise;

import all.hiber.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import all.web.model.User;

import java.util.List;

@Service
public class UserServiseImp implements UserServise {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void edit(User user) {
//        userDao.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getOne(id);
    }
}


