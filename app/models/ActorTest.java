package models;

import akka.actor.UntypedActor;

public class ActorTest extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        for (int i = 0; i <= 10; i++) {
            System.out.println("重い処理");
            Thread.sleep(500); 
        }
        this.context().system().shutdown();
    }
    
    @Override
    public void preStart() {
        System.out.println("なにか重い処理始めますよ");
    }
    
    @Override
    public void postStop() {
        System.out.println("重い処理終わりましたよ");
    }
    
}
