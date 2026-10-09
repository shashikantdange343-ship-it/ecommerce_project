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
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Double basePrice;

    @Column(nullable = false)
    private String baseDescription;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brands brands;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<ProductVariant> productVariant;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<ProductImages> productImages;

}
