package pe.edu.upeu.sysventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysventas.model.Categoria;

public interface CategoriaRepository extends ICrudGenericRepository<Categoria,Long> {
}
