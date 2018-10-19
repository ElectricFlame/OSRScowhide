package scripts;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;


import java.util.ArrayList;
import java.util.List;

import scripts.Tasks.Bank;
import scripts.Tasks.Pick;
import scripts.Tasks.Walk;

@Script.Manifest(name="hide", description = "Pickup Hide", properties = "author=Jordan; topic=999 client=4")

public class Hide extends PollingScript<ClientContext> {


    List<Task> taskList = new ArrayList<Task>();


    @Override
    public void start() {


        taskList.add(new Bank(ctx));
        taskList.add(new Walk(ctx));
        taskList.add(new Pick(ctx));
    }

    @Override
    public void stop() {

    }


    @Override
    public void poll() {
        for (Task task : taskList) {
            if(task.activate()){
                task.execute();
                break;
            }
        }
    }
}



