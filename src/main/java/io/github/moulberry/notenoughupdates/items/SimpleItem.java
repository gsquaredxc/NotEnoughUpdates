package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class SimpleItem implements IItem {
    final Item mcItemType;
    final JsonObject jsonObject;
    final String internalName;

    public SimpleItem(JsonObject json){
        mcItemType = Item.itemRegistry.getObject(new ResourceLocation(json.get("itemid").getAsString()));
        json.remove("itemid");
        internalName = json.get("internalname").getAsString();
        json.remove("internalname");
        jsonObject = json;
        if (internalName == null || mcItemType == null){
            throw new NullPointerException();
        }
    }

    @Override
    public JsonObject getJson() {
        return jsonObject;
    }

    @Override
    public Item getItemType() {
        return mcItemType;
    }

    @Override
    public String getInternalName(){
        return internalName;
    }
}
