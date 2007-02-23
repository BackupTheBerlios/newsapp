package newsletter.junit.business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
  
    public static Test suite() {

        TestSuite suite = new TestSuite();

        suite.addTest(new ArticleTest());
        return suite;
    }

    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
