package com.kennedy.course.servicies;

import com.kennedy.course.entities.Category;
import com.kennedy.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll(){

        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);

        return category.get();
    }
}
