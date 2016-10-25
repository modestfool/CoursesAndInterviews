import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.util.parsing.json._


object HelloWorld {
  
  case class Asset(id: String)
  case class Event(id: String, name: String)
  
  def makeEvent(x : String) : Event = {
    val mp : String = x.substring(1, x.length - 1)
    val smp = mp.replace("\"", "")
    val parts = smp.split(",")
    var name : String = ""
    var id : String = ""
    for(s <- parts){

       val kv : Array[String] = s.split(":")
       if(kv(0).equalsIgnoreCase("e") && 
           (kv(1).equalsIgnoreCase("view") || kv(1).equalsIgnoreCase("click"))) {
             name = kv(1)
       }
       if(kv(0).equalsIgnoreCase("pv")) {
             id = kv(1)
       }
    }
    if(name != null && id != null){
      Event(id, name)
    }
    else{
      null
    }
  }
  def checkE(str : String) : Boolean = {
    val mp : String = str.substring(1, str.length - 1)
    val smp = mp.replace("\"", "")
    val parts = smp.split(",")
    for(s <- parts){
       val kv : Array[String] = s.split(":")
       if(kv(0).equalsIgnoreCase("e") && 
           (kv(1).equalsIgnoreCase("view") || kv(1).equalsIgnoreCase("click"))) {
         return true;
       }    
    }
    false
      //.split(",")
       // .map(_.split(":"))
        //.map { case Array(k, v) => (k.substring(1, k.length-1), v.substring(1, v.length-1))}
        //.toMap
    //System.out.println(mp)
  }

  def main(args: Array[String]) = {
    System.out.println("Hello World");
    
    val conf = new SparkConf()
      .setAppName("GumGum Assignment")
      .setMaster("local")
//      .set("spark.hadoop.validateOutputSpecs", "false")
      
    val context = new SparkContext(conf);
    //val sqlContext = new SQLContext(context);
    
    val inputAssets = context.textFile("src/main/resources/assets")
    
    
    val assets = inputAssets.map(_.split(", ",2)(1))
    val asts = assets.map(line => line.split("\\}, ",2)(1))
    val df = asts.map( x => x.split(",") ).map( x=> Asset(x(1).replace("\"","").split(":")(1)))
    
    df.saveAsTextFile("src/main/resources/asts")

    val x = context.parallelize(Seq(df))
    
    val inputEvents = context.textFile("src/main/resources/ad-events")
    val events = inputEvents.map(line => line.split(", ",2)(1))
    val evnts = events.map(line => line.split("\\}, ",2)(1))         
    val clicksAndViews = evnts.filter( line =>  checkE(line.toString()))
    val df2 = clicksAndViews.map(x => makeEvent(x))
    df2.saveAsTextFile("src/main/resources/evnts")
    
    val y = context.parallelize(Seq(df2))
    
    val groupedAssets = x.groupBy(p => p.id).mapValues(_.size) 
    val groupedEvents = y.groupBy(q => q.id).mapValues(_.size) 
    System.out.println(groupedAssets);
    
    groupedAssets.saveAsTextFile("src/main/resources/ga")
    groupedEvents.saveAsTextFile("src/main/resources/ge")
    
    val a = groupedAssets.keyBy(t => t._1)
    val b = groupedEvents.keyBy(t => t._1)
    
    val jns = groupedAssets.rightOuterJoin(groupedEvents)
    val pr = jns.map(x => System.out.println(x))
    
    jns.saveAsTextFile("src/main/resources/filter")
    
    //val assets = inputAssets.map(_.split(", ",2)(1)).toJavaRDD()
//    val x = context.parallelize(Seq(assets))
//    x.groupBy { x => }
//    
//    val sqlContext = new SQLContext(context)
//    
//    val inputEvents = context.textFile("src/main/resources/events_sample.txt")
//    val events = inputEvents
//      .map(line => line.split(", ",2)(1))
//      
//    val evnts = events.map(line => line.split("\\}, ",2)(1))         
//    val clicksAndViews = evnts.filter( line =>  checkE(line.toString()))

    //val res = assets.map { v => Row(v: _*)}
    //res.saveAsTextFile("src/main/resources/filter")
    
    
  }
}