package pe.edu.upeu.sysventas.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICrudGenericService <T,ID>{
    T save(T t);
    T update(ID id, T t);
    List<T> findAll();
    T findById(ID id);
    void delete(T t);
    void deleteById(ID id);

}
