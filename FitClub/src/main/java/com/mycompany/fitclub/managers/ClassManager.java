package com.mycompany.fitclub.managers;

import com.mycompany.fitclub.enumpack.ClassType;
import com.mycompany.fitclub.models.Classes;
import com.mycompany.fitclub.models.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassManager {

    Map<String, Classes> classMap;
    Map<String, LinkedList<User>> waitingQueue;
    Map<String, TreeSet<User>> classUserMap;

    private static volatile ClassManager classManagerInstance;

    public ClassManager() {
        this.classMap = new HashMap<>();
        this.waitingQueue = new HashMap<>();
        this.classUserMap = new HashMap<>();
    }

    public static ClassManager getInstance() {

        if (classManagerInstance == null) {
            synchronized (ClassManager.class) {
                if (classManagerInstance == null) {
                    return new ClassManager();
                }
            }
        }
        return classManagerInstance;
    }

    public Classes registerClass(String className, String type, int capacity, String classTime, int classDuration) {
        try {
            ClassType classType = getClassType(type);
            if (classType == null) {
                System.out.println("INVALID CLASSTYPE");
                return null;
            }
            Date classDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(classTime);
            Classes classes = new Classes(className, classType, capacity, classDate, classDuration);

            if (!classMap.containsValue(classes)) {
                classMap.put(classes.getClassId(), classes);
                System.out.println("Class - " + classes.getClassName() + " registered!");
            } else {
                System.out.println("Class already Registered!");
            }
            return classes;
        } catch (ParseException ex) {
            Logger.getLogger(ClassManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void removeClass(User classes) {
        if (classMap.containsKey(classes.getUserId())) {
            classMap.remove(classes.getUserId());
            System.out.println("Class - " + classes.getUserName() + " removed!");
        } else {
            System.out.println("Class NOT Registered!");
        }
    }

    public List<Classes> getClassList() {
        List<Classes> clist = new ArrayList<>();
        for (String classes : classMap.keySet()) {
            clist.add(classMap.get(classes));
        }
        return clist;
    }

    public void addWaitingUser(Classes classes, User user) {
        if (!waitingQueue.containsKey(classes.getClassId())) {
            waitingQueue.put(classes.getClassId(), new LinkedList<>());
        }
        waitingQueue.get(classes.getClassId()).offer(user);
    }

    public User getWaitingUser(Classes classes) {
        return waitingQueue.get(classes.getClassId()).poll();
    }

    public Classes getClassDetails(Classes classes) {
        return classMap.get(classes.getClassId());
    }

    public void addclassBooking(Classes classes, User user) {
        if (!classUserMap.containsKey(classes.getClassId())) {
            classUserMap.put(classes.getClassId(), new TreeSet<>());
        }
        classUserMap.get(classes.getClassId()).add(user);
        classes.updateEnrollCount(1);

    }

    boolean isClassFull(Classes classes) {
        return (classes.getCapacity() - classes.getEnrollCount()) <= 0;
    }

    private ClassType getClassType(String type) {
        type = type.toUpperCase();
        switch (type) {
            case "YOGA":
                return ClassType.YOGA;
            case "GYM":
                return ClassType.GYM;
            case "DANCE":
                return ClassType.DANCE;
            default:
                break;
        }
        return null;
    }

    public void cancelClassBooking(Classes classes, User user) {
        if (classUserMap.containsKey(classes.getClassId())) {
            classUserMap.get(classes.getClassId()).remove(user);
            classes.updateEnrollCount(-1);
        }
    }
}
