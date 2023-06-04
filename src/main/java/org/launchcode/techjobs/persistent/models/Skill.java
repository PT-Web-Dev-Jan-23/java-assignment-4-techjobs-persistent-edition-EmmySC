package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;


//add a field for a longer description of the skill, named description, with public accessor methods.
//give this class the @Entity annotation and be sure it contains a no-arg constructor.

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 300, message = "the SKILL description must be < 300 characters in length")
    private String description; //Some hiring managers like to have more information available
                                //about the nature of a given programming language or framework

    public Skill() {}

    public Skill(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}