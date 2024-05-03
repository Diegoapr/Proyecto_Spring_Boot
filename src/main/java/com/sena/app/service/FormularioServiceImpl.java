//Paquete llamado service
package com.sena.app.service;

//Anotaciones que se importan
import com.sena.app.entities.Formulario;
import com.sena.app.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Se indica que este es un servicio
@Service

//Proporcionará la lógica concreta para las operaciones definidas en la interfaz FormularioService
public class FormularioServiceImpl implements FormularioService{

    //Para inyectar FormularioRepository en la clase. Esto permite el acceso al repositorio
    // para realizar operaciones CRUD en la base de datos
   @Autowired
   private FormularioRepository repository;

   //Se utiliza para indicar que un método en una subclase está sobrescribiendo un método de su superclase
    @Override

    //Este método devuelve una lista de todos los formularios en la base de datos
    public List<Formulario> listarTodosLosFormularios() {
        return repository.findAll();
    }

    @Override

    //Este método guarda un nuevo formulario en la base de datos. Utiliza el método save() del repositorio
    //para guardar el formulario y devuelve el formulario guardado
    public Formulario guardarFormulario(Formulario formulario) {
        return repository.save(formulario);
    }

    @Override

    // Este método recupera un formulario específico de la base de datos utilizando su ID.
    // Utiliza el método findById(id) del repositorio y devuelve el formulario encontrado
    public Formulario obtenerFormularioPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override

    //Este método actualiza un formulario existente en la base de datos.
    //Utiliza el método save() del repositorio para actualizar el formulario y devuelve el formulario actualizado
    public Formulario actualizarFormulario(Formulario formulario) {
        return repository.save(formulario);
    }

    @Override

    // Este método elimina un formulario de la base de datos utilizando su ID.
    // Utiliza el método deleteById(id) del repositorio para eliminar el formulario.
    public void eliminarFormulario(Long id) {
        repository.deleteById(id);

    }
}
