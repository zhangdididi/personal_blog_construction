package dison.Service;

import dison.mapper.UserMapper;
import dison.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
