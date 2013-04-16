import com.wesleyreisz.battlebot.Battle;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.*;
import com.wesleyreisz.battlebot.renderer.*;
import com.wesleyreisz.battlebot.weapon.*;
import com.wesleyreisz.battlebot.armor.*;

public class BattleHarness {

		public static void main(String[] args){
			PlayerCharacter p1 = new PlayerCharacter("Maylar", 16, 14);
			p1.setArmor(new Plate());
			p1.setWeapon(new Fire(new LongSword()));
			
			PlayerCharacter p2 = new PlayerCharacter("Deend", 15, 16);
			p2.setArmor(new Leather());
			p2.setWeapon(new Ice(new Acid(new Rapier())));
			
			Battle battle = new Battle(p1,p2);
			battle.setRenderer(new LogRenderer());
			battle.fight();
		}
}
