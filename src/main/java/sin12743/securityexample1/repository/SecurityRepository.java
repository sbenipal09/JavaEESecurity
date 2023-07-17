package sin12743.securityexample1.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import sin12743.securityexample1.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class SecurityRepository {
    protected NamedParameterJdbcTemplate jdbc;

    public ArrayList<User> getUsers() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM SEC_USER";
        ArrayList<User> drinks = (ArrayList<User>) jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));

        return users;

    }
    public User getUserByUsername(String username) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        String query = "SELECT * FROM SEC_USER where username=:woof";
        parameters.addValue("woof", username);
        ArrayList<User> drinks = (ArrayList<User>) jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));
/*
        if(users.size()>0)
            return  users.get(0);
        else
                return  null;

    }*/
        return (users.size() > 0) ? users.get(0) : null;
    }

    public List<String> getRolesById(long userId){
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String query = "Select user_role.userId, sec_role.roleName" + "From user_role,sec_role" + "where user_role.roleId = sec_role.roleId"
            + "And userId=woof";
    parameters.addValue("woof",userId);
    ArrayList<String> roles = new ArrayList<String>();
        List<Map<String , Object>> rows = jdbc.queryForList(query,parameters);
        for (Map<String,Object >row : rows){

        }



    }

}
