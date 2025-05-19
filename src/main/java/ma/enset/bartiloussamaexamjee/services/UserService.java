package ma.enset.bartiloussamaexamjee.services;

import ma.enset.bartiloussamaexamjee.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO getUserByUsername(String username);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    void addRoleToUser(String username, String roleName);
}