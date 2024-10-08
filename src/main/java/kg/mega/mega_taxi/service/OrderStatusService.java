package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.repository.OrderStatusRepository;
import kg.mega.mega_taxi.request.OrderStatusSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;


    public void saveStatus(OrderStatusSave orderStatusSave){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatusName(orderStatusSave.getStatusName());
        orderStatusRepository.save(orderStatus);
    }

    public OrderStatus getStatusById(Long id){
        return orderStatusRepository.findById(id).orElse(null);
    }

    public void deleteStatus(Long id){
        orderStatusRepository.deleteById(id);
    }

    public void updateStatus(OrderStatusSave orderStatusSave, Long id){
        OrderStatus orderStatusToUpdate = orderStatusRepository.findById(id).orElse(null);
        if(orderStatusToUpdate != null){
            orderStatusToUpdate.setStatusName(orderStatusToUpdate.getStatusName());
            orderStatusRepository.save(orderStatusToUpdate);
        }
    }

    public List<OrderStatus> getAllOrderStatus(String filter){
        if (filter == null || filter.isEmpty()){
            return orderStatusRepository.findAll();
        }
        return orderStatusRepository.findAll().stream()
                .filter(orderStatus -> orderStatus.getStatusName().equals(filter)||orderStatus.getId().equals(filter)
                ).toList();
    }
}
