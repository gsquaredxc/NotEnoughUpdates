package io.github.moulberry.notenoughupdates.items;

public enum Rarity {
    COMMON("COMMON"),
    UNCOMMON("UNCOMMON"),
    RARE("RARE"),
    EPIC("EPIC"),
    LEGENDARY("LEGENDARY"),
    MYTHIC("MYTHIC"),
    SPECIAL("SPECIAL"),
    VERY_SPECIAL("VERY SPECIAL"),
    SUPREME("SUPREME");

    public String string;

    Rarity(String string){
        this.string = string;
    }

    public static Rarity getRarityFromString(String s){
        switch(s){
            case "COMMON":
                return COMMON;
            case "UNCOMMON":
                return UNCOMMON;
            case "RARE":
                return RARE;
            case "EPIC":
                return EPIC;
            case "LEGENDARY":
                return LEGENDARY;
            case "MYTHIC":
                return MYTHIC;
            case "SPECIAL":
                return SPECIAL;
            case "VERY SPECIAL":
                return VERY_SPECIAL;
            case "SUPREME":
                return SUPREME;

        }
        return null;
    }
}
