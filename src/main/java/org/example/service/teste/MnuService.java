package org.example.service.teste;

import org.example.dao.CategoryDao;
import org.example.dao.MenuDao;
import org.example.entity.Category;
import org.example.entity.Menu;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MnuService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        createProductMenu(entityManager, createCategory(entityManager));

    }

    public static Category createCategory(EntityManager entityManager) {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        Category principalDish = new Category("Prato principal");

        entityManager.getTransaction().begin();
        categoryDao.createCategory(principalDish);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return principalDish;
    }

    public static void createProductMenu(EntityManager entityManager, Category category) {
        Menu risoto = new Menu();
        risoto.setName("Risoto");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setAvailable(true);
        risoto.setCategory(category);
        risoto.setValue(BigDecimal.valueOf(88.50));

        Menu salmao = new Menu();
        salmao.setName("Salmão");
        salmao.setDescription("Salmão acompanhado de lula, polvo e mariscos");
        salmao.setAvailable(true);
        salmao.setCategory(category);
        salmao.setValue(BigDecimal.valueOf(60.50));

        MenuDao menuDao = new MenuDao(entityManager);

        entityManager.getTransaction().begin();
        menuDao.create(risoto);
        entityManager.flush();
        menuDao.create(salmao);
        entityManager.flush();

        menuDao.findAll()
                .forEach(System.out::println);


        System.out.println("Lista de produtos por valor: "+
                menuDao.findAllByValue(BigDecimal.valueOf(60.50)));

        System.out.println("Produto pesquisado foi: "+ menuDao.findByName("risoto"));

        entityManager.close();
    }

}
