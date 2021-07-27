import java.util.Arrays;

public class Mining {
	
    
public client c; //Player

	private boolean AreXItemsInBag(client c, int ItemID, int Amount) {
        int ItemCount = 0;
        for (int i = 0; i < c.playerItems.length; i++) {
            if ((c.playerItems[i] - 1) == ItemID) {
                ItemCount++;
            }
            if (ItemCount == Amount) {
                return true;
            }
        }
        return false;
    }
	
	public int GetPickAni(client c) {
		int PickAni = 0;
		int Pick = c.playerEquipment[c.playerWeapon];
		if (Pick == 1275) {
			PickAni = 624;
		} else if (Pick == 1265) {
			PickAni = 625;
		} else if (Pick == 1267) {
			PickAni = 626;
		} else if (Pick == 1269) {
			PickAni = 627;
		} else if (Pick == 1271) {
			PickAni = 628;
		} else if (Pick == 1273) {
			PickAni = 629;
		} else if (Pick == 1275) {
			PickAni = 624;
		}
		if (AreXItemsInBag(c, 1265, 1)) {
			PickAni = 625;
		} else if (AreXItemsInBag(c, 1267, 1)) {
			PickAni = 626;
		} else if (AreXItemsInBag(c, 1269, 1)) {
			PickAni = 627;
		} else if (AreXItemsInBag(c, 1271, 1)) {
			PickAni = 628;
		} else if (AreXItemsInBag(c, 1273, 1)) {
			PickAni = 629;
		} else if (AreXItemsInBag(c, 1275, 1)) {
			PickAni = 624;
		}
		return PickAni;
	}

	public int CheckPick(client c) {
		int Pick = c.playerEquipment[c.playerWeapon];
		if (Pick == 1265) {
			return 0;
		} else if (Pick == 1267) {
			return 1;
		} else if (Pick == 1269) {
			return 2;
		} else if (Pick == 1271) {
			return 3;
		} else if (Pick == 1273) {
			return 4;
		} else if (Pick == 1275) {
			return 5;
		}
		if (AreXItemsInBag(c, 1265, 1)) {
			return 0;
		} else if (AreXItemsInBag(c, 1267, 1)) {
			return 1;
		} else if (AreXItemsInBag(c, 1269, 1)) {
			return 2;
		} else if (AreXItemsInBag(c, 1271, 1)) {
			return 3;
		} else if (AreXItemsInBag(c, 1273, 1)) {
			return 4;
		} else if (AreXItemsInBag(c, 1275, 1)) {
			return 5;
		}
		return -1;
	}

	public final static int gems[] = { 1617, 1619, 1621, 1623, 1625, 1627, 1629, 1631, 6571 };
	public boolean Mining = false;
	public int MineTimer; //choptimer
	public int RockLevel; //Treelevel
	public int RockId; // TreeID
	public int RockXp; // TreeXp
	public int OreId; // LogId
	public int MinedId; //StumpId
	public int Gone2for; // Gonefor
	public int HowManyOre; //HowManyLogs
	public int RockX; //treex
	public int RockY; //treey

	public void InitiateMI(client c, int rock, int x, int y) {
		int PickId = CheckPick(c);
		int Minus2Time = 0;
		RockId = rock;
		if (PickId == 1265) {
			Minus2Time = 0;
		} else if (PickId == 1267) {
			Minus2Time = 3;
		} else if (PickId == 1269) {
			Minus2Time = 6;
		} else if (PickId == 1271) {
			Minus2Time = 12;
		} else if (PickId == 1273) {
			Minus2Time = 18;
		} else if (PickId == 1275) {
			Minus2Time = 25;
		}
		if (RockId == 2491) { //Rune Essence
			MineTimer = 4 + misc.random(6);
			RockLevel = 1;
			HowManyOre = 1;
			RockXp = 40;
			OreId = 1436;
			MinedId = 450;
			Gone2for = 5 + misc.random(5);
		} else if (RockId == 2108 || RockId == 2109) { //Clay
			MineTimer = 8 + misc.random(4);
			RockLevel = 1;
			HowManyOre = 1;
			RockXp = 50;
			OreId = 434;
			MinedId = 450;
			Gone2for = 10 + misc.random(10);
		} else if (RockId == 2090 || RockId == 2091) { //Copper
			MineTimer = 8 + misc.random(6);
			RockLevel = 1;
			HowManyOre = 1;
			RockXp = 93;
			OreId = 436;
			MinedId = 450;
			Gone2for = 10 + misc.random(10);
		} else if (RockId == 2094 || RockId == 2095) { //Tin
			MineTimer = 8 + misc.random(6);
			RockLevel = 1;
			HowManyOre = 1;
			RockXp = 90;
			OreId = 438;
			MinedId = 450;
			Gone2for = 10 + misc.random(10);
		} else if (RockId == 10583 || RockId == 10584 || RockId == 2210) { //Blurite
			MineTimer = 20 + misc.random(15);
			RockLevel = 10;
			HowManyOre = 1;
			RockXp = 120;
			OreId = 668;
			MinedId = 450;
			Gone2for = 30 + misc.random(50);
		} else if (RockId == 4027) { //Limestone
			MineTimer = 30 + misc.random(30);
			RockLevel = 1;
			HowManyOre = 1;
			RockXp = 50;
			OreId = 3211;
			MinedId = 450;
			Gone2for = 30 + misc.random(70);
		} else if (RockId == 2098 || RockId == 2099) { //Gold
			MineTimer = 40 + misc.random(30);
			RockLevel = 40;
			HowManyOre = 1;
			RockXp = 600;
			OreId = 444;
			MinedId = 450;
			Gone2for = 30 + misc.random(30);
		} else if (RockId == 2100 || RockId == 2101) { //Silver
			MineTimer = 30 + misc.random(20);
			RockLevel = 20;
			HowManyOre = 1;
			RockXp = 400;
			OreId = 442;
			MinedId = 450;
			Gone2for = 20 + misc.random(20);
		} else if (RockId == 14856 || RockId == 2092 || RockId == 14858 || RockId == 2093) { //Iron
			MineTimer = 16 + misc.random(30);
			RockLevel = 15;
			HowManyOre = 1;
			RockXp = 350;
			OreId = 440;
			MinedId = 450;
			Gone2for = 10 + misc.random(30);
		} else if (RockId == 14850 || RockId == 2096 || RockId == 14851 || RockId == 2097) { //Coal
			MineTimer = 20 + misc.random(30);
			RockLevel = 30;
			HowManyOre = 1;
			RockXp = 856;
			OreId = 453;
			MinedId = 450;
			Gone2for = 40 + misc.random(30);
		} else if (RockId == 14854 || RockId == 2102 || RockId == 2103 || RockId == 14853) { //Mithril
			MineTimer = 30 + misc.random(50);
			RockLevel = 55;
			HowManyOre = 1;
			RockXp = 1527;
			OreId = 447;
			MinedId = 450;
			Gone2for = 60 + misc.random(50);
		} else if (RockId == 14863 || RockId == 2105 || RockId == 2104 || RockId == 14862) { //Addy
			MineTimer = 45 + misc.random(50);
			RockLevel = 70;
			HowManyOre = 1;
			RockXp = 4739;
			OreId = 449;
			MinedId = 450;
			Gone2for = 80 + misc.random(120);
		} else if (RockId == 14860 || RockId == 2106 || RockId == 2107 || RockId == 14859) { //Rune
			MineTimer = 70 + misc.random(70);
			RockLevel = 85;
			HowManyOre = 1;
			RockXp = 8318;
			OreId = 451;
			MinedId = 450;
			Gone2for = 120 + misc.random(240);
		} else if (RockId == 450 || RockId == 451 || RockId == 452 || RockId == 453) { //Empty
			resetMI(c);
			return;
		} else {
			resetMI(c);
			return;
		}
		if (c.freeSlots() == 0) {
			c.sM("You do not have enough inventory space to hold anymore ore!");
			resetMI(c);
			return;
		}
		if (PickId != -1) {
			if (c.getLevelForXP(c.playerXP[14]) < RockLevel) {
				c.sM("You are not a high enough level.");
				c.sM("You must atleast get a level of " + RockLevel + " to mine this rock.");
				resetMI(c);
				return;
			}
			if (!Mining) {
				c.sM("You start to mine the rock.");
			}
			RockX = x;
			RockY = y;
			MineTimer -= (c.playerLevel[14] / 3) + Minus2Time;
			Mining = true;
		} else {
			resetMI(c);
			c.sM("You need a pickaxe to mine this rock!");
		}
	}

	public void resetMI(client c) {
	        this.c = c;
		Mining = false;
		soundTimer = 0;
		MineTimer = 0;
		RockLevel = 0;
		RockId = 0;
		RockXp = 0;
		OreId = 0;
		MinedId = 0;
		Gone2for = 0;
		HowManyOre = 0;
		RockX = 0;
		RockY = 0;
		repeat2ani = 0;
		c.resetAnimation();
	}
	private int soundTimer = 0;
	public int repeat2ani = 0;
	public int PickAni = 0;

	public void MIprocess(client c) {
		if (MineTimer > 0) {
			MineTimer--;
		}
		if (MineTimer < 0) {
			MineTimer = 1;
		}
		if (soundTimer > 0) {
			soundTimer--;
		} else {
			soundTimer = 1;
			c.frame174(432, 025, 000);
		}
		if (repeat2ani > 0) {
			repeat2ani--;
		} else {
			c.startAnimation(GetPickAni(c));
			repeat2ani = 3;
		}
		if (MineTimer == 0) {
			if (!Removeore(c)) {
				resetMI(c);
				return;
			} else {
				InitiateMI(c, RockId, RockX, RockY);
			}
		}
	}

	public void SpawnRocks(client c) {
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKSPAWN[i] > 0) {
				c.AddGlobalObj(server.ROCKX[i], server.ROCKY[i],
						server.ROCKSTUMP[i], 0, 10);
			}
		}
	}

	public boolean HasOre() {
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKX[i] == RockX && server.ROCKY[i] == RockY) {
				if (server.ROCKSPAWN[i] > 0) {
					return false;
				} else if (server.ROCKSPAWN[i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean Removeore(client c) {
		boolean New = true;
		int Rockid = server.Rocks;
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKX[i] == RockX && server.ROCKY[i] == RockY) {
				if (!HasOre()) {
					resetMI(c);
					return false;
				}
				New = false;
				server.ORELEFT[i]--;
				c.addSkillXP(RockXp, 14);
				c.addItem(OreId, 1);
				if (misc.random(50) == 37) {
					c.addItem(gems[misc.random(8)], 1);
					c.sM("You find a gem in this rock.");
				}
				c.sM("You get some " + c.GetItemName(OreId) + ".");
				if (server.ORELEFT[i] <= 0) {
					server.ROCKSPAWN[i] = Gone2for;
					server.ORE[i] = HowManyOre;
					if (server.ORE[i] == 0) {
						server.ORE[i] = 1;
					}
					c.resetAnimation();
					c.AddGlobalObj(RockX, RockY, MinedId, 0, 10);
					return false;
				}
				return true;
			}
		}
		if (New) {
			server.ROCKX[Rockid] = RockX;
			server.ROCKY[Rockid] = RockY;
			server.ROCKID[Rockid] = RockId;
			server.ROCKSTUMP[Rockid] = MinedId;
			server.ORELEFT[Rockid] = HowManyOre;
			if (server.ORELEFT[Rockid] == 0) {
				server.ORELEFT[Rockid] = 1;
			}
			server.Rocks++;
			return true;
		}
		return false;
	}
}