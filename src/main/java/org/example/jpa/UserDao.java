package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {
    // private EntityManagerFactory emf;

    public UserDao() {
        // this.emf = Persistence.createEntityManagerFactory("lionPU");
    }

    // 입력
    public void createUser(User user) {
        // EntityManager em = emf.createEntityManager();
        // JPAUtil에서 제공하는 EntityManager 사용 가능
        EntityManager em = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch(RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // 조회


    // 수정


    // 삭제
}
