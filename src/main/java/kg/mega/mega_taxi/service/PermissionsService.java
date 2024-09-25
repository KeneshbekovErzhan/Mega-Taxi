package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Permissions;
import kg.mega.mega_taxi.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;

public class PermissionsService {

    @Autowired
    private Permissions permissions;
    @Autowired
    private PermissionsRepository permissionsRepository;


}
