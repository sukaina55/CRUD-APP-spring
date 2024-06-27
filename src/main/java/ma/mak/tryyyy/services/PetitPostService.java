package ma.mak.tryyyy.services;

import ma.mak.tryyyy.entities.PetitPost;

import java.util.List;

public interface PetitPostService {
    List<PetitPost> listAllPetitPosts();
    PetitPost getPetitPostById(Integer id);
    void savePetitPost(PetitPost petitPost);
    void deletePetitPost(Integer id);
}
