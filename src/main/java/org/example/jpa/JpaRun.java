package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("lionPU");// persistence.xml 파일 내 <persistence-unit> 태그에 지정한 name 값, 대소문자 구분
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 트랜잭션 시작
        // entityManager.getTransaction().begin();

        // 입력
        // User user = new User("kim", "kim@nate.com");
        // System.out.println("persist 전 : " + user);
        // user.setId(3L);
        // // 현재 User라고 하는 엔티티는 아직 영속성 컨텍스트와는 관련이 없다 (= 비영속성)
        // entityManager.persist(user);    // 엔티티 매니저의 persist 메소드를 사용해서 user를 영속상태로 만들어야함
        // System.out.println("persist 후 : " + user);

        // System.out.println("commit 실행 전");
        // entityManager.getTransaction().commit();    // 영속성 컨텍스트 확인, ID 3번 데이터가 DB에 없다 -> insert 쿼리 동작시킴
        // System.out.println("commit 실행 후");

        // 영속 / 비영속 상태?
        // 비영속 상태 : persistence context 가 관리하지 않고 있는 상태
        // 영속 상태 : persist() 를 해서 영속성 컨텍스트가 관리하고 있는 상태

        // 조회
        // User findUser = entityManager.find(User.class, 3L); // DB로 가기전에 영속성 컨텍스트에 가서 검색, 있었기 때문에 인스턴스 반환
        //
        // User findUser2 = entityManager.find(User.class, 3L);
        //
        // User findUser3 = entityManager.find(User.class, 3L);    // find를 3번 수행했지만 DB 접근은 1번만 함

        // System.out.println(findUser);
        
        // if(user == findUser){   // 같은 인스턴스인지 비교
        //     System.out.println("같다");
        // }

        // if(findUser2 == findUser){
        //     System.out.println("같다");
        // }
        //
        // if(findUser3 == findUser){
        //     System.out.println("같다");
        // }

        // 수정 : jpa에서 수정은 없음
        // User updateUser = entityManager.find(User.class, 1L);   // 1. 4. 영속 상태, select 해온 값을 영속성 컨텍스트에 저장
        //
        // updateUser.setName("kang");     // 5. 아무개로 변경된 이름을 kang으로 변경
        //
        // updateUser.setName("아무개");  // 2. 스냅샷의 name을 변경 / 6. 이름을 다시 아무개로 변경
        //
        // System.out.println("commit 실행 전");
        // entityManager.getTransaction().commit();    // 3. 스냅샷과 DB가 다른것을 확인, update 구문 동작 / 7. 스냅샷의 name값이 아무개 그대로이므로 update 구문 동작하지 않음
        // System.out.println("commit 실행 후");

        // 삭제
        // User delUser = entityManager.find(User.class, 1L);
        // entityManager.remove(delUser);

        // System.out.println("commit 실행 전");
        // entityManager.getTransaction().commit();    //
        // System.out.println("commit 실행 후");

    }
}