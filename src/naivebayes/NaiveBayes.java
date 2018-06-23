package naivebayes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NaiveBayes {

    private int nLinhas;
    private int nColunas;
    private double probabPositiva;
    private double probabNegativa;

    /**
     * @return the nLinhas
     */
    public int getnLinhas() {
        return nLinhas;
    }

    /**
     * @param nLinhas the nLinhas to set
     */
    public void setnLinhas(int nLinhas) {
        this.nLinhas = nLinhas;
    }

    /**
     * @return the nColunas
     */
    public int getnColunas() {
        return nColunas;
    }

    /**
     * @param nColunas the nColunas to set
     */
    public void setnColunas(int nColunas) {
        this.nColunas = nColunas;
    }

    /**
     * @return the probabPositiva
     */
    public double getProbabPositiva() {
        return probabPositiva;
    }

    /**
     * @param probabPositiva the probabPositiva to set
     */
    public void setProbabPositiva(double probabPositiva) {
        this.probabPositiva = probabPositiva;
    }

    /**
     * @return the probabNegativa
     */
    public double getProbabNegativa() {
        return probabNegativa;
    }

    /**
     * @param probabNegativa the probabNegativa to set
     */
    public void setProbabNegativa(double probabNegativa) {
        this.probabNegativa = probabNegativa;
    }

    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {
        NaiveBayes nb = new NaiveBayes();
        String[][] dataset = nb.run();
        HashMap<String,Double> probabilidades = new HashMap<String,Double>();
        probabilidades = nb.treinamento(dataset);
        nb.teste(probabilidades);
    }
    * */ 
    
    
    public String[][] preencherMatriz(String caminhoArquivo) {

        String arquivoCSV = caminhoArquivo;
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
            setnLinhas(0);
            setnColunas(0);
            int j = 0;
            int aux = 0;
            br = new BufferedReader(new FileReader(arquivoCSV));
            /*O primeiro while conta a quantidade de linhas e colunas, para setar a matriz*/
            while ((linha = br.readLine()) != null) {
                setnLinhas(getnLinhas() + 1);
                obj = linha.split(csvDivisor);
                setnColunas(obj.length);
            }
            dataset = new String[getnLinhas()][getnColunas()];
            br = new BufferedReader(new FileReader(arquivoCSV));
            /*Este segundo while, le as linhas do arquivo, transforma elas em um vetor de palavras e depois insere na matriz*/
            while ((linha = br.readLine()) != null) {
                obj = linha.split(csvDivisor);//quebra a linha onde existe ;
                for (j = 0; j < obj.length; j++) {
                    dataset[i][j] = obj[j];
                }
                i++;
            }
            for (j = 0; j < dataset.length; j++) {
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

    public HashMap<String,Double> treinamento(String[][] dataset) {
        double qntSim = 0;
        double qntNao = 0;
        int i = 0;
        int j = 0;
        int auxiliar = 0;
        int repetido = 0;
        double contSimAtt = 0;
        double contNaoAtt = 0;
        ArrayList<String> aux = new ArrayList<>();
        String temp;
        HashMap<String, Double> dic = new HashMap<>();
        //definindo quantidades de sim e não;
        for (j = 0; j < getnLinhas(); j++) {
            if (dataset[j][getnColunas() - 1].equals("SIM")) {
                qntSim++;
            } else if (dataset[j][getnColunas() - 1].equals("NAO")) {
                qntNao++;
            }
        }
        setProbabPositiva(qntSim / (getnLinhas() - 1));
        setProbabNegativa(qntNao / (getnLinhas() - 1));

        //Verificando a probabilidade das Classes dos Atributos
        while (auxiliar < getnColunas()-1) {
            aux.clear();
            for (j = 1; j < getnLinhas() - 1; j++) {
                temp = dataset[j][auxiliar];
                if (aux.isEmpty()) {
                    aux.add(temp);
                }
                for (i = 0; i < aux.size(); i++) {
                    if (aux.contains(temp)) {
                        continue;
                    } else {
                        aux.add(temp);
                    }
                }
            }
            for (i = 0; i < aux.size(); i++) {
                double probabSim = 0;
                double probabNao = 0;
                contSimAtt = 0;
                contNaoAtt = 0;
                for (j = 0; j < getnLinhas(); j++) {
                    //verificando a probabilidade da classe do atributo ser sim, ou não
                    if ((dataset[j][auxiliar].equals(aux.get(i))) && dataset[j][getnColunas()-1].equals("SIM")) {
                        contSimAtt++;
                    }
                    else if (((dataset[j][auxiliar].equals(aux.get(i))) && dataset[j][getnColunas()-1].equals("NAO"))){
                        contNaoAtt++;
                    }
                }
                    probabSim = contSimAtt/qntSim;
                    probabNao = contNaoAtt/qntNao;
                    dic.put(aux.get(i)+" SIM", probabSim);
                    dic.put(aux.get(i)+" NAO", probabNao);
            }
            auxiliar++;
        }
        return dic;
    }
}
