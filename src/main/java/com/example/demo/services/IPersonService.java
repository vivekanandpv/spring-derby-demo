package com.example.demo.services;


import com.example.demo.viewmodels.PersonCreateViewModel;
import com.example.demo.viewmodels.PersonListViewModel;
import com.example.demo.viewmodels.PersonUpdateViewModel;

import java.util.List;

public interface IPersonService {
    List<PersonListViewModel> getAll();
    PersonListViewModel getById(int id);
    void update(PersonUpdateViewModel viewModel, int id);
    void create(PersonCreateViewModel viewModel);
    void delete(int id);
}
