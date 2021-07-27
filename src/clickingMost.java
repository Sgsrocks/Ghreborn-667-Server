public class clickingMost { 
	
public void clicking(int a){
client c = (client) server.playerHandler.players[a];
		switch(c.actionButtonId) {

            case 66106:
                    c.triggerTele(2466, 3188, 0);
                break;

            case 66108:
                     c.triggerTele(3117, 9849, 0);
                break;

            case 66109:
                    c.triggerTele(3254, 3287, 0);
                break;

            case 52066:
                    c.capeEmote();
                break;

        case 58230: 
            if(c.pinCorrect())
            {
                c.resetBankPinAttempts();
                c.showInterface(7424);
               c. pinChanged = true;
                c.sM("Enter your desired pin number now.");
            } else
            {
                c.sM("You must enter your pin before changing it!");
            }
            break;

	case 9191:			
		if (c.interfaceEffect == 3) {
			if (c.taskID == -1) {
				c.giveTask();
			}
			if (c.taskID != -1) {
				c.talk2("You already have a task.", "Your task is to kill "+c.taskAmount+" "+c.GetNpcName(c.taskID)+"s.", 1597);
			}
		}
		break;

        case 58234: 
            if(c.pinCorrect())
            {
                c.RemoveAllWindows();
                c.resetBankPinAttempts();
                c.bankPin = 0;
                c.sM("You no longer have a bank pin.");
            } else
            {
                c.sM("You must enter your pin before deleting it!");
            }
            break;

        case 58025: 
            c.numberEnter(0);
            break;

        case 58026: 
            c.numberEnter(1);
            break;

        case 58027: 
            c.numberEnter(2);
            break;

        case 58028: 
            c.numberEnter(3);
            break;

        case 58029: 
            c.numberEnter(4);
            break;

        case 58030: 
            c.numberEnter(5);
            break;

        case 58031: 
            c.numberEnter(6);
            break;

        case 58032: 
            c.numberEnter(7);
            break;

        case 58033: 
            c.numberEnter(8);
            break;

        case 58034: 
            c.numberEnter(9);
            break;
case 58254:
c.sendFrame126("Items Kept on Death", 18103);
c.sendFrame126("Items you will keep on death (if not skulled):", 18104);
c.sendFrame126("Items you will lose on death(if not skulled):", 18105);
c.sendFrame126("Information:", 18106);
c.sendFrame126("Max items kept on death:", 18107);
c.sendFrame126("~ 3 ~", 18108);
c.sendFrame126("", 18109);
c.sendFrame126("The normal amount of", 18110);
c.sendFrame126("items kept is three.", 18111);
c.sendFrame126("", 18112);
c.sendFrame126("You have no factors", 18113);
c.sendFrame126("affecting the items you", 18114);
c.sendFrame126("keep.", 18117);
c.sendFrame126("", 18118);
c.sendFrame126("", 18119);
c.sendFrame126("", 18120);
c.sendFrame126("", 18121);
c.sendFrame126("", 18122);
c.sendFrame126("", 18123);
c.sendFrame126("", 18124);
c.sendFrame126("", 18125);
c.sendFrame126("", 18126);
c.sendFrame126("", 18127);
c.sendFrame126("", 18128);
c.sendFrame126("", 18129);
c.sendFrame126("", 18130);
c.showInterface(18100);
break;


			case 74192:

if(c.runis){
				if (c.playerEnergy > 0) {
					c.isRunning2 = true;
					c.isRunning = true;
c.runis = false;
				}
}else{

c.isRunning2 = false;
c.isRunning = false;
c.runis = true;
}
				break;
case 74206:
c.setClientConfig(509, 1);
c.setClientConfig(510, 0);
c.setClientConfig(511, 0);
c.setClientConfig(512, 0);
break;
case 74207:
c.setClientConfig(509, 0);
c.setClientConfig(510, 1);
c.setClientConfig(511, 0);
c.setClientConfig(512, 0);
break;
case 74208:
c.setClientConfig(509, 0);
c.setClientConfig(510, 0);
c.setClientConfig(511, 1);
c.setClientConfig(512, 0);
break;
case 74209:
c.setClientConfig(509, 0);
c.setClientConfig(510, 0);
c.setClientConfig(511, 0);
c.setClientConfig(512, 1);

break;

        case 82020: //Deposit Inventory
        for(int z = 0; z < 101; z++) {
        for(int t = 0; t < 28; t++) {
                c.bankItem(z, t, 2147000000);
                }
        }
break;
case 82024: //Deposit worn items
                        for(int r=0; r<c.playerEquipment.length; r++)
                {
                        {
                                int item2 = c.playerEquipment[r];
                                if((item2 > 0) && (item2 < 19999))
                                {
                                        c.remove(item2, r);
                                }
                        }
                }
        for(int z = 0; z < 101; z++) {
        for(int t = 0; t < 28; t++) {
                c.bankItem(z, t, 2147000000);
                }
        }
break;
                        case 82028: //Deposit Summon items
                                c.sM("This function is coming soon");
                                break;

case 82016:
if(c.noted){
c.takeAsNote = true;
c.noted = false;
}else{
c.takeAsNote = false;
}
break;

                        case 82012:
                                c.sM("This function is comming soon");
                                break;
                        case 82008:
                                c.sM("This function is comming soon");
                                break;
                        case 20174:
                                c.showInterface(14924);
                                break;


case 74201:
c.brightness = 1;
c.setClientConfig(166, 1);
c.setClientConfig(505, 1);
c.setClientConfig(506, 0);
c.setClientConfig(507, 0);
c.setClientConfig(508, 0);
break;
case 74203:
c.brightness = 2;
c.setClientConfig(166, 2);
c.setClientConfig(505, 0);
c.setClientConfig(506, 1);
c.setClientConfig(507, 0);
c.setClientConfig(508, 0);
break;
case 74204:
c.brightness = 3;
c.setClientConfig(166, 3);
c.setClientConfig(505, 0);
c.setClientConfig(506, 0);
c.setClientConfig(507, 1);
c.setClientConfig(508, 0);
break;
case 74205:
c.brightness = 4;
c.setClientConfig(166, 4);
c.setClientConfig(505, 0);
c.setClientConfig(506, 0);
c.setClientConfig(507, 0);
c.setClientConfig(508, 1);

break;
			

case 161:
c.setAnimation(855);
c.updateRequired = true;
c.appearanceUpdateRequired = true;
break;

case 33206:
c.sendFrame126("@dre@Attack", 8716);
		for(int i = 8720;i<8799;i++) {
			c.sendFrame126("",i);
		}
		c.sendFrame126("1",8720);
		c.sendFrame126("Bronze",8760);
		c.sendFrame126("1",8721);
		c.sendFrame126("Iron", 8761);
		c.sendFrame126("5",8722);
		c.sendFrame126("Steel",8762);
		c.sendFrame126("10",8723);
		c.sendFrame126("Black", 8763);
		c.sendFrame126("20",8724);
		c.sendFrame126("Mithril", 8764);
		c.sendFrame126("30",8725);
		c.sendFrame126("Adamant",8765);
		c.sendFrame126("40",8726);
		c.sendFrame126("Rune", 8766);
		c.sendFrame126("60",8727);
		c.sendFrame126("Members: Dragon", 8767);
		c.sendFrame126("70", 8728);
		c.sendFrame126("Members: Barrows", 8768);
		c.sendFrame126("70",8729);
		c.sendFrame126("Members: Abyssal",8769);
		c.sendFrame126("70",8730);
		c.sendFrame126("Members: Saradomin sword",8770);
		c.sendFrame126("75",8731);
		c.sendFrame126("Members: Godswords",8771);
		c.sendFrame126("",8823);
		c.sendFrame126("",8824);
		c.sendFrame126("",8859);
		c.sendFrame126("",8862);
		c.sendFrame126("",8865);
		c.sendFrame126("",15303);
		c.sendFrame126("",15306);
		c.sendFrame126("",15309);
		c.sendFrame126("",8849);// members only skill
		c.sendFrame126("",8827);//steel
		c.sendFrame126("",8837);//mithril
		c.sendFrame126("",8840);
		c.sendFrame126("",8843);
		c.sendFrame126("",8846); //the first choose thing
		
		c.sendFrame34(8847,1205,0,1);
		c.sendFrame34(8847,1203,1,1);
		c.sendFrame34(8847,1207,2,1);
		c.sendFrame34(8847,1217,3,1);
		c.sendFrame34(8847,1209,4,1);
		c.sendFrame34(8847,1211,5,1);
		c.sendFrame34(8847,1213,6,1);
		c.sendFrame34(8847,1215,7,1);
		c.sendFrame34(8847,4718,8,1);
		c.sendFrame34(8847,4151,9,1);
		c.sendFrame34(8847,11730,10,1);
		c.sendFrame34(8847,11700,11,1);
		c.showInterface(8714);
break;


case 33209:
c.sendFrame126("@dre@Strength", 8716);
		for(int i = 8720;i<8799;i++) {
			c.sendFrame126("",i);
		}
		c.sendFrame126("5",8720);
		c.sendFrame126("Black halberd (with 10 Attack)",8760);
		c.sendFrame126("10",8721);
		c.sendFrame126("Mithril halberd (with 20 Attack)", 8761);
		c.sendFrame126("15",8722);
		c.sendFrame126("Adamant halberd (with 30 Attack)",8762);
		c.sendFrame126("20",8723);
		c.sendFrame126("Rune halberd (with 40 Attack)", 8763);
		c.sendFrame126("50",8724);
		c.sendFrame126("Granite armour (with 50 Defence)", 8764);
		c.sendFrame126("50",8725);
		c.sendFrame126("Granite maul (with 50 Attack)",8765);
		c.sendFrame126("",8726);
		c.sendFrame126("", 8766);
		c.sendFrame126("",8727);
		c.sendFrame126("", 8767);
		c.sendFrame126("", 8728);
		c.sendFrame126("", 8768);
		c.sendFrame126("",8729);
		c.sendFrame126("",8769);
		c.sendFrame126("",8730);
		c.sendFrame126("",8770);
		c.sendFrame126("",8731);
		c.sendFrame126("",8771);
		c.sendFrame126("",8823);
		c.sendFrame126("",8824);
		c.sendFrame126("",8859);
		c.sendFrame126("",8862);
		c.sendFrame126("",8865);
		c.sendFrame126("",15303);
		c.sendFrame126("",15306);
		c.sendFrame126("",15309);
		c.sendFrame126("",8849);// members only skill
		c.sendFrame126("",8827);//steel
		c.sendFrame126("",8837);//mithril
		c.sendFrame126("",8840);
		c.sendFrame126("",8843);
		c.sendFrame126("",8846); //the first choose thing
		
		c.sendFrame34(8847,3196,0,1);
		c.sendFrame34(8847,3198,1,1);
		c.sendFrame34(8847,3200,2,1);
		c.sendFrame34(8847,3202,3,1);
		c.sendFrame34(8847,3122,4,1);
		c.sendFrame34(8847,4153,5,1);
		c.sendFrame34(8847,-1,6,1);
		c.sendFrame34(8847,-1,7,1);
		c.sendFrame34(8847,-1,8,1);
		c.sendFrame34(8847,-1,9,1);
		c.sendFrame34(8847,-1,10,1);
		c.sendFrame34(8847,-1,11,1);
		c.showInterface(8714);
break;
case 33212:
c.sendFrame126("@dre@Defence", 8716);
		for(int i = 8720;i<8799;i++) {
			c.sendFrame126("",i);
		}
		c.sendFrame126("1",8720);
		c.sendFrame126("Bronze",8760);
		c.sendFrame126("1",8721);
		c.sendFrame126("Iron", 8761);
		c.sendFrame126("5",8722);
		c.sendFrame126("Steel",8762);
		c.sendFrame126("10",8723);
		c.sendFrame126("Black", 8763);
		c.sendFrame126("20",8724);
		c.sendFrame126("Mithril", 8764);
		c.sendFrame126("30",8725);
		c.sendFrame126("Adamantite",8765);
		c.sendFrame126("40",8726);
		c.sendFrame126("Rune", 8766);
		c.sendFrame126("50",8727);
		c.sendFrame126("Members: Granite", 8767);
		c.sendFrame126("60", 8728);
		c.sendFrame126("Members: Dragon", 8768);
		c.sendFrame126("65",8729);
		c.sendFrame126("Members: Bandos armour",8769);
		c.sendFrame126("70",8730);
		c.sendFrame126("Members: Elf crystal (with 50 Agility)",8770);
		c.sendFrame126("75",8731);
		c.sendFrame126("Members: armadyl Armour (with 70 Range)",8771);
		c.sendFrame126("",8823);
		c.sendFrame126("",8824);
		c.sendFrame126("",8859);
		c.sendFrame126("",8862);
		c.sendFrame126("",8865);
		c.sendFrame126("",15303);
		c.sendFrame126("",15306);
		c.sendFrame126("",15309);
		c.sendFrame126("",8849);// members only skill
		c.sendFrame126("",8827);//steel
		c.sendFrame126("",8837);//mithril
		c.sendFrame126("",8840);
		c.sendFrame126("",8843);
		c.sendFrame126("",8846); //the first choose thing
		
		c.sendFrame34(8847,1139,0,1);
		c.sendFrame34(8847,1137,1,1);
		c.sendFrame34(8847,1141,2,1);
		c.sendFrame34(8847,1151,3,1);
		c.sendFrame34(8847,1143,4,1);
		c.sendFrame34(8847,1145,5,1);
		c.sendFrame34(8847,1147,6,1);
		c.sendFrame34(8847,3122,7,1);
		c.sendFrame34(8847,1149,8,1);
		c.sendFrame34(8847,11724,9,1);
		c.sendFrame34(8847,4211,10,1);
		c.sendFrame34(8847,11718,11,1);
		c.showInterface(8714);
break;
case 162:
c.setAnimation(856);
c.updateRequired = true;
c.appearanceUpdateRequired = true;
break;

case 163:
c.setAnimation(858);
c.updateRequired = true;
c.appearanceUpdateRequired = true;
break;

case 164:
c.setAnimation(859);
c.updateRequired = true;
c.appearanceUpdateRequired = true;
break;

            case 66110:
                    c.triggerTele(3085, 3518, 0);
                break;

            case 66111:
                    c.triggerTele(2964, 3378, 0);
                break;

            case 66112:
                    c.triggerTele(2595, 3420, 0);
                break;

            case 66113:
                    c.triggerTele(2388, 3488, 0);
                break;

            case 66114:
                    c.triggerTele(3565, 3315, 0);
					c.sM("You will need a spade to do this mini game.");
                break;

            case 66115:
                    c.triggerTele(2805, 2787, 1);
                break;

            case 66116:
                    c.triggerTele(2473, 3190, 0);
                break;

            case 66117:
                    c.triggerTele(3044, 9778, 0);
                break;

            case 66118:
                    c.triggerTele(2717, 9802, 0);
                break;

            case 66119:
                    c.triggerTele(2446, 10147, 0);
                break;

            case 66120:
                    c.triggerTele(2894, 3536, 0);
                break;

            case 66121:
                    c.triggerTele(1896, 5358, 2);
                break;

            case 66122:
                    c.triggerTele(3234, 3207, 0);
                break;

            case 66123:
                    c.triggerTele(2881, 5310, 2);
                break;

            case 66124:
                    c.triggerTele(3428, 3537, 0);
                break;

            case 66125:
                    c.triggerTele(2602, 4776, 0);
                break;

            case 66126:
                    c.triggerTele(3485, 9483, 0);
                break;

            case 66127:
					c.triggerTele(3086, 9522, 0);
                break;

}
}
}