package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProfile {
    public List<Profile> getAllProfile();
    public Profile updateProfile(Profile profile);
    public Profile deleteProfile(int id);
    public Profile addNewProfile(Profile profile);
}
