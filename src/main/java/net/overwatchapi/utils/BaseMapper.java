package net.overwatchapi.utils;

public interface BaseMapper<E, D> {

	D toDTO(E entity);

	E toEntity(D dto);

}