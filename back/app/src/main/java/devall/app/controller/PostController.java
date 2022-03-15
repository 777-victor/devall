package devall.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.modelmapper.ModelMapper;
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

     @Autowired
     private ModelMapper modelMapper;

    PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping
    ResponseEntity<Map<String, Object>> listPostPaginated(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {
        try {
            List<PostDto> posts = new ArrayList<PostDto>();
            Page<Post> pagePost = postService.listPost(search, page, size);
            posts = pagePost.getContent()
                            .stream()
                            .map(post -> {
                                post.setUrl(null);
                                return modelMapper.map(post, PostDto.class);
                            })
                            .collect(Collectors.toList());

            Map<String, Object> response = new HashMap<>();
            response.put("posts", posts);
            response.put("currentPage", pagePost.getNumber());
            response.put("totalItems", pagePost.getTotalElements());
            response.put("totalPages", pagePost.getTotalPages());
            response.put("perPage", pagePost.getSize());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clique/{id}")
    public ResponseEntity<Map<String, Object>> postClique(@PathVariable String id) {
        try {

            Post post = postService.findById(Long.parseLong(id));
            PostDto postDto = modelMapper.map(post, PostDto.class);
            post = null;
            Map<String, Object> response = new HashMap<>();
            response.put("post", postDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    private PostDto convertToDto(Post post) {
//        PostDto postDto = modelMapper.map(post, PostDto.class);
//        postDto.setDataInclusao(post.getDataInclusao(),
//                userService.getCurrentUser().getPreference().getTimezone());
//        return postDto;
//    }

    // private PostDto convertToDto(Post post) {
    // PostDto postDto = modelMapper.map(post, PostDto.class);
    // // postDto.setSubmissionDate(post.getSubmissionDate(),
    // // userService.getCurrentUser().getPreference().getTimezone());
    // return postDto;
    // }
}
