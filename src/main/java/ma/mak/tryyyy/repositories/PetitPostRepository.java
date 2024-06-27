package ma.mak.tryyyy.repositories;

import ma.mak.tryyyy.entities.PetitPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetitPostRepository extends JpaRepository<PetitPost, Integer> {
}
