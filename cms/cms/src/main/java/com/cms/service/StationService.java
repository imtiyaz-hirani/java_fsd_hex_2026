package com.cms.service;

import com.cms.dto.IncidentStationDto;
import com.cms.exception.ResourceNotFoundException;
import com.cms.mapper.StationMapper;
import com.cms.model.Officer;
import com.cms.model.Station;
import com.cms.repository.IncidentRepository;
import com.cms.repository.OfficerRepository;
import com.cms.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StationService {
   private final IncidentRepository incidentRepository;
   private final StationRepository stationRepository;
    private final OfficerRepository officerRepository;

    public IncidentStationDto getStationByIncidentId(int incidentId) {
        incidentRepository.findById(incidentId)
                .orElseThrow(()-> new ResourceNotFoundException("Incident Not Found"));
        Station station = stationRepository.getStationByIncidentId(incidentId);
        // get officer for this incident
        Officer officer = officerRepository.getByIncidentId(incidentId);

        // convert station to IncidentStationDto
        return StationMapper.fromEntityToDto(station, officer);

    }

    public Station getById(int stationId) {
        return stationRepository.findById(stationId)
                .orElseThrow(()-> new ResourceNotFoundException("Station Invalid"));
    }
}
