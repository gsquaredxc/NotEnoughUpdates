package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;

public interface IItem {
    JsonObject getJson();
    Item getItemType();
}
