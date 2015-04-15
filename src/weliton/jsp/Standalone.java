package weliton.jsp;

import br.com.metricminer2.MMOptions;

public class Standalone {

	public static void main(String[] args) {
		MMOptions opts = new MMOptions();
		opts.setScm("git");
		
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/atlas");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/central");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/Donor-Connect");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/eeg-database");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/ehour");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/esporx");
		
		//TODO: nao existe no git
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/excilys-mfb");

		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/ff-core");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/forum");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/gitblit");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/graylog2-web-interface");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/head");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/motech-whp");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/mystamps");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/open-lmis");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/openmrs-cpm");
		
		//TODO: Nao executa, por inteiro, nao da erro tambem.
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/opennms");
		
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/org.qibud.project");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/PhenotypeArchive");

		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/springtrader");

		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/TAMA-Web");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/toolkit");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/TracksAnalytics");
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/WebCash");
		opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/zanata-server");

		//TODO: Repostório not encontrado.
		//opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/CloneSeveralProjectUsp/biskit");
		
		opts.setSysOut(true);
		new JPSStudy().execute(opts);
	}
}
