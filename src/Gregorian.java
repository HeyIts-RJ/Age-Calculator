
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gregorian extends JPanel {
  /** The currently-interesting year (not modulo 1900!) */
  protected int yy;

  /** Currently-interesting month and day */
  protected int mm, dd;

  /** The buttons to be displayed */
  protected JButton labs[][];

  /** The number of day squares to leave blank at the start of this month */
  protected int leadGap = 0;

  /** A Calendar object used throughout */
  Calendar calendar = new GregorianCalendar();

  /** Today's year */
  protected final int thisYear = calendar.get(Calendar.YEAR);

  /** Today's month */
  protected final int thisMonth = calendar.get(Calendar.MONTH);

  /** One of the buttons. We just keep its reference for getBackground(). */
  private JButton b0;

  /** The month choice */
  private JComboBox monthChoice;

  /** The year choice */
  private JComboBox yearChoice;

  /**
   * Construct a Cal, starting with today.
   */
  Gregorian() {
    super();
    setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH));
    buildGUI();
    recompute();
  }

  /**
   * Construct a Cal, given the leading days and the total days
   * 
   * @exception IllegalArgumentException
   *                If year out of range
   */
  Gregorian(int year, int month, int today) {
    super();
    setYYMMDD(year, month, today);
    buildGUI();
    recompute();
  }

  private void setYYMMDD(int year, int month, int today) {
    yy = year;
    mm = month;
    dd = today;
  }

  String[] months = { "January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December" };

  /** Build the GUI. Assumes that setYYMMDD has been called. */
  private void buildGUI() {
    getAccessibleContext().setAccessibleDescription(
        "Calendar not accessible yet. Sorry!");
    setBorder(BorderFactory.createEtchedBorder());

    setLayout(new BorderLayout());

    JPanel tp = new JPanel();
    tp.add(monthChoice = new JComboBox());
    for (int i = 0; i < months.length; i++)
      monthChoice.addItem(months[i]);
    monthChoice.setSelectedItem(months[mm]);
    monthChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        int i = monthChoice.getSelectedIndex();
        if (i >= 0) {
          mm = i;
          // System.out.println("Month=" + mm);
          recompute();
        }
      }
    });
    monthChoice.getAccessibleContext().setAccessibleName("Months");
    monthChoice.getAccessibleContext().setAccessibleDescription(
        "Choose a month of the year");

    tp.add(yearChoice = new JComboBox());
    yearChoice.setEditable(true);
    for (int i = yy - 5; i < yy + 5; i++)
      yearChoice.addItem(Integer.toString(i));
    yearChoice.setSelectedItem(Integer.toString(yy));
    yearChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        int i = yearChoice.getSelectedIndex();
        if (i >= 0) {
          yy = Integer.parseInt(yearChoice.getSelectedItem()
              .toString());
          recompute();
        }
      }
    });
    add(BorderLayout.CENTER, tp);

    JPanel bp = new JPanel();
    bp.setLayout(new GridLayout(7, 7));
    labs = new JButton[6][7]; // first row is days

    bp.add(b0 = new JButton("S"));
    bp.add(new JButton("M"));
    bp.add(new JButton("T"));
    bp.add(new JButton("W"));
    bp.add(new JButton("R"));
    bp.add(new JButton("F"));
    bp.add(new JButton("S"));

    ActionListener dateSetter = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String num = e.getActionCommand();
        if (!num.equals("")) {
          setDayActive(Integer.parseInt(num));
        }
      }
    };

    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++) {
        bp.add(labs[i][j] = new JButton(""));
        labs[i][j].addActionListener(dateSetter);
      }

    add(BorderLayout.SOUTH, bp);
  }

  public final static int dom[] = { 31, 28, 31, 30, 
  31, 30, 31, 31, 
  30, 31, 30, 31 
  };
  protected void recompute() {
    if (mm < 0 || mm > 11)
      throw new IllegalArgumentException("Month " + mm
          + " bad, must be 0-11");
    clearDayActive();
    calendar = new GregorianCalendar(yy, mm, dd);

    leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;

    int daysInMonth = dom[mm];
    if (isLeap(calendar.get(Calendar.YEAR)) && mm == 1)
      ++daysInMonth;
    for (int i = 0; i < leadGap; i++) {
      labs[0][i].setText("");
    }
    for (int i = 1; i <= daysInMonth; i++) {
      JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
      b.setText(Integer.toString(i));
    }

    for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
      labs[(i) / 7][(i) % 7].setText("");
    }

    if (thisYear == yy && mm == thisMonth)
      setDayActive(dd);
    repaint();
  }

  public boolean isLeap(int year) {
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
      return true;
    return false;
  }

  public void setDate(int yy, int mm, int dd) {
    this.yy = yy;
    this.mm = mm;
    this.dd = dd;
    recompute();
  }

  private void clearDayActive() {
    JButton b;

    if (activeDay > 0) {
      b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
      b.setBackground(b0.getBackground());
      b.repaint();
      activeDay = -1;
    }
  }

  private int activeDay = -1;

  public void setDayActive(int newDay) {

    clearDayActive();

    if (newDay <= 0)
      dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
    else
      dd = newDay;
    Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
    square.setBackground(Color.red);
    square.repaint();
    activeDay = newDay;
  }

  /** For testing, a main program */
  public static void main(String[] av) {
    JFrame f = new JFrame("Date selector");
    Container c = f.getContentPane();
    c.setLayout(new FlowLayout());
    c.add(new Gregorian());

    f.pack();
    f.setVisible(true);
  }
}