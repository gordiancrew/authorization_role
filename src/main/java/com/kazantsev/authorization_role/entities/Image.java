package com.kazantsev.authorization_role.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="images")
@Data
public class Image {
    @Id
    private int id;
    private String name;
    @Lob
    private byte[] bytes;
    @Lob
    private byte[] loc;
}
