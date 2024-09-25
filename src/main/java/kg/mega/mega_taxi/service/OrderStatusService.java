package kg.mega.mega_taxi.service;

import jakarta.persistence.Access;
import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStatusService {

    @Autowired
    private OrderStatus orderStatus;

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    public void saveStatus(){
    }

    public Cars getStatusById(){
        return null;
    }

    public void deleteStatus(){
    }

    public void updateStatus(){
    }
}
