package Pack;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{
    @Autowired
    UserRepository userRepository;
   // @Autowired
   //private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private String username;


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setRoles(new HashSet<>(roleRepository.findAll()));
      userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);

    }
}