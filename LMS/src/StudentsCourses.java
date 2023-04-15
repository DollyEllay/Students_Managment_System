import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class StudentsCourses {

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

            // replace a course
            System.out.print("Enter course id to replace: ");
            String oldCourseId = scanner.nextLine();
            System.out.print("Enter new course id: ");
            String newCourseId = scanner.nextLine();

            // validate course ids
            if (!courses.has(oldCourseId) || !courses.has(newCourseId)) {
                System.out.println("Invalid course id(s)");
                return;
            }

            // check if student has any enrolled courses
            if (courseIds == null || courseIds.length == 0 || courseIds[0].isEmpty()) {
                System.out.println("This student hasn't enrolled in any courses");
                return;
            }

            // check if student is enrolled in the old course
            boolean foundOldCourse = false;
            for (String courseId : courseIds) {
                if (courseId.equals(oldCourseId))
                    // check if student is enrolled in the old course
                    boolean foundOldCourse = false;
                for (String courseId : courseIds) {
                    if (courseId.equals(oldCourseId)) {
                        foundOldCourse = true;
                        break;
                    }
                }

                if (!foundOldCourse) {
                    throw new IllegalArgumentException("Cannot update enrollment. Student is not enrolled in old course.");
                }

                // check if the new course id is already enrolled
                if (Arrays.asList(courseIds).contains(newCourseId)) {
                    throw new IllegalArgumentException("Cannot update enrollment. Student is already enrolled in new course.");
                }

                // replace the old course id with the new one
                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i].equals(oldCourseId)) {
                        courseIds[i] = newCourseId;
                        break;
                    }
                }

                // update student's course enrollment
                student.put("courses", String.join(",", courseIds));

                // update students data in file
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\csp\\Documents\\Projects\\LMS\\StudentsData.csv");
                    writer.write(jsonToCsv(students));
                    writer.close();
                    System.out.println("Course enrollment updated successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while updating course enrollment: " + e.getMessage());
                }
            }
        }

        /**
         * Reads the contents of a CSV file and returns them as a string.
         */
        public static String readFile (String filename){
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
            return contentBuilder.toString();
        }

        /**
         * Converts a CSV string to a JSON object.
         */
        public static JSONObject csvToJson (String csv){
            String[] lines = csv.split("\n");
            String[] headers = lines[0].split(",");
            JSONObject jsonObject = new JSONObject();
            for (int i = 1; i < lines.length; i++) {
                String[] fields = lines[i].split(",");
                JSONObject row = new JSONObject();
                for (int j = 0; j < fields.length; j++) {
                    row.put(headers[j], fields[j]);
                }
                jsonObject.put(fields[0], row);
            }
            return jsonObject;
        }

        /**
         * Converts a JSON object to a CSV string.
         */
        public static String jsonToCsv (JSONObject json){
            StringBuilder csvBuilder = new StringBuilder();
            String[] headers = {"id", "name", "grade", "email", "courses"};
            csvBuilder.append(String.join(",", headers)).append("\n");
            for (String id : json.keySet()) {
                JSONObject row = json.getJSONObject(id);
                String[] fields = {id, row.getString("name"), row.getString("grade"), row.getString("email"), row.getString("courses")};
                csvBuilder.append(String.join(",", fields)).append("\n");
            }
            return csvBuilder.toString();
        }
    }
}

