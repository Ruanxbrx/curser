package com.cursrespring.curser.services;

import com.cursrespring.curser.entities.Order;
import com.cursrespring.curser.entities.User;
import com.cursrespring.curser.entities.enums.OrderStatus;
import com.cursrespring.curser.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrderServiceTeste {


    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository repository;

    @Test
    @DisplayName("Deve retornar a lista de Order")
    void deveRetornarListaDeOrder(){
        //cenario
        List<Order> orders = instanciarListaOrder();
        when(repository.findAll()).thenReturn(orders);

        //execução
        List<Order> ordersBuscada = service.findAll();

        //verificação
        assertEquals(orders,ordersBuscada);
    }

    @Test
    @DisplayName("Deve retornar uma Order pelo Id informado")
    void deveBuscarOrderPorId(){
        //cenario
        Order o1 = instanciarOrder();
        when(repository.findById(any())).thenReturn(Optional.of(o1));

        //execução
        Order orderBuscada = service.findById(1L);

        //verificação
         assertEquals(o1, orderBuscada);
    }
    
    private Order instanciarOrder(){
        User u1 = instanciarUsuario();
        return new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    }

    private List<Order> instanciarListaOrder(){
        return Arrays.asList(instanciarOrder(),instanciarOrder(),instanciarOrder());
    }

    private User instanciarUsuario(){
        return new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");}
}
