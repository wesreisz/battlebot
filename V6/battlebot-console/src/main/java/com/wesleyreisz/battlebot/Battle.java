package com.wesleyreisz.battlebot;

import com.wesleyreisz.battlebot.renderer.MessageRenderer;
import com.wesleyreisz.battlebot.utils.CharacterUtil;
import com.wesleyreisz.battlebot.utils.DiceUtil;

public class Battle {
	private PlayerCharacter p1;
	private PlayerCharacter p2;
	private MessageRenderer renderer;
	
	public Battle(){}
	
	public Battle(PlayerCharacter p1, PlayerCharacter p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void fight(){
		int rounds = 0;
		String result = "";
		
		rollInitative();
		while (evaluateResult(result)){
			renderer.render("Round " + ++rounds);
			renderer.render("------------");
			if (p1.getInitative()>p2.getInitative()){
				result = combatSequence(p1,p2);
				result = combatSequence(p2,p1);
				if (checkForKill(p2)){
					renderer.render(CharacterUtil.resultMessage(p1, p2));
					break;
				}
				
			}else{
				result = combatSequence(p2,p1);
				result = combatSequence(p1,p2);
				if (checkForKill(p1)){
					renderer.render(CharacterUtil.resultMessage(p2, p1));
					break;
				}
			}
			
			renderer.render("------------");
		}
		renderer.render(result);
	}
	private boolean checkForKill(PlayerCharacter defender){
		if (defender.getHp()<=0){ 
			return true;
		}else{
			return false;
		}
	}
	private void rollInitative(){
		p1.setInitative(DiceUtil.rollDice(Dice.D20));
		p2.setInitative(DiceUtil.rollDice(Dice.D20));
	}
	private String combatSequence(PlayerCharacter attacker, PlayerCharacter defender){
		String result ="";
		int toHit = attacker.attack();
		int toDefend = defender.defend();
		renderer.render(" - " +attacker.getName() + " attacks (" + toHit + "/" + toDefend + ") ");
				
		if (toHit>=toDefend){
			int damage = attacker.dealWeaponDamage(p1);
			renderer.render("   " + attacker.getWeapon().getDescription() + " for " + damage + " damage.");
			defender.damageCharacter(damage);
		}else{
			renderer.render("   Misses.");
		}
		return result;
	}
	private boolean evaluateResult(String result){
		if(result.length()>0){
			return false;
		}else{
			return true;
		}
	}

	public MessageRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(MessageRenderer renderer) {
		this.renderer = renderer;
	}
	
}
