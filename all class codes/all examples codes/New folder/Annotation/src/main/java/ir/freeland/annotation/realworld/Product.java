package ir.freeland.annotation.realworld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;

    @Column(name = "product_name") // This specifies the column name in the database
    private String name;

    // Getters and Setters
}