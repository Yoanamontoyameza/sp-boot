package com.uttt.autosparepart.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "restore_code")
public class CodeDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "user_dx")
    private String user_dx;
    @Column(name = "date")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_dx() {
        return user_dx;
    }

    public void setUser_dx(String user_dx) {
        this.user_dx = user_dx;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
