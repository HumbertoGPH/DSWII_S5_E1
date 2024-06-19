package com.actividad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad.entity.Producto;
import com.actividad.repository.ProductoRepository;

@Service // Importante
public class ProductoServiceImpl implements ProductoService {

    // Importante
    @Autowired
    private ProductoRepository repoProducto;

    // Listar todos los productos
    @Override
    public List<Producto> listarProducto() {
        return repoProducto.findAll();
    }

    // Para Agregar y Actualizar
    @Override
    public Producto insertaActualizaCliente(Producto objProd) {
        return repoProducto.save(objProd);
    }

    // Eliminar por id
    @Override
    public void eliminaProducto(int idprod) {
        repoProducto.deleteById(idprod);
    }

    // Buscar por id
    @Override
    public Optional<Producto> obtienePorId(int idprod) {
        return repoProducto.findById(idprod);
    }

    // Buscar por nombre
    @Override
    public List<Producto> listaProductoPorNombre(String nombre) {
        return repoProducto.findByNombreLike(nombre);
    }

}
