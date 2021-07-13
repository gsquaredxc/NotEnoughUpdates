package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;

public class ItemRecipe {
    private final static String[] x = {"1","2","3"};
    private final static String[] y = {"A","B","C"};

    ItemReference[] referenceArr = new ItemReference[9];

    public ItemRecipe(JsonObject o) {
        for (int i = 0; i < 9; i++) {
            String name = y[i / 3] + x[i % 3];
            String itemS = o.get(name).getAsString();
            int count = 1;
            if (itemS != null && itemS.split(":").length == 2) {
                count = Integer.parseInt(itemS.split(":")[1]);
                itemS = itemS.split(":")[0];
            }
            referenceArr[i] = new ItemReference(itemS,count);
        }
    }

    public void allocateRecipe(){
        for (ItemReference r: referenceArr) {
            r.allocateItemReference();
        }
    }
}
