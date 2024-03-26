package me.litedeforged.ldcore.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Components {
    public Component components(String s) {
        return MiniMessage.miniMessage().deserialize(s);
    }
}
