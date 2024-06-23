package org.example.service.teste;

import org.example.dao.DishDao;
import org.example.entity.Dish;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DishService {
    public static void main(String[] args) {

        Dish risoto = new Dish();
        risoto.setName("Risoto de frutos do mar");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setAvailable(true);
        risoto.setValue(BigDecimal.valueOf(88.50));

        Dish salmao = new Dish();
        salmao.setName("Salmão de frutos do mar");
        salmao.setDescription("Salmão acompanhado de lula, polvo e mariscos");
        salmao.setAvailable(true);
        salmao.setValue(BigDecimal.valueOf(60.50));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        DishDao dishDao = new DishDao(entityManager);

        entityManager.getTransaction().begin();
        dishDao.create(risoto);
        entityManager.flush();
        dishDao.create(salmao);
        entityManager.flush();

        System.out.println("O prato consultado foi: "+ dishDao.findById(2));

//        dishDao.remove(risoto);

        System.out.println("O prato consultado foi: "+ dishDao.findById(1));
        System.out.println("O prato consultado foi: "+ dishDao.findById(2));
        System.out.println();

        risoto.setValue(BigDecimal.valueOf(55.80));
        dishDao.update(risoto);
        System.out.println("O prato consultado foi: "+ dishDao.findById(1));


        entityManager.close();
    }
}
