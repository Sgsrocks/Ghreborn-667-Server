public class DialogueManager {

	/**
	 * The dialogue type.
	 */
	private DialogueType dialogueType = new DialogueType();

	/**
	 * Should the dialogue continue?
	 */
	private boolean continueDialogue = false;

	/**
	 * The NPC the player is talking to.
	 */
	public int npcTalkingTo = -1;
        /**
         * Handles the dialogue depending on the npc ID.
         * 
         * @param player
         *            The player.
         * @param npcId
         *            The NPC interacted with's ID.
         */
        public void handleDialogue(client player, int npcId) {
                this.npcTalkingTo = npcId;
                switch (npcId) {
                case 1:
                        switch (player.NpcDialogue) {
                        case 0:
                                dialogueType.sendPlayerDialogue(player, DialogueEmote.HAPPY,
                                                "Dialogue works!");
                                continueDialogue = true;
                                break;
                        case 1:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.PLAIN_EVIL,
                                                "It already used to work you twit. Be smarter",
                                                "you idiot.");
                                continueDialogue = true;
                                break;
                        case 2:
                                dialogueType
                                                .sendPlayerDialogue(
                                                                player,
                                                                DialogueEmote.CALM,
                                                                "Yeah, but this is done the more proper way. Also, this",
                                                                "dialogue system has emotes and uses variable",
                                                                "arguements. Beat that.");
                                continueDialogue = true;
                                break;
                        case 3:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.UNINTERESTED, "Yeah, whatever kid.");
                                continueDialogue = true;
                                break;
                        case 4:
                                dialogueType.sendStatement(player,
                                                "The " + player.GetNpcName(npcId)
                                                                + " seems to be uninterested in what",
                                                "you need to say. Go find somebody else",
                                                "rather than this nobody.");
                                continueDialogue = true;
                                break;
                        case 5:
                                dialogueType.sendPlayerDialogue(player,
                                                DialogueEmote.DELIGHTED_EVIL, "Kbai.");
                                continueDialogue = true;
                                break;
                        case 6:
                                dialogueType.sendNpcDialogue(player, npcId, DialogueEmote.CALM,
                                                "Wait!");
                                continueDialogue = true;
                                break;
                        case 7:
                                dialogueType.sendPlayerDialogue(player, DialogueEmote.DEFAULT,
                                                "Hmm?");
                                continueDialogue = true;
                                break;
                        case 8:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.CALM_CONTINUED,
                                                "I want to show you something.");
                                continueDialogue = true;
                                break;
                        case 9:
                                dialogueType.sendPlayerDialogue(player, DialogueEmote.DEFAULT,
                                                "What? What is it?!?!?");
                                continueDialogue = true;
                                break;
                        case 10:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.CALM_CONTINUED, "This.");
                                continueDialogue = true;
                                break;
                        case 11:
                                dialogueType.sendStatement(player,
                                                "The " + player.GetNpcName(npcId).toLowerCase()
                                                                + " shows you his grand item.",
                                                "It's a green partyhat!");
                                continueDialogue = true;
                                break;
                        case 12:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.CALM_CONTINUED, "So, you want it?");
                                continueDialogue = true;
                                break;
                        case 13:
                                dialogueType.sendPlayerDialogue(player, DialogueEmote.HAPPY,
                                                "Of course! Gimme!");
                                continueDialogue = true;
                                break;
                        case 14:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.DELIGHTED_EVIL,
                                                "Laugh out loud! You actually think I will just",
                                                "hand you over my most prized position? No",
                                                "way. Laugh out loud!");
                                continueDialogue = true;
                                break;
                        case 15:
                                dialogueType.sendNpcDialogue(player, npcId,
                                                DialogueEmote.DELIGHTED_EVIL, "Peace out!");
                                continueDialogue = true;
                                break;
                        case 16:
                                dialogueType.sendPlayerDialogue(player,
                                                DialogueEmote.NEAR_TEARS, "Why you little...");
                                continueDialogue = true;
                                break;
                        case 17:
                                dialogueType.sendPlayerDialogue(player, DialogueEmote.ANGRY_1,
                                                "Let me just end this conversation...");
                                player.sendMessage("Your player finally calms down.");
                                continueDialogue = false;
                                break;
                        }
                        break;
                }
        }

	/**
	 * Handles the "Click here to continue" packet.
	 * 
	 * @param player
	 *            The player.
	 * @param npcId
	 *            The NPC ID.
	 */
	public void handleContinueClick(client player) {
		if (continueDialogue == true) {
			System.out.println("Test.");
			player.NpcDialogue++;
			player.NpcDialogueSend = true;
			handleDialogue(player, npcTalkingTo);
		} else if (continueDialogue == false) {
			player.NpcDialogue = 0;
			player.NpcDialogueSend = false;
			npcTalkingTo = -1;
			player.closeInterface();
		}
	}

}