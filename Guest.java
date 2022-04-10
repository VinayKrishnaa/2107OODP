package Class;

import java.util.Date;

public class Guest {
    private String Name;
    private String Country;
    private String Gender;
    private Boolean Identity;
    private String IdentityInfo;
    private Integer ContactNumber;
    private String Address;
    private Integer Rcode; // reservation code instead of ID
    //private Date CheckInDate;
    //private Boolean MainGuest;
    private String CreditCardNumber;
    private String Email;
    private Integer Age;

    public Guest() {
    }

    public Guest(String Name, String Country, String Gender, Boolean Identity,
                 String IdentityInfo, Integer ContactNumber, String Address,
                 Integer Rcode, String CreditCardNumber,
                 String Email, Integer Age) {
        this.Name = Name;
        this.Country = Country;
        this.Gender = Gender;
        this.Identity = Identity;
        this.IdentityInfo = IdentityInfo;
        this.ContactNumber = ContactNumber;
        this.Address = Address;
        this.Rcode = Rcode;
        //this.CheckInDate = CheckInDate;
        //this.MainGuest = MainGuest;
        this.CreditCardNumber = CreditCardNumber;
        this.Email = Email;
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Boolean getIdentity() {
        return Identity;
    }

    public void setIdentity(Boolean Identity) {
        this.Identity = Identity;
    }

    public String getIdentityInfo() {
        return IdentityInfo;
    }

    public void setIdentityInfo(String IdentityInfo) {
        this.IdentityInfo = IdentityInfo;
    }

    public Integer getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(Integer ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Integer getRcode() {
        return Rcode;
    }

    public void setRcode(Integer Rcode) {
        this.Rcode = Rcode;
    }

    //public Date getCheckInDate() {
    //    return CheckInDate;
    //}

    //public void setCheckInDate(Date CheckInDate) {
    //    this.CheckInDate = CheckInDate;
    //}

    //public Boolean getMainGuest() {
    //    return MainGuest;
    //}

    //public void setMainGuest(Boolean MainGuest) {
    //    this.MainGuest = MainGuest;
    //}

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(String CreditCardNumber) {
        this.CreditCardNumber = CreditCardNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }
}
