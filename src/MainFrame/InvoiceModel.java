
package MainFrame;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class InvoiceModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    
    public InvoiceModel(){}
    
    public InvoiceModel(Object[][] data, String[] columsName) {
        this.columns = columsName;
        this.rows = data;
    }
    
    @Override
    public Class getColumnClass(int col){
        if(col == 12){ return Icon.class; }
        else{
            return getValueAt(0, col).getClass();
        }
    }
    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }
}
