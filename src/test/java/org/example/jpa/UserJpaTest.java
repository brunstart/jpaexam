package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserJpaTest {
    private static EntityManagerFactory emf;    // BeforeAll이 static이어서 EntityManagerFactory도 static
    private EntityManager em;
    private EntityTransaction tx;

    // 테스트가 실행될 때 마다 EntityManagerFactory가 매번 생성될 필요가 있는가?
    // 테스트 전에 한 번만 실행되면 됨
    @BeforeAll
    public static void setUpClass() { // 이 클래스와 상관없이 생성되어야 해서 static
        emf = Persistence.createEntityManagerFactory("lionPU");
    }

    @AfterAll
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    // EntityManager는 테스트 마다 하나씩 있어야한다.
    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void tearDown() {
        if(tx != null && tx.isActive()) {
            tx.rollback();
        }
        if(em != null) {
            em.close();
        }
    }

    @Test
    @DisplayName("유저 데이터 저장")
    void insertUser() {
        User user = new User("admin", "admin@admin.com");
        em.persist(user);
        tx.commit();

        assertNotNull(user.getId(), "입력이 성공적으로 일어나면 id는 null이 아니어야 합니다.");
    }

    @Test
    void findUserById() {
        User user = new User("caramiUser", "carami@gmail.com");
        em.persist(user);
        tx.commit();

        tx = em.getTransaction();
        tx.begin();

        User findUser = em.find(User.class, user.getId());
        User findUser2 = em.find(User.class, user.getId());

        assertSame(findUser, findUser2);
    }


}
