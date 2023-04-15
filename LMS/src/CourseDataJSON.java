import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CourseDataJSON {

    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\csp\\Documents\\Projects\\LMS\\coursedata (1).xml");
        File outputFile = new File("C:\\Users\\csp\\Documents\\Projects\\LMS\\coursedata.json");
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            NodeList rows = doc.getElementsByTagName("row");
            JSONArray courses = new JSONArray();
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                JSONObject course = new JSONObject();
                course.put("id", row.getElementsByTagName("id").item(0).getTextContent());
                course.put("courseName", row.getElementsByTagName("CourseName").item(0).getTextContent());
                course.put("instructor", row.getElementsByTagName("Instructor").item(0).getTextContent().replace(",", ""));
                course.put("courseDuration", row.getElementsByTagName("CourseDuration").item(0).getTextContent());
                course.put("courseTime", row.getElementsByTagName("CourseTime").item(0).getTextContent());
                course.put("location", row.getElementsByTagName("Location").item(0).getTextContent());
                courses.put(course);
            }
            JSONObject data = new JSONObject();
            data.put("courses", courses);

            FileWriter writer = new FileWriter(outputFile);
            writer.write(data.toString());
            writer.close();

            System.out.println("Conversion completed successfully.");
        } catch (ParserConfigurationException | SAXException | IOException | JSONException ex) {
            ex.printStackTrace();
        }
    }
}
