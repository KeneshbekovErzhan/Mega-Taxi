package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.request.PermissionSave;
import kg.mega.mega_taxi.request.RoleSave;
import kg.mega.mega_taxi.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionsService permissionsService;
    @PostMapping("/create")
    public void savePermission(@RequestBody PermissionSave permissionSave){
        permissionsService.permissionSave(permissionSave);
    }

    @GetMapping("/getById/{id}")
    public void getById(@PathVariable Long id){
        permissionsService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        permissionsService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody PermissionSave permissionSave, @PathVariable Long id){
        permissionsService.update(permissionSave, id);
        return ResponseEntity.ok("Permission updated!");
    }
}
