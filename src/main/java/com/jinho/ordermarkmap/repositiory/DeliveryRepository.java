package com.jinho.ordermarkmap.repositiory;

import com.jinho.ordermarkmap.domain.Delivery;
import org.springframework.data.geo.Point;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {
    Delivery save(Delivery order);
    Optional<Delivery> findByUserName(String name);
    Optional<Delivery> findByMenu(String name);
    Optional<Delivery> findByLocation(Point point);
    List<Delivery> findAll();
}
