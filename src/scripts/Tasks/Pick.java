package scripts.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GroundItem;
import scripts.Task;

import java.util.concurrent.Callable;



public class Pick extends Task {

    final static int Hide = 1739;

    public Pick(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.players.local().speed() == 0 && ctx.inventory.select().count() < 28);
    }

    @Override
    public void execute() {

        final GroundItem Cowhide;
        Cowhide = ctx.groundItems.select().id(Hide).nearest().poll();
        Cowhide.interact("Take", "Cowhide");

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().speed() != 0;
            }
        }, 250, 12);
    }
}


