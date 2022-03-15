package com.jinho.ordermarkmap.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jinho.ordermarkmap.domain.Delivery;
import com.jinho.ordermarkmap.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveryOrder/new")
    public String createForm() {
        return "deliveries/orderForm.html";
    }

    @PostMapping("/deliveryOrder/new")
    public String create(DeliveryForm form) {
        Delivery order = new Delivery();
        order.setUsername(form.getUsername());
        order.setMenu(form.getMenu());
        order.setAddress(form.getAddress());
        order.setLocationX(form.getLocationX());
        order.setLocationY(form.getLocationY());

        deliveryService.takeOrder(order);
        return "redirect:/";
    }

    @GetMapping("/popUp")
    public String findAddressPopUp() {return "popUp.html";}

    /*@GetMapping("/map")
    public String mapPage() {
        return "map.html";
    }*/


    @GetMapping("/map")
    public String sendList(Model model) {
        List<Delivery> deliveries = deliveryService.getAllOrders();
        String str = "";
        for(var itr : deliveries) {
            str += "*";
            str += itr.getAddress();
            str += '|';
            str += itr.getLocationX();
            str += '|';
            str += itr.getLocationY();
        }
        model.addAttribute("deliveries", str);
        return "deliveries/map";
    }
}
