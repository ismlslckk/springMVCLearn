package com.ismlslck.controller;

import com.ismlslck.entity.Faculty;
import com.ismlslck.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllFaculty(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculty());
        model.addAttribute("faculty", new Faculty());
        return "list-faculty";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFaculty(@ModelAttribute("faculty") @Valid Faculty faculty, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("faculty", faculty);
            model.addAttribute("faculties", facultyService.getAllFaculty());
            return "list-faculty";
        } else {
            facultyService.saveFaculty(faculty);
            model.addAttribute("faculty", new Faculty());
            return "redirect:/faculty/list";
        }


    }

    @RequestMapping(value = "/updateForm/{facultyId}", method = RequestMethod.GET)
    public String updateFacultyForm(@PathVariable int facultyId, Model model) {
        model.addAttribute("faculty", facultyService.getFacultyById(facultyId));
        return "update-faculty";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateFaculty(@ModelAttribute("faculty") Faculty faculty,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
            model.addAttribute("faculty", faculty);
            return "update-faculty";
        } else {
            if (facultyService.updateFaculty(faculty)) {
                redirectAttributes.addFlashAttribute("message", "Güncelleme başarılı.");
                return "redirect:/faculty/list";
            } else {
                model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
                model.addAttribute("faculty", faculty);
                return "update-faculty";
            }
        }
    }

    @RequestMapping(value = "/delete/{facultyId}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int facultyId, RedirectAttributes redirectAttributes) {
        if (facultyService.deleteFaculty(facultyId)) {
            redirectAttributes.addFlashAttribute("message", "Fakülte başarıyla silindi");
            return "redirect:/faculty/list";
        } else {
            redirectAttributes.addFlashAttribute("message", "Bir sorun oluştu,fakülte silinemedi!");
            return "redirect:/faculty/list";
        }
    }


}
