package duke.hbase.sd;

import java.util.ArrayList;

public class Schema {

  static int SCHEMA_COUNT = 0;

  int id = 0;
  ArrayList<Table> tables = new ArrayList<Table>();

  public Schema() {
    // TODO Auto-generated constructor stub
  }

  public Schema(ArrayList<Table> tables) {
    super();
    this.id = SCHEMA_COUNT++;
    this.tables = tables;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ArrayList<Table> getTables() {
    return tables;
  }

  public void setTables(ArrayList<Table> tables) {
    this.tables = tables;
  }

  // initialize from the hbase connection
  public Schema init(ArrayList<String> table_list) {
    Schema schema = new Schema();
    this.id = SCHEMA_COUNT++;
    return schema;

  }

}