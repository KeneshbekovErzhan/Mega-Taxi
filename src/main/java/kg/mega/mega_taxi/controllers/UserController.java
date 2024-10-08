package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.request.SaveUser;
import kg.mega.mega_taxi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody SaveUser saveUser){
        usersService.saveUser(saveUser);
        return ResponseEntity.ok("User saved!");
    }

    @GetMapping("/getById/{id}")
    public Users getUser(@PathVariable Long id){
        return usersService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody SaveUser saveUser, @PathVariable Long id){
        usersService.updateUser(saveUser, id);
        return ResponseEntity.ok("User updated!");
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam ("id") Long id){
        usersService.deleteUser(id);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(@RequestParam ("name") String name){
        return usersService.getAllUsers(name);
    }
}
