package tests;

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class E2ERepeatedRunner {

    @Test
    void runE2ESuiteRepeatedly() {

        Launcher launcher = LauncherFactory.create();

        for (int i = 1; i <= 20; i++) {
            System.out.println("===== E2E RUN STARTED: " + i + " =====");

            LauncherDiscoveryRequest request =
                    LauncherDiscoveryRequestBuilder.request()
                            .selectors(selectClass(E2ETestSuite.class))
                            .build();

            launcher.execute(request);
        }
    }
}
