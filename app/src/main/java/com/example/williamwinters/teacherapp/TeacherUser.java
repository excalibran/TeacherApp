package com.example.williamwinters.teacherapp;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by William Winters on 4/15/2017.
 */

public class TeacherUser {
    private FirebaseAuth mAuth;

    public String teacherName;
    public String code;
    public Date endtime;

    public TeacherUser(){
    }

    public TeacherUser(String name){
        this.teacherName=name;
        this.code="";
        this.endtime = null;
    }

//    public TeacherUser(String name,String teacher, Date end){
//        this.teacherName=name;
//        this.code=teacher;
//        this.endtime = end;
//    }
}
