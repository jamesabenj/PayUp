package dev.benjamin.models;

import java.time.LocalDateTime;

public class Request {
    private int id;
    private int cost;
    private String description;
    private String eventType;
    private String gradeFormat;
    private String eventLocation;
    private String eventDate;
    private boolean complete;
    private boolean approved;
    private int reimbursement;


    public Request() {
    }

    public Request(int cost, String description, User requester, Manager approver, String eventType, String gradeFormat, String eventLocation, String eventDate, boolean complete, int reimbursement) {
        this.id = id;
        this.cost = cost;
        this.description = description;
        this.eventType = eventType;
        this.gradeFormat = gradeFormat;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.complete = complete;
        this.reimbursement = reimbursement;
    }


    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGradeFormat() {
        return gradeFormat;
    }

    public void setGradeFormat(String gradeFormat) {
        this.gradeFormat = gradeFormat;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(int reimbursement) {
        this.reimbursement = reimbursement;
    }
}
