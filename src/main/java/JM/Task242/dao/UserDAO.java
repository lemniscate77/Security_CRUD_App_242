package JM.Task242.dao;

import JM.Task242.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(Integer id);
    void edit(User user);
    User getById(Integer id);
    User getByName (String name);
    User getUserByName(String name);
}

