package com.rsbuddy.osrs.content.config;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public interface InterfaceIds {
    interface Common {
        int CHAT_GROUP = 162;
        int ALL_BUTTON_PARENT = 4;
        int REPORT_BUTTON_PARENT = 33;
        int REPORT_BUTTON_TEXT = 36;
        int INDEX_TABS_PARENT = 1;
        int CHAT_AREA_PARENT = 37;
        int CHAT_AREA_INNER = 56;
        int SEARCH_AREA = 40;
        int CHAT_AREA_CONTENTS = 44; // Also: Enter message to send to
        int CHAT_AREA_MESSAGE_VIEW = 58;
        int CHAT_AREA_MESSAGE_VIEW_END = 151;
        int CHAT_MODAL_PARENT = 33;
        int CHAT_MODAL_TITLE = 36;
        int CHAT_MODAL_INPUT = 37;

        int CHAT_SLAYER_TASK_PARENT = 231;
        int CHAT_SLAYER_TASK_MESSAGE = 4;

        int SPLIT_CHAT_AREA = 163;
        int SPLIT_CHAT_AREA_MESSAGE_VIEW = 1;
        int SPLIT_CHAT_AREA_MESSAGE_VIEW_END = 5;
        int SYSTEM_UPDATE = 0;

        int FRIENDS_LIST_PARENT = 429;
        int FRIENDS_LIST_ID = 11;

        int CLAN_CHAT_PARENT = 7;
        int CLAN_CHAT_LIST_ID = 16;

        int CLUE_MODAL_PARENT = 203;
        int CLUE_MODAL_TEXT = 2;

        // RELATIVE TO TLI
        int MINIMAP_ROOT = 17;
        int MINIMAP_PARENT = 28;
        // ~RELATIVE TO TLI

        int RAIDS_GROUP = 513;
        int RAIDS_POINTS = 6;

        int PEST_CONTROL_GROUP = 408;
        int PEST_CONTROL_INFO = 3;

        int NMZ_GROUP = 202;
        int NMZ_ABSORPTION = 3; // child 0 for correct bounds

        int WINTERTODT_GROUP = 396;
        int WINTERTODT_POINTS = 4;

        int GAUNTLET_GROUP = 637;
        int GAUNTLET_TIMER = 4;

        int BLAST_FURNACE_GROUP = 474;
        int BLAST_FURNACE_COFFER = 3;

        int MINIMAP_IFID = 160;
        int MINIMAP_CONTAINER = 0;
        int MINIMAP_HEALTH_ACTION = 4; // contains 'cure'
        int MINIMAP_XP_TOGGLE = 1;
        int MINIMAP_HEALTH = 2;
        int MINIMAP_HEALTH_FILL = 6;
        int MINIMAP_HEALTH_ICON = 11;
        int MINIMAP_PRAYER = 12;
        int MINIMAP_PRAYER_FILL = 16;
        int MINIMAP_PRAYER_ICON = 19;
        int MINIMAP_RUN_ENERGY = 20;
        int MINIMAP_RUN_ENERGY_TOGGLE = 22;
        int MINIMAP_SPECIAL_ATTACK = 28;
        int MINIMAP_SPECIAL_ATTACK_FILL = 32;
        int MINIMAP_SPECIAL_ATTACK_ICON = 35;
        int MINIMAP_WORLD_MAP = 41;
        int MINIMAP_WORLD_MAP_ACTIONS = 43;

        int XP_DROP_GROUP = 122;
        int XP_DROP_PARENT = 16;
        int XP_DROP_BASE = 17;
        int XP_COUNTER_BOUNDS = 3;
        int XP_COUNTER_TEXT = 9;

        int INVENTORY_TAB_COMPONENT = 71;
        int INVENTORY_IFID = 149; // only when bank is not open
        int INVENTORY_COMPONENT = 0;

        int INVENTORY_BANK_COMPONENT = 15;
        int INVENTORY_BANK_SLOTS = 3;

        int COMBAT_IFID = 593;
        int COMBAT_LEVEL_COMPONENT = 3;
        int COMBAT_STYLE_ONE_COMPONENT = 4;
        int COMBAT_STYLE_TWO_COMPONENT = 8;
        int COMBAT_STYLE_THREE_COMPONENT = 12;
        int COMBAT_STYLE_FOUR_COMPONENT = 16;
        int COMBAT_DEFENSIVE_SPELL_COMPONENT = 21;
        int COMBAT_SPELL_COMPONENT = 26;

        int SKILLS_IFID = 320;

        int EQUIPMENT_IFID = 387;
        int EQUIPMENT_HEAD_COMPONENT = 6;
        int EQUIPMENT_CAPE_COMPONENT = 7;
        int EQUIPMENT_NECK_COMPONENT = 8;
        int EQUIPMENT_MAIN_HAND_COMPONENT = 9;
        int EQUIPMENT_CHEST_COMPONENT = 10;
        int EQUIPMENT_OFFHAND_COMPONENT = 11;
        int EQUIPMENT_LEGS_COMPONENT = 12;
        int EQUIPMENT_GLOVES_COMPONENT = 13;
        int EQUIPMENT_BOOTS_COMPONENT = 14;
        int EQUIPMENT_RING_COMPONENT = 15;
        int EQUIPMENT_AMMO_COMPONENT = 16;
        int EQUIPMENT_ITEM_CHILD = 1; // all of the individual components use the 2nd child

        int QUEST_JOURNAL_IFID = 399;
        int QUEST_JOURNAL_FREE_COMPONENT = 6;
        int QUEST_JOURNAL_MEMBERS_COMPONENT = 7;
        int QUEST_JOURNAL_MINIQUEST_COMPONENT = 8;
        Set<Integer> QUEST_JOURNAL_COMPONENTS = ImmutableSet.of(QUEST_JOURNAL_FREE_COMPONENT,
                QUEST_JOURNAL_MEMBERS_COMPONENT, QUEST_JOURNAL_MINIQUEST_COMPONENT);

        int MINIGAMES_IFID = 76;
        int MINIGAMES_SELECTED_COMPONENT = 13; // the value inside the drop-down
        int MINIGAMES_COMBOBOX_COMPONENT = 23;

        int ACHIEVEMENT_DIARIES_IFID = 259;
        int ACHIEVEMENT_DIARIES_COMPONENT = 2; // each diary is a child of this

        int KOUREND_FAVOUR_IFID = 245;

        int MAGIC_IFID = 218;
        int PRAYER_IFID = 541;
        int SETTINGS_IFID = 261;
        int EMOTES_IFID = 216;
        int MUSIC_IFID = 239;

        int QUICK_HOP_IFID = 69;
        int QUICK_HOP_LIST_COMPONENT = 15;

        int WILDERNESS_IFID = 90;
        int WILDERNESS_PARENT_COMPONENT = 60;
        int WILDERNESS_LEVEL_COMPONENT = 66;
    }

    interface PriceChecker {
        // the price checker uses the trade offer inventory
        int GROUP = 464;

        int ITEMS_COMPONENT = 2;
        int TOTAL_VALUE_COMPONENT = 12;

        int ITEMS_CHILD = 0; // the starting child id of the items
        int PRICES_CHILD = 28; // the starting child id of the text under each item
    }

    interface EquipmentDetail {
        int GROUP = 84; // the screen with equipment stats etc
        int EQUIP_YOUR_CHARACTER = 3;
        int HEAD = 11, BASE = HEAD;
        int CAPE = 12;
        int NECK = 13;
        int WEAPON = 14;
        int BODY = 15;
        int SHIELD = 16;
        int LEGS = 17;
        int HANDS = 18;
        int FEET = 19;
        int RING = 20;
        int AMMO = 21;
        Set<Integer> EQUIPMENT_COMPONENTS = ImmutableSet.of(
                HEAD, CAPE, NECK, WEAPON, BODY, SHIELD, LEGS, HANDS, FEET, RING, AMMO);

        int ITEM_CHILD = 1; // the child within each of the equipment components containing the item id

        int ASTAB = 23;
        int ASLASH = 24;
        int ACRUSH = 25;
        int AMAGIC = 26;
        int ARANGE = 27;

        int DSTAB = 29;
        int DSLASH = 30;
        int DCRUSH = 31;
        int DMAGIC = 32;
        int DRANGE = 33;

        int MELEE_STR = 35;
        int RANGE_STR = 36;
        int MAGIC_DMG = 37;
        int PRAYER = 38;

        int UNDEAD_DMG = 40;
        int SLAYER_DMG = 41;

        int WEIGHT = 43;

        int INVENTORY_IFID = 85; // the inventory when the equipment screen is open
        int INVENTORY_PARENT = 0; // the actual 'inventory' (all items are a child of this)
    }

    interface ItemsKeptOnDeath {
        int GROUP = 4;
        int KEPT_ITEMS = 18;
        int LOST_ITEMS = 21;
        int INFO_SPACER = 28;
        int INFO_TEXT = 29;
    }

    interface KillLog {
        int GROUP = 549;
        int TITLE = 3;
        int NAMES = 13;
        int KILLS = 14;
        int INDEX_BOSS_LOG_STREAKS = 15;
    }

    interface Resizeable {
        int COMBAT = 50;
        int STATS = COMBAT + 1;
        int QUEST = STATS + 1;
        int INVENTORY = QUEST + 1;
        int EQUIPMENT = INVENTORY + 1;
        int PRAYER = EQUIPMENT + 1;
        int MAGIC = PRAYER + 1;

        int CLAN = 35;
        int ACCOUNT_MANAGEMENT = CLAN + 1;
        //        int IGNORE = CLAN + 1;
        int FRIEND = ACCOUNT_MANAGEMENT + 1;
        int SETTINGS = FRIEND + 1;
        int EMOTES = SETTINGS + 1;
        int MUSIC = EMOTES + 1;

        int WORLD_MAP_ANCHOR = 25;
        int COMPASS_ANCHOR = 15;
        int COMMON_WIDGET = 13; // the widget for when things are in the way

        int STANDARD_TAB_BORDERS_COMPONENT = 64; // the parent of STANDARD_TAB_COMPONENT
    }

    interface ResizeableHybrid {
        int COMBAT = 51;
        int STATS = COMBAT + 1;
        int QUEST = STATS + 1;
        int INVENTORY = QUEST + 1;
        int EQUIPMENT = INVENTORY + 1;
        int PRAYER = EQUIPMENT + 1;
        int MAGIC = PRAYER + 1;

        int CLAN = 35;
        int IGNORE = CLAN + 1;
        int FRIEND = IGNORE + 1;
        int LOGOUT = FRIEND + 1;
        int SETTINGS = LOGOUT + 1;
        int EMOTES = SETTINGS + 1;
        int MUSIC = EMOTES + 1;

        int WORLD_MAP_ANCHOR = 25;
        int COMPASS_ANCHOR = 15;
        int COMMON_WIDGET = 13; // the widget for when things are in the way

        int INVENTORY_LEFT_COLUMN = 31;
        int INVENTORY_RIGHT_COLUMN = 32;

        int STANDARD_TAB_BORDERS_COMPONENT = 65; // the parent of STANDARD_TAB_COMPONENT
    }

    interface Fixed {
        int COMBAT = 48;
        int STATS = COMBAT + 1;
        int QUEST = STATS + 1;
        int INVENTORY = QUEST + 1;
        int EQUIPMENT = INVENTORY + 1;
        int PRAYER = EQUIPMENT + 1;
        int MAGIC = PRAYER + 1;

        int CLAN = 31;
        int ACCOUNT_MANAGEMENT = CLAN + 1;
        int FRIEND = ACCOUNT_MANAGEMENT + 1;
        int LOGOUT = FRIEND + 1;
        int SETTINGS = LOGOUT + 1;
        int EMOTES = SETTINGS + 1;
        int MUSIC = EMOTES + 1;

        int INVENTORY_LEFT_COLUMN_UPPER = 25;
        int INVENTORY_LEFT_COLUMN_LOWER = 26;
        int INVENTORY_RIGHT_COLUMN = 27;

        int MINIMAP_ANCHOR = 8;
        int COMPASS_ANCHOR = 10;
        int COMMON_WIDGET = 21; // the widget for when things are in the way

        int STANDARD_TAB_BORDERS_COMPONENT = 62; // the parent of STANDARD_TAB_COMPONENT
    }

}
