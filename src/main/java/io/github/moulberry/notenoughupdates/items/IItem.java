package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;

public interface IItem {
    JsonObject getJson();
    Item getItemType();
    String getInternalName();
    int getDamage();
    String getDisplayName();
    NBTTagCompound getNBT();

    /**
     * Recalculated every time, not cached. Do not use repeatedly.
     * @return JsonObject
     */
    JsonObject generateJson();
}
