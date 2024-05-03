//Paquete llamado service
package com.sena.app.service;

//Anotaciones que se importan
import com.sena.app.entities.Formulario;

import java.util.List;

//En esta interfaz, se definen los métodos que proporcionarán las operaciones básicas para manipular formularios

public interface FormularioService {

    public List<Formulario> listarTodosLosFormularios();

    public Formulario guardarFormulario(Formulario formulario);

    public Formulario obtenerFormularioPorId(Long id);

    public Formulario actualizarFormulario(Formulario formulario);

    public void eliminarFormulario(Long id );

}
