/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtable;

import java.io.File;
import java.io.FileWriter;
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

        int x = 1;
        int y = 1;

        while (y <= tableSize)
        {
            table.append(x++ * y);
            if (x == tableSize)
            {
                y++;
                x = 1;
                table.append("\n");
            } else
            {
                table.append(", ");
            }
        }

        return table.toString();
    }

}
