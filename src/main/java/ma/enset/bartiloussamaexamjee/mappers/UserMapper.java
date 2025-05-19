package ma.enset.bartiloussamaexamjee.mappers;

import ma.enset.bartiloussamaexamjee.dtos.UserDTO;
//import ma.enset.bartiloussamaexamjee.entities.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
////@Component
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    UserDTO userToUserDTO(User user);
//    User userDTOToUser(UserDTO userDTO);
//    List<UserDTO> usersToUserDTOs(List<User> users);
//}

import ma.enset.bartiloussamaexamjee.entities.Role;
import ma.enset.bartiloussamaexamjee.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Add explicit mapping methods for roles

    // Method to map User entity to UserDTO
    UserDTO fromUser(User user);

    // Method to map UserDTO to User entity
    User fromUserDTO(UserDTO userDTO);

    // Custom method to convert Collection<Role> to List<String>
    default List<String> mapRolesToStrings(Collection<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(Role::getRoleName)  // Assuming Role has a getRoleName() method
                .collect(Collectors.toList());
    }

    // Custom method to convert List<String> to Collection<Role>
    default Collection<Role> mapStringsToRoles(List<String> roleNames) {
        if (roleNames == null) {
            return null;
        }
        return roleNames.stream()
                .map(roleName -> {
                    Role role = new Role();
                    role.setRoleName(roleName);  // Assuming Role has a setRoleName() method
                    return role;
                })
                .collect(Collectors.toList());
    }
}