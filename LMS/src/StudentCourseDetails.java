import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

public class StudentCourseDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        String studentId = scanner.nextLine();

        // read students data from file
        String studentsData = readFile("C:\\Users\\csp\\Documents\\Projects\\LMS\\StudentsData.csv");
        JSONObject students = csvToJson(studentsData);

        // find student in students data
        JSONObject student = students.optJSONObject(studentId);
        if (student == null) {
            System.out.println("This student does not exist.");
        } else {
            // print student's data
            System.out.println("====================================================================================");
            System.out.println("Student Details page");
            System.out.println("====================================================================================");
            System.out.println("Name: " + student.optString("name") + "\t\tGrade: " + student.optString("grade") + "\t\tEmail: " + student.optString("email"));
            System.out.println("------------------------------------------------------------------------------------");

            // read course data from file
            String courseData = readFile("C:\\Users\\csp\\Documents\\Projects\\LMS\\coursedata.csv");
            JSONObject courses = csvToJson(courseData);

            // find courses that the student has enrolled in
            String[] courseIds = student.optString("courses").split(",");
            if (courseIds == null || courseIds.length == 0 || courseIds[0].isEmpty()) {
                System.out.println("This student hasn't enrolled in any courses");
            } else {
                System.out.println("Enrolled courses.");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("No.\tCourse ID\tCourse Name\tInstructor\t\tDuration\tLocation");
                for (int i = 0; i < courseIds.length; i++) {
                    String courseId = courseIds[i];
                    JSONObject course = courses.optJSONObject(courseId);
                    if (course != null) {
                        // print course data
                        System.out.printf("%d- %-6s\t%-15s\t%-20s\t%-8s\t%-6s\n", i + 1, course.optString("id"), course.optString("name"), course.optString("instructor"), course.optString("duration"), course.optString("location"));
                    } else {
                        // handle case where course ID is invalid or not found
                        System.out.printf("%d- %-6s\tInvalid Course ID\n", i + 1, courseId);
                    }
                }
            }
            System.out.println("------------------------------------------------------------------------------------");

            // enroll student in a new course
            System.out.print("Enter course id to enroll: ");
            String courseId = scanner.nextLine();

            // validate course id
            JSONObject course = courses.optJSONObject(courseId);
            if (course == null) {
                System.out.println("Invalid course id");
                return;
            }

            // check if student has less than 6 courses enrolled
            if (courseIds.length >= 6) {
                try {
                    throw new Exception("This student has already enrolled in the maximum number of courses (6).");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } try {
                // validate course ID
                if (!courses.has(courseId)) {
                    throw new Exception("Invalid course ID.");
                }

                // get student data
                student = students.getJSONObject(studentId);

                // add the course to the student's courses
                String newCourseIds = student.optString("courses") + "," + courseId;

                // check if the student has more than 6 courses after adding this course
                if (newCourseIds.split(",").length > 6) {
                    throw new Exception("This student can't enroll in more than 6 courses.");
                }

                // check if the student is already enrolled in this course
                if (newCourseIds.contains(courseId)) {
                    throw new Exception("This student is already enrolled in this course.");
                }

                // update the student's data
                student.put("courses", newCourseIds);
                students.put(studentId, student);

                // update students data file
                FileWriter writer = new FileWriter("C:\\Users\\csp\\Documents\\Projects\\LMS\\StudentsData.csv");
                writer.write("id,name,grade,email,courses\n");
                for (String key : students.keySet()) {
                    JSONObject s = students.getJSONObject(key);
                    writer.write(s.optString("id") + "," + s.optString("name") + "," + s.optString("grade") + "," + s.optString("email") + "," + s.optString("courses") + "\n");
                }
                writer.close();

                System.out.println("Course added successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // update students data file
            try {
                FileWriter writer = new FileWriter("C:\\Users\\csp\\Documents\\Projects\\LMS\\StudentsData.csv");
                writer.write("id,name,grade,email,courses\n");
                for (String key : students.keySet()) {
                    JSONObject s = students.getJSONObject(key);
                    writer.write(s.optString("id") + "," + s.optString("name") + "," + s.optString("grade") + "," + s.optString("email") + "," + s.optString("courses") + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Course added successfully.");
        }
    }

    private static String readFile(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private static JSONObject csvToJson(String csvData) {
        String[] lines = csvData.split("\n");
        String[] headers = lines[0].split(",");
        JSONObject json = new JSONObject();
        for (int i = 1; i < lines.length; i++) {
            JSONObject obj = new JSONObject();
            String[] values = lines[i].split(",");
            for (int j = 0; j < values.length; j++) {
                obj.put(headers[j], values[j]);
            }
            json.put(obj.optString("id"), obj);
        }
        return json;
    }
}