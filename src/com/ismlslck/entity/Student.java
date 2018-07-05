package com.ismlslck.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "(*)Öğrenci No boş geçilemez.")
    private Integer ogrNo;//int olarak tanımlandiginda numberFormatException hatası veriyor.
    @NotEmpty(message = "(*)İsim alanı boş geçilemez.") @NotNull(message = "(*)İsim boş geçilemez.")
    private String name;
    @NotEmpty(message = "(*)Soysim alanı boş geçilemez.") @NotNull(message = "(*)Soysim boş geçilemez.")
    private String surname;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(
            name = "Deparment_Student",
            joinColumns = @JoinColumn(name = "studenId"),
            inverseJoinColumns = @JoinColumn(name = "departmentId")
    )

    @Valid
    private Department department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(Integer ogrNo) {
        this.ogrNo = ogrNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
