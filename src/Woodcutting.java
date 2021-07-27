class Woodcutting {

	// Woodcutting
	public boolean AreXItemsInBag(client c, int ItemID, int Amount) {
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
	
	public int GetAxeAni(client c) {
		int ChopAni = 0;
		int Axe = c.playerEquipment[c.playerWeapon];
		if (Axe == 1351) {
			ChopAni = 879;
		} else if (Axe == 1349) {
			ChopAni = 877;
		} else if (Axe == 1353) {
			ChopAni = 875;
		} else if (Axe == 1361) {
			ChopAni = 873;
		} else if (Axe == 1355) {
			ChopAni = 871;
		} else if (Axe == 1357) {
			ChopAni = 869;
		} else if (Axe == 1359) {
			ChopAni = 867;
		} else if (Axe == 6739) {
			ChopAni = 2846;
		}
		if (AreXItemsInBag(c, 1351, 1)) {
			ChopAni = 879;
		} else if (AreXItemsInBag(c, 1349, 1)) {
			ChopAni = 877;
		} else if (AreXItemsInBag(c, 1353, 1)) {
			ChopAni = 875;
		} else if (AreXItemsInBag(c, 1361, 1)) {
			ChopAni = 873;
		} else if (AreXItemsInBag(c, 1355, 1)) {
			ChopAni = 871;
		} else if (AreXItemsInBag(c, 1357, 1)) {
			ChopAni = 869;
		} else if (AreXItemsInBag(c, 1359, 1)) {
			ChopAni = 867;
		} else if (AreXItemsInBag(c, 6739, 1)) {
			ChopAni = 2846;
		}
		return ChopAni;
	}

	public int CheckAxe(client c) {
		int Axe = c.playerEquipment[c.playerWeapon];
		if (Axe == 1351) {
			return 0;
		} else if (Axe == 1349) {
			return 1;
		} else if (Axe == 1353) {
			return 2;
		} else if (Axe == 1361) {
			return 3;
		} else if (Axe == 1355) {
			return 4;
		} else if (Axe == 1357) {
			return 5;
		} else if (Axe == 1359) {
			return 6;
		} else if (Axe == 6739) {
			return 7;
		}
		if (AreXItemsInBag(c, 1351, 1)) {
			return 0;
		} else if (AreXItemsInBag(c, 1349, 1)) {
			return 1;
		} else if (AreXItemsInBag(c, 1353, 1)) {
			return 2;
		} else if (AreXItemsInBag(c, 1361, 1)) {
			return 3;
		} else if (AreXItemsInBag(c, 1355, 1)) {
			return 4;
		} else if (AreXItemsInBag(c, 1357, 1)) {
			return 5;
		} else if (AreXItemsInBag(c, 1359, 1)) {
			return 6;
		} else if (AreXItemsInBag(c, 6739, 1)) {
			return 7;
		}
		return -1;
	}

	public boolean Woodcutting = false;
	public int ChopTimer;
	public int TreeLevel;
	public int TreeId;
	public int TreeXp;
	public int LogId;
	public int StumpId;
	public int Gonefor;
	public int HowManyLogs;
	public int TreeX;
	public int TreeY;

	public void InitiateWc(client c, int tree, int x, int y) {
		int AxeId = CheckAxe(c);
		int MinusTime = 0;
		TreeId = tree;
		if (AxeId == 1351) {
			MinusTime = 0;
		} else if (AxeId == 1349) {
			MinusTime = 2;
		} else if (AxeId == 1353) {
			MinusTime = 5;
		} else if (AxeId == 1361) {
			MinusTime = 9;
		} else if (AxeId == 1355) {
			MinusTime = 14;
		} else if (AxeId == 1357) {
			MinusTime = 20;
		} else if (AxeId == 1359) {
			MinusTime = 27;
		} else if (AxeId == 6739) {
			MinusTime = 35;
		}
		if (TreeId == 1315 || TreeId == 1316 || TreeId == 1318 || TreeId == 1319 
			|| TreeId == 3033 || TreeId == 1278 || TreeId == 1276 || TreeId == 1286
			|| TreeId == 1282 || TreeId == 1383 || TreeId == 1286) { //Normal&Dead
			ChopTimer = 6 + misc.random(10);
			TreeLevel = 1;
			HowManyLogs = 1;
			TreeXp = 250;
			LogId = 1511;
			StumpId = 1342;
			Gonefor = 10 + misc.random(20);
		} else if (TreeId == 1281 || TreeId == 3037) { //Oak
			ChopTimer = 10 + misc.random(15);
			TreeLevel = 15;
			HowManyLogs = 2;
			TreeXp = 500;
			LogId = 1521;
			StumpId = 1341;
			Gonefor = 20 + misc.random(20);
		} else if (TreeId == 1308 || TreeId == 5551 || TreeId == 5552
				|| TreeId == 5553) { //Willow
			ChopTimer = 15 + misc.random(20);
			TreeLevel = 30;
			HowManyLogs = 8;
			TreeXp = 750;
			LogId = 1519;
			StumpId = 7399;
			Gonefor = 25 + misc.random(30);
		} else if (TreeId == 1307 || TreeId == 4974) { //Maple
			ChopTimer = 20 + misc.random(20);
			TreeLevel = 45;
			HowManyLogs = 11;
			TreeXp = 1250;
			LogId = 1517;
			StumpId = 1343;
			Gonefor = 30 + misc.random(50);
		} else if (TreeId == 1309) { //Yew
			ChopTimer = 30 + misc.random(30);
			TreeLevel = 60;
			HowManyLogs = 14;
			TreeXp = 1750;
			LogId = 1515;
			StumpId = 7402;
			Gonefor = 60 + misc.random(60);
		} else if (TreeId == 1306) { //Magic
			ChopTimer = 40 + misc.random(40);
			TreeLevel = 75;
			HowManyLogs = 18;
			TreeXp = 3000;
			LogId = 1513;
			StumpId = 7399;
			Gonefor = 120 + misc.random(120);
		} else {
			resetWC(c);
			return;
		}
		if (c.freeSlots() == 0) {
			c.sM("You do not have enough inventory space to hold anymore logs!");
			resetWC(c);
			return;
		}
		if (AxeId != -1) {
			if (c.getLevelForXP(c.playerXP[8]) < TreeLevel) {
				c.sM("You are not a high enough level.");
				c.sM("You must atleast get a level of " + TreeLevel + " to cut down this tree.");
				resetWC(c);
				return;
			}
			if (!Woodcutting) {
				c.sM("You start to chop down the tree.");
			}
			TreeX = x;
			TreeY = y;
			ChopTimer -= (c.playerLevel[8] / 3) + MinusTime;
			Woodcutting = true;
		} else {
			resetWC(c);
			c.sM("You need an axe to chop down this tree!");
		}
	}

	public void resetWC(client c) {
		Woodcutting = false;
		ChopTimer = 0;
		TreeLevel = 0;
		TreeId = 0;
		TreeXp = 0;
		LogId = 0;
		StumpId = 0;
		Gonefor = 0;
		HowManyLogs = 0;
		TreeX = 0;
		TreeY = 0;
		soundTimer = 0;
		repeatani = 0;
		c.resetAnimation();
	}
	private int soundTimer = 0;
	public int repeatani = 0;
	public int Chopani = 0;

	public void WCprocess(client c) {
		if (ChopTimer > 0) {
			ChopTimer--;
		}
		if (ChopTimer < 0) {
			ChopTimer = 1;
		}
		if (soundTimer > 0) {
			soundTimer--;
		} else {
			soundTimer = 1;
			c.frame174(472, 050, 000);
		}
		if (repeatani > 0) {
			repeatani--;
		} else {
			c.startAnimation(GetAxeAni(c));
			server.playerHandler.players[c.playerId].updateRequired = true;
			server.playerHandler.players[c.playerId].appearanceUpdateRequired = true;
			repeatani = 3;
		}
		if (ChopTimer == 0) {
			if (!Removelog(c)) {
				resetWC(c);
				return;
			} else {
				InitiateWc(c, TreeId, TreeX, TreeY);
			}
		}
	}

	public void SpawnStumps(client c) {
		for (int i = 0; i < server.Trees; i++) {
			if (server.TREESPAWN[i] > 0) {
				c.AddGlobalObj(server.TREEX[i], server.TREEY[i],
						server.TREESTUMP[i], 0, 10);
			}
		}
	}

	public boolean HasLogs() {
		for (int i = 0; i < server.Trees; i++) {
			if (server.TREEX[i] == TreeX && server.TREEY[i] == TreeY) {
				if (server.TREESPAWN[i] > 0) {
					return false;
				} else if (server.TREESPAWN[i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean Removelog(client c) {
		boolean New = true;
		int Treeid = server.Trees;
		for (int i = 0; i < server.Trees; i++) {
			if (server.TREEX[i] == TreeX && server.TREEY[i] == TreeY) {
				if (!HasLogs()) {
					resetWC(c);
					return false;
				}
				New = false;
				server.LOGSLEFT[i]--;
				c.addSkillXP(TreeXp, 8);
				c.addItem(LogId, 1);
				c.sM("You get some " + c.GetItemName(LogId) + ".");
				if (server.LOGSLEFT[i] <= 0) {
					server.TREESPAWN[i] = Gonefor;
					server.LOGS[i] = misc.random(HowManyLogs);
					if (server.LOGS[i] == 0) {
						server.LOGS[i] = 1;
					}
					c.AddGlobalObj(TreeX, TreeY, StumpId, 0, 10);
					return false;
				}
				return true;
			}
		}
		if (New) {
			server.TREEX[Treeid] = TreeX;
			server.TREEY[Treeid] = TreeY;
			server.TREEID[Treeid] = TreeId;
			server.TREESTUMP[Treeid] = StumpId;
			server.LOGSLEFT[Treeid] = misc.random(HowManyLogs);
			if (server.LOGSLEFT[Treeid] == 0) {
				server.LOGSLEFT[Treeid] = 1;
			}
			server.Trees++;
			return true;
		}
		return false;
	}
}