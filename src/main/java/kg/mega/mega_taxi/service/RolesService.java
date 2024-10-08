package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Roles;
import kg.mega.mega_taxi.repository.RolesRepository;
import kg.mega.mega_taxi.request.RoleSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public void roleSave (RoleSave roleSave){
        Roles role = new Roles();
        role.setRole(roleSave.getRole());
        rolesRepository.save(role);
    }

    public Roles getById(Long id){
        return rolesRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        rolesRepository.deleteById(id);
    }

    public void update(RoleSave roleSave, Long id){
        Roles roles = rolesRepository.getReferenceById(id);
        if(roles != null){
            Roles role = new Roles();
            role.setRole(roleSave.getRole());
            rolesRepository.save(role);
        }
    }

}
