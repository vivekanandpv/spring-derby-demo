package com.example.demo.controllers;

import com.example.demo.exceptions.DomainValidationException;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.services.IPersonService;
import com.example.demo.viewmodels.PersonCreateViewModel;
import com.example.demo.viewmodels.PersonListViewModel;
import com.example.demo.viewmodels.PersonUpdateViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonListViewModel> getAll() {
        return this.personService.getAll();
    }

    @GetMapping("{id}")
    public PersonListViewModel getById(@PathVariable int id) {
        return this.personService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody PersonCreateViewModel viewModel) {
        this.personService.create(viewModel);
    }

    @PutMapping("{id}")
    public void update(@RequestBody PersonUpdateViewModel viewModel, @PathVariable int id) {
        this.personService.update(viewModel, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.personService.delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException rnfe) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> handleDomainValidationException(DomainValidationException dve) {
        return ResponseEntity.badRequest().build();
    }
}
