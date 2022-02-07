package com.cursrespring.curser.controllers;

import com.cursrespring.curser.entities.User;
import com.cursrespring.curser.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @Mock
    private UserService service;

    @InjectMocks
    private UserController controller;



    @Test
    @DisplayName("Deve retornar um responseEntity lista de usuarios")
    void deveRetornarUmResponseEntutyListUser(){
        //cenario
        List<User> list = instanciarListaDeUsuario();
        when(service.findAll()).thenReturn(list);

        //execução
        ResponseEntity<List<User>> listBuscado =controller.findALL();

        //verificação
        assertEquals(listBuscado,ResponseEntity.ok().body(list));
    }

    @Test
    @DisplayName("Deve retornar um responseEntity de usuario pelo Id informado")
    void deveRetornarUmResponseEntutyUser(){
        //cenario
        User obj = instanciarUsuario();
        when(service.findById(any())).thenReturn(obj);

        //execução
        ResponseEntity<User> objBuscado = controller.findByID(1L);

        //verificação
        assertEquals(objBuscado,ResponseEntity.ok().body(obj));
    }
    @Test
    @DisplayName("Deve inserir um  usuario")
    void deveInserirUmUsuario(){
        //cenario
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        User obj = instanciarUsuario();
        when(service.insert(any())).thenReturn(obj);

        //execução
        ResponseEntity<User> objInserido = controller.insert(obj);

        //verificaçao
        assertEquals(objInserido.getBody(),obj);
    }

    @Test
    @DisplayName("Deve deletar um User pelo Id informado")
    void deveDeletarUmUserPorId(){
        //execução
        ResponseEntity<Void> obj =controller.delete(1L);

        //verificação
        assertEquals(obj,ResponseEntity.noContent().build());

    }

    @Test
    @DisplayName("Deve atualizar um Usuario pelo Id informado")
    void deveAtualizarUmUserPorId(){
        //cenario
        User obj = instanciarUsuario();
        when(service.update(anyLong(),any())).thenReturn(obj);

        //execução
        ResponseEntity<User> objAtualizado =controller.update(1L,obj);

        //verficação
        assertEquals(obj,objAtualizado.getBody());


    }

    private User instanciarUsuario(){
    return new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
}
    private List<User> instanciarListaDeUsuario(){
        List<User> usuarios = Arrays.asList(instanciarUsuario(),instanciarUsuario());
        return usuarios;
    }
    private URI intanciarURI(User obj) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        return  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
    }

}
