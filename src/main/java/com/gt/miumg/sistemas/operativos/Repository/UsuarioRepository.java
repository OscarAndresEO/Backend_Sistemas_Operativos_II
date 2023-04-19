/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Repository;

/**
 *
 * @author Oscar
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Listar solo activos
    //@Query(value = "select * from usuario u where u.estado !='E' order by u.id_usuario asc", nativeQuery = true)
    @Query(value = "select *"+
            "from usuario u\n" +
            " where u.estado!='E'\n" +
            "order by u.id_usuario asc", nativeQuery = true)
    public List<Usuario> listarActivos();

    @Query(value = "select * from usuario u where u.estado !='E' AND u.id_usuario=?1", nativeQuery = true)
    public Usuario usuarioActivoPorId(int id_usuario);

    //Cambiar estado a eliminado logico
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update usuario set estado='E' where id_usuario=?1", nativeQuery = true)
    public void eliminarUsuario(int id_usuario);


    @Query(value = "select * from usuario where username=:username and clave=:clave ", nativeQuery = true)
    public Optional<Usuario> login(@Param("username") String username, @Param("clave") String clave);
}
