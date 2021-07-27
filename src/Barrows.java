public class Barrows { 
        
/**
 * @Author: RandQm
 * @Date: 2 March 2012
 * @Info: Barrows Minigame with the right rewards and reward-amounts.
 */
        
        /* Waken check */
        public static boolean KARILS_AWAKE = false;
    public static boolean TORAG_AWAKE = false;
    public static boolean AHRIM_AWAKE = false;
    public static boolean DHAROCK_AWAKE = false;
    public static boolean VERAC_AWAKE = false;
    public static boolean GUTHAN_AWAKE = false;
    /* Types */
    public static int Ahrim;
        public static int Verac;
        public static int Dharok;
        public static int Torag;
        public static int Karils;
        public static int Guthan;
        public static int Barrows; 
        
        /* Rewards */
        public static int HIGHBarrowRewards[] = {4710, 4718, 4712, 4720, 4726, 4728, 4734, 4736, 4747, 4749, 4755, 4757, 4714, 4722, 4730, 4738, 4751, 4759};
                public static int HIGHreward() { 
        return HIGHBarrowRewards[(int)(Math.random()*HIGHBarrowRewards.length)];
    }
    public static int MEDIUMBarrowRewards[] = {4714, 4722, 4730, 4738, 4751, 4759, 4753, 4745, 4732, 4724, 4716, 4708, 1149};
    public static int MEDreward() { 
        return MEDIUMBarrowRewards[(int)(Math.random()*MEDIUMBarrowRewards.length)];
    }
    public static int LOWBarrowRewards[] = {4753, 4745, 4732, 4724, 4716, 4708, 1149};
    public static int LOWreward() { 
        return LOWBarrowRewards[(int)(Math.random()*LOWBarrowRewards.length)];
    }
    
    /**
     * @param playerId
     * @Info: Getting rewards when all brothers are defeated and resetting the minigame.
     */
    private static void getRewards(final int playerId) {
        final client c = (client) PlayerHandler.players[playerId];
        c.Barrows = 0;
                c.Verac = 0;
               c.Dharok = 0;
                c.Ahrim = 0;
                c.Torag = 0;
                c.Karils = 0;
                c.Guthan = 0;
                digIntoHill(playerId, 3564, 3288, 0);
                c.sM("You defeated barrows!");
                c.addItem(995, misc.random(4162));
                c.addItem(4740, misc.random(160));
                c.addItem(558, misc.random(1430));
                c.addItem(562, misc.random(687));
                c.addItem(560, misc.random(391));
                c.addItem(565, misc.random(159));
                if (misc.random(5) == 5)
                        c.addItem(c.HIGHreward(), 1);
                else if (misc.random(5) == 4)
                        c.addItem(c.MEDreward(), 1);
                else if (misc.random(5) == 3 || misc.random(5) == 2)
                        c.addItem(c.LOWreward(), 1);      
                else if (misc.random(5) < 2)
                        c.addItem(129, 1);      
    }
        
        /**
         * @param playerId
         * @param Xc = x coordinates
         * @param Yc = y coordinates
         * @Info: Controlling the stairs for barrows minigame.
         */
        private static void controlStairs (final int playerId, int Xc, int Yc) {
                final client c = (client) PlayerHandler.players[playerId];
                c.teleportToX = Xc;
                c.teleportToY = Yc;
                c.heightLevel = 0;
                c.killMyNPCs();
                c.resetfollowers();
        }
        
        /**
         * @param playerId
         * @param brotherName = The name of the barrows brother
         * @param brother = The barrows brother type
         * @param waken = Waking up the brother
         * @param tX = X coordinates
         * @param tY = Y coordinates
         * @param tZ = Height
         * @Info: Checking if you didn't already kill the brother. If not, spawning the brother.
         */
        private static void barrowCheck (final int playerId, String brotherName, int brother, boolean waken, int tX, int tY, int tZ) {
                final client c = (client) PlayerHandler.players[playerId];
                if(brother == 1) {
                        c.talk("You have already killed "+brotherName+" in this round!", 1078);
                }
                if (waken == true) {
                        c.talk("You have already woken up "+brotherName+" in this round!", 1078);
                }
                if(brother == 0 && waken == false) {
                        server.npcHandler.spawnANPC(tX, tY, tZ, c.heightLevel);
                        c.sM("You wake the ancient beast up!");
                        waken = true;
                }
        }
        
        /**
         * @param playerId
         * @param objectId
         * @Info: Putting the right actions for the right objects.
         */
        public static void barrowObjects (final int playerId, int objectId) {
                final client c = (client) PlayerHandler.players[playerId];
                /* Stairs */
                if(objectId == 6702){
                        controlStairs(playerId, 3565, 3289);
                }
                if(objectId == 6703){
                        controlStairs(playerId, 3575, 3297);
                }
                if(objectId == 6704){
                        controlStairs(playerId, 3577, 3282);
                }
                if(objectId == 6705){
                        controlStairs(playerId, 3566, 3275);
                }
                if(objectId == 6706){
                        controlStairs(playerId, 3553, 3282);
                }
                if(objectId == 6707){
                        controlStairs(playerId, 3557, 3297);
                }
                /* Barrows brothers spawning */         
                if(objectId == 6823){ //3568 9710
                        barrowCheck(playerId, "Verac", Verac, VERAC_AWAKE, 2030, 3575, 9705);
                }
                if(objectId == 6771){ // 3569 9694
                        barrowCheck(playerId, "Dharok", Dharok, DHAROCK_AWAKE, 2026, 3556, 9717);
                }
                if(objectId == 6821) {
                        barrowCheck(playerId, "Ahrim", Ahrim, AHRIM_AWAKE, 2025, 3557, 9700);
                }
                if(objectId == 6772){
                        barrowCheck(playerId, "Torag", Torag, TORAG_AWAKE, 2029, 3568, 9687);
                }
                if(objectId == 6822){
                        barrowCheck(playerId, "Karils", Karils, KARILS_AWAKE, 2028, 3552, 9684);
                }
                if(objectId == 6773){
                        barrowCheck(playerId, "Guthan", Guthan, GUTHAN_AWAKE, 2027, 3540, 9705);
                }
                /* Reward chest */
                if(objectId == 10284){
                        if(c.Verac == 1 && c.Dharok == 1 && c.Ahrim == 1 && c.Torag == 1 && c.Karils == 1 && c.Guthan == 1) {
                                getRewards(playerId);
                                c.sM("You search the chest and find some items!");
                        } else
                                c.sM("You need to kill all barrow brothers before searching for a reward.");
                }       
        }
        
        /**
         * @param playerId
         * @param x = x coordinate
         * @param y = y coordinate
         * @param z = height
         */
        private static void digIntoHill (final int playerId, int x, int y, int z) {
                final client c = (client) PlayerHandler.players[playerId];
                //c.setAnimation(831);
                c.teleportToX = x;
                c.teleportToY = y;
                c.heightLevel = z;
        }
        
        /**
         * @param playerId
         * @param spadeId
         */
        public static void digSpade(final int playerId, int spadeId) {
                final client c = (client) PlayerHandler.players[playerId];
                switch (spadeId) {
                case 952:
                        /* Torags Hill */
                        if(c.absX >= 3548 && c.absX <= 3557 && c.absY >= 3279 && c.absY <= 3287){
                                digIntoHill(playerId, 3568, 9683, 3);
                        }
                        /* Veracs Hill */
                        if(c.absX >= 3552 && c.absX <= 3561 && c.absY >= 3292 && c.absY <= 3303){
                                digIntoHill(playerId, 3578, 9706, 3);
                        }
                        /* Dharocks Hill */
                        if(c.absX >= 3570 && c.absX <= 3578 && c.absY >= 3293 && c.absY <= 3302){
                                digIntoHill(playerId, 3556, 9718, 3);
                        }
                        /* Guthans Hill */
                        if(c.absX >= 3573 && c.absX <= 3581 && c.absY >= 3278 && c.absY <= 3288){
                                digIntoHill(playerId, 3534, 9704, 3);
                        }
                        /* Karils Hill */
                        if(c.absX >= 3562 && c.absX <= 3568 && c.absY >= 3271 && c.absY <= 3278){
                                digIntoHill(playerId, 3546, 9684, 3);
                        }
                        /* Ahrims & final Hill */
                        if(c.absX >= 3561 && c.absX <= 3569 && c.absY >= 3284 && c.absY <= 3292){
                                if(c.Verac == 1 && c.Dharok == 1 && c.Torag == 1 && c.Karils == 1 && c.Guthan == 1) {
                                digIntoHill(playerId, 3557, 9703, 3);
                        } else 
                                c.sM("You need to kill all barrow brothers before getting a reward.");
                        }
                }
        }
}