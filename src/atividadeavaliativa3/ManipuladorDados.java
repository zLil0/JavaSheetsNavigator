/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividadeavaliativa3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author cg3028151
 */
public class ManipuladorDados {

    static void lerCSV(ArrayList<Cadastro> cadastros, String arq_dados) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(arq_dados);
        BufferedReader br = new BufferedReader(fr);
        boolean fimArquivo = false;
        do{
            String[] linha;
            try{
                linha = br.readLine().split(",");
                if(linha.length>0){
                    cadastros.add(new Cadastro(linha[0], linha[1], linha[2], Integer.parseInt(linha[3]), linha[4], linha[5]));

                }
            }
            catch(NullPointerException e){
                fimArquivo = true;
            }
        }while(fimArquivo==false);
        br.close();
        
        
    }
    
    static void gravar(ArrayList<Cadastro> cadastros, String dados_bindat) throws IOException {
        
        File f = new File(dados_bindat);
        PrintWriter pw = new PrintWriter(f);
        String text = "";
        for (int i = 0; i < cadastros.size(); i++) {
            text += cadastros.get(i).nome + "," + cadastros.get(i).cpf + "," + cadastros.get(i).rua + "," + cadastros.get(i).num + "," + cadastros.get(i).cidade + "," + cadastros.get(i).uf + "\n";
        }
        pw.write(text);
        pw.close();
    }
    
}
