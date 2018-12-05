package app.model;

public class Volunteer {
    private String firstname;
    private String lastname;
    private String dob;
    private String gender;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    private String occupation;
    private String employer;
    private String license;
    private String skillname;

    public Volunteer(String firstname, String lastname, String dob, String gender, String email, String address, String city, String state, String zipcode, String phone, String occupation, String employer, String license, String skillname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.occupation = occupation;
        this.employer = employer;
        this.license = license;
        this.skillname = skillname;
    }

    public Volunteer(String firstname, String lastname, String dob, String gender, String email, String address, String city, String state, String zipcode, String phone, String occupation, String employer, String license) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.occupation = occupation;
        this.employer = employer;
        this.license = license;
    }

    //constructor with required fields
    public Volunteer(String firstname, String lastname, String dob, String gender, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public Volunteer() {
    }

    //getter and setters


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }
}
