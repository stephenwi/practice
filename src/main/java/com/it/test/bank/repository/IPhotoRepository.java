package com.it.test.bank.repository;

import com.it.test.bank.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IPhotoRepository extends JpaRepository<Photo, Integer> {

    public Optional<Photo> findByUrl(String url); // example de query basé sur le nom de colonne

    //Custom query
    @Query("select p from Photo p where p.url = ?1 and p.description = ?2")
    public Optional<Photo> findPhotoByDescriptionOrUrl(String url, String description);

    // Native query
    @Query(value = "select * from photo where url = ?1 and description = ?2", nativeQuery = true)
    public Optional<Photo> findPhotoByDescriptionOrUrlNativeQuery(String url, String description);
}
