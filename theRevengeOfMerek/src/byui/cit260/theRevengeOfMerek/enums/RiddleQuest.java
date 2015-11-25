/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.enums;

/**
 *
 * @author co075oh
 */
public enum RiddleQuest {
    
    One("Aura cadaver, in graveyards we gather.  In the living we exist, in your closet we persist. What are we?","SKELETONS"),
    Two("The more you take away from it, the larger it becomes. What is it?","HOLE"),
    Three("I'm tasty on the inside, I'm curvy not wide. If you step on my hide, you'll go for a ride. What am I?","BANANA"),
    Four("What is broken when it's not held?","PROMISE"),
    Five("What can jump higher than a mountain?","ANYTHING"),
    Six("I have no wallet but I pay my way. I travel the world but in the corner I stay. What am I?","STAMP"),
    Seven("I build bridges of silver and crowns of gold. I clean and I fix, yet many still fear me. What am I?","DENTIST"),
    Eight("Of the king I am blue and of the peasant I am red. Of the frog I am cold and of the dog I am hot. What am I?","BLOOD"),
    Nine("What binds two people yet touches only one?","RING"),
    Ten("The shorter I am, the bigger I am. What am I?","TEMPER");
    
    // Class Instance Variables
    private final String riddle;
    private final String answer;

    // default constructor method
    RiddleQuest(String riddle, String answer) {       
        this.riddle = riddle;
        this.answer = answer;
    }
    
    // public getter function
    public String getRiddle() {
        return riddle;
    }

    public String getAnswer() {
        return answer;
    }

}
