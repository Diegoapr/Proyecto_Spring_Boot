//Paquete llamado controller
package com.sena.app.controller;

//Anotaciones que se importan
import com.sena.app.entities.Formulario;
import com.sena.app.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//Esta anotación es para especificar que este es un controlador
@Controller

// Esta es la clase
public class FormularioControlador {

    // Esto sirve para hacer una inyeccion de dependencias al servicio
    @Autowired

    //LLamamos los servicios que se van utilizar
    private FormularioService service;

    //Se hace referncia a los metodos HTTP


    // Se obtendra una ista de todos los usuarios almacenados en la base de datos

    @GetMapping({"/formularios","/"})
    public String listarFormularios(Model modelo){
        modelo.addAttribute("formularios",service.listarTodosLosFormularios());
        return "formularios";
    }

    // Aqui se redirecciona a un formulario nuevo para poderlo crear

    @GetMapping("/formularios/nuevo")
    public String crearFormularioDocumento(Model modelo){
        Formulario formulario = new Formulario();
        modelo.addAttribute("formulario", formulario);
        return "crear_formulario";
    }

    //Este código maneja las solicitudes POST enviadas a "/formularios", guarda los datos del formulario
    // y luego redirige al usuario a la página que muestra la lista de formularios.

    @PostMapping("/formularios")
    public String guardarFormulario(@ModelAttribute("formulario") Formulario formulario){
        service.guardarFormulario(formulario);
        return "redirect:/formularios";
    }

    //Este código maneja las solicitudes GET para mostrar un formulario específico que se va a editar

    @GetMapping("/formularios/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id,Model modelo){
        modelo.addAttribute("formulario",service.obtenerFormularioPorId(id));
        return "editar_formulario";
    }

    //Este código maneja las solicitudes POST para actualizar un formulario existente en la base de datos,
    //y luego redirige al usuario a la página que muestra la lista de formularios.

    @PostMapping("/formularios/{id}")
    public String actualizarFormulario(@PathVariable long id,@ModelAttribute("formulario") Formulario formulario) {
        Formulario formularioExistente = service.obtenerFormularioPorId(id);
        formularioExistente.setId(id);
        formularioExistente.setEntidad(formulario.getEntidad());
        formularioExistente.setTipo(formulario.getTipo());
        formularioExistente.setPresupuesto(formulario.getPresupuesto());
        formularioExistente.setEspecificaciones(formulario.getEspecificaciones());
        formularioExistente.setRequerimientos(formulario.getRequerimientos());
        formularioExistente.setEtapa(formulario.getEtapa());
        formularioExistente.setObservaciones(formulario.getObservaciones());
        formularioExistente.setUbicacion(formulario.getUbicacion());

        service.actualizarFormulario(formularioExistente);
        return "redirect:/formularios";
    }

    //Maneja las solicitudes GET para eliminar un formulario existente en la base de datos y
    //luego redirige al usuario a la página que muestra la lista de formularios actualizada.

    @GetMapping("/formularios/{id}")
    public String eliminarFormulario(@PathVariable Long id) {
    service.eliminarFormulario(id);
    return "redirect:/formularios";
    }

}
