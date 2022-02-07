package com.cursrespring.curser.services;

import com.cursrespring.curser.entities.Category;
import com.cursrespring.curser.repositories.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    @Test
    @DisplayName("Deve retornar a lista de Categories")
    void deveRetornarListaDeCategory(){
        //cenario
        List<Category> categories = instanciarListaCategory();
        when(repository.findAll()).thenReturn(categories);

        //execução
        List<Category> categoriesBuscada = service.findAll();

        //verificação
        assertEquals(categories,categoriesBuscada);
    }

    @Test
    @DisplayName("Deve retornar um Product pelo Id informado")
    void deveBuscarCategoryPorId(){
        //cenario
        Category c1 = instanciarCategory();
        when(repository.findById(any())).thenReturn(Optional.of(c1));

        //execução
        Category categoryBuscado = service.findById(1L);

        //verificação
        assertEquals(c1, categoryBuscado);
    }

    private Category instanciarCategory(){
        return new Category(null, "Electronics");
    }

    private List<Category> instanciarListaCategory(){
        return Arrays.asList(instanciarCategory(), instanciarCategory(), instanciarCategory());
    }
}
