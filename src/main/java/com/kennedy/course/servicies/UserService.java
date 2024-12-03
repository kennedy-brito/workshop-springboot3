package com.kennedy.course.servicies;

import com.kennedy.course.entities.User;
import com.kennedy.course.servicies.exceptions.DataBaseException;
import com.kennedy.course.servicies.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.kennedy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
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

        return obj.orElseThrow( ()-> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(long id){

        Optional<User> user = repository.findById(id);
        user.orElseThrow(() -> new ResourceNotFoundException(id));

        try{
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(long id, User obj){

        try{
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
