package com.ashburn.postgresbase.web;

import com.ashburn.postgresbase.model.Tree;
import com.ashburn.postgresbase.repository.TreeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TreeController {

    private final TreeRepository treeRepository;
    public TreeController(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/trees")
    public List<Tree> findAllTrees() {
        List<Tree> result = new ArrayList<Tree>();
        this.treeRepository.findAll().forEach(result::add);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/trees/{id}")
    public Tree findTree(@PathVariable Long id) {
        Tree found = this.treeRepository.findById(id).orElse(null);
        if(found == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return found;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/trees")
    public Tree addOneTree(@RequestBody Tree tree) {
        return (Tree) this.treeRepository.save(tree);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/trees/{id}")
    public void deleteTree(@RequestBody Long id) {
        this.treeRepository.deleteById(id);
    }
}
