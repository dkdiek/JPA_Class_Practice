package io.namoosori.customerexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer_tb")
@TableGenerator(
        name="id_generator",
        table="customer_id",
        pkColumnName = "id_name",
        pkColumnValue = "customer_id",
        valueColumnName = "next_value",
        initialValue = 0,
        allocationSize = 1
)
@ToString
@Setter
@Getter
@NoArgsConstructor
/*@SequenceGenerator(
        name="customer_generator",
        sequenceName = "customer_seq",
        initialValue = 1,
        allocationSize = 50
)*/
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
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
