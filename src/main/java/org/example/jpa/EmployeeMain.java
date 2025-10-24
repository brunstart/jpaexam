package org.example.jpa;

import jakarta.persistence.EntityManager;

public class EmployeeMain {
    public static void main(String[] args) {
        create();
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Employee employee = new Employee("hong");

            // Project project = new Project("lion project");
            Project project = em.find(Project.class, 1);

            employee.getProjects().add(project);
            project.getEmployees().add(employee);

            em.persist(project);    // 엔티티에 persist에 관한 옵션이 없으면 둘다 persist 해줘야 함
            em.persist(employee);

            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {


            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
