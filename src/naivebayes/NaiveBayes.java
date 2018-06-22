package naivebayes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NaiveBayes {

    /**
     * @param args the command line arguments
     */
    int nLinhas;
    int nColunas;
    float probabPositiva;
    float probabNegativa;
    public static void main(String[] args) {
        NaiveBayes nb = new NaiveBayes();
        String[][] dataset = nb.run();
        nb.treinamento(dataset);
    }
    public String[][] run() {

    String arquivoCSV = "C:\\Users\\micro\\Desktop\\TENIS.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    String[][] dataset = null;
    ArrayList<String> dados = new ArrayList<>();
    ArrayList<String> tempo = new ArrayList<>();
    ArrayList<String> temperatura = new ArrayList<>();
    ArrayList<String> umidade = new ArrayList<>();
    ArrayList<String> vento = new ArrayList<>();
    ArrayList<String> jogar = new ArrayList<>();
    String[] obj = null;
    try {
        int i = 0;
        nLinhas = 0;
        nColunas = 0;
        int j = 0;
        int aux = 0;
        br = new BufferedReader(new FileReader(arquivoCSV));
        /*O primeiro while conta a quantidade de linhas e colunas, para setar a matriz*/
        while((linha = br.readLine()) != null){
            nLinhas++;
            obj = linha.split(csvDivisor);
            nColunas = obj.length;
        }
        dataset = new String[nLinhas][nColunas];
        br = new BufferedReader(new FileReader(arquivoCSV));
        /*Este segundo while, le as linhas do arquivo, transforma elas em um vetor de palavras e depois insere na matriz*/
        while((linha = br.readLine()) != null){
            obj = linha.split(csvDivisor);//quebra a linha onde existe ;
            for(j=0;j<obj.length;j++){
                dataset[i][j] = obj[j];        
            }
            i++;
        }
        for(j=0;j<dataset.length;j++){
                tempo.add(dataset[j][0]);
                temperatura.add(dataset[j][1]);
                umidade.add(dataset[j][2]);
                vento.add(dataset[j][3]);
                jogar.add(dataset[j][4]);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return dataset;
  }

    private void treinamento(String[][] dataset) {
        int qntSim = 0;
        int qntNao = 0;
        int i =0;
        int j = 0;
        //definindo quantidades de sim e não;
        for(j=0;j<nLinhas;j++){
            if(dataset[j][nColunas-1].equals("SIM")){
                qntSim++;
            }
            else if(dataset[j][nColunas-1].equals("NO")){
                qntNao++;
            }
        }
        probabPositiva = (qntSim / nLinhas-1);
        probabNegativa = (qntNao / nLinhas-1);
        
        
        
    }
}
