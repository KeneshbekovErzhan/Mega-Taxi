package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.request.SaveUser;
import kg.mega.mega_taxi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;


    public ResponseEntity<?> saveUser(@RequestBody SaveUser saveUser){
        usersService.saveUser(saveUser);
        return ResponseEntity.ok("User saved!");
    }
}
