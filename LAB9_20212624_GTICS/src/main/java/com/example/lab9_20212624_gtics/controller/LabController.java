package com.example.lab9_20212624_gtics.controller;


import com.example.lab9_20212624_gtics.entity.Proveedor;
import com.example.lab9_20212624_gtics.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LabController {

    @Autowired
    private ProveedorRepository proveedorRepository;


    //agregaremos los endpoints necesarios para el lab9
    //endpoint testintg



    @GetMapping("/listarproveedores")
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }


    //borrado logico de proveedor
    @PutMapping("/borrarproveedor/{id}")
    public ResponseEntity<HashMap<String, Object>> borrarProveedor(@PathVariable Integer id) {

        try{
            Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
            if (proveedor != null) {
                proveedor.setEstado(false); // Asumimos que hay un campo 'activo' para el borrado lógico
                proveedorRepository.save(proveedor);
                HashMap<String, Object> response = new HashMap<>();
                response.put("message", "Proveedor borrado lógicamente");
                response.put("proveedorid", proveedor.getId());
                return ResponseEntity.ok(response);
            } else {
                HashMap<String, Object> response = new HashMap<>();
                response.put("message", "Proveedor no encontrado");
                return ResponseEntity.status(404).body(response);
            }
        }
        catch (Exception e) {
            HashMap<String, Object> response = new HashMap<>();
            response.put("message", "Error al borrar el proveedor");
            return ResponseEntity.status(500).body(response);
        }
    }
    @PostMapping("/crearproveedor")
    public ResponseEntity<HashMap<String, Object>> guardarProveedor(@RequestBody Proveedor proveedor) {

        HashMap<String, Object> response = new HashMap<>();
        //try-catch
        try{
            proveedorRepository.save(proveedor);
            response.put("message", "Proveedor guardado");
            response.put("proveedorid", proveedor.getId());
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            response.put("message", "Error al guardar el proveedor: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @PutMapping("/actualizarproveedor/{id}")
    public String actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        Proveedor proveedorExistente = proveedorRepository.findById(id).orElse(null);
        if (proveedorExistente != null) {
            proveedorExistente.setRazon_social(proveedor.getRazon_social());
            proveedorExistente.setNombre_comercial(proveedor.getNombre_comercial());
            proveedorExistente.setRuc(proveedor.getRuc());
            proveedorExistente.setTelefono(proveedor.getTelefono());
            proveedorExistente.setCorreo(proveedor.getCorreo());
            proveedorExistente.setWeb(proveedor.getWeb());
            proveedorExistente.setDireccion(proveedor.getDireccion());
            proveedorExistente.setPais(proveedor.getPais());
            proveedorExistente.setRepresentante_legal(proveedor.getRepresentante_legal());
            proveedorExistente.setTipo_de_proveedor(proveedor.getTipo_de_proveedor());

            proveedorExistente.setCategoria(proveedor.getCategoria());
            proveedorExistente.setFacturacion_dolares(proveedor.getFacturacion_dolares());
            proveedorExistente.setFecha_registro(proveedor.getFecha_registro());
            proveedorExistente.setUltima_actualizacion(proveedor.getUltima_actualizacion());
            // Actualizar otros campos según sea necesario

            proveedorRepository.save(proveedorExistente);
            return "Proveedor actualizado";
        } else {
            return "Proveedor no encontrado";
        }
    }


}
