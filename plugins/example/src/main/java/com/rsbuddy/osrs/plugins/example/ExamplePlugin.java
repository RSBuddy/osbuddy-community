package com.rsbuddy.osrs.plugins.example;

import com.rsbuddy.osrs.Plugin;
import com.rsbuddy.osrs.PluginContext;
import com.rsbuddy.osrs.content.ui.Bank;
import com.rsbuddy.osrs.game.Game;
import com.rsbuddy.osrs.game.ui.Interfaces;
import com.rsbuddy.osrs.game.ui.PaintHook;
import com.rsbuddy.osrs.game.ui.Paintable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.awt.*;

public class ExamplePlugin implements Plugin, Paintable {

    final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    Game game;

    @Inject
    Bank bank;

    @Inject
    Interfaces ui;

    boolean running;

    @Override
    public void init(PluginContext pluginContext) {
        running = true;
        ui.register(PaintHook.TLI, this);
        game.loop(() -> {
            log.info("Tick: " + game.time());
            return running;
        }, 1000, "Bank check loop");
    }

    @Override
    public void dispose(PluginContext pluginContext) {
        running = false;
        ui.unregister(this);
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawString(bank.open() ? "Your bank is open!!" : "Your bank isn't open.", 20, 40);
    }

}
