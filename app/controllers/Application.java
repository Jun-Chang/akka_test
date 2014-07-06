package controllers;

import models.ActorTest;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        // なにか重い処理
        ActorSystem system = ActorSystem.create("system");
        ActorRef ref = system.actorOf(Props.create(ActorTest.class));
        ref.tell("test", null);

        // レスポンスはすぐ返す
        return ok(index.render("response  immediately."));
    }

}
