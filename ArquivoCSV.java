
package aplicaçãohash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCSV {

   
    public static void main(String[] args) {
        String csvArquivo = "\\Users\\pesquisa\\Documents\\arquivo\\arquivo.csv";
        
        BufferedReader conteudoCSV = null; //Ler todo conteúdo e salvar na memória
        String linha = "";
        String csvSeparadorDeCampo = ";"; //Indica a separação dos nome por coluna
        
        try {
            conteudoCSV = new BufferedReader (new FileReader(csvArquivo)); 
                    
            while ((linha = conteudoCSV.readLine()) != null) { //Enquanto tiver conteudo
                String[] moeda = linha.split(csvSeparadorDeCampo); //Quando ele encontrar o ;, ele considera como um campo
                System.out.println("[NOME = " + moeda[0]
                        + ", MATRICULA = " + moeda[1] + "]");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado: \n"+e.getMessage());
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds: \n"+e.getMessage()); //Nao exite index
        }
        
        catch (IOException e) {
            System.out.println("IO Erro: \n"+e.getMessage());
        } finally {
            if (conteudoCSV != null) {
                try {
                    conteudoCSV.close();
                } catch (IOException e) {
                    System.out.println("IO Erro: \n"+e.getMessage());
                }
            }
        }
        
        
        
    }
    
}
