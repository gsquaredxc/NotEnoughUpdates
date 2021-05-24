package io.github.moulberry.notenoughupdates.auction;

public enum AuctionCategory {
    SWORD("sword"),
    ARMOR("armor"),
    BOW("bow"),
    ACCESSORIES("accessories"),
    FISHING_ROD("fishingrod"),
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    PET_ITEM("petitem"),
    EBOOK("ebook"),
    POTION("potion"),
    TRAVEL_SCROLL("travelscroll"),
    REFORGE_STONE("reforgestone"),
    RUNE("rune"),
    FURNITURE("furniture"),
    WEAPON("weapon"),
    TOOL(""),
    PET("pet"),
    BLOCKS("blocks"),
    CONSUMABLES("consumables"),
    MISC("misc");

    public String toMatch;
    
    AuctionCategory(String toMatch){
        this.toMatch = toMatch;
    }

    public static AuctionCategory stringToCategory(String s){
        switch(s) {
            case "sword":
                return SWORD;
            case "armor":
                return ARMOR;
            case "bow":
                return BOW;
            case "accessories":
                return ACCESSORIES;
            case "fishingrod":
                return FISHING_ROD;
            case "pickaxe":
                return PICKAXE;
            case "axe":
                return AXE;
            case "shovel":
                return SHOVEL;
            case "petitem":
                return PET_ITEM;
            case "ebook":
                return EBOOK;
            case "potion":
                return POTION;
            case "travelscroll":
                return TRAVEL_SCROLL;
            case "reforgestone":
                return REFORGE_STONE;
            case "rune":
                return RUNE;
            case "furniture":
                return FURNITURE;
            case "weapon":
                return WEAPON;
            case "":
                return TOOL;
            case "pet":
                return PET;
            case "blocks":
                return BLOCKS;
            case "consumables":
                return CONSUMABLES;
            case "misc":
                return MISC;
        }
        return null;
    }
}
