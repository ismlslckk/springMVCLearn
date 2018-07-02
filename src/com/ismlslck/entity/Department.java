package com.ismlslck.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({ "students","faculty" })
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "(*)Bölüm boş geçilemez.")
    @NotBlank(message = "(*)Bölüm boş geçilemez.")
    private String name;


    //ALL olduğunda bir department silinince bu departmana bağlı tüm öğrencileride siler.
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY,mappedBy = "department")
    private List<Student> students;

    //persist ile bir department silinince bu departmanın bağlı olduğu fakülte silinmez.
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,targetEntity = Faculty.class)
    @JoinTable(
            name = "Faculty_Deparment",
            joinColumns = @JoinColumn(name = "departmentId"),
            inverseJoinColumns = @JoinColumn(name = "facultyId")
    )

    @Valid
    @NotNull(message = "(*)Fakülte boş geçilemez.")
    private Faculty faculty;

    public Department() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
}
