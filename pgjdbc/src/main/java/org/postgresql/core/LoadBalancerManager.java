package org.postgresql.core;

import org.postgresql.util.ObjectFactory;
import org.postgresql.PGProperty;
import java.util.Properties;
import org.postgresql.plugin.LoadBalancerPlugin;

public class LoadBalancerManager {

  public static LoadBalancerPlugin getLoadBalancerPlugin(Properties info) {
    String LoadBalancerClassName = PGProperty.LOAD_BALANCER_PLUGIN_CLASS.getSetString(info);

    if ( LoadBalancerClassName == null ) {
      return new DefaultLoadBalancer();
    } else {
      try {
        System.out.println("Trying "+LoadBalancerClassName);
        return (LoadBalancerPlugin) ObjectFactory.instantiate(LoadBalancerPlugin.class, LoadBalancerClassName, info, false, null);
      } catch (Exception ex ) {
        System.out.println("Unable to load Load-Balancer Plugin");
        return new DefaultLoadBalancer();
      }
    }
  }
}
