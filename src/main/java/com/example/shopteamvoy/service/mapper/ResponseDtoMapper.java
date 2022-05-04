package com.example.shopteamvoy.service.mapper;

public interface ResponseDtoMapper<T, D> {
    D mapToDto(T t);
}
