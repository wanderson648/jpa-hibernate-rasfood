package org.example.dao;

import org.example.entity.Menu;

import javax.persistence.EntityManager;

public class MenuDao {

    private final EntityManager entityManager;

    public MenuDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Menu menu) {
        this.entityManager.persist(menu);
        System.out.println("Created dish: " + menu);
    }

    public void update(final Menu menu) {
        this.entityManager.merge(menu);
    }

    public Menu findById(final Integer id) {
        return this.entityManager.find(Menu.class, id);
    }

    public void remove(final Menu menu) {
        this.entityManager.remove(menu);
    }
}

