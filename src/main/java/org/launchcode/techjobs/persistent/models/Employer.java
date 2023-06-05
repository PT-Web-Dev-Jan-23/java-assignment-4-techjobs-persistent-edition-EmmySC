package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//In addition to the fields inherited from AbstractEntity, Employer should have a string field for location.
//Add the field for location with validation that ensures it is not empty and has a reasonable length.
//In addition, add public accessor methods to Employer.
//Employer is a class that will be mapped to one of our tables. Make sure the class has the @Entity annotation,
//as well as the no-arg constructor required for Hibernate to create an object.

@Entity
public class Employer extends AbstractEntity {


//Within Employer, add a private property jobs of type List<Job> and initialize it to an empty ArrayList.
//After setting up Job class to work w/ Employer objects, this list will represent the list of all items in a given job.
//Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship between
//data tables. Recall that this annotation needs a name parameter.
    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    @NotBlank(message = "a LOCATION is required")
    @Size(max = 100, message = "the LOCATION must be < 100 characters in length")
    private String location;

    public Employer() {}
    public Employer(String location) {
        this.location = location;
    }

//NEEDED? best practice?//
//    public List<Job> getJobs() {
//        return jobs;
//    }
//
//    public void setJobs(List<Job> jobs) {
//        this.jobs = jobs;
//    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
