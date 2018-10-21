package scripts.Tasks;

import org.powerbot.script.rt4.ClientContext;
import scripts.Task;

public class Run extends Task {
    public Run(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.movement.energyLevel() > 50);
    }

    @Override
    public void execute() {
        if (!ctx.movement.running() && ctx.movement.energyLevel() > 50){ // asking if you're not running and you have 51%+ energy, if so it will activate the next line.
            ctx.movement.running(true); // this will turn on run if not turned on already.
        } // this closes the if statement.

    }}
