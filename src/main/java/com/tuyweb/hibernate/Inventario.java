package com.tuyweb.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "inventario")
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
    @Column(name = "idProducto") //nmbre de la columna
    private int id;
    
    @Column (name = "Nombre", nullable =false)//el campo no puede ser nulo
    private String nombre;
    
    @Column(name = "Categoria", nullable = false)
    private String categoria;

    @Column(name = "Descripcion", nullable = true)
    private String descripcion;

    @Column(name = "Ubicacion", nullable = true)
    private String ubicacion;
    
    @Column (nullable = false)
    private String password;

    
    //constructor
    public Inventario() {
     
    }
    
    //constructor con parametros

    public Inventario (String nombre, String categoria, String descripcion, String ubicacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    
    //getter y setters
     public int getId() {
        return id;
    }
    
    
     public void setId(int id) {
        this.id = id;
    }
    
     public String getNombre() {
      return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public String getPassword() {//agrega el retorno
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
   
    } 
    
}
