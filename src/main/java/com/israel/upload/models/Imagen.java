package com.israel.upload.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "imagenes")
public class Imagen implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora")
    private Date hora;

    public Imagen(){}
    public Imagen(Integer id, String url, String nombre, Date fecha, Date hora) {
        this.id = id;
        this.url = url;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
