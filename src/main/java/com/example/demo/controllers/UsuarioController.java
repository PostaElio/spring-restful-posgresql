package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired//AutoSET?
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<ArrayList<UsuarioModel>> obtenerUsuarios(){
        return new ResponseEntity<>(usuarioService.obtenerUsuarios(),HttpStatus.OK);
    }

    @PostMapping()
    //Agrega y actualiza los datos si se le especifica el id
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.guardarUsuario(usuarioModel);
    }

    @GetMapping(path = "/{id}") //localhost:8080/usuario/{id}
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerUsuaioConId(id);
    }

    @GetMapping("/query") //localhost:8080/usuario/query?prioridad=VARIABLE
    public ArrayList<UsuarioModel> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerUsuariosConPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id")Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id "+id;
        }else{
            return "No se pudo eliminar al usuario con id "+id;
        }
    }
}
