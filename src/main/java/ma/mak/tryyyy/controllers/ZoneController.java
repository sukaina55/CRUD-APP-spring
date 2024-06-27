package ma.mak.tryyyy.controllers;

import lombok.AllArgsConstructor;
import ma.mak.tryyyy.entities.Zone;
import ma.mak.tryyyy.services.ZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneService zoneService;

    @GetMapping
    public List<Zone> listZones() {
        return zoneService.listAllZones();
    }

    @GetMapping("/{id}")
    public Zone getZone(@PathVariable Integer id) {
        return zoneService.getZoneById(id);
    }

    @PostMapping
    public Zone addZone(@RequestBody Zone zone) {
        zoneService.saveZone(zone);
        return zone;
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable Integer id) {
        zoneService.deleteZone(id);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable Integer id, @RequestBody Zone zoneDetails) {
        Zone existingZone = zoneService.getZoneById(id);
        if (existingZone != null) {
            existingZone.setName(zoneDetails.getName());
            zoneService.saveZone(existingZone);
            return existingZone;
        } else {
            throw new RuntimeException("Zone not found with id " + id);
        }
    }
}
