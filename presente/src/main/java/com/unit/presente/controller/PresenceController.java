package com.unit.presente.controller;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.presente.commom.HttpRequest;
import com.unit.presente.model.VO.PresenceVO;
import com.unit.presente.service.interfaces.IPresenceService;


@RestController
@RequestMapping("/presence")
public class PresenceController {
    
    final IPresenceService presenceService;

    
    final Map<String, String> headers = Stream.of(new String[][] {
        {"X-RapidAPI-Key", "c583fa23fdmsh1f477f3deff7695p170de2jsn6e03541b901e"},
        {"X-RapidAPI-Host", "facts-by-api-ninjas.p.rapidapi.com"}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

    public PresenceController(IPresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok().body(presenceService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PresenceVO presenceVO) {
        try {
            return ResponseEntity.ok().body(presenceService.create(presenceVO));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID presenceId, @RequestBody PresenceVO presenceVO) {
        try {
            return ResponseEntity.ok().body(presenceService.update(presenceVO, presenceId));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID presenceId) {
        try {
            presenceService.delete(presenceId);
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> check(@PathVariable(value = "id") UUID presenceId) {
        String fact = new String();
        try {
            presenceService.checkPresence(presenceId);

            HttpRequest request = HttpRequest
                .get("https://facts-by-api-ninjas.p.rapidapi.com/v1/facts")
                .headers(headers)
                .connectTimeout(1000000);
            fact = request.body();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(fact);
    }
}
