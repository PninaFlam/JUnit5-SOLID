package org.example.lifeCycle;

import org.junit.jupiter.api.extension.*;

public class ExtensionAtidStore extends LogExtension
        implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    /**
     * Callback that is invoked once <em>before</em> all tests in the current
     * container.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        writeToLog("Start " + context.getDisplayName());
    }

    /**
     * Callback that is invoked <em>before</em> an individual test and any
     * user-defined setup methods for that test have been executed.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        writeToLog("Start test " + context.getDisplayName());
    }

    /**
     * Callback that is invoked once <em>after</em> all tests in the current
     * container.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        writeToLog("Finish All " + context.getDisplayName());
    }

    /**
     * Callback that is invoked <em>after</em> an individual test and any
     * user-defined teardown methods for that test have been executed.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        writeToLog("Finish test " + context.getDisplayName());
    }


}
