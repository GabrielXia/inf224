import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 */
public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea textArea;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    public MainWindow() {
        textArea = new JTextArea("hello");
        textArea.setColumns(10);
        textArea.setRows(20);
        add(textArea, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        b1 = new JButton("add1");
        b2 = new JButton("add2");
        b3 = new JButton("exit");
        b1.addActionListener(new Add1Listner(textArea));
        b2.addActionListener(new Add2Listner(textArea));
        b3.addActionListener(new ExitListner());
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        add(panel, BorderLayout.SOUTH);

        addMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        //System.setProperty("apple.laf.useScreenMenuBar", "true");
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("menu");
        JToolBar tool = new JToolBar("tool");
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        add(tool, BorderLayout.NORTH);

        completeMenu(menu);
        completeMenu(tool);
    }

    private void completeMenu(JComponent menu) {
        JMenuItem j1 = new JMenuItem("add1");
        j1.addActionListener(new Add1Listner(textArea));

        JMenuItem j2 = new JMenuItem("add2");
        j2.addActionListener(new Add2Listner(textArea));

        JMenuItem j3 = new JMenuItem("exit");
        j3.addActionListener(new ExitListner());

        menu.add(j1);
        menu.add(j2);
        menu.add(j3);
    }

    private class ExitListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class Add1Listner implements ActionListener {
        private JTextArea jTextArea;
        public Add1Listner(JTextArea jTextArea) {
            this.jTextArea = jTextArea;
        }
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("first button");
        }
    }

    private class Add2Listner implements ActionListener {
        private JTextArea jTextArea;
        public Add2Listner(JTextArea jTextArea) {
            this.jTextArea = jTextArea;
        }
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("second button");
        }
    }

    private class MenuAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

