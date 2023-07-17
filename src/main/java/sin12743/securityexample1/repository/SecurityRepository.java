package sin12743.securityexample1.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SecurityRepository {
    protected NamedParameterJdbcTemplate jdbc;


}
