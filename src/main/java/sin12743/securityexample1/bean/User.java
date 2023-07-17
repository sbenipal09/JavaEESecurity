package sin12743.securityexample1.bean;


import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Long userId;
    private String userName;
    private String encryptedPassword;
    private byte enabled;
}