package kg.mega.mega_taxi.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveUser {
    private String firstName;
    private String lastName;
    private String email;
    private String phone_number;
    private Integer roleId;


}
