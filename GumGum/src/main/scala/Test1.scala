/**
  *
  * */
import java.util.regex.{Matcher, Pattern}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark._
//import org.apache.spark.sql.{SQLContext, SparkSession}
//import spray.json._
import scala.util.parsing.json._
object Test1 {
  def main(args: Array[String]): Unit = {

    case class Event(
        v: String, e:String,et:String, t:String,u:String,pu:String,bk:String,pv:String
    )
    val conf = new SparkConf().setAppName("Word Count").setMaster("local")
    conf.set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)
    val input = sc.textFile("src/main/resources/ad-events")
    System.out.println("Hello World!")

    val count = input.map(line ⇒ line.split(", ", 2)(1))

    val c = count.map(line ⇒ line.split("\\}, ",2)(1))
    System.out.println(count.count())
    val result =  c.map(line => JSON.parseFull(line))
    //    val res = result.map(line => line.get("e"))
//    val m = Pattern.compile("\\{(.*?)\\}")
//    val dum = count.filter(row ⇒ row.matches("\\{(.*?)\\}"))
//      .map(word ⇒ (word, 1))
//      .reduceByKey(_ +_)
//    count.re("people")

//    val sparkSession = SparkSession.builder.
//      master("local")
//      .appName("spark session example")
//      .getOrCreate()

//    val df = sparkSession.read.option("header","true").text("src/main/resources/sales.csv")
    /* saveAsTextFile method is an action that effects on the RDD */
    result.saveAsTextFile("src/resources/outfile")
    System.out.println("OK!!");
    System.out.println(count)
  }
}
