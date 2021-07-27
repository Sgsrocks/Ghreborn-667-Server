public class TeleportHandler extends TeleportData {
        
        client c; // Getter
        
        /*
         * Constructer
         */
        public TeleportHandler(client c2) {
                this.c = c2;
        }
        
        /*
         * This is where it checks if everything is correct
         * and if your able to teleport to a place
         * and if you are it calls the teleport method
         */
        public void triggerTele(int x, int y, int height, String type) {
                if (System.currentTimeMillis() - c.lastAction > 5000) {
                        c.lastAction = System.currentTimeMillis();
                        c.resetWalkingQueue();
                        if(c.wildyLevel > 20 && c.isInWilderness(c.absX, c.absY, 1)){
                                c.sM("You cannot teleport above level 20 wilderness!");
                                return;
                        }
                        this.x = x; // sets the x coordinate
                        this.y = y; // sets the y coordinate
                        this.z = height; // sets the z coordinate
                        this.teleport = type; // sets the type of teleport
                        teleportPlayer(); // calls method
                }
        }
        
        /*
         * This is where the all teleporting is handled
         */
        public void teleportPlayer() {
                /*
                 * Gets the values of the enum
                 */
                for(final TeleportStyles t : TeleportStyles.values()) {
                /*
                 * Checks if the teleport string is equal to the value
                 * of the enum string
                 */
                if(teleport == t.getType()) {
                /*
                 * This is the animation your player performs first
                 */
                c.setAnimation(t.getAnim());
                /*
                 * This is the gfx (the purple circle) and grabs the delay
                 */
                c.lowGFX(t.getGFX(), t.getGFXDelay());
                /*
                 * Gets the task scheduler
                 */
                server.getTaskScheduler().schedule(new Task(3, true) {
                        /*
                         * variable is for checking what stage we are on
                         */
                        int stage;
                        @Override
                        protected void execute() {
                                switch(stage) {
                                /*
                                 * Stage #1
                                 */
                                case 0:
                                        stage++; // this stage is done goes up one
                                        break;
                                /*
                                 * Stage 2
                                 */
                                case 1:
                                        /*
                                         * Grabs the second animation from enum
                                         */
                                        c.setAnimation(t.getAnim2());
                                        /*
                                         * Teleports your player to X coordinate
                                         */
                                        c.teleportToX = getX();
                                        /*
                                         * Teleports your player to Y coordinate
                                         */
                                        c.teleportToY = getY();
                                        /*
                                         * Changes player heightlevel to the Z coordinate
                                         */
                                        c.heightLevel = getZ();
                                        /*
                                         * Stops the thread
                                         */
                                        stop();
                                        break;                  
                                                }
                                        }
                                });
                        }               
                }
        }
}