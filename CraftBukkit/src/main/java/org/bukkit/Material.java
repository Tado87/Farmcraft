/*     */ package org.bukkit;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.bukkit.material.Bed;
/*     */ import org.bukkit.material.Button;
/*     */ import org.bukkit.material.Cake;
/*     */ import org.bukkit.material.Coal;
/*     */ import org.bukkit.material.Crops;
/*     */ import org.bukkit.material.DetectorRail;
/*     */ import org.bukkit.material.Diode;
/*     */ import org.bukkit.material.Dispenser;
/*     */ import org.bukkit.material.Door;
/*     */ import org.bukkit.material.Dye;
/*     */ import org.bukkit.material.Furnace;
/*     */ import org.bukkit.material.Ladder;
/*     */ import org.bukkit.material.Lever;
/*     */ import org.bukkit.material.LongGrass;
/*     */ import org.bukkit.material.MaterialData;
/*     */ import org.bukkit.material.MonsterEggs;
/*     */ import org.bukkit.material.PistonBaseMaterial;
/*     */ import org.bukkit.material.PistonExtensionMaterial;
/*     */ import org.bukkit.material.PoweredRail;
/*     */ import org.bukkit.material.PressurePlate;
/*     */ import org.bukkit.material.Pumpkin;
/*     */ import org.bukkit.material.Rails;
/*     */ import org.bukkit.material.RedstoneTorch;
/*     */ import org.bukkit.material.RedstoneWire;
/*     */ import org.bukkit.material.Sign;
/*     */ import org.bukkit.material.SmoothBrick;
/*     */ import org.bukkit.material.Stairs;
/*     */ import org.bukkit.material.Step;
/*     */ import org.bukkit.material.Torch;
/*     */ import org.bukkit.material.TrapDoor;
/*     */ import org.bukkit.material.Tree;
/*     */ import org.bukkit.material.Wool;
/*     */ 
/*     */ public enum Material
/*     */ {
/*  15 */   AIR(0), 
/*  16 */   STONE(1), 
/*  17 */   GRASS(2), 
/*  18 */   DIRT(3), 
/*  19 */   COBBLESTONE(4), 
/*  20 */   WOOD(5), 
/*  21 */   SAPLING(6, Tree.class), 
/*  22 */   BEDROCK(7), 
/*  23 */   WATER(8, MaterialData.class), 
/*  24 */   STATIONARY_WATER(9, MaterialData.class), 
/*  25 */   LAVA(10, MaterialData.class), 
/*  26 */   STATIONARY_LAVA(11, MaterialData.class), 
/*  27 */   SAND(12), 
/*  28 */   GRAVEL(13), 
/*  29 */   GOLD_ORE(14), 
/*  30 */   IRON_ORE(15), 
/*  31 */   COAL_ORE(16), 
/*  32 */   LOG(17, Tree.class), 
/*  33 */   LEAVES(18, Tree.class), 
/*  34 */   SPONGE(19), 
/*  35 */   GLASS(20), 
/*  36 */   LAPIS_ORE(21), 
/*  37 */   LAPIS_BLOCK(22), 
/*  38 */   DISPENSER(23, Dispenser.class), 
/*  39 */   SANDSTONE(24), 
/*  40 */   NOTE_BLOCK(25), 
/*  41 */   BED_BLOCK(26, Bed.class), 
/*  42 */   POWERED_RAIL(27, PoweredRail.class), 
/*  43 */   DETECTOR_RAIL(28, DetectorRail.class), 
/*  44 */   PISTON_STICKY_BASE(29, PistonBaseMaterial.class), 
/*  45 */   WEB(30), 
/*  46 */   LONG_GRASS(31, LongGrass.class), 
/*  47 */   DEAD_BUSH(32), 
/*  48 */   PISTON_BASE(33, PistonBaseMaterial.class), 
/*  49 */   PISTON_EXTENSION(34, PistonExtensionMaterial.class), 
/*  50 */   WOOL(35, Wool.class), 
/*  51 */   PISTON_MOVING_PIECE(36), 
/*  52 */   YELLOW_FLOWER(37), 
/*  53 */   RED_ROSE(38), 
/*  54 */   BROWN_MUSHROOM(39), 
/*  55 */   RED_MUSHROOM(40), 
/*  56 */   GOLD_BLOCK(41), 
/*  57 */   IRON_BLOCK(42), 
/*  58 */   DOUBLE_STEP(43, Step.class), 
/*  59 */   STEP(44, Step.class), 
/*  60 */   BRICK(45), 
/*  61 */   TNT(46), 
/*  62 */   BOOKSHELF(47), 
/*  63 */   MOSSY_COBBLESTONE(48), 
/*  64 */   OBSIDIAN(49), 
/*  65 */   TORCH(50, Torch.class), 
/*  66 */   FIRE(51), 
/*  67 */   MOB_SPAWNER(52), 
/*  68 */   WOOD_STAIRS(53, Stairs.class), 
/*  69 */   CHEST(54), 
/*  70 */   REDSTONE_WIRE(55, RedstoneWire.class), 
/*  71 */   DIAMOND_ORE(56), 
/*  72 */   DIAMOND_BLOCK(57), 
/*  73 */   WORKBENCH(58), 
/*  74 */   CROPS(59, Crops.class), 
/*  75 */   SOIL(60, MaterialData.class), 
/*  76 */   FURNACE(61, Furnace.class), 
/*  77 */   BURNING_FURNACE(62, Furnace.class), 
/*  78 */   SIGN_POST(63, 1, Sign.class), 
/*  79 */   WOODEN_DOOR(64, Door.class), 
/*  80 */   LADDER(65, Ladder.class), 
/*  81 */   RAILS(66, Rails.class), 
/*  82 */   COBBLESTONE_STAIRS(67, Stairs.class), 
/*  83 */   WALL_SIGN(68, 1, Sign.class), 
/*  84 */   LEVER(69, Lever.class), 
/*  85 */   STONE_PLATE(70, PressurePlate.class), 
/*  86 */   IRON_DOOR_BLOCK(71, Door.class), 
/*  87 */   WOOD_PLATE(72, PressurePlate.class), 
/*  88 */   REDSTONE_ORE(73), 
/*  89 */   GLOWING_REDSTONE_ORE(74), 
/*  90 */   REDSTONE_TORCH_OFF(75, RedstoneTorch.class), 
/*  91 */   REDSTONE_TORCH_ON(76, RedstoneTorch.class), 
/*  92 */   STONE_BUTTON(77, Button.class), 
/*  93 */   SNOW(78), 
/*  94 */   ICE(79), 
/*  95 */   SNOW_BLOCK(80), 
/*  96 */   CACTUS(81, MaterialData.class), 
/*  97 */   CLAY(82), 
/*  98 */   SUGAR_CANE_BLOCK(83, MaterialData.class), 
/*  99 */   JUKEBOX(84), 
/* 100 */   FENCE(85), 
/* 101 */   PUMPKIN(86, Pumpkin.class), 
/* 102 */   NETHERRACK(87), 
/* 103 */   SOUL_SAND(88), 
/* 104 */   GLOWSTONE(89), 
/* 105 */   PORTAL(90), 
/* 106 */   JACK_O_LANTERN(91, Pumpkin.class), 
/* 107 */   CAKE_BLOCK(92, 1, Cake.class), 
/* 108 */   DIODE_BLOCK_OFF(93, Diode.class), 
/* 109 */   DIODE_BLOCK_ON(94, Diode.class), 
/* 110 */   LOCKED_CHEST(95), 
/* 111 */   TRAP_DOOR(96, TrapDoor.class), 
/* 112 */   MONSTER_EGGS(97, MonsterEggs.class), 
/* 113 */   SMOOTH_BRICK(98, SmoothBrick.class), 
/* 114 */   HUGE_MUSHROOM_1(99), 
/* 115 */   HUGE_MUSHROOM_2(100), 
/* 116 */   IRON_FENCE(101), 
/* 117 */   THIN_GLASS(102), 
/* 118 */   MELON_BLOCK(103), 
/* 119 */   PUMPKIN_STEM(104), 
/* 120 */   MELON_STEM(105), 
/* 121 */   VINE(106), 
/* 122 */   FENCE_GATE(107), 
/* 123 */   BRICK_STAIRS(108), 
/* 124 */   SMOOTH_STAIRS(109), 
/* 125 */   MYCEL(110), 
/* 126 */   WATER_LILY(111), 
/* 127 */   NETHER_BRICK(112), 
/* 128 */   NETHER_FENCE(113), 
/* 129 */   NETHER_BRICK_STAIRS(114), 
/* 130 */   NETHER_WARTS(115), 
/* 131 */   ENCHANTMENT_TABLE(116), 
/* 132 */   BREWING_STAND(117), 
/* 133 */   CAULDRON(118), 
/* 134 */   ENDER_PORTAL(119), 
/* 135 */   ENDER_PORTAL_FRAME(120), 
/* 136 */   ENDER_STONE(121), 
/* 137 */   DRAGON_EGG(122), 
/* 138 */   BLOCKSPEEDY(138),
/* 139 */   IRON_SPADE(256, 1, 250), 
/* 140 */   IRON_PICKAXE(257, 1, 250), 
/* 141 */   IRON_AXE(258, 1, 250), 
/* 142 */   FLINT_AND_STEEL(259, 1, 64), 
/* 143 */   APPLE(260), 
/* 144 */   BOW(261, 1, 384), 
/* 145 */   ARROW(262), 
/* 146 */   COAL(263, Coal.class), 
/* 147 */   DIAMOND(264), 
/* 148 */   IRON_INGOT(265), 
/* 149 */   GOLD_INGOT(266), 
/* 150 */   IRON_SWORD(267, 1, 250), 
/* 151 */   WOOD_SWORD(268, 1, 59), 
/* 152 */   WOOD_SPADE(269, 1, 59), 
/* 153 */   WOOD_PICKAXE(270, 1, 59), 
/* 154 */   WOOD_AXE(271, 1, 59), 
/* 155 */   STONE_SWORD(272, 1, 131), 
/* 156 */   STONE_SPADE(273, 1, 131), 
/* 157 */   STONE_PICKAXE(274, 1, 131), 
/* 158 */   STONE_AXE(275, 1, 131), 
/* 159 */   DIAMOND_SWORD(276, 1, 1561), 
/* 160 */   DIAMOND_SPADE(277, 1, 1561), 
/* 161 */   DIAMOND_PICKAXE(278, 1, 1561), 
/* 162 */   DIAMOND_AXE(279, 1, 1561), 
/* 163 */   STICK(280), 
/* 164 */   BOWL(281), 
/* 165 */   MUSHROOM_SOUP(282, 1), 
/* 166 */   GOLD_SWORD(283, 1, 32), 
/* 167 */   GOLD_SPADE(284, 1, 32), 
/* 168 */   GOLD_PICKAXE(285, 1, 32), 
/* 169 */   GOLD_AXE(286, 1, 32), 
/* 170 */   STRING(287), 
/* 171 */   FEATHER(288), 
/* 172 */   SULPHUR(289), 
/* 173 */   WOOD_HOE(290, 1, 59), 
/* 174 */   STONE_HOE(291, 1, 131), 
/* 175 */   IRON_HOE(292, 1, 250), 
/* 176 */   DIAMOND_HOE(293, 1, 1561), 
/* 177 */   GOLD_HOE(294, 1, 32), 
/* 178 */   SEEDS(295), 
/* 179 */   WHEAT(296), 
/* 180 */   BREAD(297), 
/* 181 */   LEATHER_HELMET(298, 1, 50), 
/* 182 */   LEATHER_CHESTPLATE(299, 1, 80), 
/* 183 */   LEATHER_LEGGINGS(300, 1, 75), 
/* 184 */   LEATHER_BOOTS(301, 1, 65), 
/* 185 */   CHAINMAIL_HELMET(302, 1, 166), 
/* 186 */   CHAINMAIL_CHESTPLATE(303, 1, 240), 
/* 187 */   CHAINMAIL_LEGGINGS(304, 1, 225), 
/* 188 */   CHAINMAIL_BOOTS(305, 1, 195), 
/* 189 */   IRON_HELMET(306, 1, 165), 
/* 190 */   IRON_CHESTPLATE(307, 1, 240), 
/* 191 */   IRON_LEGGINGS(308, 1, 225), 
/* 192 */   IRON_BOOTS(309, 1, 195), 
/* 193 */   DIAMOND_HELMET(310, 1, 363), 
/* 194 */   DIAMOND_CHESTPLATE(311, 1, 528), 
/* 195 */   DIAMOND_LEGGINGS(312, 1, 495), 
/* 196 */   DIAMOND_BOOTS(313, 1, 429), 
/* 197 */   GOLD_HELMET(314, 1, 77), 
/* 198 */   GOLD_CHESTPLATE(315, 1, 112), 
/* 199 */   GOLD_LEGGINGS(316, 1, 105), 
/* 200 */   GOLD_BOOTS(317, 1, 91), 
/* 201 */   FLINT(318), 
/* 202 */   PORK(319), 
/* 203 */   GRILLED_PORK(320), 
/* 204 */   PAINTING(321), 
/* 205 */   GOLDEN_APPLE(322), 
/* 206 */   SIGN(323, 1), 
/* 207 */   WOOD_DOOR(324, 1), 
/* 208 */   BUCKET(325, 1), 
/* 209 */   WATER_BUCKET(326, 1), 
/* 210 */   LAVA_BUCKET(327, 1), 
/* 211 */   MINECART(328, 1), 
/* 212 */   SADDLE(329, 1), 
/* 213 */   IRON_DOOR(330, 1), 
/* 214 */   REDSTONE(331), 
/* 215 */   SNOW_BALL(332, 16), 
/* 216 */   BOAT(333, 1), 
/* 217 */   LEATHER(334), 
/* 218 */   MILK_BUCKET(335, 1), 
/* 219 */   CLAY_BRICK(336), 
/* 220 */   CLAY_BALL(337), 
/* 221 */   SUGAR_CANE(338), 
/* 222 */   PAPER(339), 
/* 223 */   BOOK(340), 
/* 224 */   SLIME_BALL(341), 
/* 225 */   STORAGE_MINECART(342, 1), 
/* 226 */   POWERED_MINECART(343, 1), 
/* 227 */   EGG(344, 16), 
/* 228 */   COMPASS(345), 
/* 229 */   FISHING_ROD(346, 1, 64), 
/* 230 */   WATCH(347), 
/* 231 */   GLOWSTONE_DUST(348), 
/* 232 */   RAW_FISH(349), 
/* 233 */   COOKED_FISH(350), 
/* 234 */   INK_SACK(351, Dye.class), 
/* 235 */   BONE(352), 
/* 236 */   SUGAR(353), 
/* 237 */   CAKE(354, 1), 
/* 238 */   BED(355, 1), 
/* 239 */   DIODE(356), 
/* 240 */   COOKIE(357), 
/* 241 */   MAP(358, 1, MaterialData.class), 
/* 242 */   SHEARS(359, 1, 238), 
/* 243 */   MELON(360), 
/* 244 */   PUMPKIN_SEEDS(361), 
/* 245 */   MELON_SEEDS(362), 
/* 246 */   RAW_BEEF(363), 
/* 247 */   COOKED_BEEF(364), 
/* 248 */   RAW_CHICKEN(365), 
/* 249 */   COOKED_CHICKEN(366), 
/* 250 */   ROTTEN_FLESH(367), 
/* 251 */   ENDER_PEARL(368, 16), 
/* 252 */   BLAZE_ROD(369), 
/* 253 */   GHAST_TEAR(370), 
/* 254 */   GOLD_NUGGET(371), 
/* 255 */   NETHER_STALK(372), 
/* 256 */   POTION(373, 1), 
/* 257 */   GLASS_BOTTLE(374), 
/* 258 */   SPIDER_EYE(375), 
/* 259 */   FERMENTED_SPIDER_EYE(376), 
/* 260 */   BLAZE_POWDER(377), 
/* 261 */   MAGMA_CREAM(378), 
/* 262 */   BREWING_STAND_ITEM(379), 
/* 263 */   CAULDRON_ITEM(380), 
/* 264 */   EYE_OF_ENDER(381), 
/* 265 */   SPECKLED_MELON(382), 
/* 266 */   MONSTER_EGG(383, 1), 
/* 267 */   GOLD_RECORD(2256, 1), 
/* 268 */   GREEN_RECORD(2257, 1), 
/* 269 */   RECORD_3(2258, 1), 
/* 270 */   RECORD_4(2259, 1), 
/* 271 */   RECORD_5(2260, 1), 
/* 272 */   RECORD_6(2261, 1), 
/* 273 */   RECORD_7(2262, 1), 
/* 274 */   RECORD_8(2263, 1), 
/* 275 */   RECORD_9(2264, 1), 
/* 276 */   RECORD_10(2265, 1), 
/* 277 */   RECORD_11(2266, 1),
/* 278 */   BLOCKSPEEDYSTAIRS(139),
/* 280 */   REDSTONE_BLOCK(140),
            BLOCKJUMPBLOCK(141),
			LANTERNE(142),
			FOIN(143);

/*     */   private final int id;
/*     */   private final Class<? extends MaterialData> data;
/*     */   private static final Map<Integer, Material> lookupId;
/*     */   private static final Map<String, Material> lookupName;
/*     */   private final int maxStack;
/*     */   private final short durability;
/*     */ 
/* 287 */   private Material(int id) { this(id, 64); }
/*     */ 
/*     */   private Material(int id, int stack)
/*     */   {
/* 291 */     this(id, stack, null);
/*     */   }
/*     */ 
/*     */   private Material(int id, int stack, int durability) {
/* 295 */     this(id, stack, durability, null);
/*     */   }
/*     */ 
/*     */   private Material(int id, Class<? extends MaterialData> data) {
/* 299 */     this(id, 64, data);
/*     */   }
/*     */ 
/*     */   private Material(int id, int stack, Class<? extends MaterialData> data) {
/* 303 */     this(id, stack, -1, data);
/*     */   }
/*     */ 
/*     */   private Material(int id, int stack, int durability, Class<? extends MaterialData> data) {
/* 307 */     this.id = id;
/* 308 */     this.durability = (short)durability;
/* 309 */     this.maxStack = stack;
/* 310 */     this.data = data;
/*     */   }
/*     */ 
/*     */   public int getId()
/*     */   {
/* 319 */     return this.id;
/*     */   }
/*     */ 
/*     */   public int getMaxStackSize()
/*     */   {
/* 328 */     return this.maxStack;
/*     */   }
/*     */ 
/*     */   public short getMaxDurability()
/*     */   {
/* 337 */     return this.durability;
/*     */   }
/*     */ 
/*     */   public Class<? extends MaterialData> getData()
/*     */   {
/* 346 */     return this.data == null ? MaterialData.class : this.data;
/*     */   }
/*     */ 
/*     */   public MaterialData getNewData(byte raw)
/*     */   {
/* 357 */     if (this.data == null) {
/* 358 */       return new MaterialData(this.id, raw);
/*     */     }
/*     */     try
/*     */     {
/* 362 */       Constructor ctor = this.data.getConstructor(new Class[] { Integer.TYPE, Byte.TYPE });
/*     */ 
/* 364 */       return (MaterialData)ctor.newInstance(new Object[] { Integer.valueOf(this.id), Byte.valueOf(raw) });
/*     */     } catch (InstantiationException ex) {
/* 366 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 368 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalArgumentException ex) {
/* 370 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InvocationTargetException ex) {
/* 372 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (NoSuchMethodException ex) {
/* 374 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (SecurityException ex) {
/* 376 */       Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 379 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isBlock()
/*     */   {
/* 388 */     return this.id < 256;
/*     */   }
/*     */ 
/*     */   public boolean isEdible()
/*     */   {
/* 397 */     return (equals(BREAD)) || (equals(COOKIE)) || (equals(MELON)) || (equals(MUSHROOM_SOUP)) || (equals(RAW_CHICKEN)) || (equals(COOKED_CHICKEN)) || (equals(RAW_BEEF)) || (equals(COOKED_BEEF)) || (equals(RAW_FISH)) || (equals(COOKED_FISH)) || (equals(PORK)) || (equals(GRILLED_PORK)) || (equals(APPLE)) || (equals(GOLDEN_APPLE)) || (equals(ROTTEN_FLESH)) || (equals(SPIDER_EYE));
/*     */   }
/*     */ 
/*     */   public static Material getMaterial(int id)
/*     */   {
/* 422 */     return (Material)lookupId.get(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */   public static Material getMaterial(String name)
/*     */   {
/* 434 */     return (Material)lookupName.get(name);
/*     */   }
/*     */ 
/*     */   public static Material matchMaterial(String name)
/*     */   {
/* 446 */     Material result = null;
/*     */     try
/*     */     {
/* 449 */       result = getMaterial(Integer.parseInt(name));
/*     */     } catch (NumberFormatException ex) {
/*     */     }
/* 452 */     if (result == null) {
/* 453 */       String filtered = name.toUpperCase();
/*     */ 
/* 455 */       filtered = filtered.replaceAll("\\s+", "_").replaceAll("\\W", "");
/* 456 */       result = (Material)lookupName.get(filtered);
/*     */     }
/*     */ 
/* 459 */     return result;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 281 */     lookupId = new HashMap();
/* 282 */     lookupName = new HashMap();
/*     */ 
/* 463 */     for (Material material : values()) {
/* 464 */       lookupId.put(Integer.valueOf(material.getId()), material);
/* 465 */       lookupName.put(material.name(), material);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\CARDON\Desktop\Modding\CraftBukkit 1.1\craftbukkit-1.1-R1\
 * Qualified Name:     org.bukkit.Material
 * JD-Core Version:    0.6.0
 */