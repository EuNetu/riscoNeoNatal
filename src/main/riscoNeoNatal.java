package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class riscoNeoNatal {

	public static void main(String[] args) {
		
		FIS fis = FIS.load("src/resource/fuzzyNeoNatal.fcl", true); // MANDANI
		//APRESENTA AS VARIÃ�VEIS MODELADAS
        JFuzzyChart.get().chart(fis.getFunctionBlock("riscoNascimento"));
		
        //SETA AS ENTRADAS
	    fis.setVariable("peso", 1500);
	    fis.setVariable("ig", 30);
	    
	    //AVALIA
	    fis.evaluate();

	    //MOSTRA O GRAFICO DA VARIAVEL DE SAIDA
        Variable risco = fis.getFunctionBlock("riscoNascimento").getVariable("risco");
        JFuzzyChart.get().chart(risco, risco.getDefuzzifier(), true);

        //PRINTA VARIAVEL DE SAIDA    
        System.out.println(risco.getValue());
        
        //MOSTRA CADA REGRA COM O VALOR DE ATIVACAO
        for( Rule r : fis.getFunctionBlock("riscoNascimento").getFuzzyRuleBlock("No1").getRules() )
          System.out.println(r);
	}

}