package ma.mak.tryyyy.services;

import ma.mak.tryyyy.entities.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> listAllZones();
    Zone getZoneById(Integer id);
    void saveZone(Zone zone);
    void deleteZone(Integer id);
}
