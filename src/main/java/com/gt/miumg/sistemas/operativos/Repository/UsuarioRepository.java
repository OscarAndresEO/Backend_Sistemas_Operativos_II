package com.gt.miumg.sistemas.operativos.Repository;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, Long> {

    public Usuario findByUsername(String username);
}
