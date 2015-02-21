package weliton.jsp;

import br.com.metricminer2.MMOptions;

public class Standalone {

	public static void main(String[] args) {
		MMOptions opts = new MMOptions();
		opts.setScm("git");
		opts.setProjectPath("/Users/welitonandrademartineli/Desenvolvimento/git/ExemplosJSP");
		opts.setSysOut(true);
		new JPSStudy().execute(opts);
	}
}
