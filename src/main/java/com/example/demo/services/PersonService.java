package com.example.demo.services;

import com.example.demo.repositories.PersonRepository;
import com.example.demo.viewmodels.PersonCreateViewModel;
import com.example.demo.viewmodels.PersonListViewModel;
import com.example.demo.viewmodels.PersonUpdateViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonListViewModel> getAll() {
        return null;
    }

    @Override
    public PersonListViewModel getById(int id) {
        return null;
    }

    @Override
    public void update(PersonUpdateViewModel viewModel, int id) {

    }

    @Override
    public void create(PersonCreateViewModel viewModel) {

    }

    @Override
    public void delete(int id) {

    }
}
