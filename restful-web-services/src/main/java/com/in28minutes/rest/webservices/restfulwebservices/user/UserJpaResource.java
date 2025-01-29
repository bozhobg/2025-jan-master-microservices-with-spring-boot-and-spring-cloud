package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserDaoService service;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(
            UserDaoService service
            , UserRepository userRepository
            , PostRepository postRepository
    ) {
        this.service = service;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(
            path = "/jpa/users"
//            , produces = {"application/json", "application/xml"}
    )
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //    HATEOS implementation
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserDetails(@PathVariable int id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) throw new UserNotFoundException("id:" + id);

        User user = optionalUser.get();

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPostsForUser(@PathVariable int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id:" + id));

        return user.getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPost(
            @PathVariable Integer id
            , @RequestBody @Valid Post post
    ) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id:" + id));

        Post newPost = postRepository.save(post.setUser(user));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.getId())
                .toUri();

        return ResponseEntity
                .created(location)
//                .body(newPost);
                .body(newPost);
    }

//    "/posts/{id}
    @GetMapping("/jpa/posts/{id}")
    public Post getPostDetails(@PathVariable Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("id: " + id));
    }
}
