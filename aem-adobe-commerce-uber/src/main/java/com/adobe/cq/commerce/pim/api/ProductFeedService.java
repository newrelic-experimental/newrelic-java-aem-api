package com.adobe.cq.commerce.pim.api;

import java.util.HashMap;
import java.util.List;

import com.adobe.cq.commerce.api.Product;
import com.day.cq.wcm.api.Page;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.commerce.Utils;

@Weave(type = MatchType.Interface)
public abstract class ProductFeedService {

	@Trace(dispatcher = true)
	public List<Product> getFullProductsList(Page page) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductFeedService",getClass().getSimpleName(),"getFullProductsList");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPage(attributes, page, null);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public List<Product> getIncrementalProductsList(Page page, long var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductFeedService",getClass().getSimpleName(),"getIncrementalProductsList");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPage(attributes, page, null);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

}
