package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;

public class VanillaItem extends SimpleItem {
    public VanillaItem(JsonObject json){
        super(json);
        jsonObject.remove("vanilla");
    }

    /*public VanillaItem(IItem iitem){
        this = (VanillaItem) iitem;
        jsonObject.remove("vanilla");
    }*/

    @Override
    public JsonObject generateJson(){
        JsonObject output = super.generateJson();
        output.addProperty("vanilla", true);
        return output;
    }

    @Override
    public boolean getVanilla(){
        return true;
    }
}
