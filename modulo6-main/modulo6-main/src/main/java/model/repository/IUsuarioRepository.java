package model.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
