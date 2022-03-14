package devall.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devall.app.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
