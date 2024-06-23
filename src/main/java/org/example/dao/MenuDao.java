package org.example.dao;

import org.example.entity.Menu;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

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

    public Menu findByName(final String filter) {
        try {
            String jpql = "SELECT m FROM Menu m WHERE UPPER(m.name) = UPPER(:name)";
            return this.entityManager.createQuery(jpql, Menu.class)
                    .setParameter("name", filter).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Menu> findAllByValue(final BigDecimal filter) {
        String jpql = "SELECT m FROM Menu m WHERE m.value = :value";
        return this.entityManager.createQuery(jpql, Menu.class)
                .setParameter("value", filter).getResultList();
    }


    public List<Menu> findAll() {
        String sql = "SELECT m FROM Menu m";
        return this.entityManager.createQuery(sql, Menu.class).getResultList();
    }

    public void remove(final Menu menu) {
        this.entityManager.remove(menu);
    }
}

