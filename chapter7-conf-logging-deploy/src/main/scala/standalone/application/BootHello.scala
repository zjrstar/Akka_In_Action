package standalone.application

import akka.actor.{Props, ActorSystem}
import scala.concurrent.duration._

/**
  * Created by Jerry on 3/16/16.
  */
object BootHello extends App{
  val system = ActorSystem("hellokernel")
  val actor = system.actorOf(Props[HelloWorld])
  val config = system.settings.config
  val timer = config.getInt("helloWorld.timer")
  system.actorOf(Props(new HelloWorldCaller(timer millis,
    actor)))
}
