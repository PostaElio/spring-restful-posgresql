package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired // Spring sabe que tiene que instanciarla
    private UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        //Lo casteamos para a un arreglo, para poder devolver un Json
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel){
        //Guardamos y devolvemos el usuario dado
        return usuarioRepository.save(usuarioModel);
    }
    public Optional<UsuarioModel> obtenerUsuaioConId(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<UsuarioModel> obtenerUsuariosConPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }
    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
