package com.scm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "points")
public class PointsEntity {
    private int id;
    private String content;
    private Float now;
    private Float goal;
    private Date deadline;
    private Float nextgoal;
    private Date nextdeadline;
    private TargetsEntity targetsEntity;


    @ManyToOne
    @JoinColumn(name = "targetId")
    public TargetsEntity getTargetsEntity() {
        return targetsEntity;
    }

    public void setTargetsEntity(TargetsEntity targetsEntity) {
        this.targetsEntity = targetsEntity;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Basic
    @Column(name = "now")
    public Float getNow() {
        return now;
    }

    public void setNow(Float now) {
        this.now = now;
    }

    @Basic
    @Column(name = "goal")
    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }

    @Basic
    @Column(name = "deadline")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "nextgoal")
    public Float getNextgoal() {
        return nextgoal;
    }

    public void setNextgoal(Float nextgoal) {
        this.nextgoal = nextgoal;
    }

    @Basic
    @Column(name = "nextdeadline")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getNextdeadline() {
        return nextdeadline;
    }

    public void setNextdeadline(Date nextdeadline) {
        this.nextdeadline = nextdeadline;
    }

    public void updateNow(){
        now=now+1;
    }

    public void updateNowWithData(float data){
        now=data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointsEntity that = (PointsEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (now != null ? !now.equals(that.now) : that.now != null) return false;
        if (goal != null ? !goal.equals(that.goal) : that.goal != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (nextgoal != null ? !nextgoal.equals(that.nextgoal) : that.nextgoal != null) return false;
        if (nextdeadline != null ? !nextdeadline.equals(that.nextdeadline) : that.nextdeadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (now != null ? now.hashCode() : 0);
        result = 31 * result + (goal != null ? goal.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (nextgoal != null ? nextgoal.hashCode() : 0);
        result = 31 * result + (nextdeadline != null ? nextdeadline.hashCode() : 0);
        return result;
    }
}
