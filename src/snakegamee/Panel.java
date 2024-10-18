/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegamee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;


public class Panel extends JPanel implements ActionListener {
    final int h=600;
      final int w=600;
      final int unit=25;
      final int gameUnit=((h*w)/unit);
      final int x[]=new int [gameUnit];
      final int y[]=new int [gameUnit];
      int applex;
      int appley;
      int delay=75;
      Random random;
      Timer timer;
      int bodyparts=6;
      int appleEaten;
      char dirction='R';
      boolean run =false;
    public Panel(){
      this.setPreferredSize(new Dimension(h,w));
      this.setBackground(Color.black);
      this.setFocusable(true);
      this .addKeyListener(new MyKeyAdabpter());
      this.startGame();
    }
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        draw(G);
    }
    public void startGame(){
        run=true;
        timer =new Timer (delay,this);
        random=new Random();
        timer.start();
        newApple();
        
    }
public void newApple(){
    applex=random.nextInt((int)(w/unit))*unit;
    appley=random.nextInt((int)(h/unit))*unit;
}
public void move(){
    for(int i=bodyparts;i>0;i--)
    {
        x[i]=x[i-1];
         y[i]=y[i-1];
    }
    switch(dirction){
            case 'U':
            y[0]-=unit;
            break;
            case 'D':
            y[0]+=unit;
             break;
            case 'L':
            x[0]-=unit;
             break;
            case 'R':
            x[0]+=unit;
             break;
            
    }
}
public void checkApple(){
    if(applex==x[0]&&appley==y[0])
    {
        appleEaten++;
        bodyparts++;
        newApple();
        
    }
}
public void checkcolleisions(){
    if(x[0]<0||y[0]<0||x[0]>w||y[0]>h)
    {
        run=false;
    }
    
}

    public void draw(Graphics G) {
       // for(int i=0;i<gameUnit/unit;i++)
       // {
       //     G.drawLine(i*unit, 0, i*unit, h);
       //     G.drawLine(0, i*unit, w, i*unit);
       // }
       if(run){
        G.setColor(Color.red);
         G.fillOval(applex, appley, unit, unit);
        for(int i=0;i<bodyparts;i++)
        {
            if(i==0){
                G.setColor(Color.white);
                G.fillRect(x[i], y[i], unit, unit);
            }
            else {
                G.setColor(Color.DARK_GRAY);
                G.fillRect(x[i], y[i], unit, unit);
            }
        }
       }
        else 
        {
           gameover(G) ;   
         }
    }
public void gameover (Graphics G )
{
    G.setColor(Color.red);
    G.setFont(new Font ("Ink free",Font.BOLD,75));
    FontMetrics met = getFontMetrics(G.getFont());
    G.drawString("Game Over",(w-met.stringWidth("Game Over"))/2,h/2);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(run)
    {
        move();
        checkApple();
        checkcolleisions();
        
    }
    repaint();
    }
    public class MyKeyAdabpter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if(dirction!='D')
                      dirction='U' ;
                    break;
                    case KeyEvent.VK_DOWN:
                    if(dirction!='U')
                      dirction='D' ;
                    break;
                    case KeyEvent.VK_LEFT:
                    if(dirction!='R')
                      dirction='L' ;
                    break;
                    case KeyEvent.VK_RIGHT:
                    if(dirction!='L')
                      dirction='R' ;
                    break;
                    
            }
                    
        }
    }
    
}
