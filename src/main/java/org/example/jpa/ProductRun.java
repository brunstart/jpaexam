package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductRun {
    public static void main(String[] args) {
        // product에 데이터를 입력/조회/수정/삭제 를 테스트
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("lionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 트랜잭션 시작
        entityManager.getTransaction().begin();

        // 입력
        // Product product = new Product("PC", 2000000); // 객체 생성
        // entityManager.persist(product); // 영속성 컨텍스트에 관리를 맡김
        // entityManager.getTransaction().commit();    // 커밋

        // 조회
        // Product findProduct = entityManager.find(Product.class, 1L);
        // System.out.println(findProduct);
        //
        // // 수정
        // Product updateProduct = entityManager.find(Product.class, 1L);
        // updateProduct.setPrice(40000);
        // entityManager.getTransaction().commit();    // 커밋

        // 삭제
        Product delProduct = entityManager.find(Product.class, 1L);
        entityManager.remove(delProduct);
        entityManager.getTransaction().commit();    // 커밋
    }
}
