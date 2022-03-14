package devall.app.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import devall.app.model.Post;


public interface PostRepository extends JpaRepository<Post, Long>{
    
    //Page<Post> findPaginated(PageRequest pageReq);
    Page<Post> findAll(Pageable pageable);

}
