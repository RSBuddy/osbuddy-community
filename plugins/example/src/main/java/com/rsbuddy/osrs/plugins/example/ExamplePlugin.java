package com.rsbuddy.osrs.plugins.example;

import com.rsbuddy.osrs.Plugin;
import com.rsbuddy.osrs.PluginContext;
import com.rsbuddy.osrs.content.ui.Bank;
import com.rsbuddy.osrs.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class ExamplePlugin implements Plugin {

    final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    Game game;

    @Inject
    Bank bank;

    boolean running;

    @Override
    public void init(PluginContext pluginContext) {
        running = true;
        game.loop(() -> {
            log.info(bank.open() ? "Your bank is open!!" : "Your bank isn't open.");
            return running;
        }, 1000, "Bank check loop");
    }

    @Override
    public void dispose(PluginContext pluginContext) {
        running = false;
    }

}
