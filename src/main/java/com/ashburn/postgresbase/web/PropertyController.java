package com.ashburn.postgresbase.web;

import com.ashburn.postgresbase.model.Property;
import com.ashburn.postgresbase.repository.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PropertyController {

    private final PropertyRepository propertyRepository;
    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/properties")
    public List<Property> findAllProperties() {
        List<Property> result = new ArrayList<Property>();
        this.propertyRepository.findAll().forEach(result::add);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/properties/{id}")
    public Property findProperty(@PathVariable Long id) {
        Property found = this.propertyRepository.findById(id).orElse(null);
        if(found == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return found;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/properties")
    public Property addOneProperty(@RequestBody Property prop) {
        return this.propertyRepository.save(prop);
    }
}
