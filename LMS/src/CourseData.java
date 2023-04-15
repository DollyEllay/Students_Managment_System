import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CourseData {

    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\csp\\Documents\\Projects\\LMS\\coursedata (1).xml");
        File outputFile = new File("C:\\Users\\csp\\Documents\\Projects\\LMS\\coursedata.csv");
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            NodeList rows = doc.getElementsByTagName("row");
            FileWriter writer = new FileWriter(outputFile);
            // Write CSV header
            String[] header = {"id", "Course Name", "Instructor", "Course duration", "Course time", "Location"};
            String[][] data = new String[rows.getLength()][6];
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                data[i][0] = row.getElementsByTagName("id").item(0).getTextContent();
                data[i][1] = row.getElementsByTagName("CourseName").item(0).getTextContent();
                data[i][2] = row.getElementsByTagName("Instructor").item(0).getTextContent().replace(",", "");
                data[i][3] = row.getElementsByTagName("CourseDuration").item(0).getTextContent();
                data[i][4] = row.getElementsByTagName("CourseTime").item(0).getTextContent();
                data[i][5] = row.getElementsByTagName("Location").item(0).getTextContent();
            }


// Write CSV rows
            writer.write(String.join(",", header) + "\n");
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    writer.write(data[i][j] + ",");
                }
                writer.write("\n");
            }
            writer.close();

            System.out.println("Conversion completed successfully.");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
