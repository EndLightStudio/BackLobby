package net.IchigyouRuri.BackLobby;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.net.InetSocketAddress;

public class Main extends PluginBase{

    @Override
    public void onLoad(){
        this.getLogger().info("BackLobby 开始加载");
    }

    @Override
    public void onEnable(){

        this.getLogger().info("BackLobby 加载完毕");
        this.getDataFolder().mkdirs(); //创建插件文件夹
        this.saveDefaultConfig(); //保存默认配置文件
        Config config = this.getConfig(); //读取默认配置文件

    }

    @Override
    public void onDisable(){
        this.getLogger().info("BackLobby 卸载完毕");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        switch(command.getName()){
            case "lobby":
                String ip = Main.this.getConfig().getString("ip");
                int port = Main.this.getConfig().getInt("port");
                ((Player)commandSender).transfer(new InetSocketAddress(ip, port));
                return true;
            default:
                return false;
        }
    }
}