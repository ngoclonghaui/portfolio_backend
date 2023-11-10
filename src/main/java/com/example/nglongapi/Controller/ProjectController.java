package com.example.nglongapi.Controller;

import com.example.nglongapi.Model.Project;
import com.example.nglongapi.Services.ProjectServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class ProjectController {
    @Autowired
    ProjectServices projectServices;
    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,new JsonDeserializer<LocalDate>(){

        @Override
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();
    @GetMapping(value = "getallproject")
    private List<Project> layTatCaProject(){
        return projectServices.getAllProject();
    }
    @PostMapping(value="postproject")
    private Project updateProject(@RequestBody String project){
        Project pj = gson.fromJson(project,Project.class);
        return projectServices.updateProject(pj);
    }
    @PutMapping(value = "addnewproject")
    private Project themMotDuAnMoi(@RequestBody String project){

        return projectServices.addNewProject(gson.fromJson(project,Project.class));
    }
}
