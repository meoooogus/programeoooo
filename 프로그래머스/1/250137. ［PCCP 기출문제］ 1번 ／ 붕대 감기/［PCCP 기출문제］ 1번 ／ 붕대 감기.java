class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int lastTime = attacks[attacks.length - 1][0];
        int current = 0;
        int at = 0;
        
        for (int i = 1; i <= lastTime; i++) {
            int heal = bandage[1];
            int deal = attacks[at][1];
            if (attacks[at][0] == i) {
                hp -= deal;
                current = 0;
                at++;
            } else {
                hp += heal;
                current++;
                if (current == bandage[0]) {
                    hp += bandage[2];
                    current = 0;
                }
                    
                if (hp > health)
                    hp = health;
            }
            if (hp <= 0)
                return -1;
        }
        
        return hp;
    }
}