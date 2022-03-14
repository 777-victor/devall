package devall.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import devall.app.model.Post;

public interface IPostService {

    //@Query("select * from Post p where p.titulo like '%:search%' or p.resumo like '%:search%' ")
    //Page<Post> listPost(@Param("search") String search, int page, int size);
    Page<Post> listPost(int page, int size);


}