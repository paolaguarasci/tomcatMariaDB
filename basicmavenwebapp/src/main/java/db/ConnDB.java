package it.artemat.test.db;

import java.util.HashMap;
import java.util.Map;

public class ConnDB {
  public static Map<String, String> getEnv() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("user", System.getenv("MYSQL_USER"));
    map.put("pass", System.getenv("MYSQL_PASSWORD"));
    map.put("root_pass", System.getenv("MYSQL_ROOT_PASSWORD"));
    map.put("db", System.getenv("MYSQL_DATABASE"));
    return map;
  }
}
