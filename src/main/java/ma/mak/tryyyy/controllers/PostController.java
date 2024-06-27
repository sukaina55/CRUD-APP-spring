package ma.mak.tryyyy.controllers;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.Post;
import ma.mak.tryyyy.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> listPosts() {
        return postService.listAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        postService.savePost(post);
        return post;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post postDetails) {
        Post existingPost = postService.getPostById(id);
        if (existingPost != null) {
            existingPost.setName(postDetails.getName());
            postService.savePost(existingPost);
            return existingPost;
        } else {
            throw new RuntimeException("Post not found with id " + id);
        }
    }
}
