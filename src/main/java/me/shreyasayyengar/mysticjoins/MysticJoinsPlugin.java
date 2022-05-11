package me.shreyasayyengar.mysticjoins;

import dev.esophose.playerparticles.api.PlayerParticlesAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class MysticJoinsPlugin extends JavaPlugin {

    private PlayerParticlesAPI ppAPI;

    @Override
    public void onEnable() {
        getLogger().info("MysticJoinshas been enabled!");

        this.getServer().getPluginManager().registerEvents(new Join(), this);

        if (getServer().getPluginManager().getPlugin("PlayerParticles") != null) {
            ppAPI = PlayerParticlesAPI.getInstance();
        } else {
            getLogger().info("PlayerParticles not found, disabling MysticJoins");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MysticJoinsPlugin getInstance() {
        return JavaPlugin.getPlugin(MysticJoinsPlugin.class);
    }

    public PlayerParticlesAPI getPlayerParticlesAPI() {
        return ppAPI;
    }
}
