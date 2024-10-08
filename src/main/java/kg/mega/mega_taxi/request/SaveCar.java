package kg.mega.mega_taxi.request;
import kg.mega.mega_taxi.model.Users;
import lombok.Data;

@Data
public class SaveCar {
    private String brand;

    private String model;

    private String color;

    private String numberSheet;

    private Long idUsers;
}
