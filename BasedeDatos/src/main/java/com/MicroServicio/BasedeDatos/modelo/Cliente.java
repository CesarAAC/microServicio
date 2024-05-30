package com.MicroServicio.BasedeDatos.modelo;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
    @Id
    private ObjectId id;
    private String nombre;
    private String profesion;
    private Integer ingresos;
    private Integer patrimonio;
    private Integer deudas;
    private Integer puntaje;
    private ArrayList<Oferta> ofertas;

    public Cliente(){}

    public Cliente(ObjectId id, String nombre, String profesion, Integer ingresos, Integer patrimonio, Integer deudas) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
        this.ingresos = ingresos;
        this.patrimonio = patrimonio;
        this.deudas = deudas;
        this.puntaje= calcularPuntaje(ingresos, patrimonio, deudas);
        this.ofertas = calcularOfertas(deudas);
    }

    public Integer calcularPuntaje(Integer Ingresos, Integer patrimonio, Integer deuda){
        if(deuda<=0){
        deuda=1;
        }
        return  (ingresos + patrimonio) / deudas;
    }

    public ArrayList<Oferta> calcularOfertas(Integer puntaje){
        ArrayList<Oferta> respuesta = new ArrayList<Oferta>();
        List<String> perfiles = new ArrayList<>();

        if (puntaje >= 2.0) {
            perfiles.add("Negra");
        }
        if (puntaje >= 1.5) {
            perfiles.add("Oro");
        }
        if (puntaje >= 1.0) {
            perfiles.add("Plata");
            perfiles.add("Standard");
        }
        if (puntaje < 1.0) {
            return respuesta;
        }

        String[] franquicias = {"MasterCard", "Visa"};

        for (String franquicia : franquicias) {
            for (String perfil : perfiles) {
                int cupo;
                if (perfil.equals("Negra")) {
                    cupo = (int) (Math.random() * (200 - 51) + 51);
                } else if (perfil.equals("Oro")) {
                    cupo = (int) (Math.random() * (50 - 6) + 6);
    	        } else {
        	        cupo = (int) (Math.random() * (5 - 2) + 2);
    	        }
                Oferta oferta = new Oferta(null, franquicia, perfil, cupo);
                respuesta.add(oferta);
            }
        }
        return respuesta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Integer getIngresos() {
        return ingresos;
    }

    public void setIngresos(Integer ingresos) {
        this.ingresos = ingresos;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Integer getDeudas() {
        return deudas;
    }

    public void setDeudas(Integer deudas) {
        this.deudas = deudas;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    
}