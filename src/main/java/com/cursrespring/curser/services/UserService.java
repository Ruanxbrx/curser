package com.cursrespring.curser.services;

import com.cursrespring.curser.entities.User;
import com.cursrespring.curser.repositories.UserRepository;
import com.cursrespring.curser.services.exceptions.DatabaseExepetion;
import com.cursrespring.curser.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {return repository.save(obj);    }

    public void delete (Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseExepetion(e.getMessage());

        }
    }

    public User update (Long id, User obj) {
        try {
            User entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseExepetion(e.getMessage());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
