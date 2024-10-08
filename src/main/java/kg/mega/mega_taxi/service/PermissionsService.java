package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Permissions;
import kg.mega.mega_taxi.repository.PermissionsRepository;
import kg.mega.mega_taxi.request.PermissionSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermissionsService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    public void permissionSave(PermissionSave permissionSave){
        Permissions permissions = new Permissions();
        permissions.setPermission_name(permissionSave.getPermissionName());
        permissionsRepository.save(permissions);
    }

    public Permissions getById(Long id){
        return permissionsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        permissionsRepository.deleteById(id);
    }

    public void update(PermissionSave permissionSave, Long id){
        Permissions permissionsToUpdate = permissionsRepository.getReferenceById(id);
        if(permissionsToUpdate != null){
            permissionsToUpdate.setPermission_name(permissionSave.getPermissionName());
            permissionsRepository.save(permissionsToUpdate);
        }
    }
}
