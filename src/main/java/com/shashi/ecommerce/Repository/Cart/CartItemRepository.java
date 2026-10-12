package com.shashi.ecommerce.Repository.Cart;

import com.shashi.ecommerce.Entity.Cart.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Long> {
    Optional<List<CartItems>> findByCartId(long cartId);
}
