package org.example;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName=firstName;
        this.lastName= lastName;
        this.phoneNumber=phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void validateFirstName(){
        if(this.firstName==null){
            throw  new RuntimeException("First name cannot be null");
        }
    }

    public void validateLastname(){
        if(this.lastName==null){
            throw new RuntimeException("Last name canoot be null");
        }
    }

    public void validatePhoneNumber(){
        if (this.phoneNumber.length()!=10){
            throw new RuntimeException("Phone number must be of 10 digit");
        }
        if (!this.phoneNumber.matches("\\d+")){
            throw new RuntimeException("Phone number must only contain digits");
        }

        if (!this.phoneNumber.startsWith("9")){
            throw new RuntimeException("Phone number must start with 9");
        }
    }

}
