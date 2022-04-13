package Class;

public class Guest {
    private String name;
    private String country;
    private String gender;
    private Boolean identity; // false == license | true == passport
    private String identityInfo;
    private Integer contactNumber;
    private String address;
    private Integer rcode; // reservation code instead of ID
    private String creditCardNumber;
    private String email;
    private Integer age;

    public Guest() {
    }

    public Guest(String name, String country, String gender, Boolean identity,
                 String identityInfo, Integer contactNumber, String address,
                 Integer rcode, String creditCardNumber,
                 String email, Integer age) {
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.identity = identity;
        this.identityInfo = identityInfo;
        this.contactNumber = contactNumber;
        this.address = address;
        this.rcode = rcode;
        this.creditCardNumber = creditCardNumber;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getIdentity() {
        return identity;
    }

    public void setIdentity(Boolean identity) {
        this.identity = identity;
    }

    public String getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(String identityInfo) {
        this.identityInfo = identityInfo;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRcode() {
        return rcode;
    }

    public void setRcode(Integer rcode) {
        this.rcode = rcode;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // returns the variables of each menu item as a string
    @Override
    public String toString() {
        return "|" + name + "|" + country + "|" + gender + "|" + identity + "|" + identityInfo + "|" + contactNumber
                + "|" + address + "|" + rcode + "|" + creditCardNumber + "|" + email + "|" + age + "|";
    }
}
