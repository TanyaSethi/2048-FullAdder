import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.lang.Integer;

/**
 * @author Tanya Sethi
 */

public class Grid extends Applet implements KeyListener {

    private static final int SIZE = 100;
    public int[][] board = new int[4][4];
    private Font font = new Font("Arial", Font.PLAIN, 20);
    ConvertToBin convert=new ConvertToBin();
    AddBinary add=new AddBinary();
    CheckDuplicateRow row=new CheckDuplicateRow();
    CheckDuplicateColumn col=new CheckDuplicateColumn();
    boolean stopflag=false;
    boolean over=false;

    @Override
    public void init() {
    	setForeground(Color.green);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
        resize(board.length * SIZE, board[0].length * SIZE);
        addRandom(2);
        addKeyListener(this);
    }

    private void addRandom(int howMany) {
        ArrayList<Point> available = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    available.add(new Point(i, j));
                }
            }
        }
        
        Random r = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
        if (available.isEmpty() &&(row.checkRow(board))&&(col.checkColumn(board))) {
        	over=true;
            System.out.println("Game Over");
            return;
        }}
        }
        for (int i = 0; i < howMany; i++) {

            Point p = available.get(r.nextInt(available.size()));
            // weight the 2 so it shows up more...
            board[(int)p.getX()][(int)p.getY()] = r.nextInt(4) == 1 ? 4 : 2;
            available.remove(p);
        }
    }

    private void move(int dir) {
        if (dir == KeyEvent.VK_UP) {
            for (int i = 0; i < board.length; i++) 
                {
                for (int j = 1; j < board.length; j++)
                	{
                    if (board[i][j] == 0 && board[i][j - 1] == 0) 
                      {
                        continue;
                      }
                    if (board[i][j] == board[i][j - 1] ) 
                      {
                    	int val1[] =convert.convertBinary(board[i][j]);
                    	int val2[] =convert.convertBinary(board[i][j - 1]);
                    	
                    	board[i][j - 1] = add.add(val1,val2);
                        System.out.println(board[i][j-1]);
                        board[i][j] = 0;
                      } 
                    else if (board[i][j - 1] == 0) 
                      {
                        board[i][j - 1] = board[i][j];
                        board[i][j] = 0;
                        j = 0;
                      }
                    }
                }
    }else if (dir == KeyEvent.VK_DOWN) {
            for (int i = 0; i < board.length; i++) {
                for (int j = board[0].length - 2; j >= 0; j--) {
                    if (board[i][j] == 0 && board[i][j + 1] == 0) {
                        continue;
                    }
                    if (board[i][j] == board[i][j + 1] ) {
                    	int val1[] =convert.convertBinary(board[i][j]);
                    	int val2[] =convert.convertBinary(board[i][j+1]);
                        board[i][j + 1] =add.add(val1,val2);
                        board[i][j] = 0;
                    } else if (board[i][j + 1] == 0) {
                        board[i][j + 1] = board[i][j];
                        board[i][j] = 0;
                        j = board[0].length - 1;
                    }
                }
            }
        } else if (dir == KeyEvent.VK_LEFT) {

            for (int j = 0; j < board[0].length; j++) {
                for (int i = 1; i < board.length; i++) {
                    if (board[i][j] == 0 && board[i - 1][j] == 0) {
                        continue;
                    }
                    if (board[i][j] == board[i - 1][j]) {
                    	int val1[] =convert.convertBinary(board[i][j]);
                    	int val2[] =convert.convertBinary(board[i-1][j]);
                        board[i - 1][j] =add.add(val1,val2);
                        board[i][j] = 0;
                    } else if (board[i - 1][j] == 0) {
                        board[i - 1][j] = board[i][j];
                        board[i][j] = 0;
                        i = 0;
                    }
                }
            }
        } else if (dir == KeyEvent.VK_RIGHT) {
            for (int j = 0; j < board[0].length; j++) {
                for (int i = board.length - 2; i >= 0; i--) {
                    if (board[i][j] == 0 && board[i + 1][j] == 0) {
                        continue;
                    }
                    if (board[i][j] == board[i + 1][j]) {
                    	int val1[] =convert.convertBinary(board[i][j]);
                    	int val2[] =convert.convertBinary(board[i+1][j]);
                        board[i + 1][j] =add.add(val1,val2);
                        board[i][j] = 0;
                    } else if (board[i + 1][j] == 0) {
                        board[i + 1][j] = board[i][j];
                        board[i][j] = 0;
                        i = board.length - 1;
                    }
                }
            }
        }

    }
 //   public void stop(){
   // 	stopflag=true;
    //}

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, board.length, board[0].length);
        FontMetrics fontMetrics = g.getFontMetrics();
        Color lightBlue= new Color(0,0,182,155);
        g.setFont(font);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               g.setColor(lightBlue);
                g.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                g.setColor(Color.black);
                g.drawRect(i * SIZE, j * SIZE, SIZE, SIZE);
                g.setColor(new Color(238, 228, 218));
                //int val2= (board[i][j] == 0 ?val:board[i][j]);
                if(board[i][j]==2048){
                	g.drawString("YOU WIN", 100, 200);
                	
                }
                String num = String.valueOf(board[i][j]==0?"":board[i][j]);
                // center the number on top of the square
                int x = (i * SIZE) + (SIZE / 2) - (fontMetrics.stringWidth(num) / 2);
                int y = (j * SIZE) + (SIZE / 2) + (fontMetrics.getAscent() / 2);
                g.drawString(num, x, y);
               // if(over==true){
                //	g.drawString("GAME OVER",100, 200);
               // }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP
                || key == KeyEvent.VK_DOWN
                || key == KeyEvent.VK_RIGHT
                || key == KeyEvent.VK_LEFT) {
            move(key);
            addRandom(1); 
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
