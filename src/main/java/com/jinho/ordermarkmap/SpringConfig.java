package com.jinho.ordermarkmap;


import com.jinho.ordermarkmap.repositiory.JpaDeliveryRepository;
import com.jinho.ordermarkmap.repositiory.DeliveryRepository;
import com.jinho.ordermarkmap.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {this.em = em;}

    @Bean
    public DeliveryService orderService() {
        return new DeliveryService(orderRepository());
    }

    @Bean
    public DeliveryRepository orderRepository() {
        return new JpaDeliveryRepository(em);
    }
}
