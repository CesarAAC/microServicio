package com.MicroServicio.BasedeDatos.repositorio;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import com.MicroServicio.BasedeDatos.modelo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, ObjectId> {

    @Query("{_id: ?0}")
    void eliminarPorId(ObjectId id);

    @Query("{_id: ?0}")
    Optional<Cliente> buscarPorId(ObjectId id);
    
    @Query("{}")
    List<Cliente> findAll();

    @Query("{_id: ?0}")
    @Update("{ $set: { 'clientes.direccion.departamento': ?1, 'clientes.direccion.ciudad': ?2, 'clientes.direccion.direccionFisica': ?3, 'clientes.direccion.codPostal': ?4 } }")
    void editDireccion(ObjectId objectId, String departamento, String ciudad, String direccionFisica, String codPostal);

    @Query("{'_id': ?0}")
    @Update("{ $push: {ofertas: {franquicia:?1, perfil:?2, cupo:?3}}}")
    void addOferta(ObjectId objectId, String franquicia, String perfil, Integer cupo);

    @Query("{'_id': ?0}")
    @Update("{$set: {'nombre': ?1, 'profesion':?2, 'ingresos':?3, 'patrimonio':?4, 'deudas':?5, 'puntaje':?6} }")
    void updateCliente(ObjectId objectId, String nombre, String profesion, Integer ingresos, Integer patrimonio, Integer deudas, Integer puntaje);
}
