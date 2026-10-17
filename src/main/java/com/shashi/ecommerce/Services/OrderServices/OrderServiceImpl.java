package com.shashi.ecommerce.Services.OrderServices;

import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderDTOs;
import com.shashi.ecommerce.Entity.Orders.OrderItems;
import com.shashi.ecommerce.Entity.Orders.OrderStatus;
import com.shashi.ecommerce.Entity.Orders.Orders;
import com.shashi.ecommerce.Entity.UsersEntity.Addresses;
import com.shashi.ecommerce.Entity.UsersEntity.User;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.Orders.OrderRepository;
import com.shashi.ecommerce.Repository.UserRepositories.AddressRepository;
import com.shashi.ecommerce.Services.ClassConverterService;
import com.shashi.ecommerce.Services.UserServices.AddressesService;
import com.shashi.ecommerce.Services.UserServices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final OrderItemService orderItemService;

    private final UserService userService;

    private final ClassConverterService classConverterService;

    private final AddressesService addressesService;


    @Override
    public OrderDTOs.OrderResponse handleOrders(OrderDTOs.OrderRequestDTO order, String userName) {

        User user = userService.getUser(userName);

        Orders order1 = new Orders();

        List<OrderItems> orderItemsList = order.orderItems().stream().map(orderItemService::AddOrderItems).toList();

        Double totalAmount = 0.0;

        for (OrderItems items : orderItemsList){
            items.setOrders(order1);
            totalAmount = totalAmount + items.getPriceAtThatTime()*items.getQuantity()
                    +items.getProductVariant().getExtraPrice();
        }

        order1.setOrderItems(orderItemsList);
        order1.setTotalAmount(totalAmount);
        order1.setUser(user);
        order1.setAddresses(addressesService.getAddress(order.addressId()));
        order1.setStatus(OrderStatus.valueOf("CONFIRMED"));
        orderRepository.save(order1);

        return new OrderDTOs.OrderResponse("Order placed successfully !");
    }


    public OrderDTOs.OrderDetailsListDTO ordersList(String userName ){

        User user = userService.getUser(userName);

        if(user.getOrders() == null){
            throw new ResourceNotFoundException("No Order Made Yet !");
        }

        return new OrderDTOs.OrderDetailsListDTO(user.getOrders().stream().map(classConverterService::toOrderDetailsDTO).toList());
    }
}
