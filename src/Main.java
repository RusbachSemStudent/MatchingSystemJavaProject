import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/opdrachtdatabase", "root", "Admin123!");

            Statement registrationStatement = connection.createStatement();

            ResultSet registrationResultSet = registrationStatement.executeQuery("SELECT * FROM registrations");

            Statement vacanciesStatement = connection.createStatement();

            ResultSet vacancyResultSet = vacanciesStatement.executeQuery("SELECT * FROM vacancies");

            // loop door alle registrations heen. vergelijk elk registration veld met de bijbehorende vacancyvelden

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

            // vergelijk registrations met vacancies. maak een match aan met een percentage van de match.
            // voeg deze toe aan de matchtabel en schrijf de registration en vacancy weg uit de database

            for (Registration reg : registrations) {

                // System.out.println("Region of reg is " + reg.region);

                for (Vacancy vac : vacancies) {

                    // System.out.println("Region of vac is " + vac.region);
                    System.out.println("reg: " + reg.region + " - " + " vac: " + vac.region);

                    if (vac.region.equalsIgnoreCase(reg.region)) {

                        System.out.println("Region is the same!");
                        int matchPercentage += 20;

                    }

                    if (vac.industry.equalsIgnoreCase(reg.industry)) {

                        System.out.println("Industry is the same!");
                        int matchPercentage += 20;

                    }

                    if (vac.jobPosition.equalsIgnoreCase(reg.jobPosition)) {

                        System.out.println("Job position is the same!");
                        int matchPercentage += 20;

                    }

                    if (vac.) {

                    }

                }

            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

}
