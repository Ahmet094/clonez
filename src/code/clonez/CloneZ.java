package code.clonez;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CloneZ extends JavaPlugin {

	YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml"));
	
	public void onEnable() {
		registerEvents();
		createConfig();
	}
	
	private void createConfig() {
		boolean exists = new File(getDataFolder(), "config.yml").exists();
        if (!exists) {
            new File("plugins/CloneZ").mkdir();
            config.options().header("CloneZ, made by Sushi, Mrbluebear3, Ahmet094, NP98765 and Husky!");
            
            try {
                config.save(new File(getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

	private void registerEvents() { // used to keep onEnable clean
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new CloneZListener(), this);
	}

}
