package dev.benjamin.models;


public class Request {
    private int id;
    private double cost;
    private String description;
    private String eventType;
    private String gradeFormat;
    private String provider;
    private String eventDate;
    private Status status;
    private double reimbursement;
    private User author;
    private User resolver;


    public Request() {
    }

    public Request(int id, double cost, String description, String eventType, String gradeFormat, String eventLocation, String eventDate, Status status, double reimbursement, User author, User resolver) {
        this.id = id;
        this.cost = cost;
        this.description = description;
        this.eventType = eventType;
        this.gradeFormat = gradeFormat;
        this.provider = eventLocation;
        this.eventDate = eventDate;
        this.status = status;
        this.reimbursement = reimbursement;
        this.author = author;
        this.resolver = resolver;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }
}
