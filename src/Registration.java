public class Registration {

    public int registrationID;

    public String firstName;

    public String lastName;

    public String email;

    public String region;

    public String industry;

    public String jobPosition;

    public int desiredSalary;

    public Registration(int registrationID, String firstName, String lastName, String email, String region, String industry, String jobPosition, int desiredSalary) {
        this.registrationID = registrationID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.region = region;
        this.industry = industry;
        this.jobPosition = jobPosition;
        this.desiredSalary = desiredSalary;
    }

}
