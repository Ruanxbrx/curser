package com.cursrespring.curser.controllers;

import com.cursrespring.curser.entities.Order;
import com.cursrespring.curser.entities.User;
import com.cursrespring.curser.entities.enums.OrderStatus;
import com.cursrespring.curser.services.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    @Test
    @DisplayName("Response Entity buscar lista de order")
    void deveRertornarUmResponseEntityListaDeOrder(){
        //cenario
        List<Order> list = instanciarListaOrder();
        when(service.findAll()).thenReturn(list);

        //execução
        ResponseEntity<List<Order>> listBuscada = controller.findALL();

        //verificação
        assertEquals(listBuscada,ResponseEntity.ok().body(list));

    }
    @Test
    @DisplayName("Response Entity buscar uma order pelo ID")
    void deveRertornarUmResponseEntityDeCategoryPeloId(){
        //cenario
        Order obj = instanciarOrder();
        when(service.findById(any())).thenReturn(obj);

        //execução
        ResponseEntity<Order> objBuscado = controller.findByID(1L);

        //verificação
        assertEquals(objBuscado,ResponseEntity.ok().body(obj));
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
