package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;

public class CountItem extends SimpleItem{
    final int count;

    public CountItem(JsonObject json){
        super(json);
        count = json.get("count").getAsInt();
        jsonObject.remove("count");
    }
}

