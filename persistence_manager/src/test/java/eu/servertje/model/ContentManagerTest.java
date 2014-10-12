package eu.servertje.model;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


@RunWith(JUnit4TestRunner.class)
public class ContentManagerTest {

    private static final int TIME_BETWEEN_TESTS = 500;

    @Inject
    private BundleContext context;


    @Configuration
    public static Option[] configuration() {
        return options(
                felix(),
                mavenBundle().groupId("org.mongodb").artifactId("mongo-java-driver").version("2.12.3"),
                mavenBundle().groupId("eu.servertje").artifactId("persistence_manager").version("0.0-SNAPSHOT")
//                        bundle("file:/home/ronald/dev/projects/franklin/out/bundles/persistence_manager-0.0-SNAPSHOT.jar")
        );
    }

    @Test
    public void basicTest() {
        System.out.println("Basic test");
        assertTrue(true);
        assertNotNull(context);
    }

    @Test
    public void simpleContestTest() throws InterruptedException {
        System.out.println("Simple Content Test");
        ServiceReference ref = context.getServiceReference(ContentService.class.getName());
        assertNotNull(ref);
        ContentService cs = (ContentService) context.getService(ref);
//        Thread.sleep(TIME_BETWEEN_TESTS);
        cs.create(new DefaultContent());


        Content contentA = cs.update();
        assertTrue(contentA.getTitle().equals("default"));
        assertTrue(contentA.getType().equals(ContentType.NONE));

        Content contentB = cs.read();
        assertTrue(contentB.getTitle().equals("default"));
        assertTrue(contentB.getType().equals(ContentType.NONE));

        Content contentC = cs.delete();
        assertTrue(contentC.getTitle().equals("default"));
        assertTrue(contentC.getType().equals(ContentType.NONE));

        Thread.sleep(TIME_BETWEEN_TESTS);
    }


}