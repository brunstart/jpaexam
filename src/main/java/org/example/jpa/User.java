package org.example.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티를 쓰려면 반드시 프라이머리 키가 있어야함
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="jpa_users")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // auto : 알아서 생성되도록 설정, identity : mysql에서 쓰는 auto_increment 테이블에 데이터가 입력될 때 ID가 채워짐, persistence 값이 들어갈 때 자동으로 생성됨
    // JpaRun에서 ID 값을 따로 설정해주지 않아도 자동으로 들어감
    // @GeneratedValue(strategy = GenerationType.SEQUENCE) // ID 값을 주는 테이블을 만들고 ID값을 세팅 후 데이터를 넣음, 이미 있는 데이터의 ID값이 세팅되면 오류가 남, 계속 실행해서 없는 ID가 나오면 데이터 insert
    private Long id;
    @Column(name="user_name")   // 테이블 생성 시 user_name으로 컬럼이 생성됨
    private String name;
    private String email;

    // public User() {} // 필수, @NoArgsConstructor로 선언해놔서 주석처리 함

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
