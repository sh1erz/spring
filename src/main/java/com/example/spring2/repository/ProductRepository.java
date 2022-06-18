package com.example.spring2.repository;

import com.example.spring2.model.ProductPage;

import javax.validation.constraints.NotNull;

public interface ProductRepository {

    ProductPage findAll(@NotNull Integer pageNo, @NotNull Integer pageSize, @NotNull String sortBy, @NotNull String direction);

}
