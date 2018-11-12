package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Carre
{
	private JTextField operand = new JTextField();
	private JLabel result = new JLabel();

	private void afficheCarre()
	{
		try
		{
			int k = Integer.parseInt(operand.getText());
			k *= k;
			result.setText("" + k);
		}
		catch (NumberFormatException e)
		{
			result.setText("");
		}
	}

	private KeyListener getKeyListener()
	{
		return new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				afficheCarre();
			}
		};
	}

	private JPanel getMainPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("x = "));
		operand.addKeyListener(getKeyListener());
		panel.add(operand);
		panel.add(new JLabel("x^2 = "));
		panel.add(result);
		return panel;
	}

	public Carre()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Square computer !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getMainPanel());
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new Carre();
	}
}
