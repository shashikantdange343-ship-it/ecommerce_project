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
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private Integer availableQuantity;

    private Integer lowStockThreshold;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "product_variant_id")
    private ProductVariant productVariant;

}