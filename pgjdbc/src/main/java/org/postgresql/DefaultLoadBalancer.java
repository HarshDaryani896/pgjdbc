package org.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.core.QueryExecutor;
import org.postgresql.jdbc.PgConnection;
import static org.postgresql.Driver.*;

/**
 * Default load balancer implements the stock driver behaviour. 
 */
public class DefaultLoadBalancer implements LoadBalancer{

 /**
   * Create a connection from URL and properties.
   * connect() invokes this implemented method while processing a new connection request.
   *
   * @param url the original URL
   * @param properties the parsed/defaulted connection properties
   * @return a new connection
   * @throws SQLException if the connection could not be made
   */
    @Override
    public Connection makeConnection(String url, Properties properties) throws SQLException {
        return new PgConnection(hostSpecs(properties), properties, url);
    }
    
  /**
   * Method for updating connection info if required for load-balancing.
   * PgConnection.close() invokes this implemented method after the connection is closed.
   * no-op for stock driver behaviour
   * 
   */
  @Override
  public void closeConnection(QueryExecutor queryExecutor) throws SQLException {
    //no-op
  }
}