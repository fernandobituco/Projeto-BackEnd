package com.unit.presente.model.VO;

import java.sql.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceVO {
    Date date;

    UUID userId;
}
