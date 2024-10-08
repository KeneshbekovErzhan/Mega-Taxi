package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.CarRepository;
import kg.mega.mega_taxi.repository.OrderRepository;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import kg.mega.mega_taxi.repository.UsersRepository;
import kg.mega.mega_taxi.request.OrderSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersService {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    OrderStatusRepository orderStatusRepository;

    public void saveOrder(OrderSave orderSave){
        Orders orders = new Orders();
        orders.setSourcePoint(orderSave.getSourcePoint());
        orders.setDestinationPoint(orderSave.getDestinationPoint());
        orders.setPrice(orderSave.getPrice());

        OrderStatus orderStatus = orderStatusRepository.getReferenceById(orderSave.getStatusOrder());
        orders.setStarusOrder(orderStatus);

        Users users = usersRepository.getReferenceById(orderSave.getDriverId());
        orders.setDriver(users);

        Users users1 = usersRepository.getReferenceById(orderSave.getClientId());
        orders.setClient(users1);

        orderRepository.save(orders);
    }

    public Orders getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id){
        carRepository.deleteById(id);
    }

    public void updateOrder(OrderSave orderSave, Long id){
        Orders orders = orderRepository.getReferenceById(id);
        if(orders != null){
            Orders orderToUpdate = new Orders();
            orderToUpdate.setSourcePoint(orderSave.getSourcePoint());
            orderToUpdate.setDestinationPoint(orderSave.getDestinationPoint());
            orderToUpdate.setPrice(orderSave.getPrice());

            OrderStatus orderStatus = orderStatusRepository.getReferenceById(orderSave.getStatusOrder());
            orderToUpdate.setStarusOrder(orderStatus);

            Users users = usersRepository.getReferenceById(orderSave.getDriverId());
            orderToUpdate.setDriver(users);

            Users users1 = usersRepository.getReferenceById(orderSave.getClientId());
            orderToUpdate.setClient(users1);
        }
    }

    public List<Orders> getAllCars(String filter){
        if (filter == null || filter.isEmpty()){
            return orderRepository.findAll();
        }
        return orderRepository.findAll().stream()
                .filter(car2 -> {
                    return car2.getSourcePoint().equals(filter)||car2.getDestinationPoint().equals(filter);
                        }
                ).toList();
    }
}
