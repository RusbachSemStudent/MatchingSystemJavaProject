public final class Vacancy {

    public int vacancyID;

    public String company;

    public String email;

    public String region;

    public String industry;

    public String jobPosition;

    public int startSalary;

    public int endSalary;

    public Vacancy(int vacancyID, String company, String email, String region, String industry, String jobPosition, int startSalary, int endSalary) {
        this.vacancyID = vacancyID;
        this.company = company;
        this.email = email;
        this.region = region;
        this.industry = industry;
        this.jobPosition = jobPosition;
        this.startSalary = startSalary;
        this.endSalary = endSalary;
    }

}
