package com.example.lab9_20212624_gtics.controller;


import com.example.lab9_20212624_gtics.entity.Proveedor;
import com.example.lab9_20212624_gtics.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String borrarProveedor(@PathVariable Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor != null) {
            proveedor.setEstado(false); // Asumimos que hay un campo 'activo' para el borrado lógico
            proveedorRepository.save(proveedor);
            return "Proveedor borrado lógicamente";
        } else {
            return "Proveedor no encontrado";
        }
    }

    @PostMapping("/crearproveedor")
    public String crearProveedor(@RequestBody Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return "Proveedor creado";
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
