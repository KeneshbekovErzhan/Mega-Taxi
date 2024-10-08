package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.model.Roles;
import kg.mega.mega_taxi.request.RoleSave;
import kg.mega.mega_taxi.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RolesService rolesService;

    @PostMapping("/create")
    public void roleSave(@RequestBody RoleSave roleSave){
        rolesService.roleSave(roleSave);
    }

    @GetMapping("/getById/{id}")
    public void getById(@PathVariable Long id){
        rolesService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        rolesService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody RoleSave roleSave, @PathVariable Long id){
        rolesService.update(roleSave, id);
        return ResponseEntity.ok("Role updated!");
    }
}
