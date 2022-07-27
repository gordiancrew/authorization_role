package com.kazantsev.authorization_role.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="images")
@Data
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String imagename;
    @Lob
    private byte[] bytes;
}
