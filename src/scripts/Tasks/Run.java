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
        if (!ctx.movement.running() || ctx.movement.energyLevel() > 50);
            else (ctx.movement.running();

    }}