package sin12743.securityexample1.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sin12743.securityexample1.bean.User;
import sin12743.securityexample1.repository.SecurityRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private SecurityRepository secRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        sin12743.securityexample1.bean.User user = secRepo.getUserByUsername(username);
        if (user == null){
            System.out.println("User was not found");
            throw  new UsernameNotFoundException("User not Found");
        }
        List<String> roles = secRepo.getRolesById(user.getUserId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for(String role : roles){
            grantList.add(new SimpleGrantedAuthority(role));
        }

        User springUser = new User(user.getUserName(), user.getEncryptedPassword(),grantList);
        return (UserDetails)springUser;



    }
}
