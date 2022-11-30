package com.example.demoapp.service;

import javax.validation.constraints.NotNull;

public abstract class GenericCrudService {

    public void validate(@NotNull Long id) {}
}
