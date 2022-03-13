package com.jinho.ordermarkmap.service;


import com.jinho.ordermarkmap.domain.Delivery;
import com.jinho.ordermarkmap.repositiory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    // 주문하기
    public Point takeOrder(Delivery delivery) {
        validateDuplicateOrder(delivery);
        deliveryRepository.save(delivery);
        return delivery.getLocation();
    }

    private void validateDuplicateOrder(Delivery delivery) {
        deliveryRepository.findByLocation(delivery.getLocation())
                .ifPresent(m -> {throw new IllegalStateException("고객님! 맛있는 음식이 지금 가고 있습니다~");});
    }

    public List<Delivery> getAllOrders() { return deliveryRepository.findAll(); }
}
