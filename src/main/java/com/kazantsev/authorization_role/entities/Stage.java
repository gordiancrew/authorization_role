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
    private String quest1;
    private String quest2;
    @Transient
    @OneToMany
    private Set<User> user;

}
