import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/opdrachtdatabase", "root", "Admin123!");

            Statement matchStatement = connection.createStatement();

            matchStatement.executeUpdate("DELETE FROM `match`");

            Statement registrationStatement = connection.createStatement();

            ResultSet registrationResultSet = registrationStatement.executeQuery("SELECT * FROM registrations");

            Statement vacanciesStatement = connection.createStatement();

            ResultSet vacancyResultSet = vacanciesStatement.executeQuery("SELECT * FROM vacancies");

            ArrayList<Registration> registrations = new ArrayList<Registration>();

            ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();

            while (registrationResultSet.next()) {

                Registration registration = new Registration(registrationResultSet.getInt("registrationID"), registrationResultSet.getString("firstName"), registrationResultSet.getString("lastName"), registrationResultSet.getString("email"), registrationResultSet.getString("region"), registrationResultSet.getString("industry"), registrationResultSet.getString("jobPosition"), registrationResultSet.getInt("desiredSalary"));

                registrations.add(registration);

            }

            while (vacancyResultSet.next()) {

                Vacancy vacancy = new Vacancy(vacancyResultSet.getInt("vacancyID"), vacancyResultSet.getString("company"), vacancyResultSet.getString("email"), vacancyResultSet.getString("region"), vacancyResultSet.getString("industry"), vacancyResultSet.getString("jobPosition"), vacancyResultSet.getInt("startSalary"), vacancyResultSet.getInt("endSalary"));

                vacancies.add(vacancy);

            }

            for (Registration reg : registrations) {

                for (Vacancy vac : vacancies) {

                    int matchPercentage = 0;

                    if (vac.region.equalsIgnoreCase(reg.region)) {

                        System.out.println("Region is the same!");
                        matchPercentage += 25;

                    }

                    if (vac.industry.equalsIgnoreCase(reg.industry)) {

                        System.out.println("Industry is the same!");
                        matchPercentage += 25;

                    }

                    if (vac.jobPosition.equalsIgnoreCase(reg.jobPosition)) {

                        System.out.println("Job position is the same!");
                        matchPercentage += 25;

                    }

                    if (reg.desiredSalary < vac.endSalary && reg.desiredSalary > vac.startSalary) {

                        System.out.println("Desired salary is inbetween start salary and end salary!");
                        matchPercentage += 25;

                    }

                    matchStatement.executeUpdate("INSERT INTO `match` (vacancyID,registrationID,percentage) VALUES (" + vac.vacancyID + ", " + reg.registrationID + ", " + matchPercentage + ");");

                }

            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

}
