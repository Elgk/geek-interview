package ru.geekbrains.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "findAllStudents", query="select s from Student s")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student(){
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student(Long id, String name, int mark) {
        this.name = name;
        this.mark = mark;
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("Student: [ id = %d, name = %s, mark = %d] ", id, name, mark);
    }
}
