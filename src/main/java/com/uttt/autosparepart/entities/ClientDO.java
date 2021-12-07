package com.uttt.autosparepart.entities;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class ClientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Email")
    private String email;
    @Column(name = "Passw")
    private String password;
    @Column(name = "ApellidoP")
    private String aPaterno;
    @Column(name = "ApellidoM")
    private String amaterno;
    @Column(name = "Terminos")
    private String terminos;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Foto")
    private String foto;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_direccion", referencedColumnName = "id")
    private DirectionDO directionDO;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public DirectionDO getDirection() {
        return directionDO;
    }

    public void setDirection(DirectionDO directionDO) {
        this.directionDO = directionDO;
    }
}
