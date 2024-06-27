package ma.mak.tryyyy.controllers;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.PetitPost;
import ma.mak.tryyyy.services.PetitPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/petitPosts")
public class PetitPostController {

    private final PetitPostService petitPostService;

    @GetMapping
    public List<PetitPost> listPetitPosts() {
        return petitPostService.listAllPetitPosts();
    }

    @GetMapping("/{id}")
    public PetitPost getPetitPost(@PathVariable Integer id) {
        return petitPostService.getPetitPostById(id);
    }

    @PostMapping
    public PetitPost addPetitPost(@RequestBody PetitPost petitPost) {
        petitPostService.savePetitPost(petitPost);
        return petitPost;
    }

    @DeleteMapping("/{id}")
    public void deletePetitPost(@PathVariable Integer id) {
        petitPostService.deletePetitPost(id);
    }

    @PutMapping("/{id}")
    public PetitPost updatePetitPost(@PathVariable Integer id, @RequestBody PetitPost petitPostDetails) {
        PetitPost existingPetitPost = petitPostService.getPetitPostById(id);
        if (existingPetitPost != null) {
            existingPetitPost.setName(petitPostDetails.getName());
            petitPostService.savePetitPost(existingPetitPost);
            return existingPetitPost;
        } else {
            throw new RuntimeException("PetitPost not found with id " + id);
        }
    }
}
