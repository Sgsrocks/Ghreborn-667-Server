public class ItemOnObject {

public void itemonobject(int ID,int atObjectID,int useItemID) {
client c  = (client) server.playerHandler.players[ID];

if (useItemID == 85 && atObjectID == 2607) {
c.sendMessage("You open the gate !");
c.teleportToX = 2848;
c.teleportToY = 9637;
c.heightLevel = 0;
c.deleteItem(85, c.GetItemSlot(85), 1);
}


}
}