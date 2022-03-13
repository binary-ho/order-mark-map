package com.jinho.ordermarkmap.controller;


import com.jinho.ordermarkmap.domain.Delivery;
import com.jinho.ordermarkmap.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveryOrder/new")
    public String createForm() {
        return "deliverys/orderForm.html";
    }

    @PostMapping("/deliveryOrder/new")
    public String create(DeliveryForm form) {
        Delivery order = new Delivery();
        order.setUsername(form.getUsername());
        order.setMenu(form.getMenu());
        order.setAddress(form.getAddress());
        order.setLocationX(form.getLocationX());
        order.setLocationY(form.getLocationY());

        //order.setLocationX(form.getLocationX());
        //System.out.println(order.getAge());

        deliveryService.takeOrder(order);
        return "redirect:/";
    }

    @GetMapping("/map")
    public String mapPage() {
        return "map.html";
    }

    @GetMapping("/popUp")
    public String findAddressPopUp() {return "popUp.html";}
}
