package com.scm.model;

import java.util.Date;

/*
{
[id:?,
goal:?,
nextgoal:?,
deadline:?,
nextdeadline:?],…
}
 */
public class ContentPostModel {
    private Integer id;
    private Float goal;
    private Float nextgoal;
    private Date deadline;
    private Date nextdeadline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }

    public Float getNextgoal() {
        return nextgoal;
    }

    public void setNextgoal(Float nextgoal) {
        this.nextgoal = nextgoal;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getNextdeadline() {
        return nextdeadline;
    }

    public void setNextdeadline(Date nextdeadline) {
        this.nextdeadline = nextdeadline;
    }
}
