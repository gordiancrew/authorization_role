package com.kazantsev.authorization_role.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="locs")
@Data
public class Loc {
    @Id
    private int id;
    private String name;
    @Lob
    private byte[] bytes;
}
