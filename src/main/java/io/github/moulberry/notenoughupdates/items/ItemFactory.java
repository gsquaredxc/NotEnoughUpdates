package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;

public class ItemFactory {
    public static IItem generateItem(JsonObject json){
        if (json.has("count")){
            return new CountItem(json);
        } else {
            return new SimpleItem(json);
        }
    }

    public static int getStackSize(IItem item){
        if (item instanceof CountItem){
            return ((CountItem) item).count;
        } else {
            return 1;
        }
    }
}
