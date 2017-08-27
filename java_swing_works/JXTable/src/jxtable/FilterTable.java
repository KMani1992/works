package jxtable;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.regex.PatternSyntaxException;

/**
 * Created by IntelliJ IDEA.
 * User: Serge
 * Date: 23.06.2004
 * Time: 0:59:06
 */
public class FilterTable extends JFrame {
    private JPanel panel;    
    private JScrollPane scrollPane;
    private JTextField lookupField;
    
   

    public FilterTable(String title) throws HeadlessException {
        super(title);

        SecureRandom random = new SecureRandom();
        final String[][] model = new String[30][2];

        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < 2; i++) {
                model[j][i] = new BigInteger(130, random).toString(32);
            }
        }
        TableModel dataModel = new
                AbstractTableModel() {
                    public int getColumnCount() {
                        return 2;
                    }

                    public int getRowCount() {
                        return 30;
                    }

                    public Object getValueAt(int row, int col) {
                        return model[row][col];
                    }
                };

//    Comment this code to add table dynamically
//    table.setModel(dataModel);

//    Uncomment this code to add table dynamically:
        final TableRowSorter<TableModel> sorter =
                new TableRowSorter<TableModel>(dataModel);

        JXTable myTable = new JXTable(dataModel);
        myTable.setColumnControlVisible(true);
        // To auto-hide a column
        // myTable.getColumnExt("B").setVisible(false);
        myTable.setRowSorter(sorter);
        
        lookupField=new JTextField();

        // Set lookup listener
        lookupField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String lookupFieldText = lookupField.getText();
                    if (lookupFieldText.length() == 0)
                        sorter.setRowFilter(null);
                    else
                        sorter.setRowFilter(RowFilter.regexFilter(lookupFieldText));
                } catch (PatternSyntaxException pse) {
                    System.err.println("Incorrect pattern syntax");
                }
            }
        });

        // Customize
        myTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        myTable.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, Color.GREEN));
        myTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollPane.setViewportView(myTable);
panel=new JPanel();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FilterTable("FilterTable");
    }
}
