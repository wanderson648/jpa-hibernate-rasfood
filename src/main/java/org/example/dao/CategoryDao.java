package org.example.dao;

import org.example.entity.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createCategory(Category category) {
        this.entityManager.persist(category);
    }
}
