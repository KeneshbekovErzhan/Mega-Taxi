package kg.mega.mega_taxi.controllers;

import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.request.OrderSave;
import kg.mega.mega_taxi.service.OrdersHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {
    @Autowired
    private OrdersHistoryService orderHistoryService;

    @PostMapping("/create")
    public ResponseEntity<?> saveOrder(@RequestBody OrderSave orderSave){
        orderHistoryService.saveOrder(orderSave);
        return ResponseEntity.ok("Order saved!");
    }

    @GetMapping("/getById/{id}")
    public Orders getById(@PathVariable Long id){
        return orderHistoryService.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody OrderSave orderSave, @PathVariable Long id){
        orderHistoryService.updateOrder(orderSave, id);
        return ResponseEntity.ok("Order updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        orderHistoryService.deleteOrder(id);
    }

    @GetMapping("/getAll")
    public List<Orders> getAll(@RequestParam ("name") String name){
        return orderHistoryService.getAllCars(name);
    }
}
