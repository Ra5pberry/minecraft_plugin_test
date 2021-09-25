package jp.sophia;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sophia extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LuckPerms api = LuckPermsProvider.get();

        Bukkit.getPluginManager().registerEvents(new EventListener(this, api), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
