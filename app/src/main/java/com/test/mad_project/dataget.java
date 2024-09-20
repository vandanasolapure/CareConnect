package com.test.mad_project;

public class dataget {
    String name,address,age,phone;

    public dataget(String name,String address,String age,String phone)
    {
        this.name=name;
        this.address=address;
        this.age=age;
        this.phone=phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
