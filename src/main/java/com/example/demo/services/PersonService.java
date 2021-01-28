package com.example.demo.services;

import com.example.demo.exceptions.DomainValidationException;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.viewmodels.PersonCreateViewModel;
import com.example.demo.viewmodels.PersonListViewModel;
import com.example.demo.viewmodels.PersonUpdateViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonListViewModel> getAll() {
        return this.personRepository.findAll()
                .stream()
                .map(p -> new PersonListViewModel(
                        p.getFirstName(),
                        p.getLastName(),
                        p.getEmail(),
                        p.getPhone()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public PersonListViewModel getById(int id) {
        Person person
                = this.personRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Could not find: " + id));

        return new PersonListViewModel(
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhone());
    }

    @Override
    public void update(PersonUpdateViewModel viewModel, int id) {
        //  viewModel's id and id should match
        if (viewModel.getId() != id) {
            throw new DomainValidationException("Id does not match");
        }

        //  id should exist
        Person personDb
                = this.personRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Could not find: " + id));


        //  update
        BeanUtils.copyProperties(viewModel, personDb);

        //  save
        this.personRepository.saveAndFlush(personDb);
    }

    @Override
    public void create(PersonCreateViewModel viewModel) {
        Person person = new Person();
        BeanUtils.copyProperties(viewModel, person);
        this.personRepository.saveAndFlush(person);
    }

    @Override
    public void delete(int id) {
       if (this.personRepository.existsById(id)) {
           this.personRepository.deleteById(id);
       } else {
           throw new RecordNotFoundException("Could not find: " + id);
       }
    }
}
