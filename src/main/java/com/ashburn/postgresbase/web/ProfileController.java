package com.ashburn.postgresbase.web;

import com.ashburn.postgresbase.model.Profile;
import com.ashburn.postgresbase.repository.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProfileController {

    private final ProfileRepository profileRepository;
    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/profiles/{id}")
    public Profile findProfile(@PathVariable Long id) {
        Profile found = this.profileRepository.findById(id).orElse(null);
        if(found == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return found;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/profiles")
    public Profile addOneProfile(@RequestBody Profile profile) {
        return this.profileRepository.save(profile);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/profiles{id}")
    public void addOneProfile(@PathVariable Long id) {
        this.profileRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/profiles{id}")
    public Profile replaceProfile(@RequestBody Profile newprofile, @PathVariable Long id) {

        return profileRepository.findById(id)
                .map(profile -> {
                    profile.setEquipment(newprofile.getEquipment());
                    profile.setSpecies(newprofile.getSpecies());
                    profile.setVehicles(newprofile.getVehicles());
                    profile.setUser_id(newprofile.getUser_id());
                    profile.setWorktypes(newprofile.getWorktypes());
                    profile.setUser_name(newprofile.getUser_name());
                    return profileRepository.save(profile);
                })
                .orElseGet(() -> {
                    newprofile.setId(id);
                    return profileRepository.save(newprofile);
                });

    }
}
