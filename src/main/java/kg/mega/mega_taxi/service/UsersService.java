package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {

    @Autowired
    private Users users;

    @Autowired
    private UsersRepository usersRepository;


    public void saveUser(){
    }

    public Cars getUserById(){
        return null;
    }

    public void deleteUser(){
    }

    public void updateUser(){
    }


}
