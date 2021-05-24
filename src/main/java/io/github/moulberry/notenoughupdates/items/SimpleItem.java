package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class SimpleItem implements IItem {
    final Item mcItemType;
    final JsonObject jsonObject;

    public SimpleItem(JsonObject json){
        mcItemType = Item.itemRegistry.getObject(new ResourceLocation(json.get("itemid").getAsString()));
        json.remove("itemid");
        jsonObject = json;
    }

    @Override
    public JsonObject getJson() {
        return jsonObject;
    }

    @Override
    public Item getItemType() {
        return mcItemType;
    }
}
