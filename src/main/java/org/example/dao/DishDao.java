package org.example.dao;

import org.example.entity.Dish;

import javax.persistence.EntityManager;

public class DishDao {

    private final EntityManager entityManager;

    public DishDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("Created dish: " + dish);
    }

    public void update(final Dish dish) {
        this.entityManager.merge(dish);
    }

    public Dish findById(final Integer id) {
        return this.entityManager.find(Dish.class, id);
    }

    public void remove(final Dish dish) {
        this.entityManager.remove(dish);
    }
}

