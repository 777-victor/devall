package devall.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devall.app.dto.PostDto;
import devall.app.model.Post;
import devall.app.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    // @Autowired
    // private ModelMapper modelMapper;

    PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> listPostPaginated(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {
        try {
            // repositoy.listPostPaginated();
            // Pageable paging = PageRequest.of(page, size);
            List<Post> posts = new ArrayList<Post>();
            Page<Post> pagePost;
            pagePost = postService.listPost(page, size);
            posts = pagePost.getContent();

            SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                    SimpleBeanPropertyFilter.serializeAllExcept("url");
            FilterProvider filters = new SimpleFilterProvider()
                    .addFilter("userFilter", simpleBeanPropertyFilter);
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(posts);
            mappingJacksonValue.setFilters(filters);
            System.out.println(mappingJacksonValue);
            //posts = mappingJacksonValue;

            Map<String, Object> response = new HashMap<>();
            response.put("posts", posts);
            response.put("currentPage", pagePost.getNumber());
            response.put("totalItems", pagePost.getTotalElements());
            response.put("totalPages", pagePost.getTotalPages());
            response.put("perPage", pagePost.getSize());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clique/{id}")
    public ResponseEntity<Map<String, Object>> postClicque(@PathVariable String id){
        try{

            Map<String, Object> response = new HashMap<>();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    // private PostDto convertToDto(Post post) {
    //     PostDto postDto = modelMapper.map(post, PostDto.class);
    //     // postDto.setSubmissionDate(post.getSubmissionDate(), 
    //     //     userService.getCurrentUser().getPreference().getTimezone());
    //     return postDto;
    // }
}
