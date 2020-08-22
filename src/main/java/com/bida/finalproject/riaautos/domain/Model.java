package com.bida.finalproject.riaautos.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private int value;
    @Column(name = "mark_id")
    private int markID;

    public Model(){}

    public Model(String name, int value, int markID) {
        this.name = name;
        this.value = value;
        this.markID = markID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMarkID() {
        return markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", markID=" + markID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return value == model.value &&
                markID == model.markID &&
                name.equals(model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, markID);
    }
}
