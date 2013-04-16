import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.Battle;

public class BattleHarness {

		public static void main(String[] args){
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			Battle battle = ctx.getBean("battle", Battle.class);
			battle.fight();
		}
}
