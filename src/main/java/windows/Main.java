package windows;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				final JFrame frame = new JFrame();

				frame.setUndecorated(true);
				frame.setBackground(new Color(100, 100, 100, 180));
				frame.setSize(800, 200);
//				frame.setOpacity(0.5f);
				MouseAdapter frameDragListener = new FrameDragListener(frame);
				frame.addMouseListener(frameDragListener);
				frame.addMouseMotionListener(frameDragListener);
				frame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(runnable);
	}

	public static class FrameDragListener extends MouseAdapter {

		private final JFrame frame;
		private Point mouseDownCompCoords = null;

		public FrameDragListener(JFrame frame) {
			this.frame = frame;
		}

		public void mouseReleased(MouseEvent e) {
			mouseDownCompCoords = null;
		}

		public void mousePressed(MouseEvent e) {
			mouseDownCompCoords = e.getPoint();
		}

		public void mouseDragged(MouseEvent e) {
			Point currCoords = e.getLocationOnScreen();
			frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
		}
	}
}