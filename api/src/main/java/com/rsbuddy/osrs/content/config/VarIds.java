package com.rsbuddy.osrs.content.config;

public interface VarIds {
    // BANK
    VarbitId BANK_ALWAYS_SET_PLACEHOLDERS = new VarbitId(3755);
    VarbitId BANK_INCINERATOR_ACTIVE = new VarbitId(5102);
    VarbitId BANK_SELECTED_TAB = new VarbitId(4150);
    /* valid only while bank is open
       4 bits - lsb small pouch -> msb giant
       set true when full false when empty or partial filled */
    VarpId RUNECRAFTING_POUCHES = new VarpId(261);

    // BARROWS
    VarbitId BARROWS_AHRIM_KILLED = new VarbitId(457);
    VarbitId BARROWS_DHAROK_KILLED = new VarbitId(458);
    VarbitId BARROWS_GUTHAN_KILLED = new VarbitId(459);
    VarbitId BARROWS_KARIL_KILLED = new VarbitId(460);
    VarbitId BARROWS_TORAG_KILLED = new VarbitId(461);
    VarbitId BARROWS_VERAC_KILLED = new VarbitId(462);
    VarbitId BARROWS_REWARDS_POTENTIAL = new VarbitId(463);
    VarbitId BARROWS_KILL_COUNT = new VarbitId(464);

    // CHAMBERS OF XERIC
    VarbitId CHAMBERS_OF_XERIC_OWN_POINTS = new VarbitId(5422);
    VarbitId CHAMBERS_OF_XERIC_TOTAL_POINTS = new VarbitId(5431);
    VarbitId CHAMBERS_OF_XERIC_TIME = new VarbitId(6386);

    // CHAT
    VarcId CHAT_BUFFER_POSITION = new VarcId(4);
    VarcId CHAT_LAST_MESSAGE = new VarcId(61); // contains the game cycle of the last chat message sent
    Varc$Id CHAT_MESSAGE = new Varc$Id(335);

    // HERBIBOAR
    VarbitId HERBIBOAR_FINISH_ID = new VarbitId(5766);
    VarbitId HERBIBOAR_STARTED = new VarbitId(5766);

    // INPUT / PM (i.e. chat input for private message, bank searching)
    VarcId INPUT_TYPE = new VarcId(5); // 6 = PM
    Varc$Id INPUT_TEXT = new Varc$Id(359);
    Varc$Id PRIVATE_MESSAGE_TARGET = new Varc$Id(360);

    // NIGHTMARE ZONE
    VarbitId NMZ_ABSORPTION_POINTS = new VarbitId(3956);
    VarbitId NMZ_CURRENT_POINTS = new VarbitId(3949);
    VarpId NMZ_TOTAL_POINTS = new VarpId(1060);
    VarbitId NMZ_REWARD_ABSORPTION_DOSES = new VarbitId(3954);

    // THEATRE OF BLOOD
    VarbitId THEATER_OF_BLOOD_STATUS = new VarbitId(4605);
    VarbitId THEATER_OF_BLOOD_PARTY = new VarbitId(6440);
    VarbitId THEATER_OF_BLOOD_BOSS_HEALTH = new VarbitId(6448);

    // TOOLTIP
    VarcId TOOLTIP_EXPIRE = new VarcId(1);
    VarcId TOOLTIP_VISIBLE = new VarcId(2);

    // SPECIAL ATTACK
    VarpId SPECIAL_ATTACK_ENABLED = new VarpId(301);
    VarpId SPECIAL_ATTACK_PERCENT = new VarpId(300); // note that it is multiplied by 10

    // UI
    VarbitId UI_OPAQUE_SIDE_PANEL = new VarbitId(4609); // 0 = transparent, 1 = opaque
    VarbitId UI_RESIZEABLE_SCROLLBAR_POSITION = new VarbitId(6374); // 0 = right, 1 = left
    VarbitId UI_CLOSEABLE_SIDE_PANELS = new VarbitId(4607); // 0 = fixed mode style, 1 = resizeable style (only in resizeable)
    VarbitId UI_TRANSPARENT_CHAT = new VarbitId(4608);

    // XP DROPS
    VarcId XP_DROP_NEXT_ID = new VarcId(70); // clientscript mods this with the max number of xp drops to get the id
    VarcId XP_DROP_TIME = new VarcId(71);
    VarcId XP_DROP_TYPE = new VarcId(72);
    VarbitId XP_DROP_ENABLED = new VarbitId(4702);
    VarbitId XP_DROP_COLOR = new VarbitId(4695);
    VarbitId XP_DROP_COUNTER = new VarbitId(4697);
    VarbitId XP_DROP_DURATION = new VarbitId(4694);
    VarbitId XP_DROP_GROUP = new VarbitId(4696);
    VarbitId XP_DROP_POSITION = new VarbitId(4692);
    VarbitId XP_DROP_PROGRESS_BAR = new VarbitId(4698);
    VarbitId XP_DROP_SIZE = new VarbitId(4693);
    VarbitId XP_DROP_SPEED = new VarbitId(4722);

    // ZOOM
    VarcId ZOOM_1 = new VarcId(73);
    VarcId ZOOM_2 = new VarcId(74);

    // DAILY VARBITS
    VarbitId DAILY_HERB_BOXES_COLLECTED = new VarbitId(3961);
    VarbitId DAILY_STAVES_COLLECTED = new VarbitId(4539);
    VarbitId DAILY_RUNES_COLLECTED = new VarbitId(4540);
    VarbitId DAILY_BONEMEAL_COLLECTED = new VarbitId(4543);
    VarbitId DAILY_ESSENCE_COLLECTED = new VarbitId(4547);
    VarbitId DAILY_SAND_COLLECTED = new VarbitId(4549);
    VarbitId DAILY_FLAX_EXCHANGED = new VarbitId(4559);

    // QUEST VARBITS todo: Move this
    VarbitId QUEST_HAND_IN_THE_SAND = new VarbitId(1527);

    // MISC VARBITS
    VarbitId ACCEPT_AID = new VarbitId(4180);
    VarbitId CHAMBERS_OF_XERIC_STATUS = new VarbitId(5432);
    VarbitId CORP_HIT_DAMAGE = new VarbitId(999);
    VarbitId DEFENSIVE_MAGIC_CASTING = new VarbitId(2668);
    VarbitId ESCAPE_TO_CLOSE_OPEN_INTERFACE = new VarbitId(4681);
    VarbitId LOGOUT_NOTIFICATION_DISABLED = new VarbitId(1627); //
    VarbitId MOTHERLODE_MINE_SACK_UPGRADED = new VarbitId(5556);
    VarbitId MOTHERLODE_MINE_SACK_COUNT = new VarbitId(5558); // motherlode mine
    VarbitId QUICK_PRAYER_ACTIVE = new VarbitId(4103);
    VarbitId SHIFT_TO_LEFT_CLICK_DROP = new VarbitId(5542);
    VarbitId WEAPON_TYPE = new VarbitId(357);
    VarbitId ACCOUNT_TYPE = new VarbitId(1777);
    VarbitId MULTICOMBAT =  new VarbitId(4605);
    VarbitId MISCELLANIA_FAVOR = new VarbitId(72);
    VarbitId MAGIC_IMBUE = new VarbitId(5438);

    // MISC VARPS
    VarpId ATTACK_STYLE = new VarpId(43);
    VarpId BRIGHTNESS = new VarpId(166);
    VarpId DISEASE_TICKS = new VarpId(456);
    VarpId DUEL_SETTINGS = new VarpId(286);
    VarpId LIGHTBOX_STATE = new VarpId(1356);
    VarpId MUSIC_VOLUME = new VarpId(168);
    VarpId RETALIATING = new VarpId(172);
    VarpId RUNNING = new VarpId(173);
    VarpId QUEST_POINTS = new VarpId(101);
    VarpId POISON_TICKS = new VarpId(102); // is also used for venom
    VarpId SPLIT_PRIVATE_CHAT = new VarpId(287);

    // Slayer
    VarbitId SLAYER_REWARD_POINTS = new VarbitId(4068);

    // Wilderness
    VarbitId IN_WILDERNESS = new VarbitId(5963);
    VarpId WILDERNESS_DEATHS = new VarpId(1102);
    VarpId WILDERNESS_KILLS = new VarpId(1103);

    // MISC INT VARIABLES
    VarcId SELECTED_MINIGAME = new VarcId(64);
    VarcId SELECTED_TAB = new VarcId(171); // 3 = inventory, 4 = equipment
    VarcId MEMBERSHIP_STATUS = new VarcId(103);

    // rune pouch varbits
    VarbitId RUNE_POUCH_SLOT_1_ID = new VarbitId(29);
    VarbitId RUNE_POUCH_SLOT_2_ID = new VarbitId(1622);
    VarbitId RUNE_POUCH_SLOT_3_ID = new VarbitId(1623);
    VarbitId RUNE_POUCH_SLOT_1_COUNT = new VarbitId(1624);
    VarbitId RUNE_POUCH_SLOT_2_COUNT = new VarbitId(1625);
    VarbitId RUNE_POUCH_SLOT_3_COUNT = new VarbitId(1626);

}
