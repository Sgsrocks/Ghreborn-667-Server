public class DialogueType {
 
        /**
         * Sent for player talking.
         *
         * @param player
         *            The player.
         * @param expression
         *            The expression ID.
         * @param strings
         *            The text to say in the dialogue.
         */
        public DialogueType sendPlayerDialogue(client player, int expression,
                        String... dialogueText) {
                if (dialogueText.length == 1) {
                        player.sendFrame200(969, expression);
                        player.sendFrame126(player.playerName.replaceAll("_", " "), 970);
                        player.sendFrame126(dialogueText[0], 971);
                        player.sendFrame126("Click here to continue", 972);
                        player.sendFrame185(969);
                        player.sendFrame164(968);
                } else if (dialogueText.length == 2) {
                        player.sendFrame200(974, expression);
                        player.sendFrame126(player.playerName.replaceAll("_", " "), 975);
                        player.sendFrame126(dialogueText[0], 976);
                        player.sendFrame126(dialogueText[1], 977);
                        player.sendFrame126("Click here to continue", 978);
                        player.sendFrame185(974);
                        player.sendFrame164(973);
                } else if (dialogueText.length == 3) {
                        player.sendFrame200(980, expression);
                        player.sendFrame126(player.playerName.replaceAll("_", " "), 981);
                        player.sendFrame126(dialogueText[0], 982);
                        player.sendFrame126(dialogueText[1], 983);
                        player.sendFrame126(dialogueText[2], 984);
                        player.sendFrame126("Click here to continue", 985);
                        player.sendFrame185(980);
                        player.sendFrame164(979);
                } else if (dialogueText.length == 4) {
                        player.sendFrame200(987, expression);
                        player.sendFrame126(player.playerName.replaceAll("_", " "), 988);
                        player.sendFrame126(dialogueText[0], 989);
                        player.sendFrame126(dialogueText[1], 990);
                        player.sendFrame126(dialogueText[2], 991);
                        player.sendFrame126(dialogueText[3], 992);
                        player.sendFrame126("Click here to continue", 993);
                        player.sendFrame185(987);
                        player.sendFrame164(986);
                }
                return this;
        }
 
        /**
         * Sent for NPC talking.
         *
         * @param player
         *            The player.
         * @param npcId
         *            The NPC's ID.
         * @param expression
         *            The expression ID.
         * @param dialogueText
         *            The text of the dialogue.
         */
        public DialogueType sendNpcDialogue(client player, int npcId,
                        int expression, String... dialogueText) {
                if (dialogueText.length == 1) {
                        player.sendFrame200(4883, expression);
                        player.sendFrame126(player.GetNpcName(npcId), 4884);
                        player.sendFrame126(dialogueText[0], 4885);
                        player.sendFrame75(npcId, 4883);
                        player.sendFrame164(4882);
                } else if (dialogueText.length == 2) {
                        player.sendFrame200(4888, expression);
                        player.sendFrame126(player.GetNpcName(npcId), 4889);
                        player.sendFrame126(dialogueText[0], 4890);
                        player.sendFrame126(dialogueText[1], 4891);
                        player.sendFrame75(npcId, 4901);
                        player.sendFrame164(4887);
                } else if (dialogueText.length == 3) {
                        player.sendFrame200(4894, expression);
                        player.sendFrame126(player.GetNpcName(npcId), 4895);
                        player.sendFrame126(dialogueText[0], 4896);
                        player.sendFrame126(dialogueText[1], 4897);
                        player.sendFrame126(dialogueText[2], 4898);
                        player.sendFrame75(npcId, 4894);
                        player.sendFrame164(4893);
                } else if (dialogueText.length == 4) {
                        player.sendFrame200(4901, expression);
                        player.sendFrame126(player.GetNpcName(npcId), 4902);
                        player.sendFrame126(dialogueText[0], 4903);
                        player.sendFrame126(dialogueText[1], 4904);
                        player.sendFrame126(dialogueText[2], 4905);
                        player.sendFrame126(dialogueText[3], 4906);
                        player.sendFrame126("Click here to continue", 4907);
                        player.sendFrame75(npcId, 4901);
                        player.sendFrame164(4900);
                }
                return this;
        }
 
        /**
         * The option dialogue.
         *
         * @param player
         *            The player.
         * @param choiceText
         *            The choice option texts.
         */
        public DialogueType sendOptionDialogue(client player, String... choiceText) {
                if (choiceText.length == 1)
                        return null;
                if (choiceText.length == 2) {
                        player.sendFrame126("Select an Option", 2460);
                        player.sendFrame126(choiceText[0], 2461);
                        player.sendFrame126(choiceText[1], 2462);
                        player.sendFrame164(2459);
                } else if (choiceText.length == 3) {
                        player.sendFrame126("Select an Option", 2470);
                        player.sendFrame126(choiceText[0], 2471);
                        player.sendFrame126(choiceText[1], 2472);
                        player.sendFrame126(choiceText[2], 2473);
                        player.sendFrame164(2469);
                } else if (choiceText.length == 4) {
                        player.sendFrame126("Select an Option", 8208);
                        player.sendFrame126(choiceText[0], 8209);
                        player.sendFrame126(choiceText[1], 8210);
                        player.sendFrame126(choiceText[2], 8211);
                        player.sendFrame126(choiceText[3], 8212);
                        player.sendFrame164(8207);
                } else if (choiceText.length == 5) {
                        player.sendFrame126("Select an Option", 8220);
                        player.sendFrame126(choiceText[0], 8221);
                        player.sendFrame126(choiceText[1], 8222);
                        player.sendFrame126(choiceText[2], 81986);
                        player.sendFrame126(choiceText[3], 8224);
                        player.sendFrame126(choiceText[4], 8225);
                        player.sendFrame164(8219);
                }
                return this;
        }
 
        /**
         * Sends an item message. I could not find anything other than this 1 line,
         * don't know where a 2, 3, or 4 line is.
         *
         * @param player
         *            The player.
         * @param title
         *            The title of this text. This will be the top blue text.
         * @param message
         *            The message to send.
         * @param itemid
         *            The item ID to show in the message.
         * @param size
         *            The size of the item in the message.
         */
        public DialogueType sendItemMessage(client player, String title,
                        String message, int itemid, int size) {
                player.sendFrame200(4883, 591);
                player.sendFrame126(message, 4884);
                player.sendFrame126(title, 4885);
                player.sendFrame246(4883, size, itemid);
                player.sendFrame164(4882);
                player.NpcDialogueSend = true;
                return this;
        }
 
        /**
         * An infodia text. There is no "Click here to continue" in this. I could
         * not find any other thins for this like only 3 lines and such.
         *
         * @param player
         *            The player.
         * @param text
         *            The first line of text to say.
         * @param text2
         *            The second line of text to say.
         * @param text3
         *            The third line of text to say.
         * @param text4
         *            The fourth line of text to say.
         * @param title
         *            The title of this text. This will be the blue text on the top.
         */
        public DialogueType sendInfodiaMessage(client player, String text, String text2,
                        String text3, String text4, String title) {
                player.sendFrame126(title, 6180);
                player.sendFrame126(text, 6181);
                player.sendFrame126(text2, 6182);
                player.sendFrame126(text3, 6183);
                player.sendFrame126(text4, 6184);
                player.sendFrame164(6179);
                return this;
        }
 
        /**
         * A statement. This is different from infodia as this has
         * "Click here to continue"
         *
         * @param player
         *            The player.
         * @param lines
         *            The lines to be said.
         */
        public DialogueType sendStatement(client player, String... lines) {
                int[] statementIds = { 357, 360, 364, 369 };
                if (lines == null || lines.length > 4)
                        return this;
                int id = statementIds[lines.length - 1];
                for (int i = 0; i <= lines.length; i++) {
                        if (i == lines.length) {
                                player.sendFrame126("Click here to continue", id);
                                break;
                        }
                        player.sendFrame126(lines[i], id++);
                }
                player.sendFrame164(statementIds[lines.length - 1] - 1);
                return this;
        }
 
}