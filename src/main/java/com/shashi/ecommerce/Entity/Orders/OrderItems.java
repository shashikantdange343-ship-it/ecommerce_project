package com.shashi.ecommerce.Entity.Orders;

import com.shashi.ecommerce.Entity.Cart.Cart;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import com.shashi.ecommerce.Entity.ProductsEntity.Products;
import com.shashi.ecommerce.Entity.UsersEntity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private ProductVariant productVariant;

    private Double priceAtThatTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

}