import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column) 
    {
        Component cell = super.getTableCellRendererComponent
           (table, value, isSelected, hasFocus, row, column);
        if( value instanceof String )
        {         
            if( value.equals("Yes") )
            {
                cell.setForeground(Color.GREEN);
            }
            else
            {
            	cell.setForeground(Color.RED);
            }
        }
        return cell;
    }
}
