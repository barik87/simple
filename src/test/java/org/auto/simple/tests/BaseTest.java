package org.auto.simple.tests;

import org.apache.log4j.Logger;
import org.auto.simple.data.DataFile;
import org.auto.simple.report.ErrorsHolder;
import org.auto.simple.report.Reporter;
import org.auto.simple.webBrowser.BrowserType;
import org.auto.simple.webBrowser.WebBrowser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.auto.simple.webBrowser.WebBrowser.*;

/**
 * Class that contains properties and methods which are common for all the tests. Start point of tests execution -
 * testTemplate() method.
 *
 * @author Maksym Barvinskyi
 */
public abstract class BaseTest {
    private Reporter reporter;
    private String dataFilePath;
    private String testName;
    private List<HashMap<String, String>> dataTable;
    protected HashMap<String, String> data;
//    protected WebDriver browser;

    public static Logger log = Logger.getLogger(BaseTest.class.getName());


    public BaseTest(String dataFilePath, String testName) throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/firefox/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        WebBrowser.setBrowserType(BrowserType.CHROME);
        this.testName = testName;
        this.dataFilePath = dataFilePath;
    }

    /**
     * Single unit test that contains basic structure of every automation test.
     */
    @Test
    public void testTemplate() {
        try {
            beforeTestExecute();
            for (int iter = 0; iter < dataTable.size(); iter++) {
                beforeIteration(iter);
                try {
                    WebBrowser.getInstance();
                    log.info("Browser started");
                    log.info("tests executed");
                    onExecute();
                    quitBrowser();
                    onIterationPassed();
                } catch (AssertionError | Exception error) {
                    onError(error);
                    log.info("Test FAILED");
                }
            }
        } catch (AssertionError | Exception configException) {
            configException.printStackTrace();
            Assert.fail("Configuration Exception: " + configException.getMessage());
        }
        afterTestExecute();
    }

    /**
     * Actions of the functional test. Normally they are presented as private methods of high level action.
     */
    protected abstract void onExecute();

    /**
     * Starts the browser instance.
     */
//    private void startBrowser() {
//        this.browser = new ChromeDriver();
//    }
    private void onIterationPassed() {
        reporter.onIterationPassed();
    }

    /**
     * Actions that will be performed before test execution. Here the system property of Chrome and IE drivers location
     * are set up.
     */
    private void beforeTestExecute() throws Exception {
        this.reporter = new Reporter();
        this.dataTable = new DataFile(dataFilePath).getDataTable();
        log.info("Before test ");
    }

    private void beforeIteration(int iteration) {
        ErrorsHolder.cleanUp();
        reporter.setCurrentIteration(iteration + 1);
        data = dataTable.get(iteration);
        log.info("Before iteration " + data);
    }

    private void onError(Throwable fail) {
        ErrorsHolder.setFailsTrue();
        String message = "";
        if (fail.getMessage() != null) {
            message = fail.getMessage();
            log.info("Error " + message);
        }
        reporter.onIterationFailed(message);

        quitBrowser();
    }

    private void afterTestExecute() {
        try {
            reporter.generateReport(testName);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Report Exception: " + e.getMessage());
        }
        ErrorsHolder.failUnitTest(reporter.getFailedIterations());
    }

    /**
     * Closes the browser instance.
     */
//    private void closeBrowser() {
//        quit();
//    }
}
