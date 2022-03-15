package devall.app.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import devall.app.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PostRepository extends JpaRepository<Post, Long>{

    @Query("SELECT p FROM Post p WHERE p.titulo like CONCAT('%',:search,'%') or p.resumo like CONCAT('%',:search,'%')")
    Page<Post> findAll(@Param("search") String search, Pageable pageable);

}
