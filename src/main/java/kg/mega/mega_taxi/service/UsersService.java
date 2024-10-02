package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Roles;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.RolesRepository;
import kg.mega.mega_taxi.repository.UsersRepository;
import kg.mega.mega_taxi.request.SaveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;



    public void saveUser(SaveUser saveUser){
        Users user = new Users();
        user.setFirstName(saveUser.getFirstName());
        user.setLastName(saveUser.getLastName());
        user.setEmail(saveUser.getEmail());
        user.setPhoneNumber(saveUser.getPhone_number());
        Roles roles = rolesRepository.getReferenceById(Long.valueOf(saveUser.getRoleId()));
        user.setRoles(roles);
        usersRepository.save(user);
    }

    public Users getUserById(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public void updateUser(SaveUser saveUser, Long id){
        Users usersToUpdate = usersRepository.findById(id).orElse(null);
        if(usersToUpdate != null){
            usersToUpdate.setFirstName(saveUser.getFirstName());
            usersToUpdate.setLastName(saveUser.getLastName());
            usersToUpdate.setEmail(saveUser.getEmail());
            usersToUpdate.setPhoneNumber(saveUser.getPhone_number());
            Roles roles = rolesRepository.getReferenceById(Long.valueOf(saveUser.getRoleId()));
            usersToUpdate.setRoles(roles);
            usersRepository.save(usersToUpdate);
        }
    }

    public List<Users> getAllUsers(String filter){
        if (filter == null || filter.isEmpty()){
            return usersRepository.findAll();
        }
        return usersRepository.findAll().stream()
                .filter(users1 -> users1.getRoles().equals(filter) || users1.getFirstName().equals(filter) ||
                        users1.getLastName().equals(filter) || users1.getEmail().equals(filter) ||
                        users1.getPhoneNumber().equals(filter)
                ).toList();
    }


}
