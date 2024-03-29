package com.kazantsev.authorization_role.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="stages")
public class Stage {
    @Id
    private Integer id;
    private String name;
    private String q1;
    private String q11;
    private String q2;
    private String q22;
    private String q3;
    private String q33;
    private String a1;
    private String a2;
    private String a3;

    @Transient
    @OneToMany
    private Set<User> user;

}
