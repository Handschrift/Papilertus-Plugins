package com.funplugin.init;

import com.funplugin.commands.MemeCommand;
import com.funplugin.commands.SpiritAnimalCommand;
import com.papilertus.commands.core.Command;
import com.papilertus.plugin.Plugin;
import com.papilertus.plugin.PluginConfig;
import com.papilertus.plugin.PluginData;
import com.papilertus.plugin.PluginDataStore;
import net.dv8tion.jda.api.hooks.EventListener;

import java.util.ArrayList;
import java.util.List;

public class FunPlugin implements Plugin {

    private FunConfig funConfig;
    private PluginDataStore dataStore;

    @Override
    public void onLoad(PluginData pluginData) {
        final PluginConfig config = new PluginConfig(pluginData);
        config.fromObject(new FunConfig());
        funConfig = config.toObject(FunConfig.class);
        dataStore = new PluginDataStore(pluginData);
    }

    @Override
    public List<Command> getCommands() {
        final ArrayList<Command> commands = new ArrayList<>();
        commands.add(new MemeCommand(funConfig.getMemeSubreddit()));
        commands.add(new SpiritAnimalCommand(dataStore));
        return commands;
    }

    @Override
    public List<? extends EventListener> getListeners() {
        return null;
    }

    @Override
    public void onUnload() {

    }
}
