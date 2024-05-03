//Paquete llamado repository
package com.sena.app.repository;

//Anotaciones que se importan
import com.sena.app.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Anotación Repository para indicar que este un repositorio
@Repository

// Esta interfaz UsuarioRepository proporciona un conjunto de métodos predefinidos para realizar operaciones
// de persistencia en la base de datos relacionadas con la entidad Formulario, como
// guardar, actualizar, eliminar y buscar usuarios, utilizando Spring Data JPA
public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
