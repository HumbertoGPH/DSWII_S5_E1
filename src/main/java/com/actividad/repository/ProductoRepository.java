package com.actividad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actividad.entity.Producto;

public interface ProductoRepository  extends JpaRepository<Producto,Integer>{

    public abstract List<Producto> findByNombreLike(String nombre);

}
