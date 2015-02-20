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

package aniche.selenium;

import java.util.HashSet;
import java.util.Set;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.domain.Modification;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.SCMRepository;

public class Modifications implements CommitVisitor {

	@Override
	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {

		for(Modification m : commit.getModifications()) {
			
			if(Utils.isASeleniumTest(m)) {
				
				String[] lines = m.getDiff().replace("\r", "").split("\n");
				
				Set<String> categoryAdded = new HashSet<String>();
				Set<String> categoryRemoved = new HashSet<String>();
				
				for(String line : lines) {
					for(Categories c : Categories.values()) {
						if(Utils.isAdd(line) && c.isContainedIn(line)) categoryAdded.add(c.name());
						else if(Utils.isRemove(line) && c.isContainedIn(line)) categoryRemoved.add(c.name());
					}
				}

				for(String category : categoryAdded) {
					if(categoryRemoved.contains(category)) {
						writer.write(
								repo.getLastDir(), 
								commit.getHash(), 
								Utils.format(commit.getDate()), 
								m.getNewPath(), 
								category
								);
					}
				}
				
				
			}
		}
	}
		
	@Override
	public String name() {
		return "selenium instructions modified";
	}

}
