package com.actividad.service;

import java.util.List;
import java.util.Optional;

import com.actividad.entity.Producto;

public interface ProductoService {
        //Metodos para hacer un crud
        public abstract List<Producto> listarProducto();
        public abstract Producto insertaActualizaCliente(Producto objProd);
        public abstract void eliminaProducto(int idprod);
        public abstract Optional<Producto> obtienePorId(int idprod);
    
        
        //Para las consultas por query
        public abstract List<Producto> listaProductoPorNombre(String nombre);

}
