package ru.geekbrains.hw.task1;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First name: ").append(firstName).append("\n");
        sb.append("Last name: ").append(lastName).append("\n");
        sb.append("Middle name: ").append(middleName == null ? "" : middleName).append("\n");
        sb.append("Age: ").append(age == 0 ? "" : age).append("\n");
        sb.append("Gender: ").append(gender == null ? "" : gender).append("\n");
        sb.append("Country: ").append(country == null ? "" : country).append("\n");
        sb.append("Address: ").append(address == null ? "" : address).append("\n");
        sb.append("Phone: ").append(phone == null ? "" : phone).append("\n");

        return sb.toString();
    }

    public static class Builder{
        private Person newPerson;

        public Builder() {
            this.newPerson = new Person();
        }

        public Builder firstName(String name){
            newPerson.firstName = name;
            return this;
        }

        public Builder lastName(String name){
            newPerson.lastName = name;
            return this;
        }

        public Builder middleName(String name){
            newPerson.middleName = name;
            return this;
        }

        public Builder country(String country){
            newPerson.country = country;
            return this;
        }

        public Builder address(String address){
            newPerson.address = address;
            return this;
        }

        public Builder phone(String phone){
            newPerson.phone = phone;
            return this;
        }

        public Builder gender(String gender){
            newPerson.gender = gender;
            return this;
        }

        public Builder age(int age){
            newPerson.age = age;
            return this;
        }
        public Person build(){
            return newPerson;
        }
    }
}
