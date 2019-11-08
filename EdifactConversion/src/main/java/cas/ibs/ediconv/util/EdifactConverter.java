package cas.ibs.ediconv.util;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.StringResult;
import org.xml.sax.SAXException;

/**
 * Simple example main class.
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class EdifactConverter {

    private static byte[] messageIn = readInputMessage();

    public static String runSmooksTransform() throws IOException, SAXException, SmooksException {
    	
    	Locale defaultLocale = Locale.getDefault();
    	Locale.setDefault(new Locale("en", "IE"));
    	
        // Instantiate Smooks with the config...
        Smooks smooks = new Smooks("smooks-config.xml");
        try {
             // Create an exec context - no profiles....
            ExecutionContext executionContext = smooks.createExecutionContext();

            StringResult result = new StringResult();

            // Configure the execution context to generate a report...
            executionContext.setEventListener(new HtmlReportGenerator("target/report/report.html"));

            // Filter the input message to the outputWriter, using the execution context...
            smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), result);

            Locale.setDefault(defaultLocale);

            return result.getResult();
        } finally {
            smooks.close();
        }
    }

    public static void main(String[] args) throws IOException, SAXException, SmooksException {
        System.out.println("\n\n==============Message In==============");
        System.out.println(new String(messageIn));
        System.out.println("======================================\n");


       // pause("The EDI input stream can be seen above.  Press 'enter' to see this stream transformed into XML...");

        String messageOut = EdifactConverter.runSmooksTransform();
        XmlToDtoConverter.getObjectFromXml(messageOut);

        System.out.println("==============Message Out=============");
        System.out.println(messageOut);
        System.out.println("======================================\n\n");

      //  pause("And that's it!  Press 'enter' to finish...");
    }

    private static byte[] readInputMessage() {
        try {
            return StreamUtils.readStream(
            		EdifactConverter.class.getClassLoader().getResourceAsStream("sbresfedd.edi"));
        } catch (IOException e) {
            e.printStackTrace();
            return "<no-message/>".getBytes();
        }
    }

    private static void pause(String message) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("> " + message);
            in.readLine();
        } catch (IOException e) {
        }
        System.out.println("\n");
    }
}

