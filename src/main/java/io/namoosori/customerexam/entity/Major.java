package io.namoosori.customerexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="MAJOR_TB")
@NoArgsConstructor
public class Major {
    @Id @GeneratedValue
    private Long majorId;
    private String name;
    private String category;



    public Major(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
