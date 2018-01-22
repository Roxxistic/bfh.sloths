package bfh.sloths.yellowpages.partnercontactdataservice.models;

public class Email {

    private String id;

    private String emailAddress;

    private String partnerId;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}
