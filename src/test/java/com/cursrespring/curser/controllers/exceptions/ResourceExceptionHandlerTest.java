package com.cursrespring.curser.controllers.exceptions;

import com.cursrespring.curser.services.exceptions.DatabaseExepetion;
import com.cursrespring.curser.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
public class ResourceExceptionHandlerTest {

    @Mock
    private DatabaseExepetion databaseExepetion;

    @Mock
    private ResourceNotFoundException resourceNotFoundException;

    @InjectMocks
    private ResourceExceptionHandler resourceExceptionHandler;

    @Test
    @DisplayName("Deve tratar  Exeption recurso nao encontrado")
    void deveTradaExeptionResourceNotFound(){
        //cenario
        ResourceNotFoundException e = new ResourceNotFoundException(1L);
        MockHttpServletRequest request = new MockHttpServletRequest();

        //execução
        ResponseEntity<StandardError> obj =resourceExceptionHandler.resourceNotFound(e,request);

        //verificação
        assertNotNull(obj);
    }

    @Test
    @DisplayName("Deve tratar  Exeption de Integridade de banco de dados")
    void deveTradaExeptionDeIntegridaDeBanco(){
        //cenario
        DatabaseExepetion e = new DatabaseExepetion("test");
        MockHttpServletRequest request = new MockHttpServletRequest();

        //execução
        ResponseEntity<StandardError> obj =resourceExceptionHandler.database(e,request);

        //verificação
        assertNotNull(obj);
    }

}
