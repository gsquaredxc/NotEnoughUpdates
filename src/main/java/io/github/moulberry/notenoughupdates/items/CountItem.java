package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;


/**
 * Not currently used
 */
public class CountItem extends SimpleItem{
    final int count;

    public CountItem(JsonObject json){
        super(json);
        count = json.get("count").getAsInt();
        jsonObject.remove("count");
    }

    @Override
    public JsonObject generateJson(){
        JsonObject output = super.generateJson();
        output.addProperty("count", count);
        return output;
    }
}

