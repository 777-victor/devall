package devall.app.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import devall.app.model.Post;
import devall.app.repository.PostRepository;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> listPost( int page, int size) {

        PageRequest paging = PageRequest.of(page, size, Sort.by("dataPublicacao").descending());
        Page<Post> posts = postRepository.findAll( paging );

        return posts;
    }

    // public static Specification<Post> searchByTituloOrResumo(String search){
    //     return new Specification<Post>(){
    //         public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query,
    //         CriteriaBuilder builder) {

    //             // build query here
    //         }
    //     }
    // }

}