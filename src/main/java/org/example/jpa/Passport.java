package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="passports")
@NoArgsConstructor
@Getter
@Setter
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="passport_number")
    private String passportNumber;

    @OneToOne(cascade = CascadeType.PERSIST)    // person에 대한 cascade 설정
    @JoinColumn(name = "person_id")
    private Person person;
}
