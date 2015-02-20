package aniche.selenium;

import br.com.metricminer2.MMOptions;

public class Standalone {

	public static void main(String[] args) {
		MMOptions opts = new MMOptions();
		opts.setScm("git");
		opts.setProjectPath("/home/welitons/git/spcjava");
		opts.setSysOut(true);
		new SeleniumStudy().execute(opts);
	}
}
