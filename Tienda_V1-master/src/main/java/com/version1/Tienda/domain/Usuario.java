
package com.version1.Tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data //indica que va ser una clase de datos
@Entity //va tener una entidad en la base de datos que se va relacionar con la clase
@Table(name="usuario") //se le indica el nombre de la tabla que se quiere obtener informacion 

public class Usuario implements Serializable{
    //Serializable --> indica que la clase va guardar datos 
    
    //Se hace uso del serialVersionUID para autoincremento de la db
    private static final long serialVersionUID = 1L;
    
    @Id //se le indica que la tabla tiene un identificador que es ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Los valores generados que tipo de estrategia usan identico = sea igual en la DB y en la clase 
    @Column(name="id_usuario") //Se le indica el nombre de la columna autoincremental 
    private long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany //Un usuario puede tener muchos roles
    @JoinColumn(name= "id_usuario")
    List<Rol> roles;

}
