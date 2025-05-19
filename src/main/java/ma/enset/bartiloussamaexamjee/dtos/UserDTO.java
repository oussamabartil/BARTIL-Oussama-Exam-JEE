package ma.enset.bartiloussamaexamjee.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Boolean active;
    private List<String> roles;
}