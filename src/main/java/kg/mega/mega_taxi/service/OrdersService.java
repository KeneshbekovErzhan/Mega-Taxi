package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersService {

    @Autowired
    private Orders orders;

    @Autowired
    private OrderRepository orderRepository;


    public void saveOrder(){
    }

    public Cars getOrderById(){
        return null;
    }

    public void deleteOrder(){
    }

    public void updateOrder(){
    }
}
