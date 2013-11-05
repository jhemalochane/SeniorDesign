package edu.utdallas.RepoUpdate;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class SoundSelectWindow extends JFrame
{
	public static final int WIDTH = 400, HEIGHT = 200;
	public SoundSelectWindow()
	{
		super("Sound Selection");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(d.width/2 - WIDTH/2, d.height/2 - HEIGHT/2);

		String[] comboStrings = {"Sound1.wav", "Sound2.wav"};
		JComboBox comboBox = new JComboBox(comboStrings);

		JPanel flow = new JPanel(new FlowLayout());

		JButton preview = new JButton("Preview");
		try {
			BufferedImage img = getScaledImage(ImageIO.read(new File("play.png")), 0.5);
			preview.setIcon(new ImageIcon(img));
		} catch(Exception e) {}
		preview.setPreferredSize(new Dimension(150, 30));
		JButton add = new JButton("Add");
		add.setPreferredSize(new Dimension(150, 30));

		add(comboBox, BorderLayout.NORTH);
		flow.add(preview);
		flow.add(add);
		add(flow, BorderLayout.SOUTH);
	}

	public static BufferedImage getScaledImage(BufferedImage orig, double scale)
	{
		int origW = orig.getWidth();
		int origH = orig.getHeight();
		double newW = origW * scale;
		double newH = origH * scale;

		BufferedImage resized = new BufferedImage((int)newW, (int)newH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resized.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(orig, 0, 0, (int)newW, (int)newH, 0, 0, orig.getWidth(), orig.getHeight(), null);
		g.dispose();

		return resized;
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SoundSelectWindow s = new SoundSelectWindow();
				s.setVisible(true);
			}
		});
	}
}