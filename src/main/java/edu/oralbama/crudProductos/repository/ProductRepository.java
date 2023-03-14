package edu.oralbama.crudProductos.repository;

import edu.oralbama.crudProductos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto,String> {
    @Modifying
    //Implementaion de una query ya que el metodo actualizar que trae JPA no nos funciona para este caso
    @Query("UPDATE Producto u SET u.name=:name, u.description=:description, u.price=:price, u.stock=:stock WHERE u.name=:name")
    public int update(String name, String description, String price, int stock);

}
