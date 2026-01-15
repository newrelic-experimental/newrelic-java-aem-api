package com.adobe.cq.commerce.pim.api;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public class ProductImporter {

	@Trace
	public void importProducts(SlingHttpServletRequest var1, SlingHttpServletResponse var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","ProductImporter",getClass().getSimpleName(),"importProducts");
		Weaver.callOriginal();
	}
}
