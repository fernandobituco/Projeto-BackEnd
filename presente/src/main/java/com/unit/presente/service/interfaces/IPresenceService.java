package com.unit.presente.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.unit.presente.model.VO.PresenceVO;
import com.unit.presente.model.entity.Presence;

public interface IPresenceService {

    public List<Presence> findAll();

    public Presence create(PresenceVO presenceVO);

    public Presence update(PresenceVO presenceVO, UUID presenceId);

    public void delete(UUID presenceId);

    public void checkPresence(UUID presenceId);
}
