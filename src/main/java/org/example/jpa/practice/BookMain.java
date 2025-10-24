package org.example.jpa.practice;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.example.jpa.JPAUtil;

@Slf4j
public class BookMain {

    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        log.info("id 1인 작가");
        Author author = em.find(Author.class, 1L);
        log.info("author = {}", author.getName());

        log.info("id가 1인 작가의 책들");
        for (Book book : author.getBooks()) {
            log.info("book = {}", book.getTitle());
        }

        log.info("id가 1인 책");
        Book book = em.find(Book.class, 1);
        log.info("book = {}", book.getTitle());
        log.info("author name = {}", book.getAuthor().getName());
        log.info("author id = {}", book.getAuthor().getId());
    }

    public static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            // Richard Feynman 작가 추가
            // The Selfish Gene 책 추가
            Author author = new Author();
            author.setName("Richard Feynman");

            Book book = new Book("The Selfish Gene", author);
            author.getBooks().add(book);
            author.getBooks().add(new Book("surely you're joking mr. feynman", author));

            em.persist(author);

            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    public static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            Author author = em.find(Author.class, 4);
            author.setName("Richard Feynman modified");
            em.persist(author);

            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    public static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            Author author = em.find(Author.class, 3);
            em.remove(author);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    public static void main(String[] args) {
        // find();
        // create();
        update();
        // delete();

    }
}
