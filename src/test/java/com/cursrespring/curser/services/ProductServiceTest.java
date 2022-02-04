package com.cursrespring.curser.services;

import com.cursrespring.curser.entities.Product;
import com.cursrespring.curser.repositories.ProductRepository;
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
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    @Test
    @DisplayName("Deve retornar a lista de Products")
    void deveRetornarListaDeProduct(){
        //cenario
        List<Product> products = instanciarListaProduct();
        when(repository.findAll()).thenReturn(products);

        //execução
        List<Product> productsBuscada = service.findAll();

        //verificação
        assertEquals(products,productsBuscada);
    }

    @Test
    @DisplayName("Deve retornar um Product pelo Id informado")
    void deveBuscarProductPorId(){
        //cenario
        Product p1 = instanciarProduct();
        when(repository.findById(any())).thenReturn(Optional.of(p1));

        //execução
        Product productBuscado = service.findById(1L);

        //verificação
        assertEquals(p1, productBuscado);
    }

    private Product instanciarProduct(){
        return new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    }

    private List<Product> instanciarListaProduct(){
        return Arrays.asList(instanciarProduct(),instanciarProduct(),instanciarProduct());
    }
}
