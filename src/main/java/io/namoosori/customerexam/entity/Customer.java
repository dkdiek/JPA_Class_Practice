package io.namoosori.customerexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer_tb")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long registerDate;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }

    public static Customer sample() {
        return new Customer();
    }

}
