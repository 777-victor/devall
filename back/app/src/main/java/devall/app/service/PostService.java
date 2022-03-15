package devall.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import devall.app.model.Post;
import devall.app.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> listPost( String search, int page, int size) {

        PageRequest paging = PageRequest.of(page, size, Sort.by("dataPublicacao").descending());
        Page<Post> posts = postRepository.findAll( search, paging );

        return posts;
    }

    @Override
    public Post findById(Long id) throws Exception {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()){
            throw new Exception("Post not found with that Id " + id);
        }
        return post.get();
    }

}