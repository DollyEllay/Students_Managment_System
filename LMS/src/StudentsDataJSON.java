import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StudentsDataJSON {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\csp\\Documents\\Projects\\LMS\\LMS\\output.csv";
        List<Student> students = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 7) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                int id;
                try {
                    id = Integer.parseInt(parts[0]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid ID format: " + parts[0]);
                    continue;
                }
                String name = parts[1];
                int grade;
                try {
                    grade = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid grade format: " + parts[2]);
                    continue;
                }
                String email = parts[3];
                String address = parts[4];
                String city = parts[5];
                String country = parts[6];
                students.add(new Student(id, name, grade, email, address, city, country));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(students);
        System.out.println(json);

        try {
            FileWriter fileWriter = new FileWriter("students.json");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Student {
        private int id;
        private String name;
        private int grade;
        private String email;
        private String address;
        private String city;
        private String country;

        public Student(int id, String name, int grade, String email, String address, String city, String country) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.email = email;
            this.address = address;
            this.city = city;
            this.country = country;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", email=" + email + ", address=" + address
                    + ", city=" + city + ", country=" + country + "]";
        }
    }
}