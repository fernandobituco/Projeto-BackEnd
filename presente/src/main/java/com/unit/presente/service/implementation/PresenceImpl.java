package com.unit.presente.service.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.unit.presente.model.VO.PresenceVO;
import com.unit.presente.model.entity.Presence;
import com.unit.presente.model.entity.User;
import com.unit.presente.repository.PresenceRepository;
import com.unit.presente.repository.UserRepository;
import com.unit.presente.service.interfaces.IPresenceService;

import jakarta.transaction.Transactional;

@Service
public class PresenceImpl implements IPresenceService {

    final PresenceRepository presenceRepository;
    final UserRepository userRepository;

    public PresenceImpl(PresenceRepository presenceRepository, UserRepository userRepository) {
        this.presenceRepository = presenceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Presence> findAll() {
        return presenceRepository.findAll();
    }

    @Transactional
    public Presence create(PresenceVO presenceVO) {
        User user = userRepository.findById(presenceVO.getUserId()).get();
        Presence presence = new Presence(presenceVO, user);
        presenceRepository.save(presence);
        return presence;
    }

    @Transactional
    public Presence update(PresenceVO presenceVO, UUID presenceId) {
        Presence presence = presenceRepository.findById(presenceId).get();
        User user = userRepository.findById(presenceVO.getUserId()).get();
        presence.setDate(presence.getDate());
        presence.setUser(user);
        return presence;
    }

    @Transactional
    public void delete(UUID presenceId) {
        presenceRepository.deleteById(presenceId);
    }

    @Transactional
    public void checkPresence(UUID presenceId) {
        Presence presence = presenceRepository.findById(presenceId).get();
        presence.setChecked(true);
    }
    
}
