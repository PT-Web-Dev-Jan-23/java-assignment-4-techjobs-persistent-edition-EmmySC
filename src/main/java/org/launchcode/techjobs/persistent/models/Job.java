package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


//Since the Job model class has id and name fields, it too can inherit from AbstractEntity.
//Update the class definition of Job to extend AbstractEntity. Remove the redundant fields from Job.

@Entity
public class Job extends AbstractEntity {

//Replace the type of the field employer to be of type Employer.
// Add the @ManyToOne annotation on the field employer
    @ManyToOne
    private Employer employer;

//Update your Job model class to fit its many-to-many relationship with skills.
//Job.skills already exists. What needs to change and/or be added to map this relationship?
//Tip: Be sure to check the whole class for any necessary type updates.
    @NotBlank(message = "please select at least one SKILL")  //needed?
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

//

//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;
//
//    private String employer;
//    private String skills;

    public Job() {
    }

//Need to refactor the affected constructor that uses this field.
    public Job(Employer anEmployer, List<Skill> someSkills) { //public Job(String anEmployer, String someSkills)
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

//Need to refactor the affected getter and setter that use this field

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {  //public String getEmployer()
        return employer;
    }

    public void setEmployer(Employer employer) {  //public void setEmployer(String employer)
        this.employer = employer;
    }

    public List<Skill> getSkills() {  //public String getSkills()
        return skills;
    }

    public void setSkills(List<Skill> skills) {  //public void setSkills(String skills)
        this.skills = skills;
    }
}
