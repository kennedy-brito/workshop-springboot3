package com.kennedy.course.servicies;

import com.kennedy.course.entities.User;
import org.springframework.stereotype.Service;
import com.kennedy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

        return obj.get();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public User update(long id, User obj){
        User entity = repository.getReferenceById(id);

        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
