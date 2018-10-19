package scripts.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import scripts.Task;

import java.util.concurrent.Callable;

public class Bank extends Task
{
    public Bank(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count()>27 && ctx.bank.nearest().tile().distanceTo(ctx.players.local())<6;
    }

    @Override
    public void execute() {
            if(ctx.bank.opened()){
                final int inventcount = ctx.inventory.select().count();
                        Condition.wait(new Callable<Boolean>(){
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.inventory.select().count() !=inventcount;
                    }
                }, 250, 20);
              if (ctx.bank.depositInventory()){

              }
            } else {
                if(ctx.bank.inViewport()){
                if (ctx.bank.open()) {
                    Condition.wait(new Callable<Boolean>(){
                        @Override
                        public Boolean call() throws Exception {
                            return ctx.bank.opened();
                        }
                        }, 250, 20);
            } else {
                    ctx.camera.turnTo(ctx.bank.nearest());
                }

    }
}}}
