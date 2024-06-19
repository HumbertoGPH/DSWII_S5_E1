package com.actividad.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.entity.Producto;
import com.actividad.service.ProductoService;

@RestController
@RequestMapping("/url/productos")
public class ProductoController {

    // Creamos el ProductoService
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listaTodos") //http://localhost:8050/url/productos/listaTodos
    public List<Producto> getAllProductos() {
        return productoService.listarProducto();
    }

    @GetMapping("/buscarPorNombre")  //http://localhost:8050/url/productos/buscarPorNombre?nombre=L
    public List<Producto> getProductoByNombre(@RequestParam("nombre") String nombre) {
        return productoService.listaProductoPorNombre(nombre + "%");
    }

    // Para el CRUD DE PRODUCTOS
    @PostMapping("/registrar")  
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            producto.setId_producto(0);

            Producto objSalida = productoService.insertaActualizaCliente(producto);

            salida.put("mensaje", "Producto registrado con ID >>> " + objSalida.getId_producto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaProducto(@RequestBody Producto producto) {

        HashMap<String, Object> salida = new HashMap<>();

        try {

            Producto objSalida = productoService.insertaActualizaCliente(producto);
            salida.put("mensaje", "Producto actualizado de ID >>> " + objSalida.getId_producto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{idprod}")
    public ResponseEntity<?> eliminaCliente(@PathVariable("idprod") int idprod) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productoService.eliminaProducto(idprod);
            salida.put("mensaje", "Producto eliminado de Codigo >>> " + idprod);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{idprod}")
    public ResponseEntity<?> getProductoById(@PathVariable("idprod") int idprod) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto producto = productoService.obtienePorId(idprod).get();
            salida.put("producto", producto);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }

}
