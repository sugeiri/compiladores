package analizadorlexico.SPPS1;

import javax.swing.table.AbstractTableModel;

public class ModeloDeTabla extends AbstractTableModel 
{     
    private String[] columnNames = {"TOKEN","LEXEMA"};
    private Object[][] data;
    public ModeloDeTabla(String[] tokens,String[] lexemas)     
    {         
        data=new Object[tokens.length][2];
        for(int i=0;i<tokens.length;i++)         
        {             
            data[i][0]=tokens[i];
            data[i][1]=lexemas[i];
        }     
    }     
    public int getColumnCount() {
        return columnNames.length;     
    }
    
    public int getRowCount() {
        return data.length;
    }
 @Override     
 public String getColumnName(int col) {
     return columnNames[col];    
 } 
  public Object getValueAt(int row, int col) {
      return data[row][col];     
  } 
 
}