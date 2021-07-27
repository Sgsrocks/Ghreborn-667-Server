public class TeleportData {
        
        /*
         * This grabs the X and Y coordinate and the height
         * you will be teleporting to
         */
        protected int x, y, z;
        
        /*
         * This grabs what teleport you are using
         */
        protected String teleport;
        
        /*
         * This handles which teleport your player is using 
         */
        protected enum TeleportStyles {
                ANCIENT("ANCIENT", 1979, 0x328, 392, 0),
                NORMAL("NORMAL", 714, 715, 308, 45);
                
                /*
                 * what magic teleport spell e.x. ancient, normal, lunar
                 */
                private String type;
                
                /*
                 * The anims and graphics for this teleport
                 */
                private int anim, anim2, gfx, gfxDelay;
                
                /*
                 * Constructer grabs the values of the enum and sets
                 * it to a specific variable
                 */
                private TeleportStyles(String type, int anim, int anim2, int gfx, int gfxDelay) {
                        this.type = type;
                        this.anim = anim;
                        this.anim2 = anim2;
                        this.gfx = gfx;
                        this.gfxDelay = gfxDelay;
                }
                
                /*
                 * @param type
                 */
                public String getType() {
                        return type;
                }
                
                /*
                 * @param anim
                 */
                public int getAnim() {
                        return anim;
                }
                
                /*
                 * @param 2nd anim
                 */
                public int getAnim2() {
                        return anim2;
                }
                
                /*
                 * @param gfx
                 */
                public int getGFX() {
                        return gfx;
                }
                
                /*
                 * @param delay gfx
                 */
                public int getGFXDelay() {
                        return gfxDelay;
                }
        }
        
        /*
         * @param the x coordinate
         */
        protected int getX() {
                return x;
        }
        
        /*
         * @param the y coordinate
         */
        protected int getY() {
                return y;
        }
        
        /*
         * @param the z coordinate
         */
        protected int getZ() {
                return z;
        }
}