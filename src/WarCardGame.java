
import java.util.ArrayList;     
import java.util.Random;       
import java.util.List;         
import java.util.Collections;   
import java.util.LinkedList;    

public class WarCardGame {
    public static void main(String[] args) {
        
        List<Card> cardDeck = new ArrayList<Card>(); 
        
        for(int x=0; x<4; x++){          
            for(int y=2; y<15; y++){     
                cardDeck.add(new Card(x,y)); 
            } 
        }
        
        Collections.shuffle(cardDeck, new Random()); 
        
        
        LinkedList<Card> deck1 = new LinkedList<Card>();
        LinkedList<Card> deck2 = new LinkedList<Card>();
        
        deck1.addAll(cardDeck.subList(0, 25));                    
        deck2.addAll(cardDeck.subList(26, cardDeck.size()));
        
        while(true){
            Card p1Card = deck1.pop();  
            Card p2Card = deck2.pop();
            
            //display the face up card
            System.out.println("Player 1 plays card is " + p1Card.toString());
            System.out.println("Player 2 plays card is " + p2Card.toString());
            
         
            if(p1Card.getCard() > p2Card.getCard()){
                deck1.addLast(p1Card);  
                deck1.addLast(p2Card);  
                System.out.println("PLayer 1 wins the round");
            }
 
            else if(p1Card.getCard() < p2Card.getCard()){ 
                deck2.addLast(p1Card);   
                deck2.addLast(p2Card);  
                System.out.println("PLayer 2 wins the round");
            }
            
            else {
                System.out.println("War"); 
                
                
                List<Card> war1 = new ArrayList<Card>(); 
                List<Card> war2 = new ArrayList<Card>();
                
                
                for(int x=0; x<3; x++){ 
                 
                    if(deck1.size() == 0 || deck2.size() == 0 ){                      
                        break;
                    }
                    
                    System.out.println("War card for player1 is xx\nWar card for player2 is xx");

                    war1.add(deck1.pop());  
                    war2.add(deck2.pop());                  
                }
                
                
                if(war1.size() == 3 && war2.size() == 3 ){
                    System.out.println("War card for player1 is " + war1.get(0).toString());
                    System.out.println("War card for player2 is " + war2.get(0).toString());
                    
                    
                    if(war1.get(2).getCard() > war2.get(2).getCard()){
                        deck1.addAll(war1); 
                        deck1.addAll(war2);
                        System.out.println("Player 1 wins the war round");
                    }
                    
                    else{
                        deck2.addAll(war1); 
                        deck2.addAll(war2);
                        System.out.println("Player 2 wins the war round");
                    }                    
                }
                
            }
            
            if(deck1.size() == 0 ){
                System.out.println("game over\nPlayer 1 wins the game");
                break;
            }
            else if(deck2.size() == 0){
                System.out.println("game over\nPlayer 2 wins the game");
                break;
            }
        } 

    }     
}