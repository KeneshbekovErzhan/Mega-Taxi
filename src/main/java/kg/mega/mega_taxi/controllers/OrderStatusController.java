package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.request.OrderStatusSave;
import kg.mega.mega_taxi.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    @RequestMapping("/create")
    public ResponseEntity<?> saveOrderStatus(@RequestBody OrderStatusSave orderStatusSave){
        orderStatusService.saveStatus(orderStatusSave);
        return ResponseEntity.ok("OrderStatus saved!");
    }

    @GetMapping("/getById/{id}")
    public OrderStatus getById(@PathVariable Long id){
        return orderStatusService.getStatusById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        orderStatusService.deleteStatus(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody OrderStatusSave orderStatusSave, @PathVariable Long id){
        orderStatusService.updateStatus(orderStatusSave, id);
        return ResponseEntity.ok("OrderStatus updated!");
    }

    @GetMapping("/getAll")
    public List<OrderStatus> getAll(@RequestParam ("name") String name){
        return orderStatusService.getAllOrderStatus(name);
    }
}
