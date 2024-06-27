package ma.mak.tryyyy.services;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.Zone;
import ma.mak.tryyyy.repositories.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;

    @Override
    public List<Zone> listAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Integer id) {
        Optional<Zone> optionalZone = zoneRepository.findById(id);
        return optionalZone.orElse(null);
    }

    @Override
    public void saveZone(Zone zone) {
        zoneRepository.save(zone);
    }

    @Override
    public void deleteZone(Integer id) {
        zoneRepository.deleteById(id);
    }
}
