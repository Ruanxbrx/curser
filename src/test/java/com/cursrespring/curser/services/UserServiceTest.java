package com.cursrespring.curser.services;

import com.cursrespring.curser.entities.User;
import com.cursrespring.curser.repositories.UserRepository;


import com.cursrespring.curser.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    @DisplayName("Deve retornar lista de todos os usuarios")
    void deveRetornarTodosUsuarios(){
        //cenario
        List<User> list = instanciarListaDeUsuario();

        when(repository.findAll()).thenReturn(list);
        //execução
        List<User> usuariosBuscados = service.findAll();

        //verificação
        assertEquals(usuariosBuscados,list);
    }


    @Test
    @DisplayName("Deve retornar um usuario pelo Id informado")
    void deveBuscarUsuarioPorId(){
        //cenario
        User u1 = instanciarUsuario();
        when(repository.findById(1L)).thenReturn(Optional.of(u1));

        //execução
        User obj = service.findById(u1.getId());
        //verificação
        assertEquals(obj,u1);
    }

    @Test
    @DisplayName("Deve retornar uma exeção de usuario pelo Id informado")
    public void deveBuscarUsuarioPorIdExeption() {
        assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(() ->
                service.findById(1L));

    }



    @Test
    @DisplayName("Deve inserir um usuario")
    void deveInserirUmUsuario(){
        //cenario
        User u1 = instanciarUsuario();
        when(repository.save(u1)).thenReturn(u1);

        //execução
        User usuarioSalvo = service.insert(u1);

        //verificação
        assertEquals(usuarioSalvo,u1);
    }

    @Test
    @DisplayName("Deve atualizar um usuario pelo Id e novos atributos")
    void deveAtualizarUmUsuario(){
        //cenario
        User u1 = instanciarUsuario();
        User u2 = new User(1L, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //execução
        updateData(u1,u2);

        //verificaçã
        assertEquals(u1,u2);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
    private User instanciarUsuario(){
        return new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    }
    private List<User> instanciarListaDeUsuario(){
        List<User> usuarios = Arrays.asList(instanciarUsuario(),instanciarUsuario());
        return usuarios;
    }

}
