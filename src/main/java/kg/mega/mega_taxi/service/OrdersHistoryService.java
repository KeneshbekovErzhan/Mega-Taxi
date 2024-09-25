package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.OrdersHistory;
import kg.mega.mega_taxi.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersHistoryService {

    @Autowired
    private OrdersHistory ordersHistory;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;


    public void saveOrderHistory(){
    }

    public OrdersHistory getOrderHistoryById(){
        return null;
    }

    public void deleteOrderHistory(){
    }

    public void updateOrderHistory(){
    }
}
