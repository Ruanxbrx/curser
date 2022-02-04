package com.cursrespring.curser.controllers;

import com.cursrespring.curser.entities.Product;
import com.cursrespring.curser.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @Test
    @DisplayName("Response Entity buscar lista de order")
    void deveRertornarUmResponseEntityListaDeProduct(){
        //cenario
        List<Product> list = instanciarListaProduct();
        when(service.findAll()).thenReturn(list);

        //execução
        ResponseEntity<List<Product>> listBuscada = controller.findALL();

        //verificação
        assertEquals(listBuscada,ResponseEntity.ok().body(list));

    }
    @Test
    @DisplayName("Response Entity buscar uma order pelo ID")
    void deveRertornarUmResponseEntityDeCategoryPeloId(){
        //cenario
        Product obj = instanciarProduct();
        when(service.findById(any())).thenReturn(obj);

        //execução
        ResponseEntity<Product> objBuscado = controller.findByID(1L);

        //verificação
        assertEquals(objBuscado,ResponseEntity.ok().body(obj));
    }

    private Product instanciarProduct(){
        return new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    }

    private List<Product> instanciarListaProduct(){
        return Arrays.asList(instanciarProduct(),instanciarProduct(),instanciarProduct());
    }
}
