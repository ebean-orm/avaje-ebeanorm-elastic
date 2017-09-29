package integration.support;

import io.ebean.DocumentStore;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.example.domain.Contact;
import org.example.domain.Country;
import org.example.domain.Customer;
import org.example.domain.Order;
import org.example.domain.Product;
import org.example.domain.Vehicle;

/**
 */
public class EmbeddedServer {

  final boolean indexOnStart = true;

  final EbeanServer server;

  final DocumentStore documentStore;

  public EmbeddedServer() {

    server = Ebean.getDefaultServer();
    documentStore = server.docStore();

    init();
  }

  private void init() {

    SeedDbData.reset(false);

    if (indexOnStart) {
      documentStore.indexAll(Country.class);
      documentStore.indexAll(Product.class);
      documentStore.indexAll(Customer.class);
      documentStore.indexAll(Contact.class);
      documentStore.indexAll(Order.class);
      documentStore.indexAll(Vehicle.class);
      try {
        // allow the indexing time to store
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public EbeanServer getServer() {
    return server;
  }
}
