package org.launchcode.techjobs.persistent.controllers;

import org.apache.catalina.Store;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */

//A user will select an employer when they create a job.
//Add the employer data from employerRepository into the form template.

//The add job form already includes an employer selection option.
//Be sure your variable name for the employer data matches that already used in templates/add.
// --> name="employerId"

//Checkout templates/add.html. Make a mental note of the name of the variable
//being used to pass the selected employer id on form submission.

@Controller
public class HomeController {

//Add a field employerRepository annotated with @Autowired.
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {   //indexMethod
        model.addAttribute("title", "My Jobs");
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

//In processAddJobForm, add code inside of this method to select the employer object that has been chosen
//to be affiliated with the new job.
//You will need to select the employer using the request parameter you’ve added to the method.
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId,
                                    @RequestParam List<Integer> skills) {

        Optional<Employer> optionalEmployer = employerRepository.findById(employerId);
        List<Skill> skillObjects = (List<Skill>)skillRepository.findAllById(skills); //skillObjs --> skillObjects
        newJob.setSkills(skillObjects);

        if (errors.hasErrors() || optionalEmployer.isEmpty()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        newJob.setEmployer(optionalEmployer.get());
        model.addAttribute("job", newJob);
        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional<Job> optionalJob = jobRepository.findById(jobId);
        if (optionalJob.isEmpty()) {
            return "redirect";
        } else {
            //Job job = optionalJob.get();
            model.addAttribute("job", optionalJob.get());  //("job", job)
            return "view";
        }
    }


}
