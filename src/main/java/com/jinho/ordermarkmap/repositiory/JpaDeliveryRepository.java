package com.jinho.ordermarkmap.repositiory;

import com.jinho.ordermarkmap.domain.Delivery;
import org.springframework.data.geo.Point;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaDeliveryRepository implements DeliveryRepository {

    private final EntityManager em;

    public JpaDeliveryRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Delivery save(Delivery delivery) {
        em.persist(delivery);
        return delivery;
    }

    @Override
    public Optional<Delivery> findByUserName(String userName) {
        List<Delivery> result = em.createQuery("select d from Delivery d where d.username = :username", Delivery.class)
                .setParameter("username", userName)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Delivery> findByMenu(String menu) {
        List<Delivery> result = em.createQuery("select d from Delivery d where d.menu = :menu", Delivery.class)
                .setParameter("menu", menu)
                .getResultList();
        return result.stream().findAny();
    }

    //TODO: 구현
    @Override
    public Optional<Delivery> findByAddress(String address) {
        return Optional.empty();
    }

    @Override
    public List<Delivery> findAll() {
        return em.createQuery("select d from Delivery d", Delivery.class).getResultList();
    }
}
