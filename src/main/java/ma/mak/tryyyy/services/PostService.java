package ma.mak.tryyyy.services;

import ma.mak.tryyyy.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> listAllPosts();
    Post getPostById(Integer id);
    void savePost(Post post);
    void deletePost(Integer id);
}
