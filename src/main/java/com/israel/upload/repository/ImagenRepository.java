package com.israel.upload.repository;

import com.israel.upload.models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    public List<Imagen> findAll();
    public Optional<Imagen> findById(Integer id);
}
