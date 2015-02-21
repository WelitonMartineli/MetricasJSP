/**
 * Copyright 2014 Maurício Aniche

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package weliton.jsp;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.domain.Modification;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.SCMRepository;
import br.com.metricminer2.scm.SourceCodeRepositoryNavigator;

public class CommittedTogether implements CommitVisitor {
	
	private static String SYMBOL_START_SCRIPLETS = "<%";
	private static String SYMBOL_END_SCRIPLETS = "%>";	

	private static String SYMBOL_START_TAGLIB = "<%@";
	private static String SYMBOL_END_TAGLIB = "%>";
	
	
	private boolean isJsp(Modification m) {
		return m.getNewPath().toLowerCase().endsWith(".jsp");
	}
	
	/***
	 * Método responsável por levantar a qtd de linhas encontradas de scriplets e taglib
	 * 
	 * @param source
	 * @param initialSymbol
	 * @param endSymbol
	 * @param ignoreTaglib
	 * @return
	 */
	private int qtyLines(String [] source, String initialSymbol, String endSymbol, boolean ignoreTaglib){

		boolean countBegin = false;
		boolean countEnd = false;
		int countLine = 0;
		
		for (String sourceLine : source) {
			
			if (sourceLine.contains(initialSymbol)){ 
					
					// Condição adiciona para evitar na contagem simbolo do tipo taglib, quando a contagem for de scriplets.
					if (ignoreTaglib){
						if (!sourceLine.contains(initialSymbol+"@")){
							countBegin = true;
						}	
					}else{
						countBegin = true;
					}	
			}
			
			if (sourceLine.contains(endSymbol)){
				countEnd = true;
			}
			
			if (countBegin == true){
				countLine++;
				
				if (countEnd == true){
					countBegin = false;
					countEnd = false;
					continue;

				}
			}	
			
		}
		
		return countLine;
		
	}

	/***
	 * Método responsável por encontrar a qtd linhas html.
	 * @param qtyLinesSource
	 * @param qtyLinesScriplets
	 * @param qtyLinesTaglib
	 * @return
	 */
	private int qtyLinesHtml(int qtyLinesSource, int qtyLinesScriplets, int qtyLinesTaglib){
		
		int qtyLines  =  qtyLinesSource - (qtyLinesScriplets + qtyLinesTaglib);
		return qtyLines;
	}
	
	
	@Override
	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {

		
			for (Modification m : commit.getModifications()) {
				
				if (isJsp(m)){
					
					String[] lines = m.getSourceCode().split("\n");

					int qtyLinesScriplets  = qtyLines(lines, SYMBOL_START_SCRIPLETS, SYMBOL_END_SCRIPLETS, true);
					int qtyLinesTaglib = qtyLines(lines, SYMBOL_START_TAGLIB, SYMBOL_END_TAGLIB, false);
					
					int qtyLinesHtml = qtyLinesHtml(lines.length, qtyLinesScriplets, qtyLinesTaglib);
					
					writer.write(
							Utils.format(commit.getDate()),
							m.getNewPath(),
							" Qtd total de linhas: " + lines.length,
							" Qtd Linhas Scriplets: " + qtyLinesScriplets,
							" Qtd Linhas Taglib: " + qtyLinesTaglib,
							" Qtd Linhas Html: " + qtyLinesHtml
							);
					
				}
			}

	}

	@Override
	public String name() {
		return "Checagem de arquivos JSPs";
	}

}
