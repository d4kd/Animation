import javax.swing.*;
import java.awt.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 100; // Starting X coordinate
    private int oneY = 100; // Starting Y coordinate
    private int water1 = 6;
    private int water2 = 54;
    private int water3 = 102;
    private int water4 = 150;
    private int water5 = 192;
    private int water6 = 240;
    private int cloud1 = 6;
    private int cloud2 = 102;
    private int cloud3 = 198;
    private int sky1 = 180;
    private int sky2 = 200;
    private int sky3 = 220;
    
    boolean up = false;
    boolean down = true;
    boolean left = true;
    boolean right = true;

    public static void main(String[] args) {
        new Animate().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 300);
        frame.setLocation(375, 55);
        moveDot();
    }

    class DrawPanel<Hill> extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
			
           	//White Border
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            //Black Border
            g.setColor(Color.BLACK);
            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
            
            g.setColor(Color.BLACK);
            g.fillRect(145, 145, 5, 5);
            
            //Sky
            g.setColor(new Color(sky1,sky2,sky3));
            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
            g.setColor(Color.YELLOW);
            
            //Sun
            g.setColor(Color.YELLOW);
            g.fillOval(oneX, oneY, 100, 100); // This is the dot
            // g.fillRect(oneX + 2, oneY - 2, 2, 10);
            // g.fillRect(oneX - 2, oneY + 2, 10, 2);
 

            //Water
            g.setColor(Color.BLUE);
            g.fillOval(water1, 205, 35, 35);
            g.setColor(Color.BLUE);
            g.fillOval(water2, 205, 35, 35);
            g.setColor(Color.BLUE);
            g.fillOval(water3, 205, 35, 35);
            g.setColor(Color.BLUE);
            g.fillOval(water4, 205, 35, 35);
            g.setColor(Color.BLUE);
            g.fillOval(water5, 205, 35, 35);
            g.setColor(Color.BLUE);
            g.fillOval(water6, 205, 35, 35);
            
            //Water
            g.setColor(Color.BLUE);
            g.fillRect(6, 215, 272, 40);
            
            //Cloud
            g.setColor(Color.WHITE);
            g.fillOval(cloud1, 50, 100, 25);
            g.setColor(Color.WHITE);
            g.fillOval(cloud1, 40, 75, 50);
            g.setColor(Color.WHITE);
            g.fillOval(cloud2, 100, 75, 50);
            g.setColor(Color.WHITE);
            g.fillOval(cloud2, 90, 50, 25);
            g.setColor(Color.WHITE);
            g.fillOval(cloud3, 25, 125, 25);
            g.setColor(Color.WHITE);
            g.fillOval(cloud3, 15, 75, 50);
        }
    }
    private void moveDot(){
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(20);
            } catch (Exception exc){}
            frame.repaint();
        }
    } 
    private void moveLoc(){
    	if(up){
            oneY--;
        }
        if(down){
            oneY++;
        }
    	if(up){
    		if(sky1 < 150){
    			sky1++;
    		}
    		if(sky2 < 206){
    			sky2++;
    		}
    		if(sky3 < 235){
    		}
    	}
    	if(down){
    		if(sky1 > 0 && sky1 <= 180){
    			sky1--;
    		} else if (sky1 < 30 && sky1 < 180){
    			sky1++;
    		}
    		if(sky2 > 0 && sky2 <= 200){
    			sky2--;
    		} else if(sky2 < 50 && sky2 < 200){
    			sky2++;
    		}
    		if(sky3 > 0 && sky3 <= 220){
    			sky3--;
    		} else if(sky3 < 70 && sky3 < 220){
    			sky3++;
    		}
    	}
        if(left){
    		if(water1 == -75){
    			water1 = 300;
    		}else if(water2 == -100){
    			water2 = 300;
    		}else if(water3 == -100){
    			water3 = 300;
    		}else if(water4 == -100){
    			water4 = 300;
    		}else if(water5 == -100){
    			water5 = 300;
    		}else if(water6 == -100){
    			water6 = 300;
    		}else{
    			water1--;
    			water2--;
    			water3--;
    			water4--;
    			water5--;
    			water6--;
    		}
    	}
    	if(right){
			water1++;
			water2++;
			water3++;
			water4++;
			water5++;
			water6++;
    	}

    }
    private void checkBounds(){
    	if(oneX >= 283){
            right = false;
            left = true;
        }
        if(oneX <= 7){
            right = true;
            left = false;
        }
        if(oneY >= 259){
            up = true;
            down = false;
        }
        if(oneY <= 7){
            up = false;
            down = true;
        }	
    }

}