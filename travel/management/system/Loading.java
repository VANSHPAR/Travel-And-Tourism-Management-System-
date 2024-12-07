package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable
{
    String user;
    Thread t;
    JProgressBar bar;
    public Loading(String user)
    {
        this.user=user;
        t=new Thread(this);
        
        setBounds(300,150,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel ("Travel And Tourism Application");
        text.setBounds(50,2,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("TAHOMA",Font.BOLD,35));
        add(text);
        
        bar=new JProgressBar();
        bar.setBounds(170,80,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel ("Loading,please wait.....");
        loading.setBounds(230,140,300,25);
        loading.setForeground(Color.red);
        loading.setFont(new Font("TAHOMA",Font.BOLD,15));
        add(loading);
        
        JLabel username = new JLabel ("Welcome "+user);
        username.setBounds(20,310,600,40);
        username.setForeground(Color.red);
        username.setFont(new Font("TAHOMA",Font.BOLD,25));
        add(username);
        
        t.start();
        setVisible(true);
    }
    public void run()
    {
        try
        {
            for(int i=1; i<=101; i++)
            {
               
                if(bar.getValue() < bar.getMaximum())
                {
                    bar.setValue(bar.getValue() +1);
                }
                else
                {
                    setVisible(false);
                    new Dashboard(user);
                }
                    Thread.sleep(100);
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
}
