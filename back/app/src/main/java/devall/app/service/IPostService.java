package devall.app.service;

import org.springframework.data.domain.Page;
import devall.app.model.Post;

public interface IPostService {

    Page<Post> listPost(String search, int page, int size);
    Post findById(Long id) throws Exception;
}