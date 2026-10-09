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
@Table(name = "product_variant")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private int stockKeepingUnit;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Double size;

    @Column(nullable = false)
    private Double extraPrice;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @OneToOne(mappedBy = "productVariant", cascade = CascadeType.ALL)
    private Inventory inventory;

}