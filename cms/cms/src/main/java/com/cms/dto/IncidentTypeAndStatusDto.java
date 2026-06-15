package com.cms.dto;

import com.cms.enums.IncidentStatus;
import com.cms.enums.IncidentType;

import java.util.List;

public record IncidentTypeAndStatusDto(
        List<IncidentType> types,
        List<IncidentStatus> status
) {
}
