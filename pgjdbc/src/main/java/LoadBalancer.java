package org.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.core.QueryExecutor;

/**
 * An interface to implement a custom load balancer. 
 */
public interface LoadBalancer {

 /**
   * Create a connection from URL and properties.
   * connect() invokes this implemented method while processing a new connection request.
   * 
   * @param url the original URL
   * @param properties the parsed/defaulted connection properties
   * @return a new connection
   * @throws SQLException if the connection could not be made
   */
    Connection makeConnection(String url, Properties properties) throws SQLException;

  /**
   * Method for updating connection info if required for load-balancing.
   * PgConnection.close() invokes this implemented method after the connection is closed.
   * 
   */
  public void closeConnection(QueryExecutor queryExecutor) throws SQLException;

}