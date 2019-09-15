package com.yuk.trump.entity;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 12:23
 * @description：消费记录
 * @modified By：
 */
public class Consume {
    private Long id;
    private int admin_id;
    private String useTime;
    private double money;
    private byte payWay;
    private String place;
    private String person;
    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public byte getPayWay() {
        return payWay;
    }

    public void setPayWay(byte payWay) {
        this.payWay = payWay;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
