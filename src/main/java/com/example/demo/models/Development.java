package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "development")
public class Development  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idperson;
    @Column(name = "position")
    private String position;
    @Column(name = "technology")
    private String technology;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "ordernum")
    private Integer ordernum;

    public Development(){

    }

    public Development(int idperson, String position, String technology, int salary, int ordernum) {
        this.idperson = idperson;
        this.position = position;
        this.technology = technology;
        this.salary = salary;
        this.ordernum = ordernum;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getDevposition() {
        return position;
    }

    public void setDevposition(String devposition) {
        this.position = devposition;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getOrdernum() {
        if(ordernum ==null){
            return 555;
        } else{
        return ordernum;
        }
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }
}
