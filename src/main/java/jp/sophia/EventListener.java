package jp.sophia;

import com.gamingmesh.jobs.api.JobsExpGainEvent;
import com.gamingmesh.jobs.api.JobsLevelUpEvent;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.log.LogPublishEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;

public class EventListener implements Listener {

    private final Sophia sophia;

    public EventListener(Sophia sophia, LuckPerms luckPerms) {
        this.sophia = sophia;

        EventBus ebus = luckPerms.getEventBus();
        ebus.subscribe(this.sophia, LogPublishEvent.class, e -> {
            /** do something */
        });
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        e.setJoinMessage("this is setJoinMessage!");
    }

    @EventHandler
    public void PlayerLoginEvent(PlayerLoginEvent e) {
        getLogger().info("this is info message");
    }

    @EventHandler
    public void onJobsExpGain(JobsExpGainEvent e) {
        getLogger().info(e.getPlayer().getName() + " has got exp!");

    }

    @EventHandler
    public void onJobsLevelUp(JobsLevelUpEvent e) {
        e.getPlayer().getPlayer().sendMessage("you've got leveled up!");

    }

}
