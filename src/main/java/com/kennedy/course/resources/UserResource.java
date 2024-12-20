package com.kennedy.course.resources;

import com.kennedy.course.entities.User;
import com.kennedy.course.servicies.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> u = service.findAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User user = service.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateById(@PathVariable long id, @RequestBody User obj){
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }
}
