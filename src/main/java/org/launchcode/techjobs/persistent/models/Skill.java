package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


//add a field for a longer description of the skill, named description, with public accessor methods.
//give this class the @Entity annotation and be sure it contains a no-arg constructor.

@Entity
public class Skill extends AbstractEntity {

//add a jobs field.
//What type should this field be? Initialize it in the field declaration accordingly. --> private
//Add a getter and setter for the field.
//This field has a many-to-many type relationship with skills. Add @ManyToMany annotation with argument
//mappedBy="skills" to configure this mapping.
    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    @NotBlank(message = "a DESCRIPTION is required")
    @Size(max = 300, message = "the SKILL description must be < 300 characters in length")
    private String description; //Some hiring managers like to have more information available
                                //about the nature of a given programming language or framework

    public Skill() {}

    public Skill(String description) {
        this.description = description;
    }

//Getters & Setters//
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}