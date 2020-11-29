package com.stackroute.Medicine.Service.controller;

//import com.stackroute.domain.Supplier;
//import com.stackroute.service.BlogService;

import com.stackroute.Medicine.Service.domain.Supplier;
import com.stackroute.Medicine.Service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("api/v1")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<Supplier> saveBlog(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(blogService.saveSupplier(supplier), HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<List<Supplier>> getAllBlogs() {
        return new ResponseEntity<List<Supplier>>((List<Supplier>) blogService.getAllSuppliers(),HttpStatus.FOUND);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{id}")
    public ResponseEntity<Supplier> getBlogById(@PathVariable int id){
        return new ResponseEntity<Supplier>(blogService.getSupplierById(id), HttpStatus.FOUND
        );
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Supplier> getBlogAfterDeleting(@PathVariable int id) {
        return new ResponseEntity<Supplier>(blogService.deleteSupplier(id),HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog")
    public ResponseEntity<?> updateBlog(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(blogService.updateSupplier(supplier),HttpStatus.OK);
    }
    @GetMapping("/blog/raw")
    public int   getSupplierNameByRawQuery( @RequestParam("SupplierName") String SupplierName)
    {
        return blogService.getSupplierNameByRawQuery(SupplierName);
    }
}
