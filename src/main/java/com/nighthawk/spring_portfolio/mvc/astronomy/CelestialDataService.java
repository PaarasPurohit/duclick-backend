package com.nighthawk.spring_portfolio.mvc.astronomy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@Service
public class CelestialDataService {
    private List<CelestialData> celestialDataList = new ArrayList<>();
    private Long idCounter = 1L;

    @Autowired
    public CelestialDataService() {
    }

    @PostConstruct
    public void initialize() {
        // You can add initial data here if needed
    }

    public CelestialData storeData(CelestialData celestialData) {
        celestialData.setId(idCounter);
        celestialDataList.add(celestialData);
        idCounter++;
        return celestialData;
    }

    public List<CelestialData> getAllData() {
        return celestialDataList;
    }

    public CelestialData getDataById(Long id) {
        Optional<CelestialData> result = celestialDataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst();
        return result.orElse(null);
    }

    public CelestialData updateData(Long id, CelestialData updatedData) {
        for (int i = 0; i < celestialDataList.size(); i++) {
            CelestialData data = celestialDataList.get(i);
            if (data.getId().equals(id)) {
                updatedData.setId(id);
                celestialDataList.set(i, updatedData);
                return updatedData;
            }
        }
        return null;
    }

    public boolean deleteData(Long id) {
        for (int i = 0; i < celestialDataList.size(); i++) {
            CelestialData data = celestialDataList.get(i);
            if (data.getId().equals(id)) {
                celestialDataList.remove(i);
                return true;
            }
        }
        return false;
    }
}
