package com.cursrespring.curser.controllers;

import com.cursrespring.curser.entities.Category;
import com.cursrespring.curser.services.CategoryService;
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
public class CategoryControllerTest {

    @Mock
    private CategoryService service;

    @InjectMocks
    private CategoryController controller;

    @Test
    @DisplayName("Response Entity buscar lista de category")
    void deveRertornarUmResponseEntityListaDeCategory(){
        //cenario
        List<Category> list = instanciarListaCategory();
        when(service.findAll()).thenReturn(list);

        //execução
        ResponseEntity<List<Category>> listBuscada = controller.findALL();

        //verificação
        assertEquals(listBuscada,ResponseEntity.ok().body(list));

    }
    @Test
    @DisplayName("Response Entity buscar uma category pelo ID")
    void deveRertornarUmResponseEntityDeCategoryPeloId(){
        //cenario
        Category obj = instanciarCategory();
        when(service.findById(any())).thenReturn(obj);

        //execução
        ResponseEntity<Category> objBuscado = controller.findByID(1L);

        //verificação
        assertEquals(objBuscado,ResponseEntity.ok().body(obj));
    }


    private Category instanciarCategory(){
        return new Category(null, "Electronics");
    }

    private List<Category> instanciarListaCategory(){
        return Arrays.asList(instanciarCategory(), instanciarCategory(), instanciarCategory());
    }

}