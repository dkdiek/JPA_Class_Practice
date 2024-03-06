package io.namoosori.customerexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="STUDENET_TB")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MAJORID")
    private Major major;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}
