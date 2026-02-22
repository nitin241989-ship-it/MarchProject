package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * This class creates Extent Report instance
 * Singleton Pattern used (Only one report instance)
 */

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String path = System.getProperty("user.dir") 
                    + "/reports/ExtentReport.html";

            ExtentSparkReporter spark = 
                    new ExtentSparkReporter(path);

            spark.config().setReportName("TutorialsNinja Automation Report");
            spark.config().setDocumentTitle("Hybrid Framework Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Vivek Kumar");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}