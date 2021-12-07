package com.uttt.autosparepart.entities;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class ProductDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_producto")
    private String nombre;
    @Column(name = "precio")
    private String precio;
    @Column(name = "stock")
    private String stock;
    @Column(name = "foto")
    private String foto;
    @Column(name = "descripccion")
    private String descripccion;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Id_categoria", referencedColumnName = "id")
    private CategoryDO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public CategoryDO getCategory() {
        return category;
    }

    public void setCategory(CategoryDO category) {
        this.category = category;
    }
}
