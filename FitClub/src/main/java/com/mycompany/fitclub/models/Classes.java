package com.mycompany.fitclub.models;

import com.mycompany.fitclub.enumpack.ClassType;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Classes {

    private String classId;
    private String className;
    private ClassType classType;
    private int capacity;
    private int enrollCount;
    private Date classTime;
    private int classDuration;

    public Classes(String className, ClassType classType, int capacity, Date classTime, int classDuration) {
        this.classId = UUID.randomUUID().toString();
        this.className = className;
        this.classType = classType;
        this.capacity = capacity;
        this.classTime = classTime;
        this.classDuration = classDuration;
        this.enrollCount = 0;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public ClassType getClassType() {
        return classType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrollCount() {
        return enrollCount;
    }

    public Date getClassTime() {
        return classTime;
    }

    public int getClassDuration() {
        return classDuration;
    }

    public void updateEnrollCount(int i) {
        this.enrollCount += i;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.className);
        hash = 11 * hash + Objects.hashCode(this.classType);
        hash = 11 * hash + this.capacity;
        hash = 11 * hash + this.enrollCount;
        hash = 11 * hash + Objects.hashCode(this.classTime);
        hash = 11 * hash + this.classDuration;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classes other = (Classes) obj;
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.enrollCount != other.enrollCount) {
            return false;
        }
        if (this.classDuration != other.classDuration) {
            return false;
        }
        if (!Objects.equals(this.className, other.className)) {
            return false;
        }
        if (this.classType != other.classType) {
            return false;
        }
        return Objects.equals(this.classTime, other.classTime);
    }

}
