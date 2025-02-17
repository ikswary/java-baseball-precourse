/*
 * NumberBaseball.java
 *
 * 버전 : 1.0.0
 *
 * 날짜 : 19-11-29
 */


 

import java.util.Scanner;

class Num{
    int val=0;
    int[] position = new int[3];
    Scanner sc = new Scanner(System.in);

    public void setRnum(){
        while (this.val<100
                ||this.position[0] == this.position[1]
                ||this.position[0] == this.position[2]
                ||this.position[1] == this.position[2]){
            this.val = (int)(Math.random()*1000);
            this.setPosition();
        }
    }

    public void setVal(){
        System.out.print("숫자를 입력해주세요 : ");
        this.val=this.sc.nextInt();
        this.setPosition();
    }

    private void setPosition(){
        this.position[0] = this.val/100;
        this.position[1] = this.val%100/10;
        this.position[2] = this.val%10;
    }

}

public class NumberBaseball {

    private static boolean rtnHint(Num answer, Num player){
        int strike = 0;
        int ball = 0;
        String rtnMsg = "";

        if(answer.position[0] == player.position[0]){
            strike++;
        }

        if(answer.position[1] == player.position[1]){
            strike++;
        }

        if(answer.position[2] == player.position[2]){
            strike++;
        }

        if(answer.position[0] == player.position[1]
                ||answer.position[0]==player.position[2]){
            ball++;
        }

        if(answer.position[1] == player.position[0]
                ||answer.position[1]==player.position[2]){
            ball++;
        }

        if(answer.position[2] == player.position[0]
                ||answer.position[2]==player.position[1]){
            ball++;
        }

        if(strike > 0){
            rtnMsg = strike + " 스트라이크 ";
        }

        if(ball > 0){
            rtnMsg += ball + " 볼";
        }

        if(strike == 0 && ball == 0){
            rtnMsg="헛스윙";
        }

        System.out.println(rtnMsg);
        if (strike == 3){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean gameKey = true;
        Boolean stageKey = false;
        Num player = new Num();
        while(gameKey == true){
            Num answer = new Num();
            answer.setRnum();
            stageKey = false;
            while(stageKey == false){
                player.setVal();
                stageKey=rtnHint(answer, player);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            if(sc.nextInt() == 2) {
                gameKey = false;
            }
        }
    }
}