package pe.edu.upeu.sysventas.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.sysventas.model.Categoria;
import pe.edu.upeu.sysventas.repository.CategoriaRepository;
import pe.edu.upeu.sysventas.repository.ICrudGenericRepository;
import pe.edu.upeu.sysventas.service.ICategoriaService;
@Getter
@RequiredArgsConstructor
@Transactional
@Service
public class CategoriaServiceImp extends CrudGenericServiceImp<Categoria,Long> implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    protected ICrudGenericRepository<Categoria, Long> getRepo() {
        return null;
    }

}
