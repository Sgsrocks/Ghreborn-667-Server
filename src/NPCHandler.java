import java.io.*;
import java.util.*;

public class NPCHandler {

public void newPetNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, int HP, boolean Respawns, int summonedBy) {
int slot = -1;
for (int i = 1; i < maxNPCs; i++) {
if (npcs[i] == null) {
slot = i;
break;
}
}
if(slot == -1)
return;
if(HP <= 0) {
HP = 100;
}
NPC newNPC = new NPC(slot, npcType);
newNPC.absX = x;
newNPC.absY = y;
newNPC.makeX = x;
newNPC.makeY = y;
newNPC.moverangeX1 = rangex1;
newNPC.moverangeY1 = rangey1;
newNPC.moverangeX2 = rangex2;
newNPC.moverangeY2 = rangey2;
newNPC.walkingType = WalkingType;
newNPC.HP = HP;
newNPC.MaxHP = HP;
newNPC.MaxHit = (int)Math.floor((HP / 10));
if (newNPC.MaxHit < 1) {
newNPC.MaxHit = 1;
}
newNPC.heightLevel = heightLevel;
newNPC.Respawns = Respawns;
newNPC.followPlayer = summonedBy;
newNPC.followingPlayer = true;
npcs[slot] = newNPC;
}
    public static int maxNPCs = 100000;
    public static int maxListedNPCs = 100000;
    public static int maxNPCDrops = 10000;
    public NPC npcs[] = new NPC[maxNPCs];
    public NPCList NpcList[] = new NPCList[maxListedNPCs];
    public NPCDrops NpcDrops[] = new NPCDrops[maxNPCDrops];
	public void checkBarrows(int npc) {     
if(npcs[npc].npcType == 193) //Druid
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Druidkills += 1; 
}

if (npcs[npc].npcType == 2837) {
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Zombiekills += 1;
                            }
if(npcs[npc].npcType == 104) //Ghost
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Ghostkills += 1; 
}
if(npcs[npc].npcType == 111) 
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Giantkills += 1; 
}
if(npcs[npc].npcType == 752) //Lesser Demon
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Demonkills += 1;
}
if(npcs[npc].npcType == 258) //General Khazard
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.Generalkills += 1;
}
if(npcs[npc].npcType == 1472) //Jungle demon
{
int playerId = npcs[npc].StartKilling;
client c = (client) server.playerHandler.players[playerId];
c.JDemonkills += 1;
}
if(npcs[npc].npcType == 752) //Lesser Demon
{
int Player = npcs[npc].StartKilling;
client ppl = (client) server.playerHandler.players[Player];
ppl.sendMessage("Good! Now kill the General!");
ppl.teleportToX = 3246;
ppl.teleportToY = 3244;
}
if(npcs[npc].npcType == 258) //General Khazard
{
int Player = npcs[npc].StartKilling;
client ppl = (client) server.playerHandler.players[Player];
ppl.sendMessage("Wow, you have made it this far! Kill Him to beat the Mini game!");
ppl.teleportToX = 3202;
ppl.teleportToY = 3266;
}
if(npcs[npc].npcType == 1472) //Jungle demon
{
int Player = npcs[npc].StartKilling;
client ppl = (client) server.playerHandler.players[Player];
ppl.sendMessage("You finished the Mini game! Click on the Chest to claim your reward!");
ppl.teleportToX = 3207;
ppl.teleportToY = 3222;
}
}  
public void spawnANPC2(int absX, int absY, int npcID, int height)
	{
server.npcHandler.newNPC(npcID, (absX), (absY), height, absX + 3, absY + 3, absX - 3, absY - 3, 0, server.npcHandler.GetNpcListHP(npcID), false);
	}
    NPCHandler() {
        for (int i = 0; i < maxNPCs; i++) {
            npcs[i] = null;
        }
        for (int i = 0; i < maxListedNPCs; i++) {
            NpcList[i] = null;
        }
        for (int i = 0; i < maxNPCDrops; i++) {
            NpcDrops[i] = null;
        }
        loadNPCList("./Data/cfg/npc.cfg");
        //loadNPCDrops("./Data/cfg/npcdrops.cfg");
        loadAutoSpawn("./Data/cfg/autospawn.cfg");
	loadAutoSpawn("./Data/cfg/autospawn2.cfg");
	loadAutoSpawn("./Data/cfg/autospawn3.cfg");
    }
public boolean npccanloot=false;	
public int itemdropcheck = 0;
public boolean bigloot = false;
	
public void getItemDropRare(int itemId) {

if (itemdropcheck == 1149){ bigloot = true; }
if (itemdropcheck == 3140){ bigloot = true; }
if (itemdropcheck == 1249){ bigloot = true; }
if (itemdropcheck == 4151){ bigloot = true; }
if (itemdropcheck == 7158){ bigloot = true; }
//ADD MORE ITEMS HERE THAT ARE RARE DROPS
}

		public String getItemName(int ItemID) {
		for (int i = 0; i < server.itemHandler.MaxListedItems; i++) {
			if (server.itemHandler.ItemList[i] != null) {
				if (server.itemHandler.ItemList[i].itemId == ItemID) {
					return server.itemHandler.ItemList[i].itemName;
				}
                                if (ItemID == -1) {
                                        return "Unarmed";
                                }
			}
		}
		return "!! NOT EXISTING ITEM !!! - ID:"+ItemID;
	}

public void spawnANPC(int npcID, int absX, int absY, int height)
	{
server.npcHandler.newNPC(npcID, (absX), (absY), height, absX + 3, absY + 3, absX - 3, absY - 3, 0, server.npcHandler.GetNpcListHP(npcID), false);
	}							
    public void newNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, int HP, boolean Respawns) {
        // first, search for a free slot
        int slot = -1;

        for (int i = 1; i < maxNPCs; i++) {
            if (npcs[i] == null) {
                slot = i;
                break;
            }
        }

        if (slot == -1) {
            return;
        }		// no free slot found
        if (HP <= 0) { // This will cause client crashes if we don't use this :) - xero
            HP = 3000;
        }
        NPC newNPC = new NPC(slot, npcType);

        newNPC.absX = x;
        newNPC.absY = y;
        newNPC.makeX = x;
        newNPC.makeY = y;
        newNPC.moverangeX1 = rangex1;
        newNPC.moverangeY1 = rangey1;
        newNPC.moverangeX2 = rangex2;
        newNPC.moverangeY2 = rangey2;
        newNPC.walkingType = WalkingType;
        newNPC.HP = HP;
        newNPC.MaxHP = HP;
        newNPC.MaxHit = (int) Math.floor((HP / 100));
        if (newNPC.MaxHit < 1) {
            newNPC.MaxHit = 1;
        }
        newNPC.heightLevel = heightLevel;
        newNPC.Respawns = Respawns;
        npcs[slot] = newNPC;
    }

    public void newSummonedNPC(int npcType, int x, int y, int heightLevel, int rangex1, int rangey1, int rangex2, int rangey2, int WalkingType, int HP, boolean Respawns, int summonedBy) {
        // first, search for a free slot
        int slot = -1;

        for (int i = 1; i < maxNPCs; i++) {
            if (npcs[i] == null) {
                slot = i;
                break;
            }
        }

        if (slot == -1) {
            return;
        }		// no free slot found
        if (HP <= 0) { // This will cause client crashes if we don't use this :) - xero
            HP = 3000;
        }
        NPC newNPC = new NPC(slot, npcType);

        newNPC.absX = x;
        newNPC.absY = y;
        newNPC.makeX = x;
        newNPC.makeY = y;
        newNPC.moverangeX1 = rangex1;
        newNPC.moverangeY1 = rangey1;
        newNPC.moverangeX2 = rangex2;
        newNPC.moverangeY2 = rangey2;
        newNPC.walkingType = WalkingType;
        newNPC.HP = HP;
        newNPC.MaxHP = HP;
        newNPC.MaxHit = (int) Math.floor((HP / 100));
        if (newNPC.MaxHit < 1) {
            newNPC.MaxHit = 10;
        }
        newNPC.heightLevel = heightLevel;
        newNPC.Respawns = Respawns;
        newNPC.followPlayer = summonedBy;
        newNPC.followingPlayer = true;
        npcs[slot] = newNPC;
    }

    public void newNPCList(int npcType, String npcName, int combat, int HP) {
        // first, search for a free slot
        int slot = -1;

        for (int i = 0; i < maxListedNPCs; i++) {
            if (NpcList[i] == null) {
                slot = i;
                break;
            }
        }

        if (slot == -1) {
            return;
        }		// no free slot found

        NPCList newNPCList = new NPCList(npcType);

        newNPCList.npcName = npcName;
        newNPCList.npcCombat = combat;
        newNPCList.npcHealth = HP;
        NpcList[slot] = newNPCList;
    }
	public void annoyNpcs(int npcId) {
		for(Player p : server.playerHandler.players) {
			if(p != null) {
				client player = (client)p;
				if (player.distanceToPoint(npcs[npcId].absX, npcs[npcId].absY) <= getDistanceForNpc(npcId) && p.heightLevel == npcs[npcId].heightLevel) {
					if(npcGetsAnnoyed(npcId) && (npcs[npcId] != null) && (npcs[npcId].StartKilling == 0)) {
						npcs[npcId].StartKilling = player.playerId;											npcs[npcId].IsUnderAttack = true;
						npcs[npcId].RandomWalk = false;
						AttackPlayer(player.playerId);
					}
				}
			}
		}
	}
	public int getDistanceForNpc(int Npc) {
		switch(npcs[Npc].npcType) {
			
			case 1827:
			case 1974:
			case 1105:
			case 3454:
			case 3455:
			case 3456:
			case 3457:
			case 3458:
			case 3459:
			case 3460:
			case 3612:
			case 3613:
			case 3614:
			case 2679:
			case 3452:
			case 3453:
			case 2686:
			case 2881:
			case 2882:
			case 2883:
			case 8149:
			return 1000;
			case 50:
			case 504:
			case 1155:
			case 1160:
case 1116:
			case 1115:
case 3500:
case 3496:
case 3494:
case 3495:
case 3491:
case 3493:
			case 2627:
			case 2630:
			case 2631:
			case 2738:
			case 2741:
			case 2743:
case 72:
			case 2745:
			case 1472:
			case 3735:
			case 3745:
			case 3755:
			case 3765:
			case 3775:
			case 3785:
				return 100;
			case 2746:
				return 150;
			case 3200:
			case 63:
			case 1459:
			case 111:
			case 125:
			case 59:
			case 91:
case 2025:
case 2026:
case 2027:
case 2028:
case 2029:
case 2030:
			case 912:
			case 913:
			case 914:
			case 78:
			case 83:
			case 1153:
			case 1154:
			case 2263:
			case 2264:
			case 2265:
				return 10;
			
			default:
				return 10;
		}
	}

	public boolean npcGetsAnnoyed(int Npc) {
		switch(npcs[Npc].npcType) {
			
			case 1827:
			case 1974:
			case 1105:
			case 3454:
			case 3455:
			case 3456:
			case 3457:
			case 3458:
			case 3459:
			case 3460:
			case 3612:
			case 3613:
			case 3614:
			case 2679:
			case 3452:
			case 3453:
			case 2686:
			case 50:
			case 1610:
case 8149:
case 2025:
case 2026:
case 2027:
case 2028:
case 2029:
case 3500:
case 2030:
case 3496:
case 3494:
case 3495:
case 3491:
case 3493:
			case 3200:
			case 504:

case 1116:
			case 1115:

			case 1459:
			case 1155:
			case 1160:
			case 2627:
			case 2630:
			case 2631:
			case 2738:
			case 2741:
			case 3735:
			case 3745:
			case 3755:
			case 3765:
			case 3775:
			case 3785:
			case 2743:
			case 2745:
case 72:
			case 2746:
			case 1472:
			case 63:
			case 111:
			case 125:
			case 59:
			case 91:
			case 912:
			case 913:
			case 914:
			case 78:
			case 83:
			case 1153:
			case 1154:
			case 2263:
			case 2264:
			case 2265:
				return true;
			
			default:
				return false;
			}
	}
    public void newNPCDrop(int npcType, int dropType, int Items[], int ItemsN[]) {
        // first, search for a free slot
        int slot = -1;

        for (int i = 0; i < maxNPCDrops; i++) {
            if (NpcDrops[i] == null) {
                slot = i;
                break;
            }
        }

        if (slot == -1) {
            return;
        }		// no free slot found

        NPCDrops newNPCDrop = new NPCDrops(npcType);

        newNPCDrop.DropType = dropType;
        newNPCDrop.Items = Items;
        newNPCDrop.ItemsN = ItemsN;
        NpcDrops[slot] = newNPCDrop;
    }

    /*
     public boolean IsInWorldMap(int coordX, int coordY) {
     for (int i = 0; i < worldmap[0].length; i++) {
     //if (worldmap[0][i] == coordX && worldmap[1][i] == coordY) {
     return true;
     //}
     }
     return false;
     }
     public boolean IsInWorldMap2(int coordX, int coordY) {
     for (int i = 0; i < worldmap2[0].length; i++) {
     if (worldmap2[0][i] == coordX && worldmap2[1][i] == coordY) {
     return true;
     }
     }
     return true;
     }

     public boolean IsInRange(int NPCID, int MoveX, int MoveY) {
     int NewMoveX = (npcs[NPCID].absX + MoveX);
     int NewMoveY = (npcs[NPCID].absY + MoveY);
     if (NewMoveX <= npcs[NPCID].moverangeX1 && NewMoveX >= npcs[NPCID].moverangeX2 && NewMoveY <= npcs[NPCID].moverangeY1 && NewMoveY >= npcs[NPCID].moverangeY2) {
     if ((npcs[NPCID].walkingType == 1 && IsInWorldMap(NewMoveX, NewMoveY) == true) || (npcs[NPCID].walkingType == 2 && IsInWorldMap2(NewMoveX, NewMoveY) == false)) {
     if (MoveX == MoveY) {
     if ((IsInWorldMap(NewMoveX, npcs[NPCID].absY) == true && IsInWorldMap(npcs[NPCID].absX, NewMoveY) == true) || (IsInWorldMap2(NewMoveX, npcs[NPCID].absY) == false && IsInWorldMap2(npcs[NPCID].absX, NewMoveY) == false)) {
     return true;
     }
     return false;
     }
     return true;
     }
     }
     return false;
     }*/
    public int GetMove(int Place1, int Place2) { // Thanks to diablo for this! Fixed my npc follow code <3
        if ((Place1 - Place2) == 0) {
            return 0;
        } else if ((Place1 - Place2) < 0) {
            return 1;
        } else if ((Place1 - Place2) > 0) {
            return -1;
        }
        return 0;
    }

    public void FollowPlayer(int NPCID) {
        int follow = npcs[NPCID].followPlayer;
        int playerX = server.playerHandler.players[follow].absX;
        int playerY = server.playerHandler.players[follow].absY;

        npcs[NPCID].RandomWalk = false;
        if (server.playerHandler.players[follow] != null) {
            if (playerY < npcs[NPCID].absY) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY + 1);
            } else if (playerY > npcs[NPCID].absY) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY - 1);
            } else if (playerX < npcs[NPCID].absX) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX + 1);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY);
            } else if (playerX > npcs[NPCID].absX) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX - 1);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY);
            }
            npcs[NPCID].getNextNPCMovement();                                              
            npcs[NPCID].updateRequired = true;
        }
    }

    public void FollowPlayerCB(int NPCID, int playerID) {
        int playerX = server.playerHandler.players[playerID].absX;
        int playerY = server.playerHandler.players[playerID].absY;

        npcs[NPCID].RandomWalk = false;
        if (server.playerHandler.players[playerID] != null) {
            if (playerY < npcs[NPCID].absY) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY + 1);
            } else if (playerY > npcs[NPCID].absY) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY - 1);
            } else if (playerX < npcs[NPCID].absX) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX + 1);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY);
            } else if (playerX > npcs[NPCID].absX) {
                npcs[NPCID].moveX = GetMove(npcs[NPCID].absX, playerX - 1);
                npcs[NPCID].moveY = GetMove(npcs[NPCID].absY, playerY);
            }
            npcs[NPCID].getNextNPCMovement();                                              
            npcs[NPCID].updateRequired = true;
        }
    }

    public boolean IsInWorldMap(int coordX, int coordY) {
        for (int i = 0; i < worldmap[0].length; i++) {
            // if (worldmap[0][i] == coordX && worldmap[1][i] == coordY) {
            return true;
            // }
        }
        return false;
    }

    public boolean IsInWorldMap2(int coordX, int coordY) {
        for (int i = 0; i < worldmap2[0].length; i++) {
            if (worldmap2[0][i] == coordX && worldmap2[1][i] == coordY) {
                return true;
            }
        }
        return false;
    }

    public boolean IsInRange(int NPCID, int MoveX, int MoveY) {
        int NewMoveX = (npcs[NPCID].absX + MoveX);
        int NewMoveY = (npcs[NPCID].absY + MoveY);

        if (NewMoveX <= npcs[NPCID].moverangeX1
                && NewMoveX >= npcs[NPCID].moverangeX2
                && NewMoveY <= npcs[NPCID].moverangeY1
                && NewMoveY >= npcs[NPCID].moverangeY2) {
            if ((npcs[NPCID].walkingType == 1
                    && IsInWorldMap(NewMoveX, NewMoveY) == true)
                            || (npcs[NPCID].walkingType == 2
                                    && IsInWorldMap2(NewMoveX, NewMoveY)
                                            == false)) {
                if (MoveX == MoveY) {
                    if ((IsInWorldMap(NewMoveX, npcs[NPCID].absY) == true
                            && IsInWorldMap(npcs[NPCID].absX, NewMoveY) == true)
                                    || (IsInWorldMap2(NewMoveX, npcs[NPCID].absY)
                                            == false
                                                    && IsInWorldMap2(
                                                            npcs[NPCID].absX,
                                                            NewMoveY)
                                                                    == false)) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void PoisonNPC(int NPCID) {
        npcs[NPCID].PoisonClear = 0;
        npcs[NPCID].PoisonDelay = 40;
    }

    public void Poison(int NPCID) {
        if (npcs[NPCID].PoisonDelay <= 1) {
            int hitDiff = 3 + misc.random(15);

            npcs[NPCID].poisondmg = true;
            server.npcHandler.npcs[NPCID].hitDiff = hitDiff;
            server.npcHandler.npcs[NPCID].updateRequired = true;
            server.npcHandler.npcs[NPCID].hitUpdateRequired = true;
            npcs[NPCID].PoisonClear++;
            npcs[NPCID].PoisonDelay = 40;
        }
    }

    public void process() {
        for (int i = 0; i < maxNPCs; i++) {
            if (npcs[i] == null) {
                continue;
            }
            npcs[i].clearUpdateFlags();
        }
		
        for (int i = 0; i < maxNPCs; i++) {                        
            if (npcs[i] != null) {
		annoyNpcs(i);
                if (npcs[i].actionTimer > 0) {
                    npcs[i].actionTimer--;
                }
                Poison(i);
                npcs[i].PoisonDelay -= 1;
                if (npcs[i].PoisonClear >= 15) {
                    npcs[i].PoisonDelay = 9999999;
                }
                if (npcs[i].IsDead == false) {
                    if (npcs[i].npcType == 1268 || npcs[i].npcType == 1266) {
                        for (int j = 1; j < server.playerHandler.maxPlayers; j++) {
                            if (server.playerHandler.players[j] != null) {
                                if (GoodDistance(npcs[i].absX, npcs[i].absY,
                                        server.playerHandler.players[j].absX,
                                        server.playerHandler.players[j].absY, 2)
                                        == true
                                                && npcs[i].IsClose == false) {
                                    npcs[i].actionTimer = 2;
                                    npcs[i].IsClose = true;
                                }
                            }
                        }
                                                                                            
                        if (npcs[i].actionTimer == 0 && npcs[i].IsClose == true) {
                            for (int j = 1; j < server.playerHandler.maxPlayers; j++) {
                                if (server.playerHandler.players[j] != null) {
                                    server.playerHandler.players[j].RebuildNPCList = true;
                                }
                            }
                            if (npcs[i].Respawns) {
                                int old1 = (npcs[i].npcType - 1);
                                int old2 = npcs[i].makeX;
                                int old3 = npcs[i].makeY;
                                int old4 = npcs[i].heightLevel;
                                int old5 = npcs[i].moverangeX1;
                                int old6 = npcs[i].moverangeY1;
                                int old7 = npcs[i].moverangeX2;
                                int old8 = npcs[i].moverangeY2;
                                int old9 = npcs[i].walkingType;
                                int old10 = npcs[i].MaxHP;

                                npcs[i] = null;
                                newNPC(old1, old2, old3, old4, old5, old6, old7,
                                        old8, old9, old10, true);
                            }
                        }
                    } else if (npcs[i].RandomWalk == true
                            && misc.random2(10) == 1 && npcs[i].moverangeX1 > 0
                            && npcs[i].moverangeY1 > 0
                            && npcs[i].moverangeX2 > 0
                            && npcs[i].moverangeY2 > 0) { // Move NPC
                        int MoveX = misc.random(1);
                        int MoveY = misc.random(1);
                        int Rnd = misc.random2(4);

                        if (Rnd == 1) {
                            MoveX = -(MoveX);
                            MoveY = -(MoveY);
                        } else if (Rnd == 2) {
                            MoveX = -(MoveX);
                        } else if (Rnd == 3) {
                            MoveY = -(MoveY);
                        }
                        if (IsInRange(i, MoveX, MoveY) == true) {
                            npcs[i].moveX = MoveX;
                            npcs[i].moveY = MoveY;
                        }
                        npcs[i].updateRequired = true;
                    } else if (npcs[i].RandomWalk == false
                            && npcs[i].IsUnderAttack == true) {
                        if (npcs[i].npcType == 1645 || npcs[i].npcType == 1241
                                || npcs[i].npcType == 1246
                                || npcs[i].npcType == 1159
                                || npcs[i].npcType == 54) {
                            AttackPlayerMage(i);
                        } else {
                            AttackPlayer(i);
                        }
                    } else if (npcs[i].followingPlayer
                            && npcs[i].followPlayer > 0
                            && server.playerHandler.players[npcs[i].followPlayer]
                                    != null) {
                        if (server.playerHandler.players[npcs[i].followPlayer].AttackingOn
                                > 0) {
                            int follow = npcs[i].followPlayer;

                            npcs[i].StartKilling = server.playerHandler.players[follow].AttackingOn;
                            npcs[i].RandomWalk = true;
                            npcs[i].IsUnderAttack = true;
                            if (npcs[i].StartKilling > 0) {
                                if (npcs[i].npcType == 1645
                                        || npcs[i].npcType == 509
                                        || npcs[i].npcType == 1241
                                        || npcs[i].npcType == 1246
					        || npcs[i].npcType == 766
					        || npcs[i].npcType == 765
					        || npcs[i].npcType == 764
					        || npcs[i].npcType == 763
					        || npcs[i].npcType == 762
					        || npcs[i].npcType == 761
					        || npcs[i].npcType == 768
					        || npcs[i].npcType == 769
					        || npcs[i].npcType == 770
					        || npcs[i].npcType == 771
					        || npcs[i].npcType == 772
					        || npcs[i].npcType == 773
					        || npcs[i].npcType == 3507
                                        || npcs[i].npcType == 54) {
                                    AttackPlayerMage(i);
                                } else {
                                    AttackPlayer(i);
                                } 
                            }

                        } else {
                            FollowPlayer(i);
                        }
                    } else if (npcs[i].followingPlayer
                            && npcs[i].followPlayer > 0
                            && server.playerHandler.players[npcs[i].followPlayer]
                                    != null) {
                        if (server.playerHandler.players[npcs[i].followPlayer].attacknpc
                                > 0) {
                            int follow = npcs[i].followPlayer;

                            npcs[i].attacknpc = server.playerHandler.players[follow].attacknpc;
                            npcs[i].IsUnderAttackNpc = true;
                            npcs[npcs[i].attacknpc].IsUnderAttackNpc = true;
                            if (npcs[i].attacknpc > 0) {
                                if (npcs[i].npcType == 1645
                                        || npcs[i].npcType == 1241
					        || npcs[i].npcType == 766
					        || npcs[i].npcType == 765
					        || npcs[i].npcType == 764
					        || npcs[i].npcType == 763
					        || npcs[i].npcType == 762
					        || npcs[i].npcType == 761
					        || npcs[i].npcType == 768
					        || npcs[i].npcType == 769
					        || npcs[i].npcType == 770
					        || npcs[i].npcType == 771
					        || npcs[i].npcType == 772
					        || npcs[i].npcType == 773
					        || npcs[i].npcType == 3507
                                        || npcs[i].npcType == 1246) {
                                    AttackNPCMage(i);
                                } else {                                                
                                    AttackNPC(i);
                                }
                            }
                        } else {
                            FollowPlayer(i);
                        }
                                      
                    } else if (npcs[i].IsUnderAttackNpc == true) {
                        AttackNPC(i);                                                                                                   

                        /* if(misc.random(50) == 1) {
                         npcs[i].updateRequired = true;
                         npcs[i].textUpdateRequired = true;
                         npcs[i].textUpdate = "I had ya ma last night bitch";
                         }
                         if(misc.random(50) == 3) {
                         npcs[i].updateRequired = true;
                         npcs[i].textUpdateRequired = true;
                         npcs[i].textUpdate = "Haha I own you neeb";
                         }
                         if(misc.random(50) == 5) {
                         npcs[i].updateRequired = true;
                         npcs[i].textUpdateRequired = true;
                         npcs[i].textUpdate = "Cmon then bitch";
                         }
                         if(misc.random(50) == 7) {
                         npcs[i].updateRequired = true;
                         npcs[i].textUpdateRequired = true;
                         npcs[i].textUpdate = "ARGHH!";
                         }
                         if(misc.random(50) == 9) {
                         npcs[i].updateRequired = true;
                         npcs[i].textUpdateRequired = true;
                         npcs[i].textUpdate = "Owch that hurt!";
                         }*/
                    } /* else if (i == 94) {
                     npcs[i].attacknpc = 95;
                     npcs[i].IsUnderAttackNpc = true;
                     npcs[95].IsUnderAttackNpc = true;
                     AttackNPC(i);
                     } else if (i == 96) {
                     npcs[i].attacknpc = 97;
                     npcs[i].IsUnderAttackNpc = true;
                     npcs[97].IsUnderAttackNpc = true;
                     AttackNPC(i);
                     } */
                    if (npcs[i].RandomWalk == true) {
                        npcs[i].getNextNPCMovement();
                    }
                    if (npcs[i].npcType == 81 || npcs[i].npcType == 397
                            || npcs[i].npcType == 1766
                            || npcs[i].npcType == 1767
                            || npcs[i].npcType == 1768) {
                        if (misc.random2(50) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Moo";
                        }
                    }
                    if (npcs[i].npcType == 409) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Welcome to the Staffzone!!!";
                        }
                    }
                    if (npcs[i].npcType == 246) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Do ::inside Sir!";
                        }
                    }
                    if (npcs[i].npcType == 532) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Member Shop!";
                        }
                    }
                    if (npcs[i].npcType == 660) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "We are the knights of the party room!";
                        }
                    }
                    if (npcs[i].npcType == 2478) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Nigger You Got Jailed";
                        }
                    }
                    if (npcs[i].npcType == 2478) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Don't Think Of Logging Out";
                        }
                    }
                    if (npcs[i].npcType == 2478) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "or Asking To get unjailed";
                        }
                    }
                    if (npcs[i].npcType == 2478) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Ur Here Because You Was not Being Good To Others";
                        }
                    }
                    if (npcs[i].npcType == 2478) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Think What U have Done!!";
                        }
                    }
                    if (npcs[i].npcType == 660) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Here to Party 24/7!";
                        }
                    }
                    if (npcs[i].npcType == 364) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Mod & Admin Portal Only!";
                        }
                    }
                    if (npcs[i].npcType == 280) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Strength Guild, 99 strength to Enter!";
                        }
                    }
                    if (npcs[i].npcType == 172) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Range/Magic Guild, 99 Range and Magic to Enter!";
                        }
                    }
                    if (npcs[i].npcType == 212) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Welcome to the Mod/Admin Zone..Keep up the Good Work!";
                        }
                    }
                    if (npcs[i].npcType == 945) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "You Finally Made It here..Keep up the Good Work!";
                        }
                    }
                    if (npcs[i].npcType == 225) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Icon Minigame!";
                        }
                    }
                    if (npcs[i].npcType == 648) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Welcome to Training Made To Own N33bs!";
                        }
                    }
                    if (npcs[i].npcType == 793) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Enchanted Minigame!";
                        }
                    }
                    if (npcs[i].npcType == 2253) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Clan Wars Portal!!";
                        }
                    }
                    if (npcs[i].npcType == 541) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Skill Cape Shop!";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "We are the righteous ones in his eyes alone.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Let them not infest our cities and towns...";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "And lo, we become the power, indeed the force to stop these monsters in their tracks.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Verily I urge you, my friends to take up your spades and farm your farms to feed our people in this blessed sanctuary.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "If thine monsters visage does frighten thee, then tear it off I say... tear it off!";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "For Saradomin will guide our sword arms and smash the enemies of humans till their bones become dust.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "And let us smite these monsters unto their deaths.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "For they are not the chosen ones in Saradomin's eyes.";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Where do we go for safety from these monsters... here, my brethren!";
                        }
                    }
                    if (npcs[i].npcType == 1713) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "And let there be no cave or shelter for their spawn until the end of days.";
                        }
                    }
                    if (npcs[i].npcType == 2821) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Fishing Portal!";
                        }
                    }
                    if (npcs[i].npcType == 2304) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Farming Shop!By seed's for patch's!";
                        }
                    }
                    if (npcs[i].npcType == 461) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Magic Shop!";
                        }
                    }
                    if (npcs[i].npcType == 0) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Welcome to Allstar-Scape's Shopping Area!";
                        }
                    }
                    if (npcs[i].npcType == 57) {
                        if (misc.random2(30) == 1) {     
                            npcs[i].updateRequired = true;
			    npcs[i].textUpdateRequired = true;
int players = PlayerHandler.getPlayerCount();
npcs[i].textUpdate = "Players Online: " + players;
}
}   
                    if (npcs[i].npcType == 550) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Pk Shop!";
                        }
                    }
                    if (npcs[i].npcType == 1759) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Shops Here!";
                        }
                    }
                    if (npcs[i].npcType == 1699) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Pur3 Sh0p!";
                        }
                    }
                    if (npcs[i].npcType == 2475) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Training Portal!";
                        }
                    }
                    if (npcs[i].npcType == 28) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Train Your Skills Here!";
                        }
                    }
                    if (npcs[i].npcType == 1917) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Rune Armor Shop!!!";
                        }
                    }
                    if (npcs[i].npcType == 522) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "General Store!";
                        }
                    }
                    if (npcs[i].npcType == 522) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Great deals Here!";
                        }
                    }
                    if (npcs[i].npcType == 548) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Gloves, Robes, Boots Shop!";
                        }
                    }
                    if (npcs[i].npcType == 530) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Skillers Shop!";
                        }
                    }
                    if (npcs[i].npcType == 528) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Woodcutting Store!!";
                        }
                    }
if (npcs[i].npcType == 949)
					{
					if (misc.random2(30) <= 3)
						{
							npcs[i].updateRequired = true;
							npcs[i].textUpdateRequired = true;
							npcs[i].textUpdate = "Welcome to Moderator Island!";
						}
					}
					if (npcs[i].npcType == 2244)
					{
						if (misc.random2(30) <= 3)
						{
							npcs[i].updateRequired = true;
							npcs[i].textUpdateRequired = true;
							npcs[i].textUpdate = "Welcome to Moderator Island!";
						}
					}
                    if (npcs[i].npcType == 213) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "You need the frozen key to get in this portal! Kill the troll for key!";
                        }
                    }
                    if (npcs[i].npcType == 520) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Allstar's Ownage Shop!";
                        }
                    }
                    if (npcs[i].npcType == 524) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Silab Member Shop!";
                        }
                    }
                    if (npcs[i].npcType == 555) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Random Stoof!";
                        }
                    }
                    if (npcs[i].npcType == 561) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Hood Shop!";
                        }
                    }
                    if (npcs[i].npcType == 538) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Slayer Shop!";
                        }
                    }
                    if (npcs[i].npcType == 529) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Farming Shop!";
                        }
                    }

                    if (npcs[i].npcType == 3117) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Click the chests for slayer exp ..";
                        }
                    }
                    if (npcs[i].npcType == 866) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Et .. Phone .. Home!";
                        }
                    }
                    if (npcs[i].npcType == 549) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Smithin' Shop";
                        }
                    }
                    if (npcs[i].npcType == 558) {
                        if (misc.random2(30) <= 2) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Herblore shop!!";
                        }
                    }
                  if (npcs[i].npcType == 1552) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Merry Christmas!!!";
                        }
		}
                    for (Player p : server.playerHandler.players) {
                        client person = (client) p;

                        if (p != null && person != null) {
                            if (p != null && person != null) { 
                                if (person.distanceToPoint(npcs[i].absX,
                                        npcs[i].absY)
                                        >= 5) {
                                    npcs[i].RandomWalk = true;
                                }
                            }
                        }
                    }
                    for (Player p : server.playerHandler.players) {
                        client person = (client) p;

                        if (p != null && person != null) {
                            if (p != null && person != null) { 
                                if (person.distanceToPoint(npcs[i].absX,
                                        npcs[i].absY)
                                        >= 5) {
                                    if (npcs[i].npcType != 1160
                                            || npcs[i].npcType == 2745 || npcs[i].npcType == 1115 || npcs[i].npcType == 50 || npcs[i].npcType == 3425 || npcs[i].npcType == 53 || npcs[i].npcType == 3847 || npcs[i].npcType == 1558 || npcs[i].npcType == 40 || npcs[i].npcType == 2837) {
                                        npcs[i].RandomWalk = true;
                                    }
                                }
                            }
                        }
                    }
                    for (Player p : server.playerHandler.players) {
                        client person = (client) p;

                        if (p != null && person != null) {
                            if (p != null && person != null) { 
                                if (person.distanceToPoint(npcs[i].absX,npcs[i].absY)<= 2 && p.heightLevel== npcs[i].heightLevel) {
                                    if ((npcs[i].npcType == 2745 
					|| npcs[i].npcType == 1158) 
					&& (npcs[i].IsUnderAttack == true)) {
                                        npcs[i].StartKilling = person.playerId;
                                        npcs[i].RandomWalk = false; //attack stuff low level
                                    
			            } else if ((npcs[i].npcType == 2745 
					    || npcs[i].npcType == 1158 || npcs[i].npcType == 1115 || npcs[i].npcType == 50 || npcs[i].npcType == 3425 || npcs[i].npcType == 53 || npcs[i].npcType == 3847 || npcs[i].npcType == 1558 || npcs[i].npcType == 1116 || npcs[i].npcType == 1117 || npcs[i].npcType == 2837)
					 && (npcs[i].IsUnderAttack == false)) { 
                                        npcs[i].RandomWalk = true;
                                        npcs[i].IsUnderAttack = false; //run your butt away
                                     
				    } else if (person.distanceToPoint(npcs[i].absX, npcs[i].absY)<= 127 || person.heightLevel != npcs[i].heightLevel) {
                                        if ((npcs[i].npcType == 2745 
					    || npcs[i].npcType == 1158 || npcs[i].npcType == 1115 || npcs[i].npcType == 50 || npcs[i].npcType == 3425 || npcs[i].npcType == 53 || npcs[i].npcType == 3847 || npcs[i].npcType == 1558 || npcs[i].npcType == 1116 || npcs[i].npcType == 1117 || npcs[i].npcType == 2837)
					    && (npcs[i].IsUnderAttack == true)) {
                                            npcs[i].StartKilling = person.playerId;
                                        npcs[i].RandomWalk = false; //attack stuff high level
                                        }
                                    }
                                } 
                            }
                        }
                    }
                    if (npcs[i].npcType == 1451) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Tele to varrock";
                        }
                    }
                    if (npcs[i].npcType == 33) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Tele to varrock";
                        }
                    }
                    if (npcs[i].npcType == 37) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Welcome To Edgeville...";
                        }
                    }
					
                    if (npcs[i].npcType == 1201) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "DO YOU DARE ENTER THE BLACK DRAGONS LAIR?";
                        }
                    }
					
                    if (npcs[i].npcType == 1199) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "GO THROUGH THIS DOOR TO TELEPORT TO THE BLACK DRAGON CAVE";
                        }
                    }
					
                    if (npcs[i].npcType == 2301) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Tele to the monkey training area";
                        }		
                    }
                    if (npcs[i].npcType == 1659) {
                        if (misc.random2(30) == 1) {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "Go to www.projectdestiny.co.nr to buy and sell things!";
                        }
                    } else if (npcs[i].npcType == 3832) {
                        if (misc.random2(50) <= 3) // this is the time delay
                        {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            npcs[i].textUpdate = "I shoulda never sold that crack! Ho HO HO!!";
                        }
                    } else if (npcs[i].npcType == 3832) {
                        if (misc.random2(10) <= 3) // this is the time delay
                        {
                            npcs[i].updateRequired = true;
                            npcs[i].textUpdateRequired = true;
                            if (PlayerHandler.isPlayerOn("Mod Allstar")) {
                                npcs[i].textUpdate = "Mod Allstar is ONLINE";
                            } else {
                                npcs[i].textUpdate = "Mod Allstar is OFFLINE";
                            }
                        }
                    }
                } else if (npcs[i].IsDead == true) {
			npccanloot=true;
                    if (npcs[i].actionTimer == 0 && npcs[i].DeadApply == false
                            && npcs[i].NeedRespawn == false) {
                        if (npcs[i].npcType == 81 || npcs[i].npcType == 397
                                || npcs[i].npcType == 1766
                                || npcs[i].npcType == 1767
                                || npcs[i].npcType == 1768) {
                            npcs[i].animNumber = 0x03E; // cow dead
                        } else if (npcs[i].npcType == 41) {
                            npcs[i].animNumber = 0x039; // chicken dead
                        } else if (npcs[i].npcType == 113) {
                            npcs[i].animNumber = 11418; // jogre dead
                        } else if (npcs[i].npcType == 8149) {
                            npcs[i].animNumber = 5575; // armoured zombie dead
                        } else if (npcs[i].npcType == 87) {
                            npcs[i].animNumber = 0x08D; // rat dead
                        } else if (npcs[i].npcType == 86) {
                            npcs[i].animNumber = 0x08D; // rat dead
                        } else if (npcs[i].npcType == 88) {
                            npcs[i].animNumber = 0x08D; // rat dead
                        } else if (npcs[i].npcType == 75) {
                            npcs[i].animNumber = 466; // chicken dead
                        } else if (npcs[i].npcType == 3340) {
                            npcs[i].animNumber = 3310; // chicken dead
                        } else if (npcs[i].npcType == 1338) {
                            npcs[i].animNumber = 1342; // dagnnoth dead
                        } else if (npcs[i].npcType == 2783) {
                            npcs[i].animNumber = 2733; // dagnnoth dead
                        } else if (npcs[i].npcType == 1116) {
                            npcs[i].animNumber = 6965; // sara dead
                        } else if (npcs[i].npcType == 1115) {
                            npcs[i].animNumber = 7062; // bandos dead
                        } else if (npcs[i].npcType == 1117) {
                            npcs[i].animNumber = 6946; // k'rill dead
                        } else if (npcs[i].npcType == 1122) {
                            npcs[i].animNumber = 7011; // bree dead
                        } else if (npcs[i].npcType == 2026) { // Barrows Dharok
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 1160) {
                            npcs[i].animNumber = 1187; // chicken dead
                        } else if (npcs[i].npcType == 2025) { // Barrows Ahrim
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 2027) { // Barrows Guthan
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 2028) { // Barrows Karil
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 2029) { // Barrows Torag
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 2030) { // Barrows Verac
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 50) { // KBD
                            npcs[i].animNumber = 92;
                        } else if (npcs[i].npcType == 2036) { // Barrows Skeletons
                            npcs[i].animNumber = 0x900;
                        } else if (npcs[i].npcType == 83) { // Greater Demon
                            npcs[i].animNumber = 804;
                        } else if (npcs[i].npcType == 3200) {
                            npcs[i].animNumber = 777; // drags: chaos ele emote ( YESSS ) 
                        } else if (npcs[i].npcType == 1605) {
                            npcs[i].animNumber = 1508; // drags: abberant spector ( YAY )
                        } else if (npcs[i].npcType == 55) {
                            npcs[i].animNumber = 92; // KBD dead
                        } else if (npcs[i].npcType == 49) {
                            npcs[i].animNumber = 92; // hellhound dead
                        } else if (npcs[i].npcType == 55) {
                            npcs[i].animNumber = 92; // blue dragon
                        } else if (npcs[i].npcType == 941) {
                            npcs[i].animNumber = 92; // green dragon
                        } else if (npcs[i].npcType == 1590) {
                            npcs[i].animNumber = 92; // bronze dragon
                        } else if (npcs[i].npcType == 1591) {
                            npcs[i].animNumber = 92; // iron dragon
                        } else if (npcs[i].npcType == 1592) {
                            npcs[i].animNumber = 92; // steel dragon
                        } else if (npcs[i].npcType == 8133) {
                            npcs[i].animNumber = 10386; // Corporeal Beast
                        } else if (npcs[i].npcType == 1472) {
                            npcs[i].animNumber = 67; // Corporeal Beast
                        } else if (npcs[i].npcType == 53) {
                            npcs[i].animNumber = 92; // red dragon    
                        } else if (npcs[i].npcType == 17) {
                            npcs[i].animNumber = 836; // red dragon                                              
                        } else if (npcs[i].npcType == 54) {
                            npcs[i].animNumber = 92; // black dragon
                        } else if (npcs[i].npcType == 2745) {
                            npcs[i].animNumber = 2654; // jad dead
                        } else {
                            npcs[i].animNumber = 0x900; // human dead
                        }
						client temp = (client) server.playerHandler.players[npcs[i].getKiller()];
/* Barrows */
                                                        if (npcs[i].npcType == 2025) {
                                                                Barrows.Ahrim = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.AHRIM_AWAKE = false;
                                                                temp.teleportToX = 3568;
                                                                temp.teleportToY = 9711;
                                                                temp.heightLevel = 0;
                                                        }
                                                        if (npcs[i].npcType == 2030) {
                                                                Barrows.Verac = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.VERAC_AWAKE = false;
                                                        }
                                                        if (npcs[i].npcType == 2026) {
                                                                Barrows.Dharok = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.DHAROCK_AWAKE = false;
                                                        }
                                                        if (npcs[i].npcType == 2029) {
                                                                Barrows.Torag = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.TORAG_AWAKE = false;
                                                        }
                                                        if (npcs[i].npcType == 2028) {
                                                                Barrows.Karils = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.KARILS_AWAKE = false;
                                                        }
                                                        if (npcs[i].npcType == 2027) {
                                                                Barrows.Guthan = 1;
                                                                Barrows.Barrows += 1;
                                                                Barrows.GUTHAN_AWAKE = false;
                                                        }
                        npcs[i].updateRequired = true;
                        npcs[i].animUpdateRequired = true;
                        npcs[i].DeadApply = true;
                        npcs[i].actionTimer = 10;
							if (npcs[i].npcType == 3777) {
PlayerHandler.portal1 = true;
}
							if (npcs[i].npcType == 3778) {
PlayerHandler.portal2 = true;
}
							if (npcs[i].npcType == 3779) {
PlayerHandler.portal3 = true;
}
							if (npcs[i].npcType == 3780) {
PlayerHandler.portal4 = true;
}
                        if (npcs[i].followingPlayer
                                && server.playerHandler.players[npcs[i].followPlayer]
                                        != null) {
                            server.playerHandler.players[npcs[i].followPlayer].summonedNPCS--;
                        }
                    } else if (npcs[i].actionTimer == 0
                            && npcs[i].DeadApply == true
                            && npcs[i].NeedRespawn == false && npcs[i] != null) {
                        MonsterDropItem(i);
			checkBarrows(i);
                        npcs[i].NeedRespawn = true;
                        npcs[i].actionTimer = 60;
                        npcs[i].absX = npcs[i].makeX;
                        npcs[i].absY = npcs[i].makeY;
                        npcs[i].animNumber = 0x328;
                        npcs[i].HP = npcs[i].MaxHP;
                        npcs[i].updateRequired = true;
                        npcs[i].animUpdateRequired = true;

                    } else if (npcs[i].actionTimer == 0
                            && npcs[i].NeedRespawn == true) {
                        for (int j = 1; j < server.playerHandler.maxPlayers; j++) {
                            if (server.playerHandler.players[j] != null) {
                                server.playerHandler.players[j].RebuildNPCList = true;
                            }
                        }
                        if (npcs[i].Respawns) {
                            int old1 = npcs[i].npcType;

                            if (old1 == 1267 || old1 == 1265) {
                                old1 += 1;
                            }
                            int old2 = npcs[i].makeX;
                            int old3 = npcs[i].makeY;
                            int old4 = npcs[i].heightLevel;
                            int old5 = npcs[i].moverangeX1;
                            int old6 = npcs[i].moverangeY1;
                            int old7 = npcs[i].moverangeX2;
                            int old8 = npcs[i].moverangeY2;
                            int old9 = npcs[i].walkingType;
                            int old10 = npcs[i].MaxHP;

                            npcs[i] = null;
                            newNPC(old1, old2, old3, old4, old5, old6, old7,
                                    old8, old9, old10, true);
                        }
                    }
                }
            }
        }
    }	

    /* public void MonsterDropItems(int NPCID) {
     int Drop = misc.random2(5);
     boolean Go = true;
     int ArrayID = GetNPCDropArrayID(npcs[NPCID].npcType, 0);
     int rnd = 0;
     int FirstDrop = 526; //Normal Bones
     int FirstDropN = 1;
     int SecondDrop = -1;
     int SecondDropN = -1;
     {
     if (ArrayID != -1) {
     for (int i = (NpcDrops[ArrayID].Items.length - 1); i >= 0; i--) {
     if (NpcDrops[ArrayID].Items[i] > -1) {
     FirstDrop = NpcDrops[ArrayID].Items[i];
     FirstDropN = NpcDrops[ArrayID].ItemsN[i];
     if (FirstDrop != -1 && FirstDropN != -1) {
     if (Item.itemStackable[FirstDrop] == true || Item.itemIsNote[FirstDrop] == true) {
     Go = true;
     while (Go == true) {
     if (IsDropping == false) {
     MonsterDropItem(FirstDrop, FirstDropN, NPCID);
     Go = false;
     }
     }
     } else {
     for (int j = FirstDropN; j > 0; j--) {
     Go = true;
     while (Go == true) {
     if (IsDropping == false) {
     MonsterDropItem(FirstDrop, 1, NPCID);
     Go = false;
     }
     }
     }
     }
     }
     }
     }
     } else {
     MonsterDropItem(FirstDrop, FirstDropN, NPCID);
     }
     ArrayID = GetNPCDropArrayID(npcs[NPCID].npcType, Drop);
     if (ArrayID != -1) {
     rnd = misc.random2(NpcDrops[ArrayID].Items.length);
     SecondDrop = NpcDrops[ArrayID].Items[rnd];
     SecondDropN = NpcDrops[ArrayID].ItemsN[rnd];
     }
     if (SecondDrop > -1 && SecondDropN > -1) {
     if (Item.itemStackable[SecondDrop] == true || Item.itemIsNote[SecondDrop] == true) {
     Go = true;
     while (Go == true) {
     if (IsDropping == false) {
     MonsterDropItem(SecondDrop, SecondDropN, NPCID);
     Go = false;
     }
     }
     } else {
     for (int i = SecondDropN; i > 0; i--) {
     Go = true;
     while (Go == true) {
     if (IsDropping == false) {
     MonsterDropItem(SecondDrop, 1, NPCID);
     Go = false;
     }
     }
     }
     }
     }
     }
     }*/

    public static boolean IsDropping = false;
	private void npcDied(int npcId, int absX, int absY, int killer){
		//System.out.println("Drop System");

		Random rand = new Random();
		try {
	        BufferedReader in = new BufferedReader(new FileReader("./Data/cfg/npcdrops.cfg"));
	        String input;
	        int on = 0;
	        String[] splitEQL;
	        String[] splitCOM;
	        String[] splitDSH;
	        String[] splitCLN;
	        String[] splitSCL;
	        //4=526,1-1,1:1;
while ((input = in.readLine()) != null) {
	        	splitEQL = null; splitEQL = null; splitDSH = null; splitCLN = null; splitSCL = null;
	        	if (!input.startsWith("/") && input.contains("=") && input.contains(",") && input.contains("-") && input.contains(":")) {
					try {
					splitEQL = input.split("=");
	        		if (Integer.parseInt(splitEQL[0]) == npcId) {
	        			splitSCL = splitEQL[1].split(";");
	        			for (int i=0;i<splitSCL.length;i++) {
	        				splitCOM = splitSCL[i].split(",");
	        				splitDSH = splitCOM[1].split("-");
	        				splitCLN = splitCOM[2].split(":");
	        				int item = Integer.parseInt(splitCOM[0]);
	        				int min = Integer.parseInt(splitDSH[0]);
	        				int max = Integer.parseInt(splitDSH[1]);
	        				int chance = Integer.parseInt(splitCLN[0]);
	        				int outOf = Integer.parseInt(splitCLN[1]);
	        				int amount = rand.nextInt((max - min)+1) + min; 
	        				int ifDrop = rand.nextInt(outOf)+1;
	        				if (ifDrop <= chance) {
	        					ItemHandler.addItem(item, absX, absY, amount, killer, false);
								server.npcHandler.itemdropcheck=item;
								getItemDropRare(item);
								npccanloot = false;
	        					//System.out.println("Dropping");
								
								
for (Player p : server.playerHandler.players)
{
  client person = (client)p;
 if(p != null && person != null) 
{
   if(p != null && person != null)
{ 

if (bigloot == true) {
PlayerHandler.messageToAll = getItemName(item)+" has just been dropped";
bigloot=false;
					}
}
}
}
}
			}
					}
	        		} catch (Exception e) {
						System.out.println("Exception dropping item:\n"+e);
					}
	        		++on;
	        	}
		    }
	        in.close();
		} catch (IOException e) {
	    	System.out.println(e);
		}
}	
	
	public void MonsterDropItem(int NPCID)
	{
	int O = npcs[NPCID].StartKilling;
client C = (client) server.playerHandler.players[O];

		npcDied(npcs[NPCID].npcType, npcs[NPCID].absX, npcs[NPCID].absY, GetNpcKiller(NPCID));
		
		{
			if (IsDropping == false) 
			{
				IsDropping = true;
				int Play = GetNpcKiller(NPCID);
				int Maxi = server.itemHandler.DropItemCount;
				for (int i = 0; i <= Maxi; i++) 
				{
				
					if (server.itemHandler.DroppedItemsID[i] > 0) 
					{
					} 
					else 
					{
						int NPCID2 = NPCID+34;
						//System.out.println("Npc id =" +NPCID);
						if(npcs[NPCID] != null && server.playerHandler.players[Play] != null) 
						{
						
						}


						if (i == Maxi) 
						{
							if (server.itemHandler.DropItemCount >= (server.itemHandler.MaxDropItems + 1)) 
							{
								server.itemHandler.DropItemCount = 0;
								//println("! Notify item resterting !");
							}
						}
						break;
					}
				}
				IsDropping = false;
			}
		}
		}

    public int GetNpcKiller(int NPCID) {
        int Killer = 0;
        int Count = 0;

        for (int i = 1; i < server.playerHandler.maxPlayers; i++) {
            if (Killer == 0) {
                Killer = i;
                Count = 1;
            } else {
                if (npcs[NPCID].Killing[i] > npcs[NPCID].Killing[Killer]) {
                    Killer = i;
                    Count = 1;
                } else if (npcs[NPCID].Killing[i] == npcs[NPCID].Killing[Killer]) {
                    Count++;
                }
            }
        }
        if (Count > 1
                && npcs[NPCID].Killing[npcs[NPCID].StartKilling]
                        == npcs[NPCID].Killing[Killer]) {
            Killer = npcs[NPCID].StartKilling;
        }
        return Killer;
    }

    /*
     WORLDMAP: (walk able places)
     01 - Aubury
     02 - Varrock Mugger
     03 - Lowe
     04 - Horvik
     05 - Varrock General Store
     06 - Thessalia
     07 - Varrock Sword Shop
     08 - Varrock East Exit Guards
     09 - Falador General Store
     10 - Falador Shield Shop
     11 - Falador Mace Shop
     12 - Falador Center Guards
     13 - Falador North Exit Guards
     14 - Barbarian Village Helmet Shop
     15 - Varrock Staff Shop
     16 - Al-Kharid Skirt Shop
     17 - Al-Kharid Crafting Shop
     18 - Al-Kharid General Store
     19 - Al-Kharid Leg Shop
     20 - Al-Kharid Scimitar Shop
     21 - Lumbridge Axe Shop
     22 - Lumbridge General Store
     23 - Port Sarim Battleaxe Shop
     24 - Port Sarim Magic Shop
     25 - Port Sarim Jewelery Shop
     26 - Port Sarim Fishing Shop
     27 - Port Sarim Food Shop
     28 - Rimmington Crafting Shop
     29 - Rommington Archery Shop
     30 - Npc's around and in varrock
     31 - Npc's at Rellekka
     32 - Npc's around and in lumbridge
     33 - 
     34 - 
     35 - 
     36 - 
     37 - 
     38 - 
     39 - 
     40 - 
     */
    public static int worldmap[][] = {
        {

             /* 01 */		3252, 3453, 3252, 3453, 3252, 3253, 3254, 3252, 3253,
            3254, 3255, 3252, 3253, 3252, 3253, /* 02 */3248, 3249, 3250, 3251,
            3252, 3253, 3254, 3248, 3249, 3250, 3251, 3252, 3253, 3254, 3248,
            3249, 3250, 3251, 3252, 3254, 3248, 3249, 3250, 3251, 3252, 3253,
            3254, 3248, 3249, 3250, 3251, 3252, 3253, 3254, 3248, 3249, 3250,
            3251, 3252, 3253, 3254, 3248, 3249, 3250, 3251, 3252, 3254, 3248,
            3249, 3250, 3251, 3252, 3253, 3254, 3248, 3249, 3250, 3251, 3252,
            3253, 3254, 3248, 3249, 3250, 3251, 3252, 3253, 3254, 3248, 3249,
            3250, 3251, 3252, 3253, 3254, 3248, 3249, 3250, 3251, 3252, 3253,
            3254, 3248, 3249, 3250, 3251, 3252, 3253, 3254, /* 03 */3235, 3234,
            3233, 3232, 3231, 3230, 3235, 3230, 3235, 3234, 3233, 3232, 3231,
            3230, 3234, 3232, 3231, 3234, 3233, 3232, 3231, 3234, 3233, 3232,
            3233, 3231, /* 04 */3231, 3230, 3229, 3232, 3231, 3230, 3229, 3229,
            3228, 3227, 3229, 3227, 3232, 3231, 3230, 3229, 3228, 3227, 3232,
            3231, 3230, 3229, 3228, 3227, 3226, 3225, 3232, 3231, 3230, 3229,
            3228, 3227, 3225, 3232, 3231, 3230, 3229, 3228, 3227, 3225, 3232,
            3229, 3228, 3227, 3226, 3232, 3231, 3230, 3229, /* 05 */3217, 3216,
            3215, 3214, 3219, 3218, 3217, 3216, 3219, 3218, 3217, 3219, 3217,
            3216, 3215, 3219, 3218, 3217, 3216, 3215, 3214, 3220, 3219, 3217,
            3216, 3215, 3214, 3219, 3217, 3216, 3215, 3214, 3219, 3217, 3216,
            3215, 3214, 3218, 3217, /* 06 */3207, 3206, 3205, 3208, 3207, 3206,
            3203, 3207, 3206, 3205, 3204, 3203, 3207, 3206, 3205, 3204, 3203,
            3202, 3208, 3207, 3206, 3205, 3208, 3207, 3206, 3207, /* 07 */3206,
            3204, 3203, 3202, 3209, 3208, 3207, 3205, 3203, 3208, 3207, 3206,
            3205, 3203, 3208, 3207, 3206, 3205, 3204, 3203, 3202, 3208, 3207,
            3206, 3205, 3203, 3207, 3206, 3203, 3206, 3203, 3206, 3205, 3205,
            3205, /* 08 */3268, 3268, 3268, 3268, 3268, 3269, 3269, 3269, 3269,
            3269, 3270, 3270, 3270, 3270, 3270, 3271, 3271, 3271, 3271, 3271,
            3272, 3272, 3272, 3272, 3272, 3273, 3273, 3273, 3273, 3273, 3274,
            3274, 3274, 3274, 3274, 3275, 3275, 3275, 3276, 3276, 3276, 3276,
            3273, 3274, 3275, 3276, 3273, 3274, 3275, 3273, /* 09 */2958, 2957,
            2959, 2958, 2957, 2959, 2958, 2957, 2959, 2958, 2957, 2956, 2955,
            2954, 2953, 2960, 2959, 2956, 2955, 2953, 2960, 2959, 2957, 2956,
            2953, /* 10 */2979, 2977, 2976, 2975, 2974, 2973, 2972, 2979, 2978,
            2977, 2972, 2972, 2974, 2973, 2972, /* 11 */2952, 2950, 2949, 2948,
            2952, 2951, 2950, 2949, 2948, 2952, 2951, 2950, 2949, 2948, 2952,
            2951, 2950, 2949, 2948, 2952, 2952, 2951, /* 12 */2969, 2967, 2966,
            2965, 2964, 2963, 2962, 2961, 2960, 2959, 2958, 2969, 2968, 2967,
            2966, 2965, 2964, 2963, 2962, 2961, 2960, 2959, 2958, 2969, 2968,
            2967, 2966, 2965, 2964, 2963, 2962, 2961, 2960, 2959, 2958, 2969,
            2968, 2967, 2966, 2965, 2964, 2963, 2962, 2961, 2960, 2959, 2958,
            2969, 2968, 2967, 2966, 2965, 2964, 2963, 2962, 2961, 2960, 2959,
            2958, 2969, 2968, 2967, 2966, 2964, 2963, 2962, 2961, 2960, 2959,
            2958, 2969, 2968, 2967, 2966, 2965, 2964, 2963, 2962, 2961, 2960,
            2959, 2958, 2969, 2968, 2967, 2966, 2965, 2964, 2963, 2962, 2961,
            2960, 2959, 2958, 2969, 2968, 2967, 2966, 2965, 2964, 2963, 2962,
            2961, 2960, 2959, 2958, /* 13 */2968, 2967, 2966, 2965, 2964, 2963,
            2967, 2966, 2965, 2964, 2966, 2965, 2967, 2966, 2965, 2964, 2968,
            2967, 2966, 2965, 2964, 2963, 2968, 2967, 2966, 2965, 2964, 2963,
            2967, 2966, 2965, 2964, 2968, 2967, 2966, 2965, 2964, 2963,

            /* 14 */			3076, 3074, 3076, 3075, 3074, 3077, 3076, 3075, 3074,
            3073, 3077, 3074, 3077, 3076, 3075, 3074, /* 15 */3204, 3204, 3203,
            3202, 3201, 3204, 3203, 3202, 3201, 3203, 3201, 3203, 3202, 3201,
            3204, 3203, 3201, 3204, /* 16 */3315, 3316, 3313, 3314, 3315, 3317,
            3318, 3314, 3317, 3314, 3315, 3316, 3317, 3313, 3314, 3315, 3316,
            3317, 3318, 3314, 3315, 3316, 3317, /* 17 */3319, 3320, 3323, 3318,
            3319, 3320, 3322, 3323, 3318, 3319, 3320, 3321, 3322, 3323, 3319,
            3320, 3321, 3322, 3319, 3320, 3322, 3323, 3318, 3319, 3320, 3323,
            3319, 3320, /* 18 */3315, 3316, 3312, 3313, 3314, 3315, 3316, 3312,
            3313, 3314, 3315, 3316, 3317, 3312, 3313, 3314, 3315, 3316, 3317,
            3318, 3312, 3313, 3314, 3316, 3317, 3312, 3313, 3314, 3316, 3317,
            3312, 3313, 3314, 3316, 3317, 3314, 3317, 3315, /* 19 */3314, 3315,
            3316, 3318, 3315, 3316, 3317, 3318, 3314, 3315, 3316, 3317, 3318,
            3314, 3315, 3316, 3314, 3315, /* 20 */3287, 3288, 3289, 3285, 3286,
            3287, 3288, 3289, 3290, 3287, 3288, 3289, 3290, 3287, 3288, 3289,
            3290, 3286, 3287, 3288, 3287, /* 21 */3229, 3232, 3228, 3229, 3230,
            3231, 3232, 3233, 3228, 3230, 3231, 3232, 3233, 3228, 3230, 3231,
            3232, 3232, /* 22 */3210, 3211, 3209, 3210, 3211, 3212, 3214, 3209,
            3211, 3212, 3213, 3214, 3209, 3211, 3212, 3213, 3209, 3210, 3211,
            3212, 3213, 3214, 3209, 3211, 3212, 3213, 3209, 3210, 3211, 3212,
            3213, 3209, 3211, 3213, /* 23 */3026, 3028, 3024, 3025, 3026, 3027,
            3028, 3029, 3025, 3026, 3027, 3028, 3029, 3030, 3024, 3025, 3028,
            3029, 3030, 3024, 3025, 3028, 3029, 3024, 3025, 3026, 3027, 3028,
            3029, 3028, 3029, 3030, 3025, 3026, 3027, 3028, 3029, /* 24 */3012,
            3013, 3014, 3015, 3016, 3012, 3015, 3016, 3012, 3015, 3016, 3011,
            3012, 3013, 3014, 3015, 3012, /* 25 */3012, 3014, 3012, 3013, 3014,
            3015, 3012, 3013, 3014, 3015, 3012, 3013, 3015, 3012, 3013, 3014,

            /* 26 */			3013, 3014, 3013, 3014, 3013, 3014, 3015, 3016, 3012,
            3013, 3014, 3015, 3016, 3017, 3012, 3013, 3014, 3015, 3011, 3012,
            3013, 3014, 3015, 3016, 3011, 3012, 3013, 3014, 3015, 3016, 3011,
            3016, 3011, 3013, 3014, 3015, 3016, 3013, 3014, 3016, /* 27 */3012,
            3014, 3012, 3013, 3014, 3015, 3016, 3012, 3015, 3012, 3013, 3014,
            3015, 3016, 3013, 3014, 3015, 3013, 3014, 3013, 3013, /* 28 */2946,
            2947, 2952, 2946, 2947, 2950, 2951, 2952, 2946, 2948, 2949, 2950,
            2951, 2946, 2948, 2949, 2950, 2951, 2946, 2947, 2948, 2949, 2950,
            2951, 2948, 2949, 2948, 2949, /* 29 */2955, 2958, 2959, 2954, 2955,
            2956, 2957, 2958, 2959, 2953, 2954, 2956, 2957, 2958, 2957, 2958,
            2959, /* 30 */3236, 3236, 3237, 3238, 3239, 3237, 3238, 3239, 3240,
            3236, 3237, 3238, 3239, 3240, 3236, 3237, 3238, 3239, 3237, 3238, /**/
            3245,
            3246, 3243, 3244, 3245, 3246, 3243, 3244, 3245, 3246, 3247, 3246,
            3247,  /**/3261, 3260, 3261, 3262, 3260, 3261, 3263, 3260, 3263,
            3260, 3263, 3260, 3263, 3260, 3261, 3262, 3263, 3260, 3261, 3263,  /**/
            3234,
            3235, 3238, 3233, 3234, 3235, 3236, 3237, 3238, 3235, 3233, 3234,
            3235, 3236, 3233, 3234, 3235, 3236, 3237, 3238,  /**/3290, 3291,
            3292, 3293, 3294, 3297, 3298, 3299, 3290, 3291, 3292, 3293, 3294,
            3295, 3296, 3297, 3298, 3299, 3290, 3291, 3292, 3293, 3294, 3295,
            3296, 3297, 3298, 3299, 3290, 3293, 3294, 3295, 3296, 3297, 3298,
            3299, 3290, 3293, 3294, 3295, 3296, 3297, 3298, 3299, 3290, 3291,
            3292, 3293, 3294, 3295, 3296, 3297, 3298, 3299, 3290, 3291, 3292,
            3293, 3294, 3295, 3296, 3297, 3298, 3299,  /* 31 */2662, 2663, 2661,
            2662, 2663, 2661, 2662, 2663, 2661, 2662, 2663, 2662, 2663, 2664,
            2665, 2666, 2665, 2666,/**/ 2664, 2665, 2666, 2664, 2665, 2666,
            2664, 2665, 2666, 2664, 2665, 2666, 2664, 2665, 2666,  /**/2679,
            2680, 2679, 2680, 2676, 2677, 2678, 2679, 2680, 2676, 2677, 2678,
            2679, 2680, 2676, 2677, 2678, 2679, 2680, 2674, 2675, 2676, 2677,
            2678, 2679, 2680, 2675, 2676, 2677, 2678, 2679, 2680,  /**/2667,
            2668, 2669, 2670, 2671, 2667, 2668, 2669, 2670, 2671, 2667, 2668,
            2669, 2670, 2671, 2667, 2668, 2669, 2670, 2671, 2667, 2668, 2669,
            2670, 2671, 2667, 2668, 2669, 2670, 2671, 2667, 2668, 2669, 2670,
            2671, 2667, 2668, 2669, 2670, 2671,  /**/2681, 2682, 2683, 2684,
            2685, 2681, 2682, 2683, 2684, 2685, 2681, 2682, 2683, 2684, 2685,
            2681, 2682, 2683, 2684, 2685, 2681, 2682, 2683, 2684, 2685,  /**/
            2675, 2676, 2677, 2678, 2679, 2675, 2676, 2677, 2678, 2679, 2675,
            2676, 2677, 2678, 2679, 2676, 2677, 2678, 2679, 2677, 2678, 2679,  /**/
            2672,
            2673, 2674, 2675, 2672, 2673, 2674, 2675, 2672, 2673, 2674, 2675,
            2672, 2673, 2674, 2675, 2672, 2673, 2674, 2675, 2672, 2673, 2674,
            2675, 2672, 2673, 2674, 2675,  /**/2674, 2675, 2676, 2677, 2678,
            2674, 2675, 2676, 2677, 2678, 2674, 2675, 2676, 2677, 2678, 2674,
            2675, 2676, 2677, 2678, 2674, 2675, 2677, 2678,  /**/2685, 2686,
            2687, 2688, 2689, 2685, 2686, 2687, 2688, 2689, 2685, 2686, 2687,
            2688, 2689, 2685, 2686, 2687, 2688, 2689, 2685, 2686, 2687, 2688,
            2689,  /**/2668, 2669, 2670, 2671, 2672, 2668, 2669, 2670, 2671,
            2672, 2668, 2669, 2670, 2671, 2672, 2668, 2669, 2670, 2671, 2672,
            2668, 2669, 2670, 2671, 2672,  /**/2679, 2680, 2681, 2682, 2683,
            2679, 2680, 2681, 2682, 2683, 2679, 2680, 2681, 2682, 2683, 2679,
            2680, 2681, 2682, 2683, 2679, 2680, 2681, 2682, 2683,  /**/2673,
            2674, 2675, 2673, 2674, 2675, 2676, 2677, 2673, 2674, 2675, 2676,
            2677, 2673, 2674, 2675, 2676, 2677, 2673, 2674, 2675, 2676, 2677,  /**/
            2669,
            2670, 2671, 2672, 2669, 2670, 2671, 2672, 2673, 2669, 2670, 2671,
            2672, 2673, 2669, 2670, 2671, 2672, 2673, 2669, 2670, 2671, 2672,
            2673,  /**/2680, 2681, 2682, 2679, 2680, 2681, 2682, 2678, 2679,
            2680, 2681, 2682, 2678, 2679, 2680, 2681, 2682, 2678, 2679, 2680,
            2681, 2682,  /* 32 */3228, 3229, 3226, 3227, 3228, 3225, 3226, 3228,
            3229, 3226, 3227, 3228, 3229, 3230, 3225, 3226, 3227, 3228, 3229,
            3230, 3225, 3229, 3225, 3226, 3227, 3228, 3229, 3226,/**/ 3232,
            3233, 3234, 3235, 3236, 3237, 3232, 3233, 3234, 3235, 3236, 3231,
            3232, 3233, 3234, 3235, 3236, 3227, 3228, 3229, 3231, 3232, 3233,
            3234, 3235, 3236, 3225, 3226, 3227, 3228, 3229, 3230, 3231, 3233,
            3234, 3235, 3236, 3225, 3226, 3227, 3228, 3229, 3230, 3231, 3232,
            3233, 3234, 3235, 3236, 3225, 3228, 3229, 3230, 3231, 3232, 3235,
            3236, 3237, 3225, 3227, 3228, 3229, 3230, 3231, 3232, 3233, 3235,
            3236, 3237, 3225, 3227, 3228, 3229, 3230, 3231, 3232, 3233, 3235,
            3236, 3231, 3235,
        },
        {

             /* 01 */		3404, 3404, 3403, 3403, 4302, 4302, 4302, 3401, 3401,
            3401, 3401, 3400, 3400, 3399, 3399, /* 02 */3398, 3398, 3398, 3398,
            3398, 3398, 3398, 3397, 3397, 3397, 3397, 3397, 3397, 3397, 3396,
            3396, 3396, 3396, 3396, 3396, 3395, 3395, 3395, 3395, 3395, 3395,
            3395, 3394, 3394, 3394, 3394, 3394, 3394, 3394, 3393, 3393, 3393,
            3393, 3393, 3393, 3393, 3392, 3392, 3392, 3392, 3392, 3392, 3391,
            3391, 3391, 3391, 3391, 3391, 3391, 3390, 3390, 3390, 3390, 3390,
            3390, 3390, 3389, 3389, 3389, 3389, 3389, 3389, 3389, 3388, 3388,
            3388, 3388, 3388, 3388, 3388, 3387, 3387, 3387, 3387, 3387, 3387,
            3387, 3386, 3386, 3386, 3386, 3386, 3386, 3386, /* 03 */3421, 3421,
            3421, 3421, 3421, 3421, 3422, 3422, 3423, 3423, 3423, 3423, 3423,
            3423, 3424, 3424, 3424, 3425, 3425, 3425, 3425, 3426, 3426, 3426,
            3427, 3427, /* 04 */3433, 3433, 3433, 3434, 3434, 3434, 3434, 3435,
            3435, 3435, 3436, 3436, 3437, 3437, 3437, 3437, 3437, 3437, 3438,
            3438, 3438, 3438, 3438, 3438, 3438, 3438, 3439, 3439, 3439, 3439,
            3439, 3439, 3439, 3440, 3440, 3440, 3440, 3440, 3440, 3440, 3441,
            3441, 3441, 3441, 3441, 3442, 3442, 3442, 3442, /* 05 */3411, 3411,
            3411, 3411, 3412, 3412, 3412, 3412, 3413, 3413, 3413, 3414, 3414,
            3414, 3414, 3415, 3415, 3415, 3415, 3415, 3415, 3416, 3416, 3416,
            3416, 3416, 3416, 3417, 3417, 3417, 3417, 3417, 3418, 3418, 3418,
            3418, 3418, 3419, 3419, /* 06 */3414, 3414, 3414, 3415, 3415, 3415,
            3415, 3416, 3416, 3416, 3416, 3416, 3417, 3417, 3417, 3417, 3417,
            3417, 3418, 3418, 3418, 3418, 3419, 3419, 3419, 3420, /* 07 */3495,
            3495, 3495, 3495, 3396, 3396, 3396, 3396, 3396, 3397, 3397, 3397,
            3397, 3397, 3398, 3398, 3398, 3398, 3398, 3398, 3398, 3399, 3399,
            3399, 3399, 3399, 3400, 3400, 3400, 3401, 3401, 3402, 3402, 3403,
            3404, /* 08 */3426, 3427, 3428, 3429, 3430, 3426, 3427, 3428, 3429,
            3430, 3426, 3427, 3428, 3429, 3430, 3426, 3427, 3428, 3429, 3430,
            3426, 3427, 3428, 3429, 3430, 3426, 3427, 3428, 3429, 3430, 3426,
            3427, 3428, 3429, 3430, 3227, 3228, 3229, 3426, 3427, 3430, 3420,
            3421, 3421, 3421, 3421, 3422, 3422, 3422, 3423, /* 09 */3385, 3385,
            3386, 3386, 3386, 3387, 3387, 3387, 3388, 3388, 3388, 3388, 3388,
            3388, 3388, 3389, 3389, 3389, 3389, 3389, 3390, 3390, 3390, 3390,
            3390, /* 10 */3383, 3383, 3383, 3383, 3383, 3383, 3383, 3384, 3384,
            3384, 3384, 3385, 3386, 3386, 3386, /* 11 */3385, 3385, 3385, 3385,
            3386, 3386, 3386, 3386, 3386, 3387, 3387, 3387, 3387, 3387, 3388,
            3388, 3388, 3388, 3388, 3389, 3390, 3390, /* 12 */3376, 3376, 3376,
            3376, 3376, 3376, 3376, 3376, 3376, 3376, 3376, 3377, 3377, 3377,
            3377, 3377, 3377, 3377, 3377, 3377, 3377, 3377, 3377, 3378, 3378,
            3378, 3378, 3378, 3378, 3378, 3378, 3378, 3378, 3378, 3378, 3379,
            3379, 3379, 3379, 3379, 3379, 3379, 3379, 3379, 3379, 3379, 3379,
            3380, 3380, 3380, 3380, 3380, 3380, 3380, 3380, 3380, 3380, 3380,
            3380, 3381, 3381, 3381, 3381, 3381, 3381, 3381, 3381, 3381, 3381,
            3381, 3382, 3382, 3382, 3382, 3382, 3382, 3382, 3382, 3382, 3382,
            3382, 3382, 3383, 3383, 3383, 3383, 3383, 3383, 3383, 3383, 3383,
            3383, 3383, 3383, 3384, 3384, 3384, 3384, 3384, 3384, 3384, 3384,
            3384, 3384, 3384, 3384, /* 13 */3391, 3391, 3391, 3391, 3391, 3391,
            3392, 3392, 3392, 3392, 3393, 3393, 3394, 3394, 3394, 3394, 3395,
            3395, 3395, 3395, 3395, 3395, 3396, 3396, 3396, 3396, 3396, 3396,
            3397, 3397, 3397, 3397, 3398, 3398, 3398, 3398, 3398, 3398,

            /* 14 */			3427, 3427, 3428, 3428, 3428, 3429, 3429, 3429, 3429,
            3429, 3430, 3430, 3431, 3431, 3431, 3431, /* 15 */3431, 3432, 3432,
            3432, 3432, 3433, 3433, 3433, 3433, 3434, 3434, 3435, 3435, 3435,
            3436, 3436, 3436, 3437, /* 16 */3160, 3160, 3161, 3161, 3161, 3161,
            3161, 3162, 3162, 3163, 3163, 3163, 3163, 3164, 3164, 3164, 3164,
            3164, 3164, 3165, 3165, 3165, 3165, /* 17 */3191, 3191, 3191, 3192,
            3192, 3192, 3192, 3192, 3193, 3193, 3193, 3193, 3193, 3193, 3194,
            3194, 3194, 3194, 3195, 3195, 3195, 3195, 3196, 3196, 3196, 3196,
            3197, 3197, /* 18 */3178, 3178, 3179, 3179, 3179, 3179, 3179, 3180,
            3180, 3180, 3180, 3180, 3180, 3181, 3181, 3181, 3181, 3181, 3181,
            3181, 3182, 3182, 3182, 3182, 3182, 3183, 3183, 3183, 3183, 3183,
            3184, 3184, 3184, 3184, 3184, 3185, 3185, 3186, /* 19 */3173, 3173,
            3173, 3173, 3174, 3174, 3174, 3174, 3175, 3175, 3175, 3175, 3175,
            3176, 3176, 3176, 3177, 3177, /* 20 */3187, 3187, 3187, 3188, 3188,
            3188, 3188, 3188, 3188, 3189, 3189, 3189, 3189, 3190, 3190, 3190,
            3190, 3191, 3191, 3191, 3192, /* 21 */3201, 3201, 3202, 3202, 3202,
            3202, 3202, 3202, 3203, 3203, 3203, 3203, 3203, 3204, 3204, 3204,
            3204, 3205, /* 22 */3243, 3243, 3244, 3244, 3244, 3244, 3244, 3245,
            3245, 3245, 3245, 3245, 3246, 3246, 3246, 3246, 3247, 3247, 3247,
            3247, 3247, 3247, 3248, 3248, 3248, 3248, 3249, 3249, 3249, 3249,
            3249, 3250, 3250, 3250, /* 23 */3245, 3245, 3246, 3246, 3246, 3246,
            3246, 3246, 3247, 3247, 3247, 3247, 3247, 3247, 3248, 3248, 3248,
            3248, 3248, 3249, 3249, 3249, 3249, 3250, 3250, 3250, 3250, 3250,
            3250, 3251, 3251, 3251, 3252, 3252, 3252, 3252, 3252, /* 24 */3257,
            3257, 3257, 3257, 3257, 3258, 3258, 3258, 3259, 3259, 3259, 3260,
            3260, 3260, 3260, 3260, 3261, /* 25 */3244, 3244, 3245, 3245, 3245,
            3245, 3246, 3246, 3246, 3246, 3247, 3247, 3247, 3248, 3248, 3248,

            /* 26 */			3220, 3220, 3221, 3221, 3222, 3222, 3222, 3222, 3223,
            3223, 3223, 3223, 3223, 3223, 3224, 3224, 3224, 3224, 3225, 3225,
            3225, 3225, 3225, 3225, 3226, 3226, 3226, 3226, 3226, 3226, 3227,
            3227, 3228, 3228, 3228, 3228, 3228, 3229, 3229, 3229, /* 27 */3203,
            3203, 3204, 3204, 3204, 3204, 3204, 3205, 3205, 3206, 3206, 3206,
            3206, 3206, 3207, 3207, 3207, 3208, 3208, 3209, 3210, /* 28 */3202,
            3202, 3202, 3203, 3203, 3203, 3203, 3203, 3204, 3204, 3204, 3204,
            3204, 3205, 3205, 3205, 3205, 3205, 3206, 3206, 3206, 3206, 3206,
            3206, 3207, 3207, 3208, 3208, /* 29 */3202, 3202, 3202, 3203, 3203,
            3203, 3203, 3203, 3203, 3204, 3204, 3204, 3204, 3204, 3205, 3205,
            3205, /* 30 */3403, 3404, 3404, 3404, 3404, 3405, 3405, 3405, 3405,
            3406, 3406, 3406, 3406, 3406, 3407, 3407, 3407, 3407, 3408, 3408, /**/
            3393,
            3393, 3394, 3394, 3394, 3394, 3395, 3395, 3395, 3395, 3395, 3396,
            3396,  /**/3396, 3397, 3397, 3397, 3398, 3398, 3398, 3399, 3399,
            3400, 3400, 3401, 3401, 3402, 3402, 3402, 3402, 3403, 3403, 3403,  /**/
            3382,
            3382, 3382, 3383, 3383, 3383, 3383, 3383, 3383, 3384, 3385, 3385,
            3385, 3385, 3386, 3386, 3386, 3386, 3386, 3386,  /**/3377, 3377,
            3377, 3377, 3377, 3377, 3377, 3377, 3378, 3378, 3378, 3378, 3378,
            3378, 3378, 3378, 3378, 3378, 3379, 3379, 3379, 3379, 3379, 3379,
            3379, 3379, 3379, 3379, 3380, 3380, 3380, 3380, 3380, 3380, 3380,
            3380, 3381, 3381, 3381, 3381, 3381, 3381, 3381, 3381, 3382, 3382,
            3382, 3382, 3382, 3382, 3382, 3382, 3382, 3382, 3383, 3383, 3383,
            3383, 3383, 3383, 3383, 3383, 3383, 3383,  /* 31 */3713, 3713, 3714,
            3714, 3714, 3715, 3715, 3715, 3716, 3716, 3716, 3717, 3717, 3718,
            3718, 3718, 3719, 3719,/**/ 3713, 3713, 3713, 3714, 3714, 3714,
            3715, 3715, 3715, 3716, 3716, 3716, 3717, 3717, 3717,  /**/3714,
            3714, 3715, 3715, 3716, 3716, 3716, 3716, 3716, 3717, 3717, 3717,
            3717, 3717, 3718, 3718, 3718, 3718, 3718, 3719, 3719, 3719, 3719,
            3719, 3719, 3719, 3720, 3720, 3720, 3720, 3720, 3720,  /**/3712,
            3712, 3712, 3712, 3712, 3713, 3713, 3713, 3713, 3713, 3714, 3714,
            3714, 3714, 3714, 3715, 3715, 3715, 3715, 3715, 3716, 3716, 3716,
            3716, 3716, 3717, 3717, 3717, 3717, 3717, 3718, 3718, 3718, 3718,
            3718, 3719, 3719, 3719, 3719, 3719,  /**/3714, 3714, 3714, 3714,
            3714, 3715, 3715, 3715, 3715, 3715, 3716, 3716, 3716, 3716, 3716,
            3717, 3717, 3717, 3717, 3717, 3718, 3718, 3718, 3718, 3718,  /**/
            3718, 3718, 3718, 3718, 3718, 3719, 3719, 3719, 3719, 3719, 3720,
            3720, 3720, 3720, 3720, 3721, 3721, 3721, 3721, 3722, 3722, 3722,  /**/
            3712,
            3712, 3712, 3712, 3713, 3713, 3713, 3713, 3714, 3714, 3714, 3714,
            3715, 3715, 3715, 3715, 3716, 3716, 3716, 3716, 3717, 3717, 3717,
            3717, 3718, 3718, 3718, 3718,  /**/3711, 3711, 3711, 3711, 3711,
            3712, 3712, 3712, 3712, 3712, 3713, 3713, 3713, 3713, 3713, 3714,
            3714, 3714, 3714, 3714, 3715, 3715, 3715, 3715, 3715,  /**/3722,
            3722, 3722, 3722, 3722, 3723, 3723, 3723, 3723, 3723, 3724, 3724,
            3724, 3724, 3724, 3725, 3725, 3725, 3725, 3725, 3726, 3726, 3726,
            3726, 3726,  /**/3725, 3725, 3725, 3725, 3725, 3726, 3726, 3726,
            3726, 3726, 3727, 3727, 3727, 3727, 3727, 3728, 3728, 3728, 3728,
            3728, 3729, 3729, 3729, 3729, 3729,  /**/3730, 3730, 3730, 3730,
            3730, 3731, 3731, 3731, 3731, 3731, 3732, 3732, 3732, 3732, 3732,
            3733, 3733, 3733, 3733, 3733, 3734, 3734, 3734, 3734, 3734,  /**/
            3727, 3727, 3727, 3728, 3728, 3728, 3728, 3728, 3729, 3729, 3729,
            3729, 3729, 3730, 3730, 3730, 3730, 3730, 3731, 3731, 3731, 3731,
            3731,  /**/3723, 3723, 3723, 3723, 3724, 3724, 3724, 3724, 3724,
            3725, 3725, 3725, 3725, 3725, 3726, 3726, 3726, 3726, 3726, 3727,
            3727, 3727, 3727, 3727,  /**/3726, 3726, 3726, 3727, 3727, 3727,
            3727, 3728, 3728, 3728, 3728, 3728, 3729, 3729, 3729, 3729, 3729,
            3730, 3730, 3730, 3730, 3730,  /* 32 */3287, 3287, 3288, 3288, 3288,
            3289, 3289, 3289, 3289, 3290, 3290, 3290, 3290, 3290, 3291, 3291,
            3291, 3291, 3291, 3291, 3292, 3292, 3293, 3293, 3293, 3293, 3293,
            3294,/**/ 3292, 3292, 3292, 3292, 3292, 3292, 3293, 3293, 3293,
            3293, 3293, 3294, 3294, 3294, 3294, 3294, 3294, 3295, 3295, 3295,
            3295, 3295, 3295, 3295, 3295, 3295, 3296, 3296, 3296, 3296, 3296,
            3296, 3296, 3296, 3296, 3296, 3296, 3297, 3297, 3297, 3297, 3297,
            3297, 3297, 3297, 3297, 3297, 3297, 3297, 3298, 3298, 3298, 3298,
            3298, 3298, 3298, 3298, 3298, 3299, 3299, 3299, 3299, 3299, 3299,
            3299, 3299, 3299, 3299, 3299, 3300, 3300, 3300, 3300, 3300, 3300,
            3300, 3300, 3300, 3300, 3301, 3301,
        },
    };

     /*
     WORLDMAP 2: (not-walk able places)
     01 - Lumbridge cows
     */
    public static int worldmap2[][] = {
        {

            /* 01 */		3257, 3258, 3260, 3261, 3261, 3262, 3261, 3262, 3257, 3258,
            3257, 3258, 3254, 3255, 3254, 3255, 3252, 3252, 3250, 3251, 3250,
            3251, 3249, 3250, 3249, 3250, 3242, 3242, 3243, 3243, 3257, 3244,
            3245, 3244, 3245, 3247, 3248, 3250, 3251, 3255, 3256, 3255, 3256,
            3259, 3260,
        },
        {

            /* 01 */		3256, 3256, 3256, 3256, 3266, 3266, 3267, 3267, 3270, 3270,
            3271, 3271, 3272, 3272, 3273, 3273, 3275, 3276, 3277, 3277, 3278,
            3278, 3279, 3279, 3280, 3280, 3285, 3286, 3289, 3290, 3289, 3297,
            3297, 3298, 3298, 3298, 3298, 3297, 3297, 3297, 3297, 3298, 3298,
            3297, 3297,
        },
    };

    public int remove = 2; // 1 = removes equipment, 2 = doesn't remove - xerozcheez
    public static int removeschaos[] = { 1, 2, 2, 2};

    public static int randomremoveschaos() {
        return removeschaos[(int) (Math.random() * removeschaos.length)];
    }

    public void gfxAll(int id, int Y, int X) {
        for (Player p : server.playerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if ((person.playerName != null || person.playerName != "null")) {
                    if (person.distanceToPoint(X, Y) <= 60) {
                        person.stillgfx2(id, Y, X, 0 ,0);
                    }
                }
            }
        }
    }

    public int GetNPCBlockAnim(int id) {
        switch (id) {



        case 21:
            return 403;

        case 17:
            return 430;

        case 941:
	case 53:
	case 54:
	case 55:
	case 50:
            return 89;

        case 2745:
            return 2653;

        case 113:
            return 11415;

        case 8149:
            return 5574;

        case 1116:
            return 6966;

        case 1122:
            return 7010;

        case 8133:
            return 10058;


        case 1472:
            return 65;

        case 18:
            return 403;

        case 92:
            return 0;

        default:
            return 1834;

        }
    }

    public boolean AttackPlayerRanged(int NPCID) {
        int Player = npcs[NPCID].StartKilling;

        if (server.playerHandler.players[Player] == null) {
            ResetAttackPlayer(NPCID);
            return false;
        } else if (server.playerHandler.players[Player].DirectionCount < 2) {
            return false;
        }
        client plr = (client) server.playerHandler.players[Player];
        int EnemyX = server.playerHandler.players[Player].absX;
        int EnemyY = server.playerHandler.players[Player].absY;

        npcs[NPCID].enemyX = EnemyX;
        npcs[NPCID].enemyY = EnemyY;
        // if(EnemyX != npcs[NPCID].absX && EnemyY != npcs[NPCID].absY) {
        // npcs[NPCID].viewX = EnemyX;
        // npcs[NPCID].viewY = EnemyY;
        // npcs[NPCID].faceToUpdateRequired = true;
        // }
        int EnemyHP = server.playerHandler.players[Player].playerLevel[server.playerHandler.players[Player].playerHitpoints];
        int EnemyMaxHP = getLevelForXP(
                server.playerHandler.players[Player].playerXP[server.playerHandler.players[Player].playerHitpoints]);
        boolean RingOfLife = false;

        if (server.playerHandler.players[Player].playerEquipment[server.playerHandler.players[Player].playerRing]
                == 2570) {
            RingOfLife = true;
        }
        // if(EnemyX != npcs[NPCID].absX && EnemyY != npcs[NPCID].absY) // Xerozcheez: stops client crashing
        // plr.viewTo(npcs[NPCID].absX, npcs[NPCID].absY); // Xerozcheez: Player turns to npc

        if (server.playerHandler.players[Player].attacknpc == NPCID) {
            server.playerHandler.players[Player].faceNPC = NPCID; // Xerozcheez: sets npc index for player to view
            server.playerHandler.players[Player].faceNPCupdate = true; // Xerozcheez: updates face npc index so player faces npcs
            server.playerHandler.players[Player].attacknpc = NPCID; // Xerozcheez: makes it so if player runs away the player attacks back when npc follows
            server.playerHandler.players[Player].IsAttackingNPC = true; // Xerozcheez: makes it so if player runs away the player attacks back when npc follows
        }
        int hitDiff = 0;

        hitDiff = misc.random(npcs[NPCID].MaxHit);
        if (npcs[NPCID].npcType != 3200 && npcs[NPCID].npcType != 1645) {
            FollowPlayerCB(NPCID, Player);
        }
        if (GoodDistance(npcs[NPCID].absX, npcs[NPCID].absY, EnemyX, EnemyY, 1)
                == true
                        || npcs[NPCID].npcType == 3200) {
            if (npcs[NPCID].actionTimer == 0) {
                if (RingOfLife == true
                        && EnemyHP
                                <= (int) ((double) ((double) EnemyMaxHP / 10.0)
                                        + 0.5)) {
                    server.playerHandler.players[Player].SafeMyLife = true;
                } else {
                    if (server.playerHandler.players[Player].IsDead == true) {
                        ResetAttackPlayer(NPCID);
                    } else {
						
                        if (npcs[NPCID].npcType == 3200) { // chaos elemental
                            npcs[NPCID].animNumber = 0x326;
                            remove = randomremoveschaos();
                            if (remove == 1) {
                                server.playerHandler.players[Player].removeequipped();
                            } 
                        } else if (npcs[NPCID].npcType == 752) {
                            npcs[NPCID].animNumber = 0x326;
                                               
                        } else if (npcs[NPCID].npcType == 50 && misc.random(3)==1) {
                            npcs[NPCID].animNumber = 91; // KBD attack
                                                } else if(npcs[NPCID].npcType == 50 && misc.random(3)==2){
if(plr.playerEquipment[plr.playerShield] == 1540 || plr.playerEquipment[plr.playerShield] == 2621 || plr.playerEquipment[plr.playerShield] == 15185) {
plr.lowGFX(579, 0);
hitDiff = 3 + misc.random(7);
plr.sM("You are protected from the dragon's fire!");
} else if(plr.playerEquipment[plr.playerShield] != 1540 && plr.playerEquipment[plr.playerShield] != 2621 && plr.playerEquipment[plr.playerShield] != 15185) {
plr.lowGFX(579, 0);
hitDiff = 20 + misc.random(30);
plr.sM("You are burnt by the fire!");}
 
                        } else if (npcs[NPCID].npcType == 35) {
                            npcs[NPCID].animNumber = 390; // Guard Attack
                        } else if (npcs[NPCID].npcType == 113) {
                            npcs[NPCID].animNumber = 2100; // jogre Attack                                                    
                        } else if (npcs[NPCID].npcType == 53) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 54) {
                            npcs[NPCID].animNumber = 80; // Dragon
} else if(npcs[NPCID].npcType == 55 && misc.random(1)==0){
npcs[NPCID].animNumber = 80;
} else if(npcs[NPCID].npcType == 55 && misc.random(0)==0){
npcs[NPCID].animNumber = 91;                                             
                        } else if (npcs[NPCID].npcType == 941) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1590) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1591) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1592) {
                            npcs[NPCID].animNumber = 80; // Dragon
//Tormented demon
//Melee Attack
} else if(npcs[NPCID].npcType == 3825 && misc.random(1)==0){
npcs[NPCID].animNumber = 10922;
//hitDiff = 4 + misc.random(25);
//Magic Attack
} else if(npcs[NPCID].npcType == 3825 && misc.random(0)==0){
npcs[NPCID].animNumber = 10919;
//hitDiff = 12 + misc.random(35);
plr.stillgfx(1886, npcs[NPCID].absY, npcs[NPCID].absX);
//plr.attackPlayersWithin2(160, 30, 30);

//Tormented demon
                        } else if (npcs[NPCID].npcType == 3647) {
                            npcs[NPCID].animNumber = 0x03B; // cow attack                                                                 
                        } else if (npcs[NPCID].npcType == 3340) {
                            npcs[NPCID].animNumber = 3312; //
			} else if (npcs[NPCID].npcType == 451) {
                            npcs[NPCID].animNumber = 2363; // paladin attack
                        } else if (npcs[NPCID].npcType == 41) {
                            npcs[NPCID].animNumber = 0x037; // chicken attack
                        } else if (npcs[NPCID].npcType == 87) {
                            npcs[NPCID].animNumber = 0x08A; // rat attack
                        } else if (npcs[NPCID].npcType == 3200) { // chaos elemental
                            npcs[NPCID].animNumber = 0x326;
                            remove = randomremoveschaos();
                            if (remove == 1) {
                                server.playerHandler.players[Player].removeequipped();
                            } 
                        } else if (npcs[NPCID].npcType == 752) {
                            npcs[NPCID].animNumber = 0x326;
                        } else {
                            npcs[NPCID].animNumber = 0x326; // human attack
                        }
                        plr.startAnimation(
                                plr.GetBlockAnim(
                                        plr.playerEquipment[plr.playerWeapon]));
                        npcs[NPCID].animUpdateRequired = true;
                        npcs[NPCID].updateRequired = true;
                        if ((EnemyHP - hitDiff) < 0) {
                            hitDiff = EnemyHP;
                        }
                        server.playerHandler.players[Player].hitDiff = hitDiff;
                        server.playerHandler.players[Player].updateRequired = true;
                        server.playerHandler.players[Player].hitUpdateRequired = true;
                        server.playerHandler.players[Player].appearanceUpdateRequired = true;
                        npcs[NPCID].actionTimer = 7;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean AttackPlayer(int NPCID) {
        int Player = npcs[NPCID].StartKilling;

        if (server.playerHandler.players[Player] == null) {
            ResetAttackPlayer(NPCID);
            return false;
        } else if (server.playerHandler.players[Player].DirectionCount < 2) {
            return false;
        }if (npcs[NPCID].npcType == 3777 && npcs[NPCID].HP < 120 && npcs[NPCID].HP < 90) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3777 && npcs[NPCID].HP < 120 && npcs[NPCID].HP < 60) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3777 && npcs[NPCID].HP < 120 && npcs[NPCID].HP < 90 && npcs[NPCID].HP < 50) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3777 && npcs[NPCID].HP < 49) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3778) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3777) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3933;
			return false;
		}
		if (npcs[NPCID].npcType == 3779 || npcs[NPCID].npcType == 3780) {
			ResetAttackPlayer(NPCID);
npcs[NPCID].animNumber = 3928;
			return false;
		}
        client plr = (client) server.playerHandler.players[Player];
        int EnemyX = server.playerHandler.players[Player].absX;
        int EnemyY = server.playerHandler.players[Player].absY;
        npcs[NPCID].enemyX = EnemyX;
        int i;
        int j;
        int k;
        int l;
        int i1;
            PlayerHandler _tmp1 = server.playerHandler;
            i = PlayerHandler.players[npcs[NPCID].StartKilling].absX;
            PlayerHandler _tmp2 = server.playerHandler;
            j = PlayerHandler.players[npcs[NPCID].StartKilling].absY;
            PlayerHandler _tmp3 = server.playerHandler;
            l = (npcs[NPCID].absX - i) * -1;
            i1 = (npcs[NPCID].absY - j) * -1;
		npcs[NPCID].TurnNpcTo(i, j);
		if ((Math.abs(npcs[NPCID].absX - EnemyX) > 20)
				|| (Math.abs(npcs[NPCID].absY - EnemyY) > 20)) {
			ResetAttackPlayer(NPCID);
		}
        // if(EnemyX != npcs[NPCID].absX && EnemyY != npcs[NPCID].absY) {
        // npcs[NPCID].viewX = EnemyX;
        // npcs[NPCID].viewY = EnemyY;
        // npcs[NPCID].faceToUpdateRequired = true;
        // }
        int EnemyHP = server.playerHandler.players[Player].playerLevel[server.playerHandler.players[Player].playerHitpoints];
        int EnemyMaxHP = getLevelForXP(
                server.playerHandler.players[Player].playerXP[server.playerHandler.players[Player].playerHitpoints]);
        boolean RingOfLife = false;

        if (server.playerHandler.players[Player].playerEquipment[server.playerHandler.players[Player].playerRing]
                == 2570) {
            RingOfLife = true;
        }
        // if(EnemyX != npcs[NPCID].absX && EnemyY != npcs[NPCID].absY) // Xerozcheez: stops client crashing
        // plr.viewTo(npcs[NPCID].absX, npcs[NPCID].absY); // Xerozcheez: Player turns to npc

        if (server.playerHandler.players[Player].attacknpc == NPCID) {
            server.playerHandler.players[Player].faceNPC = NPCID; // Xerozcheez: sets npc index for player to view
            server.playerHandler.players[Player].faceNPCupdate = true; // Xerozcheez: updates face npc index so player faces npcs
            server.playerHandler.players[Player].attacknpc = NPCID; // Xerozcheez: makes it so if player runs away the player attacks back when npc follows
            server.playerHandler.players[Player].IsAttackingNPC = true; // Xerozcheez: makes it so if player runs away the player attacks back when npc follows
        }
        int hitDiff = 0;

        hitDiff = misc.random(npcs[NPCID].MaxHit);
        if (npcs[NPCID].npcType != 3200 && npcs[NPCID].npcType != 1645) {
            FollowPlayerCB(NPCID, Player);
        }
        if (GoodDistance(npcs[NPCID].absX, npcs[NPCID].absY, EnemyX, EnemyY, 1)
                == true
                        || npcs[NPCID].npcType == 3200) {
            if (npcs[NPCID].actionTimer == 0) {
                if (RingOfLife == true
                        && EnemyHP
                                <= (int) ((double) ((double) EnemyMaxHP / 10.0)
                                        + 0.5)) {
                    server.playerHandler.players[Player].SafeMyLife = true;
                } else {
                    if (server.playerHandler.players[Player].IsDead == true) {
                        ResetAttackPlayer(NPCID);
                    } else {
                        if (npcs[NPCID].npcType == 81
                                || npcs[NPCID].npcType == 397
                                || npcs[NPCID].npcType == 1766
                                || npcs[NPCID].npcType == 1767
                                || npcs[NPCID].npcType == 1768) {
                            npcs[NPCID].animNumber = 0x03B; // cow attack
                        } else if (npcs[NPCID].npcType == 41) {
                            npcs[NPCID].animNumber = 0x037; // chicken attack
                        } else if (npcs[NPCID].npcType == 87) {
                            npcs[NPCID].animNumber = 0x08A; // rat attack 
                        } else if (npcs[NPCID].npcType == 21) {
                            npcs[NPCID].animNumber = 451; // Hero attack 
                            hitDiff = 4 + misc.random(9);                                                                           
                        } else if (npcs[NPCID].npcType == 1958) {
                            npcs[NPCID].animNumber = 422; // Hero attack 
                            hitDiff = 4 + misc.random(18);
                        } else if (npcs[NPCID].npcType == 2256) {
                            npcs[NPCID].animNumber = 451; // Paladin attack 
                            hitDiff = 4 + misc.random(8);                                                 
                        } else if (npcs[NPCID].npcType == 50) {
                            npcs[NPCID].animNumber = 91; // KBD attack  
                     } else if (npcs[NPCID].npcType == 3261) {
                            npcs[NPCID].animNumber = 428; // KBD attack                                              
                        } else if (npcs[NPCID].npcType == 18) {
                            npcs[NPCID].animNumber = 451; // Al-K'harid Warrior Attack
                            hitDiff = 4 + misc.random(2);                                                                                           
                        } else if (npcs[NPCID].npcType == 53) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1116) {
                            npcs[NPCID].animNumber = 6964; // sara attack
                        } else if (npcs[NPCID].npcType == 1117) {
                            npcs[NPCID].animNumber = 6945; // k'rill attack
                        } else if (npcs[NPCID].npcType == 1115) {
                            npcs[NPCID].animNumber = 7060; // bandos attack
                        } else if (npcs[NPCID].npcType == 8149) {
                            npcs[NPCID].animNumber = 5571; // armoured zombie attack
                        } else if (npcs[NPCID].npcType == 1122) {
                            npcs[NPCID].animNumber = 7009; // bree attack
                        } else if (npcs[NPCID].npcType == 54) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1160) {
                            npcs[NPCID].animNumber = 1184; // KQ attack 
                            hitDiff = 4 + misc.random(35);
                        } else if (npcs[NPCID].npcType == 55) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 941) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 8133) {
                            npcs[NPCID].animNumber = 10057; // Corporeal Beast
                     } else if (npcs[NPCID].npcType == 1472) {
                            npcs[NPCID].animNumber = 64; // Corporeal Beast
                        } else if (npcs[NPCID].npcType == 1590) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1591) {
                            npcs[NPCID].animNumber = 80; // Dragon
                        } else if (npcs[NPCID].npcType == 1160) {
                            npcs[NPCID].animNumber = 1184; // KQ attack 
                            hitDiff = 4 + misc.random(35);
                        } else if (npcs[NPCID].npcType == 2026) {
                            npcs[NPCID].animNumber = 2067; // Dharok
                            hitDiff = 4 + misc.random(15);
                        } else if (npcs[NPCID].npcType == 2027) {
                            npcs[NPCID].animNumber = 2080; // Guthan
                            hitDiff = 4 + misc.random(15);
                        } else if (npcs[NPCID].npcType == 2029) {
                            npcs[NPCID].animNumber = 2068; // Torag
                            hitDiff = 4 + misc.random(15);
                        } else if (npcs[NPCID].npcType == 2030) {
                            npcs[NPCID].animNumber = 2062; // Verac
                            hitDiff = 4 + misc.random(15);					
                        } else if (npcs[NPCID].npcType == 83) {
                            npcs[NPCID].animNumber = 64; // Greater Demon
                        } else if (npcs[NPCID].npcType == 82) {
                            npcs[NPCID].animNumber = 64; // Lesser Demon
                            hitDiff = 4 + misc.random(13);
                        } else if (npcs[NPCID].npcType == 2745
                                && misc.random(2) == 1) {
                            npcs[NPCID].animNumber = 2655; // poke
                            npcs[NPCID].actionTimer = 7;
                            hitDiff = 4 + misc.random(25);                                                                                         
                        } else if (npcs[NPCID].npcType == 2745
                                && misc.random(3) == 2) {
                            npcs[NPCID].animNumber = 2652; // slash
                            gfxAll(451, EnemyY, EnemyX);
                            npcs[NPCID].actionTimer = 1;
                            hitDiff = 4 + misc.random(30);                                                                   
                        } else if (npcs[NPCID].npcType == 2745
                                && misc.random(5) == 3) {
                            npcs[NPCID].animNumber = 2656; // crush
                            gfxAll(451, EnemyY, EnemyX);
                            npcs[NPCID].actionTimer = 1;
                            hitDiff = 4 + misc.random(35);                                                     
                        } else if (npcs[NPCID].npcType == 64) {
                            npcs[NPCID].animNumber = 0x326; // Ogre
                        } else if (npcs[NPCID].npcType == 3647) {} else if (npcs[NPCID].npcType
                                == 3200) { // chaos elemental
                            npcs[NPCID].animNumber = 0x326;
                            remove = randomremoveschaos();
                            if (remove == 1) {
                                server.playerHandler.players[Player].removeequipped();
                            } 
                        } else if (npcs[NPCID].npcType == 2745) {
                            npcs[NPCID].animNumber = 2656;
                            npcs[NPCID].actionTimer = 7; 
                            hitDiff = 4 + misc.random(25);
                        } else if (npcs[NPCID].npcType == 752) {
                            npcs[NPCID].animNumber = 0x326;
                        } else {
                            npcs[NPCID].animNumber = 0x326; // human attack
                        }
                        plr.startAnimation(
                                plr.GetBlockAnim(
                                        plr.playerEquipment[plr.playerWeapon]));
                        npcs[NPCID].animUpdateRequired = true;
                        npcs[NPCID].updateRequired = true;
                        if ((EnemyHP - hitDiff) < 0) {
                            hitDiff = EnemyHP;
                        }
                        server.playerHandler.players[Player].hitDiff = hitDiff;
                        server.playerHandler.players[Player].updateRequired = true;
                        server.playerHandler.players[Player].hitUpdateRequired = true;
                        server.playerHandler.players[Player].appearanceUpdateRequired = true;
                        npcs[NPCID].actionTimer = 7;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean AttackPlayerMage(int NPCID) {
        int Player = npcs[NPCID].StartKilling;
        client p = (client) server.playerHandler.players[Player];

        if (server.playerHandler.players[Player] == null) {
            ResetAttackPlayer(NPCID);
            return false;
        } else if (server.playerHandler.players[Player].DirectionCount < 2) {
            return false;
        }
        int EnemyX = server.playerHandler.players[Player].absX;
        int EnemyY = server.playerHandler.players[Player].absY;
        int EnemyHP = server.playerHandler.players[Player].playerLevel[server.playerHandler.players[Player].playerHitpoints];
        int EnemyMaxHP = getLevelForXP(
                server.playerHandler.players[Player].playerXP[server.playerHandler.players[Player].playerHitpoints]);
        boolean RingOfLife = false;

        if (server.playerHandler.players[Player].playerEquipment[server.playerHandler.players[Player].playerRing]
                == 2570) {
            RingOfLife = true;
        }
        int hitDiff = 0;

        // hitDiff = misc.random(npcs[NPCID].MaxHit);
        if (npcs[NPCID].actionTimer == 0) {
            if (RingOfLife == true
                    && EnemyHP
                            <= (int) ((double) ((double) EnemyMaxHP / 10.0)
                                    + 0.5)) {
                server.playerHandler.players[Player].SafeMyLife = true;
            } else {
                if (server.playerHandler.players[Player].IsDead == true) {
                    ResetAttackPlayer(NPCID);
                } else {
                    npcs[NPCID].animNumber = 711; // mage attack
                    if (npcs[NPCID].npcType == 1645) {
                        p.stillgfx(369, p.absY, p.absX);
                        hitDiff = 6 + misc.random(43);
                    } 
                    if (npcs[NPCID].npcType == 509) {
                        hitDiff = 8 + misc.random(20); 
                    }                                                                                                                     
                    if (npcs[NPCID].npcType == 1241) {
                        p.stillgfx(363, p.absY, p.absX);
                        hitDiff = 2 + misc.random(19); 
                    }
                    if (npcs[NPCID].npcType == 124) {
                        npcs[NPCID].animNumber = 1833;
                        hitDiff = 4 + misc.random(35);
                    }                                              
                    if (npcs[NPCID].npcType == 1246) {
                        p.stillgfx(368, npcs[NPCID].absY, npcs[NPCID].absX);
                        p.stillgfx(367, p.absY, p.absX);
                        hitDiff = 4 + misc.random(35); 
                    }
                    if (npcs[NPCID].npcType == 1159) {
                        p.stillgfx(552, p.absY, p.absX);
                        hitDiff = 2 + misc.random(88); 
                    }
                    if (npcs[NPCID].npcType == 54) {
                        p.stillgfx(1, p.absY, p.absX);
                        hitDiff = 2 + misc.random(96); 
                    }
                    server.playerHandler.players[Player].setPlrAnimation(
                            server.playerHandler.players[Player].GetPlrBlockAnim(
                                    server.playerHandler.players[Player].playerEquipment[server.playerHandler.players[Player].playerWeapon]));
                    npcs[NPCID].animUpdateRequired = true;
                    npcs[NPCID].updateRequired = true;
                    if ((EnemyHP - hitDiff) < 0) {
                        hitDiff = EnemyHP;
                    }
                    server.playerHandler.players[Player].hitDiff = hitDiff;
                    server.playerHandler.players[Player].updateRequired = true;
                    server.playerHandler.players[Player].hitUpdateRequired = true;
                    server.playerHandler.players[Player].appearanceUpdateRequired = true;
                    npcs[NPCID].actionTimer = 7;
                }
            }
            return true;
        }
        return false;
    }

    public boolean AttackNPCMage(int NPCID) {
        int EnemyX = server.npcHandler.npcs[npcs[NPCID].attacknpc].absX;
        int EnemyY = server.npcHandler.npcs[npcs[NPCID].attacknpc].absY;
        int EnemyHP = server.npcHandler.npcs[npcs[NPCID].attacknpc].HP;
        int hitDiff = 0;
        int Npchitdiff = 0;
        int wepdelay = 0;

        // hitDiff = misc.random(npcs[NPCID].MaxHit);
        if (npcs[NPCID].actionTimer == 0) {
            if (server.npcHandler.npcs[npcs[NPCID].attacknpc].IsDead == true) {
                ResetAttackNPC(NPCID);
                // npcs[NPCID].textUpdate = "Oh yeah I win bitch!";
                // npcs[NPCID].textUpdateRequired = true;
                npcs[NPCID].animNumber = 2103;
                npcs[NPCID].animUpdateRequired = true;
                npcs[NPCID].updateRequired = true;
            } else {
                npcs[NPCID].animNumber = 711; // mage attack
                if (npcs[NPCID].npcType == 1645) {
                    gfxAll(369, EnemyY, EnemyX);
                    hitDiff = 6 + misc.random(43);
                }                                              
                if (npcs[NPCID].npcType == 1645) {
                    gfxAll(369, EnemyY, EnemyX);
                    hitDiff = 6 + misc.random(43);
                }                                               
                if (npcs[NPCID].npcType == 509) {
                    hitDiff = 8 + misc.random(20); 
                }
                if (npcs[NPCID].npcType == 1241) {
                    gfxAll(363, EnemyY, EnemyX);
                    hitDiff = 2 + misc.random(19); 
                }
                if (npcs[NPCID].npcType == 1246) {
                    gfxAll(368, npcs[NPCID].absY, npcs[NPCID].absX);
                    gfxAll(367, EnemyY, EnemyX);
                    hitDiff = 4 + misc.random(35); 
                }
                if (npcs[NPCID].npcType == 1159) {
                    gfxAll(552, EnemyY, EnemyX);
                    hitDiff = 2 + misc.random(88); 
                }
                if (npcs[NPCID].npcType == 54) {
                    gfxAll(197, EnemyY, EnemyX);
                    hitDiff = 2 + misc.random(96); 
                }
                npcs[NPCID].animUpdateRequired = true;
                npcs[NPCID].updateRequired = true;
                if ((EnemyHP - hitDiff) < 0) {
                    hitDiff = EnemyHP;
                }
                server.npcHandler.npcs[npcs[NPCID].attacknpc].hitDiff = hitDiff;
                server.npcHandler.npcs[npcs[NPCID].attacknpc].attacknpc = NPCID;
                server.npcHandler.npcs[npcs[NPCID].attacknpc].updateRequired = true;
                server.npcHandler.npcs[npcs[NPCID].attacknpc].hitUpdateRequired = true;
                npcs[NPCID].actionTimer = 7;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean AttackNPC(int NPCID) {
        if (server.npcHandler.npcs[npcs[NPCID].attacknpc] != null) {
            int EnemyX = server.npcHandler.npcs[npcs[NPCID].attacknpc].absX;
            int EnemyY = server.npcHandler.npcs[npcs[NPCID].attacknpc].absY;
            int EnemyHP = server.npcHandler.npcs[npcs[NPCID].attacknpc].HP;
            int hitDiff = 0;
            int Npchitdiff = 0;
            int wepdelay = 0;

            hitDiff = misc.random(npcs[NPCID].MaxHit);
            if (GoodDistance(EnemyX, EnemyY, npcs[NPCID].absX, npcs[NPCID].absY,
                    1)
                    == true) {
                if (server.npcHandler.npcs[npcs[NPCID].attacknpc].IsDead == true) {
                    ResetAttackNPC(NPCID);
                    npcs[NPCID].textUpdate = "Oh yeah I win bitch!";
                    npcs[NPCID].textUpdateRequired = true;
                    npcs[NPCID].animNumber = 2103;
                    npcs[NPCID].animUpdateRequired = true;
                    npcs[NPCID].updateRequired = true;
                } else {
                    if ((EnemyHP - hitDiff) < 0) {
                        hitDiff = EnemyHP;
                    }
                    if (npcs[NPCID].npcType == 9) {
                        npcs[NPCID].animNumber = 386;
                    }
                    if (npcs[NPCID].npcType == 3200) {
                        npcs[NPCID].animNumber = 0x326;
                    } // drags: chaos ele emote ( YESSS ) 
                    if (npcs[NPCID].npcType == 1605) {
                        npcs[NPCID].animNumber = 386; // drags: abberant spector death ( YAY )
                    } 
                    npcs[NPCID].animUpdateRequired = true;
                    npcs[NPCID].updateRequired = true;
                    server.npcHandler.npcs[npcs[NPCID].attacknpc].hitDiff = hitDiff;
                    server.npcHandler.npcs[npcs[NPCID].attacknpc].attacknpc = NPCID;
                    server.npcHandler.npcs[npcs[NPCID].attacknpc].updateRequired = true;
                    server.npcHandler.npcs[npcs[NPCID].attacknpc].hitUpdateRequired = true;
                    npcs[NPCID].actionTimer = 7;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ResetAttackNPC(int NPCID) {
        npcs[NPCID].IsUnderAttackNpc = false;
        npcs[NPCID].IsAttackingNPC = false;
        npcs[NPCID].attacknpc = -1;
        npcs[NPCID].RandomWalk = true;
        npcs[NPCID].animNumber = 0x328;
        npcs[NPCID].animUpdateRequired = true;
        npcs[NPCID].updateRequired = true;
        return true;
    }

    public int getLevelForXP(int exp) {
        int points = 0;
        int output = 0;

        for (int lvl = 1; lvl <= 135; lvl++) {
            points += Math.floor(
                    (double) lvl + 300.0 * Math.pow(2.0, (double) lvl / 7.0));
            output = (int) Math.floor(points / 4);
            if (output >= exp) {
                return lvl;
            }
        }
        return 0;
    }

    public boolean GoodDistance(int objectX, int objectY, int playerX, int playerY, int distance) {
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j <= distance; j++) {
                if ((objectX + i) == playerX
                        && ((objectY + j) == playerY || (objectY - j) == playerY
                        || objectY == playerY)) {
                    return true;
                } else if ((objectX - i) == playerX
                        && ((objectY + j) == playerY || (objectY - j) == playerY
                        || objectY == playerY)) {
                    return true;
                } else if (objectX == playerX
                        && ((objectY + j) == playerY || (objectY - j) == playerY
                        || objectY == playerY)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ResetAttackPlayer(int NPCID) {
        npcs[NPCID].IsUnderAttack = false;
        npcs[NPCID].StartKilling = 0;
        npcs[NPCID].RandomWalk = true;
        npcs[NPCID].animNumber = 0x328;
        npcs[NPCID].animUpdateRequired = true;
        npcs[NPCID].updateRequired = true;
        return true;
    }

    public boolean loadAutoSpawn(String FileName) {
        String line = "";
        String token = "";
        String token2 = "";
        String token2_2 = "";
        String[] token3 = new String[10];
        boolean EndOfFile = false;
        int ReadMode = 0;
        BufferedReader characterfile = null;

        try {
            characterfile = new BufferedReader(new FileReader("./" + FileName));
        } catch (FileNotFoundException fileex) {
            misc.println(FileName + ": file not found.");
            return false;
        }
        try {
            line = characterfile.readLine();
        } catch (IOException ioexception) {
            misc.println(FileName + ": error loading file.");
            return false;
        }
        while (EndOfFile == false && line != null) {
            line = line.trim();
            int spot = line.indexOf("=");

            if (spot > -1) {
                token = line.substring(0, spot);
                token = token.trim();
                token2 = line.substring(spot + 1);
                token2 = token2.trim();
                token2_2 = token2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token3 = token2_2.split("\t");
                if (token.equals("spawn")) {
                    newNPC(Integer.parseInt(token3[0]),
                            Integer.parseInt(token3[1]),
                            Integer.parseInt(token3[2]),
                            Integer.parseInt(token3[3]),
                            Integer.parseInt(token3[4]),
                            Integer.parseInt(token3[5]),
                            Integer.parseInt(token3[6]),
                            Integer.parseInt(token3[7]),
                            Integer.parseInt(token3[8]),
                            GetNpcListHP(Integer.parseInt(token3[0])), true);
                }
            } else {
                if (line.equals("[ENDOFSPAWNLIST]")) {
                    try {
                        characterfile.close();
                    } catch (IOException ioexception) {}
                    return true;
                }
            }
            try {
                line = characterfile.readLine();
            } catch (IOException ioexception1) {
                EndOfFile = true;
            }
        }
        try {
            characterfile.close();
        } catch (IOException ioexception) {}
        return false;
    }

    public int GetNpcListHP(int NpcID) {
        for (int i = 0; i < maxListedNPCs; i++) {
            if (NpcList[i] != null) {
                if (NpcList[i].npcId == NpcID) {
                    return NpcList[i].npcHealth;
                }
            }
        }
        return 0;
    }

    public boolean loadNPCList(String FileName) {
        String line = "";
        String token = "";
        String token2 = "";
        String token2_2 = "";
        String[] token3 = new String[10];
        boolean EndOfFile = false;
        int ReadMode = 0;
        BufferedReader characterfile = null;

        try {
            characterfile = new BufferedReader(new FileReader("./" + FileName));
        } catch (FileNotFoundException fileex) {
            misc.println(FileName + ": file not found.");
            return false;
        }
        try {
            line = characterfile.readLine();
        } catch (IOException ioexception) {
            misc.println(FileName + ": error loading file.");
            return false;
        }
        while (EndOfFile == false && line != null) {
            line = line.trim();
            int spot = line.indexOf("=");

            if (spot > -1) {
                token = line.substring(0, spot);
                token = token.trim();
                token2 = line.substring(spot + 1);
                token2 = token2.trim();
                token2_2 = token2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token3 = token2_2.split("\t");
                if (token.equals("npc")) {
                    newNPCList(Integer.parseInt(token3[0]), token3[1],
                            Integer.parseInt(token3[2]),
                            Integer.parseInt(token3[3]));
                }
            } else {
                if (line.equals("[ENDOFNPCLIST]")) {
                    try {
                        characterfile.close();
                    } catch (IOException ioexception) {}
                    return true;
                }
            }
            try {
                line = characterfile.readLine();
            } catch (IOException ioexception1) {
                EndOfFile = true;
            }
        }
        try {
            characterfile.close();
        } catch (IOException ioexception) {}
        return false;
    }

    public boolean loadNPCDrops(String FileName) {
        String line = "";
        String token = "";
        String token2 = "";
        String token2_2 = "";
        String[] token3 = new String[10];
        boolean EndOfFile = false;
        int ReadMode = 0;
        BufferedReader characterfile = null;

        try {
            characterfile = new BufferedReader(new FileReader("./" + FileName));
        } catch (FileNotFoundException fileex) {
            misc.println(FileName + ": file not found.");
            return false;
        }
        try {
            line = characterfile.readLine();
        } catch (IOException ioexception) {
            misc.println(FileName + ": error loading file.");
            return false;
        }
        while (EndOfFile == false && line != null) {
            line = line.trim();
            int spot = line.indexOf("=");

            if (spot > -1) {
                token = line.substring(0, spot);
                token = token.trim();
                token2 = line.substring(spot + 1);
                token2 = token2.trim();
                token2_2 = token2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token3 = token2_2.split("\t");
                if (token.equals("npcdrop")) {
                    int[] Items = new int[10000];
                    int[] ItemsN = new int[10000];

                    for (int i = 0; i < ((token3.length - 2) / 2); i++) {
                        if (token3[(2 + (i * 2))] != null) {
                            Items[i] = Integer.parseInt(token3[(2 + (i * 2))]);
                            ItemsN[i] = Integer.parseInt(token3[(3 + (i * 2))]);
                        } else {
                            break;
                        }
                    }
                    newNPCDrop(Integer.parseInt(token3[0]),
                            Integer.parseInt(token3[1]), Items, ItemsN);
                }
            } else {
                if (line.equals("[ENDOFNPCDROPLIST]")) {
                    try {
                        characterfile.close();
                    } catch (IOException ioexception) {}
                    return true;
                }
            }
            try {
                line = characterfile.readLine();
            } catch (IOException ioexception1) {
                EndOfFile = true;
            }
        }
        try {
            characterfile.close();
        } catch (IOException ioexception) {}
        return false;
    }

    public int GetNPCDropArrayID(int NPCID, int DropType) {
        for (int i = 0; i < maxNPCDrops; i++) {
            if (NpcDrops[i] != null) {
                if (NpcDrops[i].npcId == NPCID
                        && NpcDrops[i].DropType == DropType) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void println(String str) {
        System.out.println(str);
    }
}
