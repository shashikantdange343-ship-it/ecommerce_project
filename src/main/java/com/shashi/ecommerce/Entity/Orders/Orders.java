package com.shashi.ecommerce.Entity.Orders;

import com.shashi.ecommerce.Entity.Cart.CartItems;
import com.shashi.ecommerce.Entity.ProductsEntity.Products;
import com.shashi.ecommerce.Entity.UsersEntity.Addresses;
import com.shashi.ecommerce.Entity.UsersEntity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Double totalAmount;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Addresses addresses;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

}