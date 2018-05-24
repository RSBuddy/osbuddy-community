package com.rsbuddy.osrs.plugins.example;

import com.rsbuddy.osrs.Plugin;
import com.rsbuddy.osrs.PluginContext;
import com.rsbuddy.osrs.annotation.Paint;
import com.rsbuddy.osrs.annotation.Schedule;
import com.rsbuddy.osrs.annotation.Setting;
import com.rsbuddy.osrs.content.ui.Bank;
import com.rsbuddy.osrs.game.Game;
import com.rsbuddy.osrs.game.ui.Interfaces;
import com.rsbuddy.osrs.game.ui.PaintHook;
import com.rsbuddy.osrs.game.ui.Paintable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.awt.*;

@Paint(PaintHook.TLI)
public class ExamplePlugin implements Plugin, Paintable {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private Game game;

    @Inject
    private Bank bank;

    @Setting("Draw hello world")
    private boolean draw;

    @Override
    public void init(PluginContext pluginContext) {
        log.info("init!");
    }

    @Override
    public void dispose(PluginContext pluginContext) {
        log.info("dispose");
    }

    @Schedule(1000)
    public void loop() {
        log.info("Tick: " + game.time());
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawString(draw ? "Hello world" : (bank.open() ? "Your bank is open!!" : "Your bank isn't open."), 20, 40);
    }

}
