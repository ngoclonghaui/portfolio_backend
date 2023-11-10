package com.example.nglongapi.Controller;

import com.example.nglongapi.Model.Profile;
import com.example.nglongapi.Services.ProfileServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class ProfileController {
    @Autowired
    ProfileServices profileServices;
    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,new JsonDeserializer<LocalDate>(){

        @Override
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();
    @GetMapping(value="getallprofile")
    private List<Profile> layTatCaProfile(){
        return profileServices.getAllProfile();
    }
    @PostMapping(value="postprofile")
    private Profile updateProfile(@RequestBody String profile){
        Profile pf = gson.fromJson(profile,Profile.class);
        return profileServices.updateProfile(pf);
    }
}
