package com.ismlslck.controller;

import com.ismlslck.entity.Department;
import com.ismlslck.entity.Faculty;
import com.ismlslck.entity.Student;
import com.ismlslck.service.DepartmentService;
import com.ismlslck.service.FacultyService;
import com.ismlslck.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private DepartmentService departmentService;

    @Component
    public class DepartmentConverter implements Converter<String, Department> {
        @Override
        public Department convert(String id) {
            try {
                return departmentService.getDepartmentById(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }

    @Component
    public class FacultyConverter implements Converter<String, Faculty> {
        @Override
        public Faculty convert(String id) {
            try {
                return facultyService.getFacultyById(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public String getAllStudents(@ModelAttribute("message") String message,Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("message", message);
        return "list-student";
    }

    @RequestMapping(value = "/saveStudentForm", method = RequestMethod.GET)
    public String saveStudentForm(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculty();
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("student", new Student());
        model.addAttribute("faculties", faculties);
        model.addAttribute("departments", departments);
        return "save-student";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
        //bindingResult.getFieldErrors().add(new FieldError("student","department.faculty","ger"));
        if(student.getDepartment().getFaculty()==null){
            bindingResult.rejectValue("department.faculty.name","department.faculty.name","(*)Fakülte ismi boş geçilemez.");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("faculties", facultyService.getAllFaculty());
            model.addAttribute("departments", departmentService.getAllDepartment());
            return "save-student";
        } else {
            if (studentService.saveStudent(student)) {
                return "redirect:/student/list";
            } else {
                model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
                return "save-student";
            }
        }
    }

    @RequestMapping(value = "/updateForm/{studentId}", method = RequestMethod.GET)
    public String updateStudentForm(@PathVariable int studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId));
        model.addAttribute("faculties", facultyService.getAllFaculty());
        model.addAttribute("departments", departmentService.getAllDeparmentByFacultyId(facultyService.getFacultyIdByStudentId(studentId)));
        return "update-student";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
            model.addAttribute("student", student);
            return "update-student";
        } else {
            if (studentService.updateStudent(student)) {
                redirectAttributes.addFlashAttribute("message", "Güncelleme başarılı.");
                return "redirect:/student/list";
            } else {
                model.addAttribute("message", "Bir sorun oluştu,daha sonra tekrar deneyiniz.");
                model.addAttribute("student", student);
                return "update-student";
            }
        }
    }

    @RequestMapping(value = "/delete/{studentId}",method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int studentId,RedirectAttributes redirectAttributes){
            if(studentService.deleteStudent(studentId)){
                redirectAttributes.addFlashAttribute("message","Öğrenci başarıyla silindi");
                return "redirect:/student/list";
            }
            else {
                redirectAttributes.addFlashAttribute("message","Bir sorun oluştu,öğrenci silinemedi!");
                return "redirect:/student/list";
            }
    }


}
