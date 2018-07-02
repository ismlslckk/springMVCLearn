package com.ismlslck.controller;

import com.ismlslck.entity.Department;
import com.ismlslck.entity.Student;
import com.ismlslck.service.DepartmentService;
import com.ismlslck.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DeparmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllDepartment(Model model) {
        model.addAttribute("deparment", new Department());
        model.addAttribute("deparments", departmentService.getAllDepartment());
        model.addAttribute("faculties", facultyService.getAllFaculty());
        return "list-department";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("deparment") Department department, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
            return "redirect:/department/list";
        } else {
            if (departmentService.saveDepartment(department)) {
                return "redirect:/department/list";
            } else {
                model.addAttribute("error", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
                return "list-department";
            }
        }
    }

    //json olarak return etmek için responsebody ve jackson kütüphanesini kullandım.
    @RequestMapping(value = "/list/{facultyId}",method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getAllDepartmentByFacultyId(@PathVariable int facultyId){
        return departmentService.getAllDeparmentByFacultyId(facultyId);
    }

    @RequestMapping(value = "/updateForm/{departmentId}", method = RequestMethod.GET)
    public String updateDepartmentForm(@PathVariable int departmentId, Model model) {
        model.addAttribute("department",departmentService.getDepartmentById(departmentId));
        model.addAttribute("faculties", facultyService.getAllFaculty());
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "update-department";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDepartment(@ModelAttribute("department") Department department,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
            model.addAttribute("department", department);
            return "update-department";
        } else {
            if (departmentService.updateDepartment(department)) {
                redirectAttributes.addFlashAttribute("message", "Güncelleme başarılı.");
                return "redirect:/department/list";
            } else {
                model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
                model.addAttribute("department", department);
                return "update-department";
            }
        }
    }
    @RequestMapping(value = "/delete/{departmentId}",method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable int departmentId,RedirectAttributes redirectAttributes){
        if(departmentService.deleteDepartment(departmentId)){
            redirectAttributes.addFlashAttribute("message","Bölüm başarıyla silindi");
            return "redirect:/department/list";
        }
        else {
            redirectAttributes.addFlashAttribute("message","Bir sorun oluştu,öğrenci silinemedi!");
            return "redirect:/department/list";
        }
    }


}
