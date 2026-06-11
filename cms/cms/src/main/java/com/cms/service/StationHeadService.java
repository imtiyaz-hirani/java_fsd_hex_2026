package com.cms.service;

import com.cms.dto.CombinedStatDto;
import com.cms.dto.StationDto;
import com.cms.mapper.StationMapper;
import com.cms.model.Incident;
import com.cms.model.Officer;
import com.cms.model.Station;
import com.cms.repository.StationHeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationHeadService {

private final StationHeadRepository stationHeadRepository;

    public CombinedStatDto getCombinedStats(String stationHeadUsername) {
        // Step 1 : Fetch all incidents for give station head
        List<Incident> listIncident = stationHeadRepository.getAllIncidentsByStationHead(stationHeadUsername);

        // Step 2 : Fetch all officers regardless of weather they are handling incidents or not
        List<Officer> listOfficer = stationHeadRepository.getAllOfficers(stationHeadUsername);

        // Fetch Station from List of Officer
        List<Station> listStation = stationHeadRepository.getAllStations(stationHeadUsername);

        List<String> label = List.of("Incident", "Officer", "Station");
        List<Long> count = List.of((long) listIncident.size(), (long) listOfficer.size() , (long) listStation.size());

        return new CombinedStatDto(label,count);
    }

    public List<StationDto> getAllStations(String stationHeadUsername) {
        List<Station> list = stationHeadRepository.getAllStations(stationHeadUsername);
        // Convert Station Entity to StationDto
        return list.stream()
                .map(StationMapper :: entityToDto)
                .toList();
    }
}
/*
select

where sh.user.username = ?1


List<Incident>
   each incident: List<Officer>   : List<Station>


* */