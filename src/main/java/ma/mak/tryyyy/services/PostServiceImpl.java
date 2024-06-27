package ma.mak.tryyyy.services;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.Post;
import ma.mak.tryyyy.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
