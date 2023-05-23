package pl.kielce.entity;

import javax.persistence.*;
import java.util.Random;

@Embeddable
public class Class {
    public int classId;
    @Column(name="class_name")
    public String className;
    @Column(name="class_master")
    public String classMaster;

    public Class() {
        Random r = new Random();
        classId = r.nextInt(1000);
    }

    public Class(String className, String classMaster) {
        Random r = new Random();
        this.classId = r.nextInt(1000);
        this.className = className;
        this.classMaster = classMaster;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassMaster() {
        return classMaster;
    }

    public void setClassMaster(String classMaster) {
        this.classMaster = classMaster;
    }
}
