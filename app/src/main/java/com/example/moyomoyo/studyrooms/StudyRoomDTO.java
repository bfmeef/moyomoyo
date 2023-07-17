package com.example.moyomoyo.studyrooms;

public class StudyRoomDTO {
    private String studyRoomId;
    private String name;
    private String manager;
    private String contact;
    private String location;
    private String info;
    private Integer capacity;

    public String getStudyRoomId() {
        return studyRoomId;
    }

    public void setStudyRoomId(String studyRoomId) {
        this.studyRoomId = studyRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
