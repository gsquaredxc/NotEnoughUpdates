package io.github.moulberry.notenoughupdates.items;

import java.util.TreeMap;

/**
 * Reference for IItem for recipes.
 * Stores either a pointer to an IItem from the itemMap, or the string.
 * Reduces memory footprint AND calculation footprint.
 */
public class ItemReference {
    private static final TreeMap<String,IItem> itemMap = ItemUtils.manager.getItemInformation();

    String internalName;
    IItem itemReference;
    final int count;

    public ItemReference(String internalName, int count){
        this.internalName = internalName;
        this.count = count;
    }

    public IItem getItemReference() {
        if (itemReference == null){ //allocation boolean is not needed as ifnull exists
            allocateItemReference();
        }
        return itemReference;
    }

    public int getCount(){
        return count;
    }

    public void allocateItemReference(){
        itemReference = itemMap.get(internalName);
        internalName = null;
    }
}
