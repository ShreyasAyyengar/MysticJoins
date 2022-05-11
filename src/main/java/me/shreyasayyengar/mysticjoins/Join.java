package me.shreyasayyengar.mysticjoins;

import dev.esophose.playerparticles.api.PlayerParticlesAPI;
import dev.esophose.playerparticles.particles.ParticleEffect;
import dev.esophose.playerparticles.particles.data.OrdinaryColor;
import dev.esophose.playerparticles.styles.DefaultStyles;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Join implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Color color = Color.LIME;
        PlayerParticlesAPI api = MysticJoinsPlugin.getInstance().getPlayerParticlesAPI();
        api.addActivePlayerParticle(player, ParticleEffect.DUST, DefaultStyles.NORMAL, new OrdinaryColor(color.getRed(), color.getGreen(), color.getBlue()));


        new BukkitRunnable() {

            @Override
            public void run() {
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);
            }
        }.runTaskLater(MysticJoinsPlugin.getInstance(), 5 * 20);

        new BukkitRunnable() {

            @Override
            public void run() {
                api.removeActivePlayerParticles(player, ParticleEffect.DUST);
            }
        }.runTaskLater(MysticJoinsPlugin.getInstance(), 20 * 10);
    }
}
