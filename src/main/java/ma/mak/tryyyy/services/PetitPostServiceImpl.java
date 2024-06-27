package ma.mak.tryyyy.services;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.PetitPost;
import ma.mak.tryyyy.repositories.PetitPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetitPostServiceImpl implements PetitPostService {

    private final PetitPostRepository petitPostRepository;

    @Override
    public List<PetitPost> listAllPetitPosts() {
        return petitPostRepository.findAll();
    }

    @Override
    public PetitPost getPetitPostById(Integer id) {
        Optional<PetitPost> optionalPetitPost = petitPostRepository.findById(id);
        return optionalPetitPost.orElse(null);
    }

    @Override
    public void savePetitPost(PetitPost petitPost) {
        petitPostRepository.save(petitPost);
    }

    @Override
    public void deletePetitPost(Integer id) {
        petitPostRepository.deleteById(id);
    }
}
