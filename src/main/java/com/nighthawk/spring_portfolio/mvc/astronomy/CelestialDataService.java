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
        celestialData.getCell().setId(String.valueOf(idCounter)); // Set id as a string
        celestialDataList.add(celestialData);
        idCounter++;
        return celestialData;
    }

    public List<CelestialData> getAllData() {
        return celestialDataList;
    }

    public CelestialData getDataById(String id) { // Change parameter and return type to String
        Optional<CelestialData> result = celestialDataList.stream()
                .filter(data -> data.getCell().getId().equals(id))
                .findFirst();
        return result.orElse(null);
    }

    public CelestialData updateData(String id, CelestialData updatedData) { // Change parameter to String
        for (int i = 0; i < celestialDataList.size(); i++) {
            CelestialData data = celestialDataList.get(i);
            if (data.getCell().getId().equals(id)) {
                updatedData.getCell().setId(id); // Set id as a string
                celestialDataList.set(i, updatedData);
                return updatedData;
            }
        }
        return null;
    }

    public boolean deleteData(String id) { // Change parameter to String
        for (int i = 0; i < celestialDataList.size(); i++) {
            CelestialData data = celestialDataList.get(i);
            if (data.getCell().getId().equals(id)) {
                celestialDataList.remove(i);
                return true;
            }
        }
        return false;
    }
}
