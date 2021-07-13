package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;

public class ItemFactory {
    public static IItem generateItem(JsonObject json) {
        if (json.has("count")) {//never happens
            return new CountItem(json);
        }
        if (json.has("vanilla") && json.get("vanilla").getAsBoolean()) {
            return new VanillaItem(json);
        }
        json.remove("vanilla"); //remove vanilla attribute since its false
        return new SimpleItem(json);
    }

    public static int getStackSize(IItem item) {
        if (item instanceof CountItem) {
            return ((CountItem) item).count;
        } else {
            return 1;
        }
    }
}
