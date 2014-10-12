package eu.servertje.manager;


import eu.servertje.model.ContentService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * Author: ronald
 * Date:   9/9/14
 * Description:
 *
 */
public class PersistenceManager implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
       // Add Content service to context
       context.registerService(ContentService.class.getName(),
               new ContentServiceImpl(),
               null);

    }

    @Override
    public void stop(BundleContext context) throws Exception {
//        conn.disconnect();
    }
}
