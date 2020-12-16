package com.cliffside.pojo;

import java.io.Serializable;

/**
 * @author cliffside
 * @date 2020-12-16 16:56
 */
public class Person implements Serializable {
    //序列化版本号
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
