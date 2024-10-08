package kg.mega.mega_taxi.request;
import lombok.Data;

@Data
public class OrderSave {

    private String sourcePoint;

    private String destinationPoint;

    private Long clientId;

    private Long driverId;

    private Long statusOrder;

    private double price;
}
