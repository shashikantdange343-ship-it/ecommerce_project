package com.shashi.ecommerce.Entity.ProductsEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private int parentCategoryId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "categories")
    private List<Products> products;

}