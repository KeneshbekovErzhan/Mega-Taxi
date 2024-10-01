package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Roles;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.RolesRepository;
import kg.mega.mega_taxi.repository.UsersRepository;
import kg.mega.mega_taxi.request.SaveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Cars getUserById(){
        return null;
    }

    public void deleteUser(){
    }

    public void updateUser(){
    }


}
