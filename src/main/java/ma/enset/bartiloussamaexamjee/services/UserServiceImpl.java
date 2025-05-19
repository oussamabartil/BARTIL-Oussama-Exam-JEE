package ma.enset.bartiloussamaexamjee.services;

import lombok.RequiredArgsConstructor;
import ma.enset.bartiloussamaexamjee.dtos.UserDTO;
import ma.enset.bartiloussamaexamjee.entities.Role;
import ma.enset.bartiloussamaexamjee.entities.User;
import ma.enset.bartiloussamaexamjee.mappers.UserMapper;
import ma.enset.bartiloussamaexamjee.repositories.RoleRepository;
import ma.enset.bartiloussamaexamjee.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        // PAS d'encodage de mot de passe ici
        user.setActive(true);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }
        return userMapper.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserDTOs(users);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDTO.getId()));

        existingUser.setUsername(userDTO.getUsername());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            // PAS d'encodage
            existingUser.setPassword(userDTO.getPassword());
        }
//        existingUser.setActive(userDTO.isActive());

        User updatedUser = userRepository.save(existingUser);
        return userMapper.userToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }
        Role role = roleRepository.findByRoleName(roleName);
        if (user == null) {
            throw new RuntimeException("ROle not found with rolename: " + roleName);
        }

        user.getRoles().add(role);
        userRepository.save(user);
    }
}
