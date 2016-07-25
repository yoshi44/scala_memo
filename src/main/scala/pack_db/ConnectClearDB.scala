package pack_db

import java.io.File
import java.sql.{Connection, DriverManager, SQLException, Statement}
import org.yaml.snakeyaml.constructor.Constructor
import scala.beans.BeanProperty

class DbConfig {
  @BeanProperty var host: String = ""
  @BeanProperty var databaseName: String = ""
  @BeanProperty var userName: String = ""
}

class PasswordConfig {
  @BeanProperty var databasePassword: String = ""
}

object ConnectClearDB extends App {

  def getCurrentPath: String = {
    new File(".").getAbsoluteFile().getParent()
  }

  def readConfigFile: (String, String) = {
    val currentPath = getCurrentPath
    val dbConfig = scala.io.Source.fromFile(s"${currentPath}/src/main/scala/pack_db/dbConfig.yaml").mkString
    val passwordConfig = scala.io.Source.fromFile(s"${currentPath}/src/main/scala/pack_db/passwordConfig.yaml").mkString
    (dbConfig, passwordConfig)
  }

  def dbConnectionInfo: String = {

    val configFile = readConfigFile

    import org.yaml.snakeyaml.Yaml
    val dbConfigYaml = new Yaml(new Constructor(classOf[DbConfig]))
    val dbConfig = dbConfigYaml.load(configFile._1).asInstanceOf[DbConfig]
    val passwordConfigYaml = new Yaml(new Constructor(classOf[PasswordConfig]))
    val passwordConfig = passwordConfigYaml.load(configFile._2).asInstanceOf[PasswordConfig]

    s"jdbc:mysql://${dbConfig.host}/${dbConfig.databaseName}?user=${dbConfig.userName}&password=${passwordConfig.databasePassword}"
  }

  def connection = {
    Class.forName("com.mysql.jdbc.Driver").newInstance()
    DriverManager.getConnection(connectionName)
  }

  val connectionName = dbConnectionInfo
  var con: Connection = _
  var stmt: Statement = _
  try {
    con = connection
    stmt = con.createStatement
    val rs = stmt.executeQuery("SELECT * FROM t_test")
    while (rs.next()){
      println(rs.getString(1) + " ")
      println(rs.getString(2) + " ")
      println(rs.getString(3) + " ")
      println(rs.getString(4) + " ")
    }
  } catch {
    case e:SQLException => println("Database error "+e)
  } finally {
    stmt.close()
    con.close()
  }
}
