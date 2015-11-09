/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PeterH
 */
public class MTable
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MTable mTable = new MTable();

    }



    private MTable()
    {
        try
        {
            System.out.println("Enter table size");
            int tableSize = Integer.parseInt(new Scanner(System.in).next());
            System.out.println("\nYou entered: "
                    + tableSize
                    + ", generating table...\n");

            try (FileWriter fw = new FileWriter(new File("table.csv")))
            {
                fw.write(this.getTable(tableSize));
            }
            
            System.out.println("Done, table can be found in 'table.csv'.");

        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }



    private String getTable(int tableSize)
    {

        StringBuilder table = new StringBuilder();

        List<Integer> list = new ArrayList();

        for (int i = 1; i <= tableSize; i++)
        {
            list.add(i);
        }

        int i = 1;
        for (Integer y : list)
        {
            for (Integer x : list)
            {
                table.append(x * i);
                if (x < list.size())
                {
                    table.append(", ");
                }
            }
            table.append("\n");
            i++;
        }
        return table.toString();
    }

}
