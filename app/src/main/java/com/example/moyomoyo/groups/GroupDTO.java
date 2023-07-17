package com.example.moyomoyo.groups;

public class GroupDTO {
    private String groupId;
    private String name;
    private String info;
    private String field;
    private String isReserved;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(String isReserved) {
        this.isReserved = isReserved;
    }
}
