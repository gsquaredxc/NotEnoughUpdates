package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class SimpleItem implements IItem {
    final Item mcItemType;
    final JsonObject jsonObject;
    final String internalName;
    final int damage;
    final String displayname;
    final NBTTagCompound tag;

    public SimpleItem(JsonObject json){
        NBTTagCompound tag1;
        //this probably isnt great for GC but idk how else to do it
        mcItemType = Item.itemRegistry.getObject(new ResourceLocation(json.get("itemid").getAsString()));
        json.remove("itemid");
        internalName = json.get("internalname").getAsString();
        json.remove("internalname");
        if (json.has("damage")) {
            damage = json.get("damage").getAsInt();
            json.remove("damage");
        } else {
            damage = 0;
            System.err.println("Error, damage missing for: " + internalName);
        }
        displayname = json.get("displayname").getAsString();
        json.remove("displayname");
        try {
            tag1 = JsonToNBT.getTagFromJson(json.get("nbttag").getAsString());
            json.remove("nbttag");
        } catch (NBTException e) {
            e.printStackTrace();
            tag1 = null;
        }
        tag = tag1;
        if (internalName == null || mcItemType == null || displayname == null){
            throw new NullPointerException(json.toString());
        }
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

    @Override
    public String getInternalName(){
        return internalName;
    }

    @Override
    public int getDamage(){
        return damage;
    }

    @Override
    public String getDisplayName(){
        return displayname;
    }

    @Override
    public NBTTagCompound getNBT(){
        return tag;
    }

    @Override
    public JsonObject generateJson(){
        JsonObject output = ItemUtils.deepCopy(jsonObject);
        output.addProperty("itemid", mcItemType.getRegistryName());
        output.addProperty("internalname", internalName);
        output.addProperty("damage", damage);
        output.addProperty("displayname", displayname);
        return output;
    }
}
