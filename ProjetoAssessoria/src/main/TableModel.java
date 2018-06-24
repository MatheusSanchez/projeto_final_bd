package main;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel{

    private List<String> objects;

    private String[] columnNames;
    private Object[][] columnData;

    public TableModel(String[] columnNames, List<String> objects) {
        this.columnNames = columnNames;
        updateModel(objects);
    }

    @Override
    public int getRowCount() {
       return objects.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        return columnData[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int column)
    {
        return this.columnNames[column];
    }
    
    public void updateModel(List<String> objects)
    {
        this.objects = objects;
        updateDataModel();
    }

    public void updateDataModel() 
    {
       atualizarMatrix();
       fireTableDataChanged();
    }

    private void atualizarMatrix() 
    {
        columnData = new Object[objects.size()][columnNames.length];

        for (int i = 0; i < objects.size(); i++) {
            String[] valores = objects.get(i).split("\n");
            for (int j = 0; j < valores.length; j++) {
            	columnData[i][j] = valores[j];
            }
            
        }
    }

}
