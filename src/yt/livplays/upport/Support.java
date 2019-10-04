package yt.livplays.upport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Support extends JavaPlugin {
	 
	@Override
	public void onEnable() {
		super.onEnable();
		
		String pluginVersion = this.getDescription().getVersion();
		
		System.out.println("Supportplugin von livPlaysYT gestartet. Die installierte Version des Plugins ist " + pluginVersion);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = null;
		if(sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (player != null) {
			if (command.getName().equalsIgnoreCase("support")) {
				if (args.length == 0) {
					sender.sendMessage("Bitte gebe eine Supportnachricht an.");
				} else {
					String ok = String.join(" ", args);
					
					if(player.hasPermission("supportplugin.supporter")) {
						Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "[SUPPORT] " + ChatColor.RED + player.getDisplayName() + ChatColor.RED + ": " + ChatColor.BLUE + ok);
					} else {
						Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "[SUPPORT] " + ChatColor.BLUE + player.getDisplayName() + ChatColor.BLUE + ": " + ChatColor.BLUE + ok);
					}
					return true;
				}
			}
		}
		
		return false;
	}
	
}
