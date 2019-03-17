import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class GUI {

    // Create Date Renderer for formatting Date
    public static class DateComboBoxRenderer extends DefaultListCellRenderer {

        // desired format for the date
        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Object item = value;

            // if the item to be rendered is date then format it
            if( item instanceof Date ) {
                item = dateFormat.format( ( Date ) item );
            }
            return super.getListCellRendererComponent( list, item, index, isSelected, cellHasFocus);
        }
    }

    public static void main( String[] str ) {
        JComboBox combo = new JComboBox();

        // Add current date
        GregorianCalendar calendar = new GregorianCalendar();
        combo.addItem( calendar.getTime() );

        // Add Next date
        calendar.roll( GregorianCalendar.DAY_OF_MONTH, 1 );
        combo.addItem( calendar.getTime() );

        // Set Renderer for formating the date in combobox
        combo.setRenderer( new DateComboBoxRenderer() );

        JFrame frame = new JFrame( "Date Rendere Example" );

        JPanel panel = new JPanel();
        panel.add( new JLabel( "Date Combo: ") );
        panel.add( combo );
        frame.add( panel );
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible( true );
    }

}