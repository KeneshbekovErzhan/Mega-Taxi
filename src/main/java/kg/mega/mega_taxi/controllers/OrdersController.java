package kg.mega.mega_taxi.controllers;


import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.request.OrderSave;
import kg.mega.mega_taxi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<?> saveOrder(@RequestBody OrderSave orderSave){
        ordersService.saveOrder(orderSave);
        return ResponseEntity.ok("Order saved!");
    }

    @GetMapping("/getById/{id}")
    public Orders getById(@PathVariable Long id){
        return ordersService.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody OrderSave orderSave, @PathVariable Long id){
        ordersService.updateOrder(orderSave, id);
        return ResponseEntity.ok("Order updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        ordersService.deleteOrder(id);
    }

    @GetMapping("/getAll")
    public List<Orders> getAll(@RequestParam ("name") String name){
        return ordersService.getAllCars(name);
    }
}
