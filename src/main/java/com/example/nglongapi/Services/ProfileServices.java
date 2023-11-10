package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Profile;
import com.example.nglongapi.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServices implements IProfile{
    @Autowired
    ProfileRepository profileRepository;
    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Optional<Profile> profile1 = profileRepository.findById(profile.getId());
        if(profile1.isEmpty()){
            return null;
        }
        Profile pf = profile1.get();
        pf.setId(profile.getId());
        pf.setGioiThieu(profile.getGioiThieu());
        pf.setLinkAnh(profile.getLinkAnh());
        pf.setName(profile.getName());
        profileRepository.save(pf);
        return pf;
    }

    @Override
    public Profile deleteProfile(int id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if(profile.isEmpty()){
            return null;
        }
        profileRepository.delete(profile.get());
        return profile.get();
    }

    @Override
    public Profile addNewProfile(Profile profile) {
        profileRepository.save(profile);
        return profile;
    }
}
