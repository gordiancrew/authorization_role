package com.kazantsev.authorization_role.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="images")
@Data
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String imagename;
}
