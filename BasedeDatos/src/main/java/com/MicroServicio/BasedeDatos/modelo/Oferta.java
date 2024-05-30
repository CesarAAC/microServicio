package com.MicroServicio.BasedeDatos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ofertas")
public class Oferta {
    @Id
    private ObjectId id;
    private String franquicia;
    private String perfil;
    private Integer cupo;

    public Oferta(){}

    public Oferta(ObjectId id, String franquicia, String perfil, Integer cupo) {
        this.id = id;
        this.franquicia = franquicia;
        this.perfil = perfil;
        this.cupo = cupo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    
    
}
