package org.example.jpa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) // 리스트에 값을 채우는건 시간이 걸려서 기본적으로 fetch 타입이 LAZY로 동작, 사용할때 채움, EAGER로 하면 학교 정보 가져올때 전부 다 조회해서 학생정보도 같이 가져옴
    private List<Student> students = new ArrayList<>();

    // JPA에서 ToString 사용 시 주의 필요, 잘못 사용하면 toString 채우려고 쿼리를 계속 날리게 되는 경우가 생김

    public School(String name) {
        this.name = name;
    }
}
