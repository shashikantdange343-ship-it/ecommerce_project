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
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String brandName;

    @Column(nullable = false)
    private String logoUrl;

    @Column(nullable = false)
    private String contactEmail;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "brands")
    private List<Products> products;

}