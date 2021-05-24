package io.github.moulberry.notenoughupdates.items;

import com.google.gson.JsonObject;
import io.github.moulberry.notenoughupdates.NEUManager;
import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ItemUtils {
    public final static NEUManager manager = NotEnoughUpdates.INSTANCE.manager;

    public static ItemStack itemToStack(IItem item) {
        return itemToStack(item, true);
    }

    public static ItemStack itemToStack(IItem item, boolean useCache) {
        return itemToStack(item, useCache, true);
    }

    public static ItemStack itemToStack(IItem item, boolean useCache, boolean useReplacements) {
        return itemToStack(item, useCache, useReplacements, true);
    }

    public static ItemStack itemToStack(IItem item, boolean useCache, boolean useReplacements, boolean copyStack){
        if(item.getJson() == null) return new ItemStack(Items.painting, 1, 10);
        String internalname = item.getInternalName();

        final Map<String,ItemStack> itemCache = manager.itemstackCache;
        if(useCache) {
            ItemStack stack = itemCache.get(internalname);
            if(stack != null) {
                if(copyStack) {
                    return stack.copy();
                } else {
                    return stack;
                }
            }
        }

        ItemStack stack = new ItemStack(item.getItemType());

        stack.stackSize = ItemFactory.getStackSize(item);

        if(stack.getItem() == null) {
            stack = new ItemStack(Item.getItemFromBlock(Blocks.stone), 0, 255); //Purple broken texture item
        } else {
            if(item.getJson().has("damage")) {
                stack.setItemDamage(item.getJson().get("damage").getAsInt());
            }

            if(item.getJson().has("nbttag")) {
                try {
                    NBTTagCompound tag = JsonToNBT.getTagFromJson(item.getJson().get("nbttag").getAsString());
                    stack.setTagCompound(tag);
                } catch(NBTException ignored) {
                }
            }

            HashMap<String, String> replacements = new HashMap<>();

            if(useReplacements) {
                replacements = manager.getLoreReplacements(stack.getTagCompound(), -1);

                String displayname = item.getJson().get("displayname").getAsString();
                for(Map.Entry<String, String> entry : replacements.entrySet()) {
                    displayname = displayname.replace("{"+entry.getKey()+"}", entry.getValue());
                }
                stack.setStackDisplayName(displayname);
            }

            if(item.getJson().has("lore")) {
                NBTTagCompound display = new NBTTagCompound();
                if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("display")) {
                    display = stack.getTagCompound().getCompoundTag("display");
                }
                display.setTag("Lore", manager.processLore(item.getJson().get("lore").getAsJsonArray(), replacements));
                NBTTagCompound tag = stack.getTagCompound() != null ? stack.getTagCompound() : new NBTTagCompound();
                tag.setTag("display", display);
                stack.setTagCompound(tag);
            }
        }

        if(useCache) itemCache.put(internalname, stack);
        if(copyStack) {
            return stack.copy();
        } else {
            return stack;
        }
    }
}
