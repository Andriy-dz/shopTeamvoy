package com.example.shopteamvoy.service.mapper;

public interface RequestDtoMapper<T, D> {
    T mapToModel(D dto);
}
