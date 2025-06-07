package com.example.lab9_20212624_gtics.repository;


import com.example.lab9_20212624_gtics.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {


}
