package scripts.Tasks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import scripts.Task;
import scripts.Walker;

public class Walk extends Task {

    public static final Tile pathToBank[] = {new Tile(3256, 3280, 0), new Tile(3256, 3276, 0), new Tile(3256, 3272, 0), new Tile(3254, 3268, 0), new Tile(3250, 3266, 0), new Tile(3250, 3262, 0), new Tile(3250, 3258, 0), new Tile(3250, 3254, 0), new Tile(3252, 3250, 0), new Tile(3255, 3247, 0), new Tile(3258, 3244, 0), new Tile(3259, 3240, 0), new Tile(3259, 3236, 0), new Tile(3259, 3232, 0), new Tile(3258, 3228, 0), new Tile(3254, 3226, 0), new Tile(3250, 3226, 0), new Tile(3246, 3226, 0), new Tile(3242, 3226, 0), new Tile(3238, 3223, 0), new Tile(3234, 3221, 0), new Tile(3230, 3219, 0), new Tile(3226, 3219, 0), new Tile(3222, 3219, 0), new Tile(3218, 3219, 0), new Tile(3215, 3216, 0), new Tile(3215, 3212, 0), new Tile(3211, 3211, 0), new Tile(3207, 3210, 0), new Tile(3205, 3209, 1), new Tile(3205, 3209, 2), new Tile(3205, 3213, 2), new Tile(3206, 3217, 2), new Tile(3209, 3220, 2)};
    private final Walker walker = new Walker(ctx);

    public Walk(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() > 27 || ctx.inventory.select().count() < 28 && pathToBank[0].distanceTo(ctx.players.local()) > 12;
    }

    @Override
    public void execute() {

        if (!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            if (ctx.inventory.select().count()>27){
                walker.walkPath(pathToBank);
            } else {
                walker.walkPathReverse(pathToBank);
            }
    }
    }
}

